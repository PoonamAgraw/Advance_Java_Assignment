package com.demo.service;

import com.demo.dao.ResetDao;
import com.demo.dao.ResetDaoImpl;

public class ResetServiceImpl implements ResetService {
	private ResetDao rdao;

	public ResetServiceImpl() {
		rdao = new ResetDaoImpl();
	}

	@Override
	public boolean resetPsw(String uname, String pass, String email) {

		return rdao.resetPsw(uname, pass, email);
	}
}