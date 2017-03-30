package com.springmvc.myapp;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Application;
import com.springmvc.model.JobInfo;
import com.springmvc.model.Message;
import com.springmvc.model.User;
import com.springmvc.service.JobService;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/publish", method=RequestMethod.GET)
	public String publishJob(Model model){
		model.addAttribute(new JobInfo());
		return "job";
	}
	
	@RequestMapping(value="/jobSubmitted", method=RequestMethod.POST)
	public String JobSubmitted(@Valid @ModelAttribute("jobInfo") JobInfo jobInfo,Principal principal,BindingResult result){
		if (result.hasErrors()) {
			return "job";
		}
		User user = userService.SearchUser(principal.getName());
		jobInfo.setUser(user);
		jobInfo.setPublishDate(new Date());
		jobService.publishJob(jobInfo);
		return "published";
	}
	
	@RequestMapping(value="/{jobId}/showDetail", method=RequestMethod.GET)
	public String showJobDetail(@PathVariable Long jobId, @ModelAttribute("Application")Application application, Model model) {
		JobInfo jobInfo = jobService.getJob(jobId);
		model.addAttribute(jobInfo);
		model.addAttribute(application);
		return "jobDetail";
	}
	@RequestMapping(value="/searchJobs", method=RequestMethod.GET)
	public String searchJobs(HttpServletRequest request, Model model){
		String search = request.getParameter("searchString");
		List<JobInfo> jobs = (List<JobInfo>) jobService.searchJobByPosition(search);
		model.addAttribute("jobs",jobs);
		return "searchResult";
	}
	@RequestMapping(value="/home/searchJobs", method=RequestMethod.GET)
	public String homeSearchJobs(HttpServletRequest request, Model model){
		String search = request.getParameter("searchString");
		List<JobInfo> jobs = (List<JobInfo>) jobService.searchJobByPosition(search);
		model.addAttribute("jobs",jobs);
		return "home";
	}
	
	@RequestMapping(value="/viewPublished", method=RequestMethod.GET)
	public String publishedJob(Principal principal,Model model){
		User user = userService.SearchUser(principal.getName());
		Set<JobInfo> jobs = user.getJobInfos();
		for(JobInfo job:jobs){
		System.out.println(job);
		
		}
		model.addAttribute("jobs",jobs);
		return "publishedJob";
	}
	
	@RequestMapping(value="{jobId}/editOffer", method=RequestMethod.GET)
	public String editJob(@PathVariable Long jobId,@ModelAttribute("jobInfo")JobInfo jobInfo,Principal principal,Model model){
		JobInfo job = jobService.getJob(jobId);
		model.addAttribute("job", job);
		return "editJob";
	}
	@RequestMapping(value="/editSubmitted", method=RequestMethod.POST)
	public String editSubmitted(@Valid JobInfo jobInfo,Principal principal, Model model){
		System.out.println(jobInfo);
		User user = userService.SearchUser(principal.getName());
		jobInfo.setUser(user);
		jobInfo.setPublishDate(new Date());
		jobService.updateJob(jobInfo);
		return "jobUpdated";
	}


}
