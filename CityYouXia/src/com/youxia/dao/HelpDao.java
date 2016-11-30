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
	 * ���������Ϣ
	 * */
	public boolean addHelp(HelpBean helpBean){
		String statement = "com.youxia.mapping.helpMapper.addHelp";
		return this.baseDao.addObjectB(statement, helpBean);
	}
	
	/**
	 * ���������Ϣ���ȡ����ID
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
	 * �޸�������Ϣ
	 * */
	public boolean updateHelp(HelpBean helpBean){
		String statement = "com.youxia.mapping.helpMapper.updateHelp";
		return this.baseDao.updateB(statement, helpBean);
	}
	
	
	/**
	 * ��ȡhelp�б�
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
	 * ��ȡ������ϸ��Ϣ 
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
	 * ��֯help���ѯ������������
	 * */
	public Map helpParamFormat(Map<String, Object> param){
		//��ʼ����������(�����˿��ܲ�ѯ�����в���)
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
		
		//��ʵ�ʲ�����ֵ����������
		for(Map.Entry<String, Object> entry : param.entrySet()){
			formatParam.put(entry.getKey(), entry.getValue());
		}
		return formatParam;	
	}
	
	/**
	 * ���helpͼƬ
	 * */
	public boolean addHelpImage(HelpImageBean bean){
		String statement = "com.youxia.mapping.helpMapper.addHelpImage";
		return this.baseDao.addObjectB(statement, bean);
	} 
	
	/**
	 * ɾ��helpͼƬ
	 * */
//	public boolean delHelpImage(int imageId){
//		
//	}
	

	/**
	 * ��ȡ������ϢͼƬ
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
	 * ���help����
	 * */
	public boolean addHelpComment(HelpCommentBean bean){
		String statement = "com.youxia.mapping.helpMapper.addHelpComment";
		return this.baseDao.addObjectB(statement, bean);
	} 
	
	/**
	 * ��ȡ��������������
	 * */
	public int queryHelpCommentsCount(int helpId){
		String statement = "com.youxia.mapping.helpMapper.queryHelpCommentsCount";
		Object object = this.baseDao.queryObject(statement, helpId);
		return CommFunc.ObjectToInt(object);
	}
	
	
	/**
	 * ��ȡ����������Ϣ
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
