package com.vms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vms.dbconnection.DbConnection;
import com.vms.model.BookingModel;

public class BookingService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public int insert(BookingModel been) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into booking(date,doctorName,vaccinationType,babyId) values(?,?,?,?)");
			ps.setDate(1, been.getDate());
			ps.setString(2, been.getDoctorName());
			ps.setString(3, been.getVaccinationType());
			ps.setInt(4, been.getBabyId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
