package com.youxia.service;

import java.sql.Timestamp;

import javax.annotation.Resource;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import com.youxia.bean.UserBean;
import com.youxia.dao.UserDao;
import com.youxia.util.CommFunc;
import com.youxia.util.SystemDef;

@Service("userService")
public class UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	/**
	 * 用户注册,手机号
	 * */
	public JSONObject registeUser(String mobile){
		JSONObject json = new JSONObject(); 
		UserBean user = this.userDao.queryUserByMobile(mobile);
		if(user != null){
			json.put("errorCode", SystemDef.REGISTE_USER_EXIST);
		}
		else{
			user = new UserBean();
			user.setMobile(mobile);
			if(this.userDao.addUserBean(user)){
				json.put("errorCode", SystemDef.OPER_SUCCESS);
			}
			else{
				json.put("errorCode", SystemDef.OPER_FAIL);
			}
		}
		return json;
	}
	
	
	/**
	 * 用户名密码登录
	 * */
	public JSONObject loginCheckUser(String userName, String password){
		JSONObject json = new JSONObject(); 
		
		UserBean user = this.userDao.queryUserByName(userName);
		if(user == null){
			json.put("errorCode", SystemDef.LOGIN_NOUSER_ERROR);
			return json;
		}
		
		//判断用户是否被锁定
		//锁定
		Timestamp lockedDate = user.getLockedDate();
		if(user.getIsLocked() == SystemDef.USER_LOCK_YES 
				&& CommFunc.isTimestampSameDay(lockedDate, CommFunc.getNowTimestamp())){
			json.put("errorCode", SystemDef.LOGIN_LOCK_ERROR);
		}
		else{
			UserBean userNew = new UserBean();
			//登录成功
			if(password.equals(user.getPassword())){
				json.put("errorCode", SystemDef.LOGIN_SUCCESS);
				json.put("user", user.toLoginResult());
				
				//更新锁定状态
				userNew.setUserId(user.getUserId());
				userNew.setIsLocked(SystemDef.USER_LOCK_NO);
				userNew.setLoginFailCount(0);	//设置登录失败次数为0
				userNew.setLoginCount(user.getLoginCount() + 1);
			}
			//密码错误
			else{
				json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
				int loginFailCount = user.getLoginFailCount();
				//达到最大登录次数
				if(loginFailCount + 1 == SystemDef.USER_MAXLOGIN_TIMES){
					json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
					json.put("errorDesc", "密码错误，今日账户已经被锁定！");
					//更新用户状态
					userNew.setUserId(user.getUserId());
					userNew.setIsLocked(SystemDef.USER_LOCK_YES);		//设置为锁定
					userNew.setLockedDate(CommFunc.getNowTimestamp());
					userNew.setLoginCount(0);							//失败次数置0
				}
				else{
					json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
					int remainCount = SystemDef.USER_MAXLOGIN_TIMES - loginFailCount - 1;
					json.put("errorDesc", "密码错误，还有" + remainCount + "次机会");
					//更新用户状态
					userNew.setUserId(user.getUserId());
					userNew.setLoginFailCount(loginFailCount + 1);
				}
			}
			//更新状态失败，返回操作失败错误码
			if(updateUserB(userNew) == SystemDef.OPER_FAIL){
				json.put("errorCode", SystemDef.OPER_FAIL);
			}
		}
		
		return json;
	}

	/**
	 * 更新用户信息,返回json
	 * */
	public JSONObject updateUser(UserBean user){
		JSONObject json = new JSONObject(); 
		json.put("errorCode", this.updateUserB(user));
		return json;
	}
	
	/**
	 * 更新用户信息，返回byte
	 * */
	public byte updateUserB(UserBean user){
		if(this.userDao.updateUser(user)){
			return SystemDef.OPER_SUCCESS;
		}
		else 
			return SystemDef.OPER_FAIL;
	}
	
	
	
	
	
	
	
	
}
