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
	 * �û�ע��,�ֻ���
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
	 * �û��������¼
	 * */
	public JSONObject loginCheckUser(String userName, String password){
		JSONObject json = new JSONObject(); 
		
		UserBean user = this.userDao.queryUserByName(userName);
		if(user == null){
			json.put("errorCode", SystemDef.LOGIN_NOUSER_ERROR);
			return json;
		}
		
		//�ж��û��Ƿ�����
		//����
		Timestamp lockedDate = user.getLockedDate();
		if(user.getIsLocked() == SystemDef.USER_LOCK_YES 
				&& CommFunc.isTimestampSameDay(lockedDate, CommFunc.getNowTimestamp())){
			json.put("errorCode", SystemDef.LOGIN_LOCK_ERROR);
		}
		else{
			UserBean userNew = new UserBean();
			//��¼�ɹ�
			if(password.equals(user.getPassword())){
				json.put("errorCode", SystemDef.LOGIN_SUCCESS);
				json.put("user", user.toLoginResult());
				
				//��������״̬
				userNew.setUserId(user.getUserId());
				userNew.setIsLocked(SystemDef.USER_LOCK_NO);
				userNew.setLoginFailCount(0);	//���õ�¼ʧ�ܴ���Ϊ0
				userNew.setLoginCount(user.getLoginCount() + 1);
			}
			//�������
			else{
				json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
				int loginFailCount = user.getLoginFailCount();
				//�ﵽ����¼����
				if(loginFailCount + 1 == SystemDef.USER_MAXLOGIN_TIMES){
					json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
					json.put("errorDesc", "������󣬽����˻��Ѿ���������");
					//�����û�״̬
					userNew.setUserId(user.getUserId());
					userNew.setIsLocked(SystemDef.USER_LOCK_YES);		//����Ϊ����
					userNew.setLockedDate(CommFunc.getNowTimestamp());
					userNew.setLoginCount(0);							//ʧ�ܴ�����0
				}
				else{
					json.put("errorCode", SystemDef.LOGIN_PWD_ERROR);
					int remainCount = SystemDef.USER_MAXLOGIN_TIMES - loginFailCount - 1;
					json.put("errorDesc", "������󣬻���" + remainCount + "�λ���");
					//�����û�״̬
					userNew.setUserId(user.getUserId());
					userNew.setLoginFailCount(loginFailCount + 1);
				}
			}
			//����״̬ʧ�ܣ����ز���ʧ�ܴ�����
			if(updateUserB(userNew) == SystemDef.OPER_FAIL){
				json.put("errorCode", SystemDef.OPER_FAIL);
			}
		}
		
		return json;
	}

	/**
	 * �����û���Ϣ,����json
	 * */
	public JSONObject updateUser(UserBean user){
		JSONObject json = new JSONObject(); 
		json.put("errorCode", this.updateUserB(user));
		return json;
	}
	
	/**
	 * �����û���Ϣ������byte
	 * */
	public byte updateUserB(UserBean user){
		if(this.userDao.updateUser(user)){
			return SystemDef.OPER_SUCCESS;
		}
		else 
			return SystemDef.OPER_FAIL;
	}
	
	
	
	
	
	
	
	
}
