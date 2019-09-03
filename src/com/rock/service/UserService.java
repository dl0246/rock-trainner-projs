package com.rock.service;

import com.rock.entities.User;
import com.rock.util.JDBCUtil;

/**FileName:	com.rock.service 	UserService.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年8月28日:下午3:57:55
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年8月28日 	老张	 		1.0 		1.0 Version
 * 
 */
public class UserService {
	JDBCUtil util=null;
	public UserService(){
		util=new JDBCUtil();
	}
	public User login(String userid,String password){
		String sql="select * from user where userid=? and password=?";
		return util.queryById(User.class, sql, userid,password);
	}
	/**
	 * @TODO	 :
	 * @Date	 :2019年8月29日 上午11:27:07
	 * @Author	 :老张
	 * @param userid
	 * @return   :
	 */
	public boolean isExist(String userid) {
		String sql="select * from  user where userid=?";
		User user=util.queryById(User.class, sql,userid);
		if(user==null)
			return false;
		return true;
	}
}
