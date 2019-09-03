package com.test;

import java.util.List;

import com.rock.entities.News;
import com.rock.util.JDBCUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**FileName:	com.test 	JSONTest.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	����
 * @Date:		2019��8��29��:����1:38:06
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019��8��29�� 	����	 		1.0 		1.0 Version
 * 
 */
public class JSONTest {
	public static void main(String[] args) {
		String json="{\"name\":\"rock\",\"password\":\"123456\",\"address\":\"������\"}";
		News n=new News();
		
		n.setNewsid("N00001");
		n.setTitle("�����Ĵ���");
		n.setBody("������");
		n.setUserid("Rock");
		n.setTypeid("1");
		
		JDBCUtil util=new JDBCUtil();
		List<News> all=util.query(News.class, "select * from news");
		
//		all.forEach((n1)->System.out.println(n1));
		
		
		System.out.println(JSONObject.fromObject(n).toString());
		System.out.println(JSONArray.fromObject(all).toString());
		
		
//		System.out.println(json);
	}
}
