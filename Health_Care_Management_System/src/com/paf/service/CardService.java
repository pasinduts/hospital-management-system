package com.paf.service;
//package bill_package;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.controller.BillDao;

@Path("/Cards")
public class CardService {

	BillDao billd = new BillDao();

	// -------read card details--------------------------

	@GET
	@Path("/readcard")
	@Produces(MediaType.TEXT_HTML)
	public String readCards() {
		return billd.readcardDetail();
	}


	// -------read one card details--------------------------

	@GET
	@Path("/readAcard")
	@Produces(MediaType.TEXT_HTML)
	public String readACard() {
		return billd.readACard();
	}

	
	// ------inserting card details----------------------
	@POST
	@Path("/addcard")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCardDetails(@FormParam("id") String id, @FormParam("customerID") String customerid,
			@FormParam("cardNo") String cardNo, @FormParam("cardName") String cardName,
			@FormParam("cardType") String cardType) {
		String output = billd.insertCard(id, customerid, cardNo, cardName, cardType);
		return output;
	}

	// -------update card details---------------------------

	@PUT
	@Path("/updatecard")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCardDetails(String card) {
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(card).getAsJsonObject();

		// Read the values from the JSON object
		String id = itemObject.get("id").getAsString();
		String customerID = itemObject.get("customerID").getAsString();
		String cardNo = itemObject.get("cardNo").getAsString();
		String cardName = itemObject.get("cardName").getAsString();
		String cardType = itemObject.get("cardType").getAsString();

		String output = billd.updateCard(id, customerID, cardNo, cardName, cardType);

		return output;
	}

	// -------delete card details---------------------------

	@DELETE
	@Path("/deletecard")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemCard) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(itemCard, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		String id = doc.select("id").text();

		String output = billd.deleteCard(id);

		return output;

	}
	
	
	
	
	

}
