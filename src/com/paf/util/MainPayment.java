package com.paf.util;

import com.paf.controller.BillDao;

public class MainPayment {

	public static void main(String[] args) {
		
		
		//DBConnection con = new DBConnection();
		//con.getConnection();
//BillDao dao = new BillDao();
	//	dao.readACard();
		//DBConnection con = new DBConnection();
		//con.getConnection();
		
		BillDao b = new BillDao();
		b.readAllBills();

	}

}
