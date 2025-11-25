package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDaoImpl implements RegisterDao {
	static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public boolean register(String uname, String pass, String email, String role, String gender) {
		String sql = "insert into user (uname, pass, email, role, gender) values (?, ?, ?, ?, ?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, uname);
			pst.setString(2, pass);
			pst.setString(3, email);
			pst.setString(4, role);
			pst.setString(5, gender);
			int n = pst.executeUpdate();

			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}