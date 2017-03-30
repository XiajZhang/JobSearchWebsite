package com.springmvc.myapp;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Application;
import com.springmvc.model.JobInfo;
import com.springmvc.model.User;
import com.springmvc.service.ApplicationService;
import com.springmvc.service.JobService;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/application")
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	@Autowired
	JobService jobService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/{jobId}/apply", method=RequestMethod.POST)
	public String sendApplication(@PathVariable Long jobId,@Valid @ModelAttribute("Application") Application application,BindingResult result,Principal principal, Model model){
		JobInfo jobInfo = jobService.getJob(jobId);
		if (result.hasErrors()) {
			model.addAttribute(jobInfo);
			return "jobDetail";
		}
		User applicant = userService.SearchUser(principal.getName());
		application.setJob(jobInfo);
		application.setApplicant(applicant);
		application.setApplyDate(new Date());
		System.out.println(application);
		applicationService.sendApplication(application);
		return "applied";	
	}
	
	@RequestMapping(value="/viewAll",method=RequestMethod.GET)
	public String viewAll(Principal principal, Model model){
		String username = principal.getName();
		User applicant = userService.SearchUser(username);
		Set<Application> applications = applicant.getApplications();
		model.addAttribute("applications",applications);
		return "viewAllApplications";	
	}
	
	@RequestMapping(value="/{jobId}/viewAllApplicants",method=RequestMethod.GET)
	public String viewAllApplicants(@PathVariable Long jobId,Principal principal, Model model){
		JobInfo jobInfo = jobService.getJob(jobId);
		Set<Application> applications = jobInfo.getApplications();
		for(Application app:applications){
			System.out.println(app);
		}
		model.addAttribute("applications",applications);
		return "viewApplicants";	
	}

}
