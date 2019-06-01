package com.learn.controller;
 
 
 
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String addLearn(LearnVO learnVO,Model model,HttpServletRequest request,@RequestParam("file") MultipartFile file) throws IOException {//新增資料
		
		UploadFile uploadFile = new UploadFile();
		String[] url = uploadFile.upLoadPhoto(file,request);
		learnVO.setWeburl(url[0]);
		learnVO.setFileurl(url[1]);
		this.learnService.addLearn(learnVO);
		model.addAttribute("learnList", this.learnService.getAll());
		model.addAttribute("learnVO", learnVO);
		return "learn/LearnList";
	}	
	
	@RequestMapping("/download")  //下檔檔案
	public ResponseEntity<byte[]> addLearn(HttpServletRequest request,@RequestParam("no") String no,
            Model model) throws IOException {
	
	    LearnVO learnVO = new LearnVO();
	    learnVO = learnService.findLearnByPk(Integer.valueOf(no));
		DownloadFile downloadFile = new DownloadFile();
		
		int local=learnVO.getFileurl().lastIndexOf("\\");
		String fileName=learnVO.getFileurl().substring(local+1);
		String fileUrl=learnVO.getFileurl().substring(0, local);
		return downloadFile.download(request, fileName, model,fileUrl);
	}	
	
}