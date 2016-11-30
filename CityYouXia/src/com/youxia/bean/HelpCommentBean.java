package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class HelpCommentBean implements Serializable{

	/**
	 * 求助评论
	 */
	private static final long serialVersionUID = -7127393887231876405L;

	private Integer   commentId = 0; 		 
	private Integer   helpId = 0;     
	private Integer   userId = 0;       
	private String    content = "";   
	private Timestamp commentDate;
	
	private String commentUserName;
	private String commentUserPhoto;
	private Byte   sex = 0;					//性别
	
	public HelpCommentBean(){
		
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getHelpId() {
		return helpId;
	}

	public void setHelpId(Integer helpId) {
		this.helpId = helpId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp createDate) {
		this.commentDate = createDate;
	}
	
	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	
	public String getCommentUserPhoto() {
		return commentUserPhoto;
	}

	public void setCommentUserPhoto(String commentUserPhoto) {
		this.commentUserPhoto = commentUserPhoto;
	}
	
	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	//具体内容
	public JSONObject toItemJSON(){
		JSONObject json = new JSONObject();
		json.put("commentId", commentId);
		json.put("helpId", helpId);
		json.put("userId", userId);
		json.put("content", content);
		json.put("createDate", CommFunc.formatDiff(new Timestamp(System.currentTimeMillis()),commentDate));
		json.put("commentUserName", commentUserName);
		json.put("commentUserPhoto", commentUserPhoto);
		json.put("sex", 				sex);
		return json;
	} 
	
}
