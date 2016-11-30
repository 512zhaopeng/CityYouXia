package com.youxia.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.youxia.util.SystemDef;

@Service("fileOperService")
public class FileOperService {
	
	@Resource(name="helpService")
	private HelpService helpService;
	
	@Autowired(required=false)
	private HttpSession session;
	
	/**
	 * 上传help图片
	 * */
	public byte uploadHelpImage(MultipartFile file, int helpId, String name) throws IOException{
		String originalFileName = file.getOriginalFilename();
		String targetDir = session.getServletContext().getRealPath(SystemDef.HELPIMAGE_BASEPATH);
		StringBuffer fileName = new StringBuffer(helpId + "_" + System.currentTimeMillis()).append(".").append(originalFileName.split("\\.")[1]); 
		
		InputStream in = file.getInputStream();
		File targetFile = new File(targetDir, fileName.toString());
		FileOutputStream out = new FileOutputStream(targetFile);
		IOUtils.copy(in, out);
		
		in.close();
		out.close();

        //添加图片到数据库
        byte result = this.helpService.addHelpImage(helpId, name, SystemDef.HELPIMAGE_BASEPATH + "/" + fileName.toString());
        if(result == SystemDef.OPERTYPE_SUCCESS)
        	return 0;  //成功
        else
        	return 1;  //失败
	}
	
	/**
	 * 上传help图片
	 * */
	public byte uploadHelpImageByFile(MultipartFile file, int helpId, String name) throws IOException{
		String originalFileName = file.getOriginalFilename();
		String targetDir = session.getServletContext().getRealPath(SystemDef.HELPIMAGE_BASEPATH);
		StringBuffer fileName = new StringBuffer(helpId + "_" + System.currentTimeMillis()).append(".").append(originalFileName.split("\\.")[1]); 
		
		return 1;
//		InputStream in = new FileInputStream(file);
//		File targetFile = new File(targetDir, fileName.toString());
//		FileOutputStream out = new FileOutputStream(targetFile);
//		IOUtils.copy(in, out);
//		
//		in.close();
//		out.close();
//
//        //添加图片到数据库
//        byte result = this.helpService.addHelpImage(helpId, name, SystemDef.HELPIMAGE_BASEPATH + fileName.toString());
//        if(result == SystemDef.OPERTYPE_SUCCESS)
//        	return 0;  //成功
//        else
//        	return 1;  //失败
	}
	
	
	
	
	/**
	 * 上传用户头像
	 * */
	public byte uploadUserPhoto(MultipartFile file, int userId){
		String originalFileName = file.getOriginalFilename();
		String targetDir = session.getServletContext().getRealPath(SystemDef.USERPHOTO_BASEPATH);
		StringBuffer fileName = new StringBuffer(userId + "_" + System.currentTimeMillis()).append(".").append(originalFileName.split("\\.")[1]); 
		
		
		return 0;
	}
	
	
	
	
	
	 public static File getFile(String fileName) {  
	    return new File(SystemDef.HELPIMAGE_BASEPATH, fileName);  
	 } 
	
	
	
	
	
	
}
