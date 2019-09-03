package com.rock.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.rock.entities.News;
import com.rock.entities.PageInfo;
import com.rock.util.JDBCUtil;

import net.sf.json.JSONArray;


/**FileName:	com.rock.service 	NewsService.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	����
 * @Date:		2019��8��27��:����3:19:12
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019��8��27�� 	����	 		1.0 		1.0 Version
 * 
 */
public class NewsService {
	private JDBCUtil util=null;
	public NewsService(){
		util=new JDBCUtil();
	}
	public boolean deleteBatch(String[] ids){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newsystem","root","admin");
			
			//����������ύ��ʽΪ�ֹ��ύ
			conn.setAutoCommit(false);//���Զ��ύ����
			
//			ids=[162,163,166]
//			delete from news where newsid in ('162,163,166');
			String sql="delete from news where newsid=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			for(String id:ids){
				stmt.setString(1, id);
				stmt.addBatch();
			}
//			delete from news where newsid=162
//			delete from news where newsid=163
//			delete from news where newsid=166
//			
			stmt.executeBatch();//ִ�ж���delete���
			conn.commit();		//�ύ���delete��������
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public boolean deleteBatch1(String id){
		
		String ids[]=id.split(",");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newsystem","root","admin");
			
			//����������ύ��ʽΪ�ֹ��ύ
			conn.setAutoCommit(false);//���Զ��ύ����
			
//			ids=[162,163,166]
//			delete from news where newsid in ('162,163,166');
			String sql="delete from news where newsid=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			
			for(String temp:ids){
				stmt.setString(1, temp);
				stmt.addBatch();
			}
//			delete from news where newsid=162
//			delete from news where newsid=163
//			delete from news where newsid=166
//			
			stmt.executeBatch();//ִ�ж���delete���
			conn.commit();		//�ύ���delete��������
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * @TODO	 :
	 * @Date	 :2019��8��28�� ����11:08:09
	 * @Author	 :����
	 * @param newsid
	 * @return   :
	 */
	public int doDelete(String newsid){
		String sql="delete from news where newsid=?";
		return util.runSql(sql, newsid);
	}
	
	
	public PageInfo pageList(int cpage){
		PageInfo pi=new PageInfo();
		String sql1="select count(*) from news";
		int rows=util.count(sql1);
		pi.setRows(rows);
		int pagesize=5;
		int maxpage=(pagesize+rows-1)/pagesize;
		pi.setMaxpage(maxpage);
		
		if(cpage<1)
			cpage=1;
		if(cpage>maxpage)
			cpage=maxpage;
		
		int begin=(cpage-1)*pagesize;
		
		String sql="SELECT a.*,b.typename FROM news a LEFT JOIN newstype b ON a.typeid=b.typeid LIMIT ?,?";
		List<News> list=util.query(News.class, sql, begin,pagesize);
		pi.setPageList(list);
		pi.setCpage(cpage);
		pi.setPagesize(pagesize);
		
		
		return pi;
	}
	public String allNews4JSON(){
		List<News> all=util.query(News.class, "select * from news");
		return JSONArray.fromObject(all).toString();
	}
}
