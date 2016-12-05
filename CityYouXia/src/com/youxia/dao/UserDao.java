package com.youxia.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.youxia.bean.UserBean;

@Repository("userDao")
public class UserDao {
	
	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	/**
	 * ���userBean
	 * */
	public boolean addUserBean(UserBean userBean){
		String statement = "com.youxia.mapping.userMapper.addUserBean";
		return this.baseDao.addObjectB(statement, userBean);
	}
	
	/**
	 * ����id��ȡ�û���Ϣ
	 * */
	public UserBean queryUserById(int userId){
		String statement = "com.youxia.mapping.userMapper.queryUser";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("userName", null);
		map.put("mobile", null);
		
		Object object = this.baseDao.queryObject(statement, map);
		if(object != null) return (UserBean)object;
		else			   return null;
	}
	
	/**
	 * ����userName��ȡ�û���Ϣ
	 * */
	public UserBean queryUserByName(String userName){
		String statement = "com.youxia.mapping.userMapper.queryUser";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 0);
		map.put("userName", userName);
		map.put("mobile", null);
		
		Object object = this.baseDao.queryObject(statement, map);
		if(object != null) return (UserBean)object;
		else			   return null;
	}
	
	/**
	 * �����ֻ��Ż�ȡ�û���Ϣ
	 * */
	public UserBean queryUserByMobile(String mobile){
		String statement = "com.youxia.mapping.userMapper.queryUser";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 0);
		map.put("userName", null);
		map.put("mobile", mobile);
		
		Object object = this.baseDao.queryObject(statement, map);
		if(object != null) return (UserBean)object;
		else			   return null;
	}
	
	
	/**
	 * ����userId�����û���Ϣ
	 * */
	public boolean updateUser(UserBean user){
		String statement = "com.youxia.mapping.userMapper.updateUser";
		return this.baseDao.updateB(statement, user);
	}
	
	
	
	
}
