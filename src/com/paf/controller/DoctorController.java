package com.paf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.paf.model.Doctor;
import com.paf.util.DBConnection;

public class DoctorController {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public String AddDoctor(Doctor doctor) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			 if (connection == null)
			 {return "Error while connecting to the database for inserting."; } 
			
			ps = connection.prepareStatement(
					"INSERT INTO  doctor(Did,Dname,Dmail,Specialization,Dcontact) "
							+ "	VALUES (?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, doctor.getDname());
			ps.setString(3, doctor.getDmail());
			ps.setString(4, doctor.getSpecialization());
			ps.setString(5, doctor.getDcontact());
			

			ps.execute();
			 connection.close();
			 output = "Inserted successfully"; 

		}
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output; 

		
	}

	public List<Doctor> readDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				System.err.println("connecting failed.");
			}
			// Prepare the html table to be displayed
			

			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from doctor");
			

			// iterate through the rows in the result set
			while (rs.next()) {
				Doctor doc = new Doctor();
				doc.setDid(rs.getInt("Did"));
				doc.setDname(rs.getString("Dname"));
				doc.setDmail(rs.getString("Dmail"));
				doc.setSpecialization(rs.getString("Specialization"));
				doc.setDcontact(rs.getString("Dcontact"));

				doctors.add(doc);
			}
			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return doctors;
	}

	public String updatedoctor(Doctor doctor) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			ps = connection.prepareStatement(
					"UPDATE doctor SET Dname=?,Dmail=?,Specialization=?,Dcontact=? WHERE Did=?");

			// binding values
			ps.setString(1, doctor.getDname());
			ps.setString(2, doctor.getDmail());
			ps.setString(3,doctor.getSpecialization());
			ps.setString(4, doctor.getDcontact());
			ps.setInt(5, doctor.getDid());
			// execute the statement
			ps.execute();
			connection.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctor(String Did) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("delete from doctor where Did=?");
			// binding values
			ps.setInt(1, Integer.parseInt(Did));
			// execute the statement
			ps.execute();
			connection.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item. -"+ e.getMessage();
			System.err.println(e.getMessage());
		}
		return output;
	}

}
