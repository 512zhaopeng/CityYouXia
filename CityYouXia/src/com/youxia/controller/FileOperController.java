package com.youxia.controller;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.youxia.service.FileOperService;

@Controller
@RequestMapping("/fileOper")
public class FileOperController {

	@Resource(name="fileOperService")
	private FileOperService fileOperService;
	
	
	@RequestMapping("/uploadHelpImage")
	public void uploadHelpImage(
			@RequestParam(value="image1",  required=true) MultipartFile file1,
			@RequestParam(value="image2",  required=false) MultipartFile file2,
			@RequestParam(value="image3",  required=false) MultipartFile file3,
			@RequestParam(value="image4",  required=false) MultipartFile file4,
			@RequestParam(value="image5",  required=false) MultipartFile file5,
			@RequestParam(value="helpId", required=true) int helpId,
			@RequestParam(value="name",   required=false) String name,
			HttpServletRequest  request,
			HttpServletResponse response) throws IOException{
		name = name == null ? "" : name;
		MultipartFile[] fileArray = new MultipartFile[5];
		fileArray[0] = file1;
		fileArray[1] = file2;
		fileArray[2] = file3;
		fileArray[3] = file4;
		fileArray[4] = file5;
		
		byte result = 0;
		for(int i=0,nums=fileArray.length; i<nums; i++){
			if(fileArray[i] == null) continue;
			result = fileOperService.uploadHelpImage(fileArray[i], helpId, name);
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	@RequestMapping("/uploadHelpImageByFile")
	public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
         long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    System.out.println("OK");
                	//String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    //file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
    return "/success"; 
    }
	
	
	
	@RequestMapping("/download")
	public void downloadImage(){
		
	}
	
}
