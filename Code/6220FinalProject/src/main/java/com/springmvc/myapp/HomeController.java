package com.springmvc.myapp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.JobInfo;
import com.springmvc.model.User;
import com.springmvc.service.JobService;
import com.springmvc.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/jobList")
	public String jobListPage(Principal principal,Model model){
		
		User user = userService.SearchUser(principal.getName());
		
		List<JobInfo> jobs = (List<JobInfo>) jobService.listJobs();
		
		model.addAttribute("jobs",jobs);
		
		model.addAttribute("currentUser", user);

		return "userInterface";
	}
}
