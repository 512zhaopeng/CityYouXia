package com.youxia.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.youxia.bean.HelpBean;
import com.youxia.bean.HelpCommentBean;
import com.youxia.bean.HelpImageBean;
import com.youxia.util.CommFunc;

@Repository("helpDao")
public class HelpDao {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	/**
	 * 添加求助信息
	 * */
	public boolean addHelp(HelpBean helpBean){
		String statement = "com.youxia.mapping.helpMapper.addHelp";
		return this.baseDao.addObjectB(statement, helpBean);
	}
	
	/**
	 * 添加求助信息后获取新增ID
	 * */
	public int addHelpToId(HelpBean helpBean){
		String statement = "com.youxia.mapping.helpMapper.addHelp";
		if(this.baseDao.addObjectB(statement, helpBean)){
			return helpBean.getHelpId();
		}
		else
			return 0;
	}
	
	
	/**
	 * 修改求助信息
	 * */
	public boolean updateHelp(HelpBean helpBean){
		String statement = "com.youxia.mapping.helpMapper.updateHelp";
		return this.baseDao.updateB(statement, helpBean);
	}
	
	
	/**
	 * 获取help列表
	 * */
	public List<HelpBean> queryHelpList(int categoryId, byte isSolve, int startIndex, int pageSize){
		String statement = "com.youxia.mapping.helpMapper.queryHelp";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("categoryId", categoryId);
		param.put("isSolve",    isSolve);
		param.put("startIndex", startIndex);
		param.put("pageSize",   pageSize);
		
		List<Object> listDB = this.baseDao.queryList(statement, helpParamFormat(param));
		if(!listDB.isEmpty()){
			List<HelpBean> list = new ArrayList<HelpBean>();
			for(Object obj : listDB){
				list.add((HelpBean)obj);
			}
			return list;
		}
		else
			return null;
	}
	
	/**
	 * 获取帮助详细信息 
	 * */
	public HelpBean queryHelpDetail(int helpId){
		String statement = "com.youxia.mapping.helpMapper.queryHelp";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("helpId", helpId);
		param.put("startIndex", -1);
		param.put("pageSize",   -1);
		
		Object object = this.baseDao.queryObject(statement, helpParamFormat(param));
		if(object != null) return (HelpBean)object;
		else			   return null;
	}
	
	/**
	 * 组织help表查询条件公共参数
	 * */
	public Map helpParamFormat(Map<String, Object> param){
		//初始化基本参数(包含了可能查询的所有参数)
		Map<String, Object> formatParam = new HashMap<String, Object>();
		formatParam.put("helpId", 0);
		formatParam.put("categoryId", 0);
		formatParam.put("userId", 0);
		formatParam.put("area", 0);
		formatParam.put("helpFlag", 0);
		formatParam.put("helpUserId", 0);
		formatParam.put("isSolve", 0);
		formatParam.put("startIndex", -1);
		formatParam.put("pageSize",   -1);
		
		//将实际参数赋值给基本参数
		for(Map.Entry<String, Object> entry : param.entrySet()){
			formatParam.put(entry.getKey(), entry.getValue());
		}
		return formatParam;	
	}
	
	/**
	 * 添加help图片
	 * */
	public boolean addHelpImage(HelpImageBean bean){
		String statement = "com.youxia.mapping.helpMapper.addHelpImage";
		return this.baseDao.addObjectB(statement, bean);
	} 
	
	/**
	 * 删除help图片
	 * */
//	public boolean delHelpImage(int imageId){
//		
//	}
	

	/**
	 * 获取帮助信息图片
	 * */
	public List<HelpImageBean> queryHelpImageList(int helpId, int startIndex, int pageSize){
		String statement = "com.youxia.mapping.helpMapper.queryHelpImages";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("helpId", helpId);
		param.put("startIndex", startIndex);
		param.put("pageSize", pageSize);
		List<Object> listDB = this.baseDao.queryList(statement, param);
		if(!listDB.isEmpty()){
			List<HelpImageBean> list = new ArrayList<HelpImageBean>();
			for(Object obj : listDB){
				list.add((HelpImageBean)obj);
			}
			return list;
		}
		else
			return null;
	}
	
	/**
	 * 添加help评论
	 * */
	public boolean addHelpComment(HelpCommentBean bean){
		String statement = "com.youxia.mapping.helpMapper.addHelpComment";
		return this.baseDao.addObjectB(statement, bean);
	} 
	
	/**
	 * 获取帮助评论总条数
	 * */
	public int queryHelpCommentsCount(int helpId){
		String statement = "com.youxia.mapping.helpMapper.queryHelpCommentsCount";
		Object object = this.baseDao.queryObject(statement, helpId);
		return CommFunc.ObjectToInt(object);
	}
	
	
	/**
	 * 获取帮助评论信息
	 * */
	public List<HelpCommentBean> queryHelpCommentList(int helpId, int startIndex, int pageSize){
		String statement = "com.youxia.mapping.helpMapper.queryHelpComments";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("helpId", helpId);
		param.put("startIndex", startIndex);
		param.put("pageSize", pageSize);
		List<Object> listDB = this.baseDao.queryList(statement, param);
		if(!listDB.isEmpty()){
			List<HelpCommentBean> list = new ArrayList<HelpCommentBean>();
			for(Object obj : listDB){
				list.add((HelpCommentBean)obj);
			}
			return list;
		}
		else
			return null;
	}

	
	
	
}
