package com.springmvc.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewPersonalInfo(@ModelAttribute("user") User user,HttpServletRequest request, Model model){
		//get current username.
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request  
				 .getSession().getAttribute("SPRING_SECURITY_CONTEXT");  
		String currentUser = securityContextImpl.getAuthentication().getName();
		User cuser = userService.SearchUser(currentUser);
		model.addAttribute("user",cuser);
		return "userInfo";
	}
	@RequestMapping(value="/editUser", method=RequestMethod.POST)
	public String editUserInfo(@Valid User user, BindingResult result, Model model){
		if(user.getPhotoChange().getOriginalFilename()!=""){
			System.out.println("******************************");
			user.setPhoto(user.getPhotoChange());
		}
		model.addAttribute("user", user);
		userService.UpdateUser(user);
		return "updatedProfile";
	}
}
