package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.*;

public class LoginServiceImpl implements LoginService {

	private LoginDao ldao;
	public LoginServiceImpl()
	{
		ldao=new LoginDaoImpl();
	}
	@Override
	public MyUser validateUser(String uname, String password) {
		// TODO Auto-generated method stub
		return ldao.checkUser(uname,password);
	}
}
