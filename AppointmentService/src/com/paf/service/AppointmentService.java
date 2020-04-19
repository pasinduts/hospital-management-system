package com.paf.service;



import java.sql.Date;
import java.util.List;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;

//For JSON
import com.google.gson.*;
import com.paf.controller.Appointment;
import com.paf.model.AppoinmentClass;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Appointments")
public class AppointmentService {
	Appointment appointmentObj = new Appointment();
	
	
//	@GET 
//	@Path("/test")
//	@Produces(MediaType.TEXT_PLAIN) 
//	public String helloName(@PathParam("name") String name) 
//	{  
//		return "Hello " + name; 
//		} 

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointment() {
		return appointmentObj.readAppointment();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(
			@FormParam("AID") String id, 
			@FormParam("AName") String name, 
			@FormParam("AContact")String contact,
			@FormParam("ADate") String date,
			@FormParam("ADocName") String DocName,
			@FormParam("Alocation") String location, 
			@FormParam("Atime") String time) {
		
		AppoinmentClass aa = new AppoinmentClass();
		aa.setId(id);
		aa.setName(name);
		aa.setContact(contact);
		aa.setDate(date);
		aa.setDoctor(DocName);
		aa.setLocation(location);
		aa.setTime(time);
		
		String output = appointmentObj.insertAppointmnet(aa);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointment(String AppointmentData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(AppointmentData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String AID = doc.select("AID").text();
		String output = appointmentObj.deleteAppointment(AID);
		return output;
	}

	@PUT
	@Path("/updateapp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(String AppointmentData) {
		// Convert the input string to a JSON object
		JsonObject AppointmentObject = new JsonParser().parse(AppointmentData).getAsJsonObject();
		
		// Read the values from the JSON object
		String AName = AppointmentObject.get("AName").getAsString();
		String AContact = AppointmentObject.get("AContact").getAsString();
		String ADate = AppointmentObject.get("ADate").getAsString();
		String ADocName = AppointmentObject.get("ADocName").getAsString();
		String Alocation = AppointmentObject.get("Alocation").getAsString();
		String Atime = AppointmentObject.get("Atime").getAsString();
		String AID = AppointmentObject.get("AID").getAsString();
		
		String output = appointmentObj.updateAppointment(AID, AName, AContact, ADate, ADocName, Alocation, Atime);
		
		return output;
	}
	


}
