package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetDaoImpl implements ResetDao {
	static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public boolean resetPsw(String uname, String email, String pass) {
		String query = "UPDATE USER SET pass=? where uname=? and email=?";
		try (PreparedStatement pst = conn.prepareStatement(query)) {
			pst.setString(1, pass);
			pst.setString(2, uname);
			pst.setString(3, email);
			int n = pst.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}