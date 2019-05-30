package com.learn.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public class DownloadFile {

public ResponseEntity<byte[]> download(HttpServletRequest request,String filename,Model model) throws IOException{
	
	//文件命名並保存到服務器
    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); //檔案名稱為年月日時分秒
    DateFormat folderdate = new SimpleDateFormat("yyyyMMdd"); //檔案名稱為年月日時分秒
	//下載檔案路徑
    String path = request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date()));
    File file = new File(path + File.separator + filename);
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
