package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class UserBean implements Serializable {

	/**
	 *  用户信息
	 */
	private static final long serialVersionUID = -251404488477931685L;
    private Integer 	userId = 0;		    	/*用户ID*/          		
	private String 		userName = "";       	/*用户名称*/          
	private String 		nickName = "";       	/*昵称*/              
	private String 		password = "";       	/*密码*/              
	private Byte 		sex = 0;            	/*性别*/              
	private Timestamp 	birthday;       		/*生日*/              
	private String 		mobile = "";			/*手机号码*/         
	private String 		plateNumber = "";    	/*车牌号*/           
	private String 		imageUrl = "";       	/*头像本地路径*/      
	private Integer 	area = 0; 				/*区域-具体到城市*/  
	private Integer 	rank = 0;				/*会员等级*/         
	private Timestamp 	createDate;     		/*创建日期*/   
	private String 		registerIp = "";		/*注册IP*/           
	
	private Integer 	points = 0;         	/*积分*/              
	private Integer 	signIn = 0;				/*签到次数*/         
	private Byte 		isLocked = 0;			/*是否锁定1=锁定,2=不锁定*/         
    private Timestamp 	lockedDate; 			/*锁定日期*/             private Timestamp 	loginDate;				/*登录日期*/             private Integer 	loginCount = 0; 		/*登录成功次数*/         private Integer 	loginFailCount = -1; 	/*连续登录失败次数*/    private String 		loginIp = "";        	/*登录IP*/  
    
    private String      areaDesc = "未知";		/*所属地域描述*/
    
                    
    public UserBean(){
    	
    }
    
    //登录成功返回
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