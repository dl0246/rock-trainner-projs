package cn.rock.dao;

import cn.rock.entities.User;

/**FileName:	cn.rock.dao 	IUserDao.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年9月2日:上午11:08:42
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年9月2日 	老张	 		1.0 		1.0 Version
 * 
 */
public interface IUserDao {
	public User login(String userid,String password);
	
}
