package com.youxia.service;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.youxia.bean.HelpBean;
import com.youxia.bean.HelpCommentBean;
import com.youxia.bean.HelpImageBean;
import com.youxia.dao.HelpDao;
import com.youxia.util.SystemDef;

@Service("helpService")
public class HelpService {
	
	@Resource(name="helpDao")
	private HelpDao helpDao;
	
	@Resource(name="fileOperService")
	private FileOperService fileOperService;
	
	//--------------------道路救援--开始-------------------------\\
	/**
	 * 添加道路救援信息
	 * @throws IOException 
	 * */
	public byte addRoadRescueHelp(int userId, String name, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints, MultipartFile[] fileArray) throws IOException{
		return addHelp(userId, name, SystemDef.HELPTYPE_ROADRESCUE, content, area, site, longitude, latitude, rewardPoints, fileArray);
	}
	
	/**
	 * 获取道路救援列表(所有)
	 * */
	public JSONArray queryRoadRescueList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_ALL, nowPage, pageSize);
	}
	
	/**
	 * 获取道路救援(未解决列表)
	 * */
	public JSONArray queryRoadRescueUnsolveList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_NO, nowPage, pageSize);
	}
	
	/**
	 * 获取道路救援(已解决列表)
	 * */
	public JSONArray queryRoadRescueSolvedList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_YES, nowPage, pageSize);
	}
	
	/**
	 * 获取道路救援详细信息
	 * */
	public JSONObject queryRoadRescueDetail(int helpId){
		return queryHelpDetail(helpId);
	}
	
	//--------------------道路救援--结束-------------------------\\
	
	//--------------------寻人--开始-------------------------\\
	
	/**
	 * 添加寻人信息
	 * @throws IOException 
	 * */
	public byte addPeopleSearchHelp(int userId, String name, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints, MultipartFile[] fileArray) throws IOException{
		return addHelp(userId, name, SystemDef.HELPTYPE_PEOPLESEARCH, content, area, site, longitude, latitude, rewardPoints, fileArray);
	}
	
	/**
	 * 寻人列表(所有)
	 * */
	public JSONArray queryPeopleSearchList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_ALL, nowPage, pageSize);
	}
	
	/**
	 * 获取寻人列表(未解决列表)
	 * */
	public JSONArray queryPeopleSearchUnsolveList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_NO, nowPage, pageSize);
	}
	
	/**
	 * 获取寻人列表(已解决列表)
	 * */
	public JSONArray queryPeopleSearchSolvedList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_YES, nowPage, pageSize);
	}
	
	/**
	 * 获取寻人详细信息
	 * */
	public JSONObject queryPeopleSearchDetail(int helpId){
		return queryHelpDetail(helpId);
	}
	
	//--------------------寻人--结束-------------------------\\

	
	/**
	 * 添加求助信息 
	 * @throws IOException 
	 * */
	public byte addHelp(int userId, String name, int categoryId, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints, MultipartFile[] fileArray) throws IOException{
		HelpBean bean = new HelpBean();
		bean.setUserId(userId);
		bean.setCategoryId(categoryId);
		bean.setName(name);
		bean.setContent(content);
		bean.setArea(area);
		bean.setSite(site);
		bean.setLongitude(longitude);
		bean.setLatitude(latitude);
		bean.setRewardPoints(rewardPoints);
		bean.setIsSolve((byte)1);				//1=未解决 2=已解决
		
		int helpId = helpDao.addHelpToId(bean);
		if(fileArray == null) 
			return SystemDef.OPER_SUCCESS;
		
		if(helpId > 0){
			//循环添加图片
			for(int i=0,nums=fileArray.length; i<nums; i++){
				if(fileArray[i] == null) continue;
				fileOperService.uploadHelpImage(fileArray[i], helpId, name);
			}
		}
		
		
		return SystemDef.OPER_SUCCESS;
	}

	/**
	 * 更新求助信息(发布者自己)
	 * */
	public byte updateHelp(int helpId, String name, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints){
		HelpBean bean = new HelpBean();
		bean.setHelpId(helpId);
		bean.setName(name);
		bean.setContent(content);
		bean.setArea(area);
		bean.setSite(site);
		bean.setLongitude(longitude);
		bean.setLatitude(latitude);
		bean.setRewardPoints(rewardPoints);
	
		if(helpDao.updateHelp(bean)) return SystemDef.OPER_SUCCESS;
		else					     return SystemDef.OPER_FAIL;
	}
	
	/**
	 * 获取帮助信息列表(根据categoryId(1=道路救援 2=寻人)和isSolve(1=未解决 2=已解决))
	 * */
	public JSONArray queryHelpList(int categoryId, byte isSolve, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1); //数据库中分页从0开始，不要减一
		}
			
		List<HelpBean> list = this.helpDao.queryHelpList(categoryId, isSolve, startIndex, pageSize);
		if(list == null) return null;
		JSONArray j_array = new JSONArray();
		JSONObject json = null;
		for(HelpBean bean : list){
			json = bean.toListJSON();
			List<HelpImageBean> imageList = this.helpDao.queryHelpImageList(bean.getHelpId(), -1, -1);
			//添加所含图片总个数和首张图片url
			if(imageList != null && !imageList.isEmpty()){
				json.put("helpPhotoCount",imageList.size());
				json.put("helpPhotoUrl", imageList.get(0).getImageUrl());
			}
			
			j_array.add(json);
		}
		return j_array;
	}
	
	/**
	 * 获取help详细信息
	 * */
	public JSONObject queryHelpDetail(int helpId){
		HelpBean bean = this.helpDao.queryHelpDetail(helpId);
		if(bean != null) return bean.toItemJSON();
		else return null;
	}
	
	/**
	 * 添加帮助图片信息
	 * */
	public byte addHelpImage(int helpId, String name, String imageUrl){
		HelpImageBean bean = new HelpImageBean();
		bean.setHelpId(helpId);
		bean.setName(name);
		bean.setImageUrl(imageUrl);
		if(this.helpDao.addHelpImage(bean)) 
			return SystemDef.OPER_SUCCESS;
		else					  			
			return SystemDef.OPER_FAIL;
	}
	
	/**
	 * 获取帮助信息图片
	 * */
	public JSONArray queryHelpImageList(int helpId, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1);	//数据库中分页从0开始，不要减一
		}
		List<HelpImageBean> list = this.helpDao.queryHelpImageList(helpId, startIndex, pageSize);
		if(list == null) return null;
		JSONArray j_array = new JSONArray();
		for(HelpImageBean bean : list){
			j_array.add(bean.toListJSON());
		}
		return j_array;
	}
	
	/**
	 * 添加评论信息
	 * */
	public byte addHelpComment(int helpId, int userId, String content){
		HelpCommentBean bean = new HelpCommentBean();
		bean.setHelpId(helpId);
		bean.setContent(content);
		bean.setUserId(userId);
		
		if(this.helpDao.addHelpComment(bean))
			return SystemDef.OPER_SUCCESS;
		else
			return SystemDef.OPER_FAIL;
	}
	
	/**
	 * 获取帮助评论信息
	 * */
	public JSONArray queryHelpCommentList(int helpId, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1);	//数据库中分页从0开始，不要减一
		}
		List<HelpCommentBean> list = this.helpDao.queryHelpCommentList(helpId, startIndex, pageSize);
		if(list == null) return null;
		JSONArray j_array = new JSONArray();
		for(HelpCommentBean bean : list){
			j_array.add(bean.toItemJSON());
		}
		return j_array;
	}
	
}
