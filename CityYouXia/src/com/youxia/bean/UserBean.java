package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class UserBean implements Serializable {

	/**
	 *  �û���Ϣ
	 */
	private static final long serialVersionUID = -251404488477931685L;
    private Integer 	userId = 0;		    	/*�û�ID*/          		
	private String 		userName = "";       	/*�û�����*/          
	private String 		nickName = "";       	/*�ǳ�*/              
	private String 		password = "";       	/*����*/              
	private Byte 		sex = 0;            	/*�Ա�*/              
	private Timestamp 	birthday;       		/*����*/              
	private String 		mobile = "";			/*�ֻ�����*/         
	private String 		plateNumber = "";    	/*���ƺ�*/           
	private String 		imageUrl = "";       	/*ͷ�񱾵�·��*/      
	private Integer 	area = 0; 				/*����-���嵽����*/  
	private Integer 	rank = 0;				/*��Ա�ȼ�*/         
	private Timestamp 	createDate;     		/*��������*/   
	private String 		registerIp = "";		/*ע��IP*/           
	
	private Integer 	points = 0;         	/*����*/              
	private Integer 	signIn = 0;				/*ǩ������*/         
	private Byte 		isLocked = 0;			/*�Ƿ�����1=����,2=������*/         
    private Timestamp 	lockedDate; 			/*��������*/             private Timestamp 	loginDate;				/*��¼����*/             private Integer 	loginCount = 0; 		/*��¼�ɹ�����*/         private Integer 	loginFailCount = -1; 	/*������¼ʧ�ܴ���*/    private String 		loginIp = "";        	/*��¼IP*/  
    
    private String      areaDesc = "δ֪";		/*������������*/
    
                    
    public UserBean(){
    	
    }
    
    //��¼�ɹ�����
    public JSONObject toLoginResult(){
    	JSONObject json = new JSONObject();
    	json.put("userId", 		userId);
    	json.put("userName", 	userName);
    	json.put("nickName", 	nickName);
    	json.put("sex", 		sex);
    	
    	json.put("birthday", 	CommFunc.formatDate(birthday, (byte)2));
    	json.put("imageUrl", 	imageUrl);
    	json.put("area", 		area);
    	json.put("areaDesc", 	areaDesc);
    	json.put("points", 		points);
    	json.put("nickName", 	nickName);
    	return json;
    }
    
    

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getSignIn() {
		return signIn;
	}

	public void setSignIn(Integer signIn) {
		this.signIn = signIn;
	}

	public Byte getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Byte isLocked) {
		this.isLocked = isLocked;
	}

	public Timestamp getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Timestamp lockedDate) {
		this.lockedDate = lockedDate;
	}

	public Timestamp getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	} 
	
	
	
	
	
	
	
	
	
}                    