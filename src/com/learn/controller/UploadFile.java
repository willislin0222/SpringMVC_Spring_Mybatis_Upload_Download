package com.learn.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

public String[] upLoadPhoto(MultipartFile file,HttpServletRequest request) throws IOException{
		
		System.out.println("有檔案想要上傳");
		//回傳的路徑陣列
		String pathArray[] =  new String[2];
		
//		//取得上傳的檔案名稱
        String name = null;
        name = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
        
       //取得上傳的檔案副檔名
        int startIndex = name.lastIndexOf(".");
        int endIndex = name.length();
        String uploadContentType = name.substring(startIndex, endIndex);
        
       //文件命名並保存到服務器
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); //檔案名稱為年月日時分秒
        DateFormat folderdate = new SimpleDateFormat("yyyyMMdd"); //檔案名稱為年月日時分秒
        name = df.format(new Date()) +uploadContentType;             //存入伺服器檔案名稱為年月日時分秒+副檔名 
		//獲得物理路徑webapp所在路徑
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String filepath = request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date())) + "\\" + name;
        if(!file.isEmpty()){
			//儲存的檔案
			File savefile = new File(request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date())),name); 
			//判斷路徑是否存在，不存在就建立路徑
            File savepath = new File(request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date())));
            if(!savepath.exists()){
            	savepath.mkdirs();
            }
			file.transferTo(savefile);
		}
        String webPath =request.getContextPath() + "/resources/upload/" + folderdate.format(new Date())+ "/" +name;
		request.setAttribute("filename", name);
		pathArray[0] = webPath;
		pathArray[1] = filepath;

        return pathArray;
	}
}
