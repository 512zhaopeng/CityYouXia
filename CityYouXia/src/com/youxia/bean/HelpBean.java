package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class HelpBean implements Serializable {
	/**
	 * ��������
	 */
	private static final long serialVersionUID = 4260110698195396997L;
	
	private Integer 	helpId = 0;
	private Integer 	categoryId = 0; 	//���ID 1=��·��Ԯ 2=Ѱ��
	private String 		name = "";			//��������
	private String      content = "";		//��������
	private Integer 	userId = 0; 		//������
	private Integer 	area = 0; 			//����
	private Double 		longitude = 0.0; 	//����
	private Double 		latitude = 0.0; 	//ά��
	private String 		site = ""; 			//λ��

	private Byte 		helpFlag = 0;		//������־
	private Integer 	helpUserId = 0;		//������id
	private String 		helpUserName = "";	//����������	
	private Timestamp 	helpDate;			//��������
	private Integer 	rewardPoints = 0; 	//���ͷ�
	private Byte 		isSolve = 0;		//�Ƿ��� 0=δ��� 1=�ѽ�� 
	private Integer 	viewCount = 0;		//�������	
	private Integer 	commentCount = 0;	//���۴���
	private Timestamp 	createDate;			//��������
	
	private String      createUserName = "";		//����������
	private String      createUserNickName = "";	//�������ǳ�
	private String      userPhoto = "";				//��Ƭ���·��
	private Byte        sex = 0;					//�Ա�
	
	
	public HelpBean(){
		
	}
	
	//�б�
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
		json.put("helpPhotoCount", 		0);	//ͼƬ����,ֻ�ǳ�ʼ��ֵ����ҵ������¸�ֵ		
		json.put("helpPhotoUrl", 		"");	//��һ��ͼƬ,ֻ�ǳ�ʼ��ֵ����ҵ������¸�ֵ
		
		return json;
	}
	
	//��������
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
