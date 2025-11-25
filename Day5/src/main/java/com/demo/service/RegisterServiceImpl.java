package com.demo.service;

import com.demo.dao.RegisterDao;
import com.demo.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService {
	private RegisterDao rdao;

	public RegisterServiceImpl() {
		rdao = new RegisterDaoImpl();
	}

	@Override
	public boolean registerUser(String uname, String pass, String email, String role, String gender) {

		return rdao.register(uname, pass, email, role, gender);
	}
}