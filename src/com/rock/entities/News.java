package com.rock.entities;

/**FileName:	com.rock.entities 	News.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年8月27日:下午3:20:03
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年8月27日 	老张	 		1.0 		1.0 Version
 * 
 */
public class News {
	private String newsid;
	private String title;
	private String body;
	private String typeid;
	private String newsdate;
	private String userid;
	private String status;
	private String typename;
	public String getNewsid() {
		return newsid;
	}
	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", title=" + title + ", body=" + body + ", typeid=" + typeid + ", newsdate="
				+ newsdate + ", userid=" + userid + ", status=" + status + ", typename=" + typename + "]";
	}
	
}
