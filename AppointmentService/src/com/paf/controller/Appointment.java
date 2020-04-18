package com.paf.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Appointment {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/appointmentservice", "root", "Lalindu97");
			//?verifyServerCertificate=false&useSSL=true");
			// For testing
			System.out.println("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String insertAppointmnet(String name, int contact, String date,String DocName) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into Appointment(`AID`,`AName`,`AContact`,`ADate`,`ADocName`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, contact);
			preparedStmt.setString(4,date);
			preparedStmt.setString(5, DocName);
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
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
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// System.out.println("------------b---------------------------------");
			// Add into the html table
			// Prepare the html table to be displayed
			output = "<table border=\"1\">" + "<tr>" + "<th>Patient Name</th>" + "<th>Contact Number</th>"
					+ "<th>Appointment Date</th>" + "<th>Doctor Name</th>" + "<th>Update</th>" + "<th>Remove</th>"
					+ "</tr>";
			// System.out.println("------------c--------------------------------");
			String query = "select * from appointment";
			// Statement stmt = (Statement) con.createStatement();
			PreparedStatement sts = con.prepareStatement(query);
			
			ResultSet rss = sts.executeQuery();

			while (rss.next()) {
				// System.out.println("------------e---------------------------------");
				int AID = rss.getInt("AID");
				String AName = rss.getString("AName");
				int AContact = rss.getInt("AContact");
				String ADate = rss.getString("ADate");
				String ADocName = rss.getString("ADocName");

				System.out.println("Patient Name : " + AName);

				output += "<tr><td>" + AName + "</td>";
				output += "<td>" + AContact + "</td>";
				output += "<td>" + ADate + "</td>";
				output += "<td>" + ADocName + "</td>";

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

	public String updateAppointment(String ID, String name, String contact, String date,String DocName) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE appointment SET `AName` = ?, `AContact` = ?, `ADate` = ?, `ADocName` = ? WHERE `AID` = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
			preparedStmt.setString(2, name);
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, DocName);
			
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
			Connection con = connect();
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
