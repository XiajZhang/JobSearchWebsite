package com.springmvc.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping("/home")
	public String showHome(){
		return "home";
	}
	
	 @RequestMapping("/signin")
	  public String showLogin() {
	      return "signin";
	  }

	 @RequestMapping("/loggedout")
	  public String showLoggedOut() {
	      return "home";
	  }
	 @RequestMapping("/UI")
	 public String showUI(){
		 return "userInterface";
	 }
}
