package com.vms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.vms.dbconnection.DbConnection;
import com.vms.model.BeenLogin;

public class LoginServiceEMS {

	public String check(BeenLogin beenEMS) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String username = beenEMS.getUsername();
		String password = beenEMS.getPassword();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery("select username,password from login where  username = '" + username
					+ "' and  password = '" + password + "'");
			if (rs.next()) {
				return "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failed";
	}

	public int register(BeenLogin beenEMS) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String username = beenEMS.getUsername();
		String password = beenEMS.getPassword();
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into login(username,password) values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

}
