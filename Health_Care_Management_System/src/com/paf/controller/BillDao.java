package com.paf.controller;
//package bill_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.paf.util.DBConnection;

public class BillDao {

//	public Connection connect() {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "root");
//
//			System.out.println("Successfully connected");
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

//--------------------insert card---------------------------------------------------------
	public String insertCard(String id, String custNo, String cardnumber, String cardname, String cardtype) {

		String output = "";

		try {
			//Connection con = connect();
			  Connection con = DBConnection.getConnection(); 
			
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into cardtable (`id`,`customerID`,`cardNo`,`cardName`,`cardType`) values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, Integer.parseInt(custNo));
			preparedStmt.setInt(3, Integer.parseInt(cardnumber));
			preparedStmt.setString(4, cardname);
			preparedStmt.setString(5, cardtype);

			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";
		}

		catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}

//--------------------------------UPDATE  card-----------------------------------------

	public String updateCard(String id, String customerID, String cardNo, String cardName, String cardType) {
		String output = "";

		try {
		//	Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE cardtable SET customerID=?,cardNo=?,cardName=?,cardType=?      WHERE id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setInt(1, Integer.parseInt(customerID));
			preparedStmt.setInt(2, Integer.parseInt(cardNo));
			preparedStmt.setString(3, cardName);
			preparedStmt.setString(4, cardType);
			preparedStmt.setInt(5, Integer.parseInt(id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// ----------DELETE card-------------------------------------

	public String deleteCard(String id) {
		String output = "";

		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from cardtable where id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));

			// execute the statement
			preparedStmt.execute();

			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// --------------READ card---------------------------------------------------

	public String readcardDetail() {
		String output = "";

		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			output = "	<table border=\"1\">" 
					+ "<tr>" 
					+ "<th>No</th>" 
					+ "<th>Customer Id</th>" 
					+ "<th>Card Name</th>"
					+ "<th>Card Type</th>" 
					+ "<th>Card Number</th>" 
					+ "<th>Update</th>" 
					+ "<th>Remove</th>" 
					+ "</tr>";

			String query = "select * from cardtable";
			// where id=?
			PreparedStatement sts = con.prepareStatement(query);

			ResultSet rss = sts.executeQuery();

			while (rss.next()) {

				String id = Integer.toString(rss.getInt("id"));
				String cid = Integer.toString(rss.getInt("customerID"));
				String cardNo = Integer.toString(rss.getInt("cardNo"));
				String cardName = rss.getString("cardName");
				String cardType = rss.getString("cardType");

				System.out.println("card name : " + cardName);

				output += "<tr>";
				output += "<td>" + id + "</td>";
				output += "<td>" + cid + "</td>";
				output += "<td>" + cardNo + "</td>";
				output += "<td>" + cardName + "</td>";
				output += "<td>" + cardType + "</td>";

				// buttons
				output += "<td> "
							+ "<input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btnUpdate btn btn-secondary\">"
						+ "</td>"
						+ "<td>"
					+	 "<form method=\"post\" action=\"CardDetails_Add.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
							+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + id + "\">"
							+ "</form>"
						+ "</td>"
						+ "</tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());

		}

		return output;

	}
	
	
	
	
	// --------------READ one card---------------------------------------------------

		public String readACard() {
			String output = "";

			try {
				//Connection con = connect();
				Connection con = DBConnection.getConnection(); 

				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				
				output = "	<table border=\"1\">" 
						+ "<tr>" 
						+ "<th>No</th>" 
						+ "<th>Customer Id</th>" 
						+ "<th>Card Name</th>"
						+ "<th>Card Type</th>" 
						+ "<th>Card Number</th>" 
						+ "<th>Update</th>" 
						+ "<th>Remove</th>" 
						+ "</tr>";

				String query = "select * from cardtable where customerID=?";
				// where id=?
				PreparedStatement sts = con.prepareStatement(query);

				ResultSet rss = sts.executeQuery();

				while (rss.next()) {

					String id = Integer.toString(rss.getInt("id"));
					String cid = Integer.toString(rss.getInt("customerID"));
					String cardNo = Integer.toString(rss.getInt("cardNo"));
					String cardName = rss.getString("cardName");
					String cardType = rss.getString("cardType");

					System.out.println("card name : " + cardName);

					output += "<tr>";
					output += "<td>" + id + "</td>";
					output += "<td>" + cid + "</td>";
					output += "<td>" + cardNo + "</td>";
					output += "<td>" + cardName + "</td>";
					output += "<td>" + cardType + "</td>";

					// buttons
					output += "<td> "
								+ "<input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btnUpdate btn btn-secondary\">"
							+ "</td>"
							+ "<td>"
						+	 "<form method=\"post\" action=\"CardDetails_Add.jsp\">"
								+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
								+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + id + "\">"
								+ "</form>"
							+ "</td>"
							+ "</tr>";
				}

				con.close();

				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the items.";
				System.err.println(e.getMessage());

			}

			return output;

		}
		
	
	
	
	
	
	
	

	// ----------add bill--------------------------------------------------------

	// public String addBill(BillClass e) {
	public String addBill(String billNo, String cno, String cname, String cemail, String cmobile, String cnote,
			String cappoinmnetno, String ctotal) {
		String output = "";

//		int No = e.getBillNumber();
//		String Name = e.getBillName();
//		String email = e.getBillEmail();
//		int mob = e.getBillMobile();
//		String note = e.getBillNote();
//		int apoinmentno = e.getBillAppoinmentNo();
//		double total = e.getBilltotal();

		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database";
			}

			String sql = "insert into billtable(billno,cno,cname,cemail,cmobile,cnote,cappoinmnetno,ctotal) values(?,?,?,?,?,?,?,?)";

			PreparedStatement p = con.prepareStatement(sql);

			p.setInt(1, 0);
			p.setInt(2, Integer.parseInt(cno));
			p.setString(3, cname);
			p.setString(4, cemail);
			p.setInt(5, Integer.parseInt(cmobile));
			p.setString(6, cnote);
			p.setInt(7, Integer.parseInt(cappoinmnetno));
			p.setDouble(8, Double.parseDouble(ctotal));

			p.execute();

			con.close();

			output = "Inserted successfully";

		}

		catch (Exception e1) {
			output = "Error while inserting";
			System.err.println(e1.getMessage());
		}

		return output;
	}

	// --------delete bill-------------------------------------

	public String deleteBill(String billNo) {
		String output = "";

		try {
		//	Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from billtable  where billNo=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(billNo));

			// execute the statement
			preparedStmt.execute();

			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// ---------------read bill----------------------------------------

	public String readAllBills() {
		String output = "";

		// Add into the html table
		try {
			//Connection con = connect();
			Connection con = DBConnection.getConnection(); 

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "	<table border=\"1\">" 
						+ "<tr>" 
						+ "<th>Bill NO</th>"
						+ "<th> number</th>"
						+ "<th> name</th>"
						+ "<th> email</th>" 
						+ "<th> mobile</th>"
						+ "<th>Note</th>" 
						+ "<th>appoinment no</th>"
						+ "<th>total</th>"
						+ "<th>Remove</th>" 
						+ "</tr>";

			String query = "select * from billtable";

			PreparedStatement sts = con.prepareStatement(query);

			ResultSet rss = sts.executeQuery();

			while (rss.next()) {

				String billno = Integer.toString(rss.getInt("billNo"));
				String cusno = Integer.toString(rss.getInt("cno"));
				String cusname = rss.getString("cname");
				String cusemail = rss.getString("cemail");
				String cumobile = Integer.toString(rss.getInt("cmobile"));
				String cusnote = rss.getString("cnote");
				String appoinmnetno = Integer.toString(rss.getInt("cappoinmnetno"));
				String total = Double.toString(rss.getDouble("ctotal"));

				System.out.println("namee : " + cusname);
				output += "<tr>";
				output += "<td>" + billno + "</td>";
				output += "<td>" + cusno + "</td>";
				output += "<td>" + cusname + "</td>";
				output += "<td>" + cusemail + "</td>";
				output += "<td>" + cumobile + "</td>";
				output += "<td>" + cusnote + "</td>";
				output += "<td>" + appoinmnetno + "</td>";
				output += "<td>" + total + "</td>";

				// buttons
				output += "<td>" 
						+ "<form method=\"post\" action=\"Adminview_AllCardsDetails.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
						+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + billno + "\">"
						+ "</form>" 
						+ "</td>" 
						+ "</tr>";
			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());

		}

		return output;

	}

}