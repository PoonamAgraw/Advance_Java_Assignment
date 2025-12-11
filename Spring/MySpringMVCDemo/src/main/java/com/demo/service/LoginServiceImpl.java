package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUSer;
import com.demo.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService{

	  @Autowired
      LoginDao ldao;
	  
	@Override
	public MyUSer validateUser(String uname, String passwd) {
		// TODO Auto-generated method stub
		return ldao.autheticateUser(uname,passwd);
	}

}
