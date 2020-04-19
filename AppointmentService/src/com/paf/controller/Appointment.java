package com.paf.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.paf.model.AppoinmentClass;
import com.paf.util.DBConnection;

public class Appointment {

//	public Connection connect() {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/appointmentservice", "root", "Lalindu97");
//			//?verifyServerCertificate=false&useSSL=true");
//			// For testing
//			System.out.println("Successfully connected");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return con;
//	}

	public String insertAppointmnet(AppoinmentClass a) {
		String output = "";
		
		String id = a.getId();
		String name = a.getName();
		String contact = a.getContact();
		String date = a.getDate();
		String doctor =  a.getDoctor();
		String location = a.getLocation();
		String ttime = a.getTime();
		
		
		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection();
			
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into appointment(`AID`,`AName`,`AContact`,`ADate`,`ADocName`,`Alocation`,`Atime`) values (?, ?, ?, ?, ?, ?, ?)";
			//INSERT INTO `appointmentservice`.`appointment` (`AID`, `AName`, `AContact`, `ADate`, `ADocName`, `Alocation`, `Atime`) VALUES ('4', 'aa', '1452', '30-mar-2025', 'FD', 'shg', '50.00 A M');

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2,name);
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, doctor);
			preparedStmt.setString(6, location);
			preparedStmt.setString(7, ttime);
			
			//System.out.println(e);
			System.out.println(name);
			System.out.println(contact);
			System.out.println(date);
			System.out.println(doctor);
			System.out.println(location);
			System.out.println(ttime);
			
			con.close();
			output = "Inserted successfully";
			System.out.println("Inserted successfully----------");
		} catch (Exception e) {
			output = "Error while inserting the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readAppointment() {
		String output = "";
		System.out.println("----------------------------------------------");
		// Add into the html table
		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection();
			
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// System.out.println("------------b---------------------------------");
			// Add into the html table
			// Prepare the html table to be displayed
			output = "<table border=\"1\">" + "<tr>" + "<th>Patient Name</th>" + "<th>Contact Number</th>"
					+ "<th>Appointment Date</th>" + "<th>Doctor Name</th>" + "<th>Location</th>" + "<th>Time</th>" + "<th>Update</th>" + "<th>Remove</th>"
					+ "</tr>";
			// System.out.println("------------c--------------------------------");
			String query = "select * from appointment";
			// Statement stmt = (Statement) con.createStatement();
			PreparedStatement sts = con.prepareStatement(query);
			
			ResultSet rss = sts.executeQuery();

			while (rss.next()) {
				// System.out.println("------------e---------------------------------");
				//b.setCusNo(Integer.toString(rss.getInt("cno")));
				//b.setCusName(rss.getString("cname"));
				
				AppoinmentClass a = new AppoinmentClass();
				
				a.setId(Integer.toString(rss.getInt("AID")));
				a.setName(rss.getString("AName"));
				a.setContact(Integer.toString(rss.getInt("AContact")));
				a.setDate(rss.getString("ADate"));
				a.setDoctor(rss.getString("ADocName"));
				a.setLocation(rss.getString("Alocation"));
				a.setTime(rss.getString("Atime"));
				
				String AID = a.getId();
				String AName = a.getName();
				String AContact = a.getContact();
				String ADate = a.getDate();
				String ADocName = a.getDoctor();
				String location = a.getLocation();
				String ttime = a.getTime();
				
				
				System.out.println("Patient Name : " + AName);

				output += "<tr><td>" + AName + "</td>";
				output += "<td>" + AContact + "</td>";
				output += "<td>" + ADate + "</td>";
				output += "<td>" + ADocName + "</td>";
				output += "<td>" + location + "</td>";
				output += "<td>" + ttime + "</td>";

				// buttons
				output += "<td>" + "<input name=\"btnUpdate\" " + " type=\"button\" value=\"Update\">" + "</td>"
						+ "<td>" + "<form method=\"post\" action=\"Appointments.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" value=\"Remove\">" + "<input name=\"AID\" type=\"hidden\" " + " value=\""
						+ AID + "\">" + "</form></td></tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Appointment.";
			System.err.println(e.getMessage());

		}

		return output;

	}

	public String updateAppointment(String ID, String name, String contact, String date,String DocName,String location,String time) {
		String output = "";
		try {
			//Connection con = connect();
			
			Connection con = DBConnection.getConnection();
			
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE appointment SET `AName` = ?, `AContact` = ?, `ADate` = ?, `ADocName` = ?, `Alocation` = ?, `Atime` = ? WHERE `AID` = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			System.out.println("----------update start---------");
			preparedStmt.setInt(1, Integer.parseInt(ID));
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, DocName);
			preparedStmt.setString(6, date);
			preparedStmt.setString(7, DocName);
			
			System.out.println("----------update ---------");
			System.out.println(ID);
			System.out.println( name);
			System.out.println(contact);
			System.out.println(date);
			System.out.println(DocName);
			// execute the statement
			preparedStmt.execute();

			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteAppointment(String AID) {
		String output = "";
		try {
			//Connection con = connect();
		
			Connection con = DBConnection.getConnection();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from appointment where AID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(AID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
