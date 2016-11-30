package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class HelpBean implements Serializable {
	/**
	 * 救助内容
	 */
	private static final long serialVersionUID = 4260110698195396997L;
	
	private Integer 	helpId = 0;
	private Integer 	categoryId = 0; 	//类别ID 1=道路救援 2=寻人
	private String 		name = "";			//求助名称
	private String      content = "";		//具体描述
	private Integer 	userId = 0; 		//求助人
	private Integer 	area = 0; 			//区域
	private Double 		longitude = 0.0; 	//经度
	private Double 		latitude = 0.0; 	//维度
	private String 		site = ""; 			//位置

	private Byte 		helpFlag = 0;		//救助标志
	private Integer 	helpUserId = 0;		//救助人id
	private String 		helpUserName = "";	//救助人名称	
	private Timestamp 	helpDate;			//救助日期
	private Integer 	rewardPoints = 0; 	//悬赏分
	private Byte 		isSolve = 0;		//是否解决 0=未解决 1=已解决 
	private Integer 	viewCount = 0;		//浏览次数	
	private Integer 	commentCount = 0;	//评论次数
	private Timestamp 	createDate;			//创建日期
	
	private String      createUserName = "";		//发布人姓名
	private String      createUserNickName = "";	//发布人昵称
	private String      userPhoto = "";				//照片相对路径
	private Byte        sex = 0;					//性别
	
	
	public HelpBean(){
		
	}
	
	//列表
	public JSONObject toListJSON(){
		JSONObject json = new JSONObject(); 
		json.put("helpId",     			helpId);
		json.put("categoryId", 			categoryId);
		json.put("name", 				name);
		json.put("content", 			content);
		json.put("area", 				area);
		json.put("longitude", 			longitude);
		json.put("latitude", 			latitude);
		json.put("site", 				site);
		json.put("rewardPoints",		rewardPoints);
		json.put("isSolve", 			isSolve);
		json.put("viewCount", 			viewCount);
		json.put("commentCount",		commentCount);
		json.put("createDate", 			CommFunc.formatDiff(new Timestamp(System.currentTimeMillis()),createDate));
		json.put("createUserName", 		createUserName);
		json.put("createUserNickName", 	createUserNickName);
		json.put("userPhoto", 			userPhoto);
		json.put("sex", 				sex);
		json.put("helpPhotoCount", 		0);	//图片总数,只是初始化值，在业务层重新赋值		
		json.put("helpPhotoUrl", 		"");	//第一张图片,只是初始化值，在业务层重新赋值
		
		return json;
	}
	
	//具体内容
	public JSONObject toItemJSON(){
		JSONObject json = new JSONObject();
		json.put("helpId",     			helpId);
		json.put("categoryId", 			categoryId);
		json.put("name", 				name);
		json.put("content", 			content);
		json.put("area", 				area);
		json.put("longitude", 			longitude);
		json.put("latitude", 			latitude);
		json.put("site", 				site);
		json.put("helpFlag", 			helpFlag);
		json.put("helpUserId", 			helpUserId);
		json.put("helpUserName",		helpUserName);
		json.put("helpDate", 			CommFunc.formatDate(helpDate,(byte)2));
		json.put("rewardPoints", 		rewardPoints);
		json.put("isSolve", 			isSolve);
		json.put("viewCount", 			viewCount);
		json.put("commentCount",		commentCount);
		json.put("createDate", 			CommFunc.formatDiff(new Timestamp(System.currentTimeMillis()),createDate));
		json.put("sex", 				sex);
		json.put("createUserName", 		createUserName);
		json.put("createUserNickName", 	createUserNickName);
		json.put("userPhoto", 			userPhoto);
		return json;
	} 
	
	
	public Integer getHelpId() {
		return helpId;
	}
	
	public void setHelpId(Integer helpId) {
		this.helpId = helpId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getArea() {
		return area;
	}
	
	public void setArea(Integer area) {
		this.area = area;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public Byte getHelpFlag() {
		return helpFlag;
	}
	
	public void setHelpFlag(Byte helpFlag) {
		this.helpFlag = helpFlag;
	}
	
	public Integer getHelpUserId() {
		return helpUserId;
	}
	
	public void setHelpUserId(Integer helpUserId) {
		this.helpUserId = helpUserId;
	}
	
	public String getHelpUserName() {
		return helpUserName;
	}
	
	public void setHelpUserName(String helpUserName) {
		this.helpUserName = helpUserName;
	}
	
	public Timestamp getHelpDate() {
		return helpDate;
	}
	
	public void setHelpDate(Timestamp helpDate) {
		this.helpDate = helpDate;
	}
	
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	public Byte getIsSolve() {
		return isSolve;
	}
	
	public void setIsSolve(Byte isSolve) {
		this.isSolve = isSolve;
	}
	
	public Integer getViewCount() {
		return viewCount;
	}
	
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	public Integer getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserNickName() {
		return createUserNickName;
	}

	public void setCreateUserNickName(String createUserNickName) {
		this.createUserNickName = createUserNickName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}
	
	
}
