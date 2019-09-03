package com.rock.service;

import com.rock.entities.NewsType;
import com.rock.util.JDBCUtil;

import net.sf.json.JSONArray;

/**FileName:	com.rock.service 	NewsTypeService.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	����
 * @Date:		2019��8��29��:����3:29:04
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019��8��29�� 	����	 		1.0 		1.0 Version
 * 
 */
public class NewsTypeService {
	private JDBCUtil util=null;
	public NewsTypeService(){
		util=new JDBCUtil();
	}
	public String allTypes(){
		return JSONArray.fromObject(util.query(NewsType.class,"select * from newstype")).toString();
	}
}
