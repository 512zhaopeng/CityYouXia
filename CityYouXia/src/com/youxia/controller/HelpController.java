package com.youxia.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.youxia.service.HelpService;
import com.youxia.util.SystemDef;

@Controller
@RequestMapping("/helpOper")
public class HelpController {

	@Resource(name="helpService")
	private HelpService helpService;
	
	/**
	 * ���������Ϣ 
	 * */
	@RequestMapping(value = "/addRoadRescueHelp", method= RequestMethod.POST)
	public void addRoadRescueHelp(
			@RequestParam(value="userId", 		required=true)  int userId,
			@RequestParam(value="name",   		required=true)  String name,
			@RequestParam(value="content",		required=true)  String content,
			@RequestParam(value="area",   		required=true)  int area,
			@RequestParam(value="site",   		required=true)  String site,
			@RequestParam(value="longitude",   	required=false) Double longitude,
			@RequestParam(value="latitude",   	required=false) Double latitude,
			@RequestParam(value="image1",  		required=false) MultipartFile file1,
			@RequestParam(value="image2",  		required=false) MultipartFile file2,
			@RequestParam(value="image3",  		required=false) MultipartFile file3,
			@RequestParam(value="image4",  		required=false) MultipartFile file4,
			@RequestParam(value="image5",  		required=false) MultipartFile file5,
			@RequestParam(value="rewardPoints", required=true)  int rewardPoints,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		//����null����
		longitude = longitude == null ? 0 : longitude;
		latitude = latitude == null ? 0 : latitude;
		
		//��ȡͼƬ
		MultipartFile[] fileArray = new MultipartFile[5];
		fileArray[0] = file1;
		fileArray[1] = file2;
		fileArray[2] = file3;
		fileArray[3] = file4;
		fileArray[4] = file5;

		byte result = SystemDef.OPER_SUCCESS;
		try{
			//�ݴ��Ȳ�д����ʱ��˵
			this.helpService.addRoadRescueHelp(userId, name, content, area, site, longitude, latitude, rewardPoints, fileArray);
		}
		catch (Exception e) {
			result = SystemDef.OPER_FAIL;
		}
		
		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ����������Ϣ(�������Լ�)
	 * */
	@RequestMapping(value = "/updateRoadRescueHelp", method= RequestMethod.GET)
	public void updateHelp(
			@RequestParam(value="helpId", 		required=true) int helpId,
			@RequestParam(value="name",   		required=false) String name,
			@RequestParam(value="content",		required=false) String content,
			@RequestParam(value="area",   		required=false) Integer area,
			@RequestParam(value="site",   		required=false) String site,
			@RequestParam(value="longitude",   	required=false) Double longitude,
			@RequestParam(value="latitude",   	required=false) Double latitude,
			@RequestParam(value="rewardPoints", required=false) Integer rewardPoints,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		name = name == null ? "" : name;
		content = content == null ? "" : content;
		site = site == null ? "" : site;
		area = area == null ? 0 : area;
		longitude = longitude == null ? 0 : longitude;
		latitude = latitude == null ? 0 : latitude;
		rewardPoints = rewardPoints == null ? 0 : rewardPoints;
		
		
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		byte result = this.helpService.updateHelp(helpId, name, content, area, site, longitude, latitude, rewardPoints);
		
		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡ��·��Ԯ(ȫ��)
	 * */
	@RequestMapping(value = "/queryRoadRescue", method= RequestMethod.GET)
	public void queryRoadRescueList(
			@RequestParam(value="nowPage", 	  required=true) int nowPage,
			@RequestParam(value="pageSize",   required=true) int pageSize,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		JSONArray json = this.helpService.queryRoadRescueList(nowPage, pageSize);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ˢ�µ�·��Ԯ�б�
	 * */
	@RequestMapping(value="/refreshRoadRescueList", method= RequestMethod.GET)
	public void refreshRoadRescueList(
			@RequestParam(value="helpId", 	  required=true) int helpId,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONArray json = this.helpService.refreshRoadRescueList(helpId);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
	/**
	 * ��ȡ��·��Ԯ(δ����б�)
	 * */
	@RequestMapping(value = "/queryRoadRescueUnsolve", method= RequestMethod.GET)
	public void queryRoadHelpUnsolveList(
			@RequestParam(value="nowPage", 	  required=true) int nowPage,
			@RequestParam(value="pageSize",   required=true) int pageSize,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		JSONArray json = this.helpService.queryRoadRescueUnsolveList(nowPage, pageSize);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡ��·��Ԯ(�Ѿ�����б�)
	 * */
	@RequestMapping(value = "/queryRoadRescueSolved", method= RequestMethod.GET)
	public void queryRoadHelpSolvedList(
			@RequestParam(value="nowPage", 	required=true) int nowPage,
			@RequestParam(value="pageSize", required=true) int pageSize,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		JSONArray json = this.helpService.queryRoadRescueSolvedList(nowPage, pageSize);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡhelp��ϸ��Ϣ
	 * */
	@RequestMapping(value = "/queryHelpDetail", method = RequestMethod.GET)
	public void queryHelpDetail(
			@RequestParam(value="helpId", required=true) int helpId,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONObject json = this.helpService.queryHelpDetail(helpId);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡ������ϢͼƬ
	 * */
	@RequestMapping(value = "/queryHelpImageList", method = RequestMethod.GET)
	public void queryHelpImageList(
			@RequestParam(value="helpId", 	required=true) int helpId,
			@RequestParam(value="nowPage", 	required=true) int nowPage,
			@RequestParam(value="pageSize", required=true) int pageSize,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONArray jarray = this.helpService.queryHelpImageList(helpId, nowPage, pageSize);
		String result = "";
		if(jarray != null) result = jarray.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * �������
	 * @throws IOException 
	 * */
	@RequestMapping(value = "/addHelpComment", method = RequestMethod.GET)
	public void addHelpComment(
			@RequestParam(value="helpId", 	required=true) int helpId,
			@RequestParam(value="userId", 	required=true) int userId, 
			@RequestParam(value="content", 	required=true) String content,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		byte result = SystemDef.OPER_SUCCESS;
		try{
			this.helpService.addHelpComment(helpId, userId, content);
		}
		catch(Exception e){
			result = SystemDef.OPER_FAIL;
		}

		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
		
	}
	
	/**
	 * ��ȡ����������Ϣ
	 * */
	@RequestMapping(value = "/queryHelpCommentList", method = RequestMethod.GET)
	public void queryHelpCommentList(
			@RequestParam(value="helpId", 	required=true) int helpId,
			@RequestParam(value="nowPage", 	required=true) int nowPage,
			@RequestParam(value="pageSize", required=true) int pageSize,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONArray jarray = this.helpService.queryHelpCommentList(helpId, nowPage, pageSize);
		String result = "";
		if(jarray != null) result = jarray.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ���Ѱ����Ϣ 
	 * */
	@RequestMapping(value = "/addFindPeopleHelp", method= RequestMethod.GET)
	public void addPeopleSearchHelp(
			@RequestParam(value="userId", 		required=true) int userId,
			@RequestParam(value="name",   		required=true) String  name,
			@RequestParam(value="content",		required=true) String  content,
			@RequestParam(value="area",   		required=true) int area,
			@RequestParam(value="site",   		required=true) String site,
			@RequestParam(value="longitude",   	required=false) Double longitude,
			@RequestParam(value="latitude",   	required=false) Double latitude,
			@RequestParam(value="rewardPoints", required=true) int rewardPoints,
			@RequestParam(value="image1",  		required=false)  MultipartFile file1,
			@RequestParam(value="image2",  		required=false) MultipartFile file2,
			@RequestParam(value="image3",  		required=false) MultipartFile file3,
			@RequestParam(value="image4",  		required=false) MultipartFile file4,
			@RequestParam(value="image5",  		required=false) MultipartFile file5,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		//����null����
		longitude = longitude == null ? 0 : longitude;
		latitude = latitude == null ? 0 : latitude;
		
		//��ȡͼƬ
		MultipartFile[] fileArray = new MultipartFile[5];
		fileArray[0] = file1;
		fileArray[1] = file2;
		fileArray[2] = file3;
		fileArray[3] = file4;
		fileArray[4] = file5;
		byte result = SystemDef.OPER_SUCCESS;
		try{
			//�ݴ��Ȳ�д����ʱ��˵
			 this.helpService.addPeopleSearchHelp(userId, name, content, area, site, longitude, latitude, rewardPoints, fileArray);
		}
		catch (Exception e) {
			result = SystemDef.OPER_FAIL;
		}
		
		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ����Ѱ����Ϣ(�������Լ�)
	 * */
	@RequestMapping(value = "/updateFindPeopleHelp", method= RequestMethod.GET)
	public void updatePeopleSearchHelp(
			@RequestParam(value="helpId", 		required=true) int helpId,
			@RequestParam(value="name",   		required=false) String name,
			@RequestParam(value="content",		required=false) String content,
			@RequestParam(value="area",   		required=false) Integer area,
			@RequestParam(value="site",   		required=false) String site,
			@RequestParam(value="longitude",   	required=false) Double longitude,
			@RequestParam(value="latitude",   	required=false) Double latitude,
			@RequestParam(value="rewardPoints", required=false) Integer rewardPoints,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		name = name == null ? "" : name;
		content = content == null ? "" : content;
		site = site == null ? "" : site;
		area = area == null ? 0 : area;
		longitude = longitude == null ? 0 : longitude;
		latitude = latitude == null ? 0 : latitude;
		rewardPoints = rewardPoints == null ? 0 : rewardPoints;
		
		
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		byte result = this.helpService.updateHelp(helpId, name, content, area, site, longitude, latitude, rewardPoints);
		
		response.getWriter().write(String.valueOf(result));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡѰ���б�
	 * */
	@RequestMapping(value = "/queryFindPeopleList", method = RequestMethod.GET)
	public void queryPeopleSearchList(
			@RequestParam(value="nowPage", 	  required=true) int nowPage,
			@RequestParam(value="pageSize",   required=true) int pageSize,			
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		//����Ϊrequired=false.��������ʱ���������Ͻ����û������Ͷ������������ʱ��һ�� 
		JSONArray json = this.helpService.queryPeopleSearchList(nowPage, pageSize);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
		
	}
	
	/**
	 * ˢ��Ѱ���б�
	 * */
	@RequestMapping(value="/refreshFindPeopleList", method= RequestMethod.GET)
	public void refreshPeopleSearchList(
			@RequestParam(value="helpId", 	  required=true) int helpId,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONArray json = this.helpService.refreshPeopleSearchList(helpId);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ��ȡѰ����ϸ��Ϣ
	 * */
	@RequestMapping(value = "/queryFindPeopleDetail", method = RequestMethod.GET)
	public void queryPeopleSearchDetail(
			@RequestParam(value="helpId", required=true) int helpId,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		JSONObject json = this.helpService.queryHelpDetail(helpId);
		String result = "";
		if(json != null) result = json.toString();
		
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
}
