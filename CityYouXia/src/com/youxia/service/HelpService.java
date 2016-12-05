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
	
	//--------------------��·��Ԯ--��ʼ-------------------------\\
	/**
	 * ��ӵ�·��Ԯ��Ϣ
	 * @throws IOException 
	 * */
	public byte addRoadRescueHelp(int userId, String name, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints, MultipartFile[] fileArray) throws IOException{
		return addHelp(userId, name, SystemDef.HELPTYPE_ROADRESCUE, content, area, site, longitude, latitude, rewardPoints, fileArray);
	}
	
	/**
	 * ��ȡ��·��Ԯ�б�(����)
	 * */
	public JSONArray queryRoadRescueList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_ALL, nowPage, pageSize);
	}
	
	/**
	 * ��ȡ��·��Ԯ(δ����б�)
	 * */
	public JSONArray queryRoadRescueUnsolveList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_NO, nowPage, pageSize);
	}
	
	/**
	 * ��ȡ��·��Ԯ(�ѽ���б�)
	 * */
	public JSONArray queryRoadRescueSolvedList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_ROADRESCUE, SystemDef.HELP_SOLVED_YES, nowPage, pageSize);
	}
	
	/**
	 * ��ȡ��·��Ԯ��ϸ��Ϣ
	 * */
	public JSONObject queryRoadRescueDetail(int helpId){
		return queryHelpDetail(helpId);
	}
	
	//--------------------��·��Ԯ--����-------------------------\\
	
	//--------------------Ѱ��--��ʼ-------------------------\\
	
	/**
	 * ���Ѱ����Ϣ
	 * @throws IOException 
	 * */
	public byte addPeopleSearchHelp(int userId, String name, String content, 
			int area, String site, double longitude, double latitude, int rewardPoints, MultipartFile[] fileArray) throws IOException{
		return addHelp(userId, name, SystemDef.HELPTYPE_PEOPLESEARCH, content, area, site, longitude, latitude, rewardPoints, fileArray);
	}
	
	/**
	 * Ѱ���б�(����)
	 * */
	public JSONArray queryPeopleSearchList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_ALL, nowPage, pageSize);
	}
	
	/**
	 * ��ȡѰ���б�(δ����б�)
	 * */
	public JSONArray queryPeopleSearchUnsolveList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_NO, nowPage, pageSize);
	}
	
	/**
	 * ��ȡѰ���б�(�ѽ���б�)
	 * */
	public JSONArray queryPeopleSearchSolvedList(int nowPage, int pageSize){
		return queryHelpList(SystemDef.HELPTYPE_PEOPLESEARCH, SystemDef.HELP_SOLVED_YES, nowPage, pageSize);
	}
	
	/**
	 * ��ȡѰ����ϸ��Ϣ
	 * */
	public JSONObject queryPeopleSearchDetail(int helpId){
		return queryHelpDetail(helpId);
	}
	
	//--------------------Ѱ��--����-------------------------\\

	
	/**
	 * ���������Ϣ 
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
		bean.setIsSolve((byte)1);				//1=δ��� 2=�ѽ��
		
		int helpId = helpDao.addHelpToId(bean);
		if(fileArray == null) 
			return SystemDef.OPER_SUCCESS;
		
		if(helpId > 0){
			//ѭ�����ͼƬ
			for(int i=0,nums=fileArray.length; i<nums; i++){
				if(fileArray[i] == null) continue;
				fileOperService.uploadHelpImage(fileArray[i], helpId, name);
			}
		}
		
		
		return SystemDef.OPER_SUCCESS;
	}

	/**
	 * ����������Ϣ(�������Լ�)
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
	 * ��ȡ������Ϣ�б�(����categoryId(1=��·��Ԯ 2=Ѱ��)��isSolve(1=δ��� 2=�ѽ��))
	 * */
	public JSONArray queryHelpList(int categoryId, byte isSolve, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1); //���ݿ��з�ҳ��0��ʼ����Ҫ��һ
		}
			
		List<HelpBean> list = this.helpDao.queryHelpList(categoryId, isSolve, startIndex, pageSize);
		if(list == null) return null;
		JSONArray j_array = new JSONArray();
		JSONObject json = null;
		for(HelpBean bean : list){
			json = bean.toListJSON();
			List<HelpImageBean> imageList = this.helpDao.queryHelpImageList(bean.getHelpId(), -1, -1);
			//�������ͼƬ�ܸ���������ͼƬurl
			if(imageList != null && !imageList.isEmpty()){
				json.put("helpPhotoCount",imageList.size());
				json.put("helpPhotoUrl", imageList.get(0).getImageUrl());
			}
			
			j_array.add(json);
		}
		return j_array;
	}
	
	/**
	 * ��ȡhelp��ϸ��Ϣ
	 * */
	public JSONObject queryHelpDetail(int helpId){
		HelpBean bean = this.helpDao.queryHelpDetail(helpId);
		if(bean != null) return bean.toItemJSON();
		else return null;
	}
	
	/**
	 * ��Ӱ���ͼƬ��Ϣ
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
	 * ��ȡ������ϢͼƬ
	 * */
	public JSONArray queryHelpImageList(int helpId, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1);	//���ݿ��з�ҳ��0��ʼ����Ҫ��һ
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
	 * ���������Ϣ
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
	 * ��ȡ����������Ϣ
	 * */
	public JSONArray queryHelpCommentList(int helpId, int nowPage, int pageSize){
		int startIndex = -1;
		if(nowPage != -1 && pageSize != -1){
			startIndex = pageSize * (nowPage - 1);	//���ݿ��з�ҳ��0��ʼ����Ҫ��һ
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
