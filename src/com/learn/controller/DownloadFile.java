package com.learn.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public class DownloadFile {

public ResponseEntity<byte[]> download(HttpServletRequest request,String filename,Model model,String fileUrl) throws IOException{
	
	//下載檔案路徑
    File file = new File(fileUrl + File.separator + filename);
    HttpHeaders headers = new HttpHeaders();  
    //下載顯示的檔案名，解決中文名稱亂碼問題 
    String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
    //通知瀏覽器以attachment（下載方式）開啟圖片
    headers.setContentDispositionFormData("attachment", downloadFielName); 
    //application/octet-stream ︰ 二進制流資料（最常見的檔案下載）。
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
            headers, HttpStatus.CREATED);  
	}
}
