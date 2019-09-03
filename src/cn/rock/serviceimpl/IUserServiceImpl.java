package cn.rock.serviceimpl;

import cn.rock.dao.IUserDao;
import cn.rock.daoimpl.IUserDaoImpl;
import cn.rock.entities.User;
import cn.rock.service.IUserService;


/**FileName:	cn.rock.serviceimpl 	IUserServiceImpl.java
 * TODO:		
 * Copyright:	Copyright (c) 2015-2016 All Rights Reserved. Company: 01skill-soft.com Inc.
 * @author: 	老张
 * @Date:		2019年9月2日:上午11:07:54
 * @version: 	1.0
 * 
 *           Modification History: Date			Author 		Version 	Description
 *           ----------------------------------------------------------------------
 *           					   2019年9月2日 	老张	 		1.0 		1.0 Version
 * 
 */
public class IUserServiceImpl implements IUserService{
	private IUserDao iUserDao;
	public IUserServiceImpl(){
		iUserDao=new IUserDaoImpl();
	}
	@Override
	public boolean login(String userid, String password) {
		User user=iUserDao.login(userid, password);
		if(user==null)
			return false;
		else 
			return  true;
	}
}
