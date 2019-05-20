package com.learn.controller;
 
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.pojo.LearnVO;
import com.learn.service.LearnService;

 
@Controller
@RequestMapping("/learn")
public class LearnController {
 
	@Autowired
	LearnService learnService;
	
	@RequestMapping("/toadd")  //導向新增頁面
	public String regUser() {
		return "learn/addLearn";
	}
	
	@RequestMapping("/addLearn")
	public String addLearn(LearnVO learnVO,Model model) {//新增員工帳號
		this.learnService.addLearn(learnVO);
		return "learn/LearnList";
	}	
	
}