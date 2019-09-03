package cn.rock.daoimpl;

import com.rock.util.JDBCUtil;

import cn.rock.dao.IUserDao;
import cn.rock.entities.User;

/**FileName:	cn.rock.daoimpl 	IUserDaoImpl.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年9月2日:上午11:10:38
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年9月2日 	老张	 		1.0 		1.0 Version
 * 
 */
public class IUserDaoImpl implements IUserDao {
	private JDBCUtil util;
	public IUserDaoImpl(){
		util=new JDBCUtil();
	}
	@Override
	public User login(String userid, String password) {
		return util.queryById(User.class, "select a.* from user a where a.userid=? and password=?", userid,password);
	}

}
