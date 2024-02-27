package com.vms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vms.dbconnection.DbConnection;
import com.vms.model.BabyBeen;

public class BabyService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<BabyBeen> getAll() throws ClassNotFoundException {
		ArrayList<BabyBeen> groceryList = new ArrayList<BabyBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from babyDetails";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				BabyBeen model = new BabyBeen();
				model.setBabyId(rs.getInt("babyId"));
				model.setName(rs.getString("name"));
				model.setDob(rs.getDate("dob"));
				model.setGender(rs.getString("gender"));
				model.setFatherName(rs.getString("fatherName"));
				model.setMotherName(rs.getString("motherName"));
				model.setPlaceOfBirth(rs.getString("placeOfBirth"));
				model.setMobileNumber(rs.getString("mobileNumber"));
				
				groceryList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groceryList;
	}

	public BabyBeen getById(int id) throws ClassNotFoundException {
		BabyBeen model = new BabyBeen();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from babyDetails where babyId='" + id + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setBabyId(rs.getInt("babyId"));
				model.setName(rs.getString("name"));
				model.setDob(rs.getDate("dob"));
				model.setGender(rs.getString("gender"));
				model.setFatherName(rs.getString("fatherName"));
				model.setMotherName(rs.getString("motherName"));
				model.setPlaceOfBirth(rs.getString("placeOfBirth"));
				model.setMobileNumber(rs.getString("mobileNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public int deleteBaby(int id) throws ClassNotFoundException, SQLException {
		int status = 0;
		String query = "delete from babyDetails where babyId=" + id + "";
		con = DbConnection.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		status = ps.executeUpdate();
		return status;
	}

	public ArrayList<BabyBeen> get2() throws ClassNotFoundException {
		ArrayList<BabyBeen> list = new ArrayList<BabyBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from babyDetails";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				BabyBeen model = new BabyBeen();
				model.setBabyId(rs.getInt("babyId"));
				model.setName(rs.getString("name"));
				model.setDob(rs.getDate("dob"));
				model.setGender(rs.getString("gender"));
				model.setFatherName(rs.getString("fatherName"));
				model.setMotherName(rs.getString("motherName"));
				model.setPlaceOfBirth(rs.getString("placeOfBirth"));
				model.setMobileNumber(rs.getString("mobileNumber"));
				list.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert(BabyBeen been) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into babyDetails(name,dob,gender,fatherName,motherName,placeOfBirth, mobileNumber) values(?,?,?,?,?,?,?)");
			ps.setString(1, been.getName());
			ps.setDate(2, been.getDob());
			ps.setString(3, been.getGender());
			ps.setString(4, been.getFatherName());
			ps.setString(5, been.getMotherName());
			ps.setString(6, been.getPlaceOfBirth());
			ps.setString(7, been.getMobileNumber());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int update(BabyBeen been) throws ClassNotFoundException {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update babyDetails set name=?,dob=?,gender=?,fatherName=?,motherName=?,placeOfBirth=?, mobileNumber=?  where babyId='" + been.getBabyId() + "'");
			ps.setString(1, been.getName());
			ps.setDate(2, been.getDob());
			ps.setString(3, been.getGender());
			ps.setString(4, been.getFatherName());
			ps.setString(5, been.getMotherName());
			ps.setString(6, been.getPlaceOfBirth());
			ps.setString(7, been.getMobileNumber());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public String nameCheck(String check) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery("select mobileNumber from babyDetails where  mobileNumber = '" + check + "'");
			if (rs.next()) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}
}
