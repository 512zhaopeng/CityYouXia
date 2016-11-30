package com.youxia.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import com.youxia.util.CommFunc;

import net.sf.json.JSONObject;

public class HelpImageBean implements Serializable{

	/**
	 * «Û÷˙Õº∆¨
	 */
	private static final long serialVersionUID = -6641091186680600694L;

	private Integer   imageId = 0;			
	private Integer   helpId = 0; 		 
	private Integer   orders = 0;     
	private String    name = "";       
	private String    imageUrl = "";   
	private Timestamp createDate;
	private Timestamp modifyDate;
	 
	public HelpImageBean(){
		
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getHelpId() {
		return helpId;
	}

	public void setHelpId(Integer helpId) {
		this.helpId = helpId;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public JSONObject toListJSON(){
		JSONObject json = new JSONObject();
		json.put("imageId", imageId);
		json.put("helpId", helpId);
		json.put("orders", orders);
		json.put("name", name);
		json.put("imageUrl", imageUrl);
		json.put("createDate", CommFunc.formatDate(createDate,(byte)2));
		json.put("modifyDate", CommFunc.formatDate(modifyDate,(byte)2));
		return json;
	}
	
}
