package com.springmvc.myapp;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.User;
import com.springmvc.service.UserService;




@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registryUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "register";
		}
		try{
		userService.RegistryUser(user);
		} catch(ConstraintViolationException e){
			result.rejectValue("username", "error.user.username", "An account already exists for this username.");
			return "register";
		}
		return "registrySucceed";
	}
	
//	@RequestMapping(value="Summited", method=RequestMethod.POST)
//	public String registrySucceed(){
//		return "registrySucceed";
//	}
	@RequestMapping(method=RequestMethod.GET)
	public String infoInput(Model model){
		model.addAttribute(new User());
//		model.addAttribute("UserList", userService.getUsers());
		return "register";
	}
//	@RequestMapping(method=RequestMethod.GET)
//	public String listUsers(Model model) {
//		model.addAttribute(new User());
//		model.addAttribute("UserList", userService.getUsers());
//		return "users";
//	}

	@RequestMapping(value="/{userId}/photo", method=RequestMethod.GET)
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
	@RequestMapping(value="/{userId}/{userId}/photo", method=RequestMethod.GET)
	public @ResponseBody String userPhoto(@PathVariable Long userId, HttpServletResponse response) throws IOException {
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
//	@RequestMapping(value="/{userId}/userInformation", method=RequestMethod.GET)
//	public String viewUser(@PathVariable Long userId, Model model){
//		User user = userService.getById(userId);
//		model.addAttribute(user);
//		return "viewUser";
//	}
}
