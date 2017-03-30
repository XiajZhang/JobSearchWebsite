package com.springmvc.myapp;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Message;
import com.springmvc.model.User;
import com.springmvc.service.MessageService;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{userId}/messageForm", method=RequestMethod.GET)
	public String showMessageForm(@PathVariable Long userId,@ModelAttribute("Message")Message message,Model model) {
		User receiver = userService.getById(userId);
		model.addAttribute(new Message());
		model.addAttribute("receiver",receiver);
		return "messageForm";
	}
	@RequestMapping(value="/{userId}/send", method=RequestMethod.POST)
	public String sendMessage(@PathVariable Long userId, @Valid @ModelAttribute("Message") Message message,BindingResult result,Model model, Principal principal) {
		if (result.hasErrors()) {
			return "messageForm";
		}
		User receiver = userService.getById(userId);
		User sender = userService.SearchUser(principal.getName());
		message.setReceiver(receiver);
		message.setReceiverName();
		message.setSenderName(sender.getUsername());
		message.setSenderId(sender.getId());
		message.setSendDate(new Date());
		System.out.println(message);
		messageService.sendMessage(message);
		return "messageSendOut";
	}
	@RequestMapping(value="/myMessages", method=RequestMethod.GET)
	public String myMessages(Principal principal,Model model){
		String userName = principal.getName();
		System.out.println(userName);
		List<Message> messages = messageService.getMessage(userName);
		for(Message message:messages){
			System.out.println(message);
		}
		model.addAttribute("messages",messages);
		return "myMessages";
	}
	@RequestMapping(value="{userId}/message/{userId}/photo", method=RequestMethod.GET)
	public @ResponseBody String viewPhoto(@PathVariable Long userId, HttpServletResponse response) throws IOException {
		User user = userService.getById(userId);
		byte[] photoBytes = user.getPhotoBytes();
		if (photoBytes != null) {
			int photoLength = photoBytes.length;
			try (ServletOutputStream sos = response.getOutputStream()) {
				
				response.setContentType(user.getPhotoContentType());
				response.setContentLength(photoLength);
				response.setHeader("Content-Disposition", "inline; filename=\"" + user.getPhotoFilename() + "\"");
				
				sos.write(photoBytes);
				sos.flush();
			}
		}
		return "";
	}
}
