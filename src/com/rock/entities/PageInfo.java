package com.rock.entities;

import java.util.List;

/**FileName:	com.rock.entities 	PageInfo.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年8月27日:下午3:24:27
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年8月27日 	老张	 		1.0 		1.0 Version
 * 
 */
public class PageInfo {
	private int cpage;
	private int pagesize=5;
	private int maxpage;
	private int rows;
	private List<News> pageList;
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<News> getPageList() {
		return pageList;
	}
	public void setPageList(List<News> pageList) {
		this.pageList = pageList;
	}
	
}
