package Hospital_Management;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Hospital_Management.*;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import Hospital_Management.hospitalDetails;

@Path("/hospitalDetails")
public class HospitalServices {

	hospitalDetails hospital = new hospitalDetails();
	AddingDoctor doctor = new AddingDoctor();
	
	
	// readdata hospital
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital() {

		return hospital.readHospital();
	}
	
	// Inserting data hospital
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("companyName") String companyName,
	 @FormParam("contact") String contact,
	 @FormParam("email") String email,
	 @FormParam("address") String address,
	 @FormParam("services") String services,
	 @FormParam("userName") String userName,
	 @FormParam("password") String password)
	{
	 String output = hospital.insertHospital(companyName, contact, email, address,services,userName,password);
	return output;
	}

	
	//updating data hospital
	
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateHospital(String hospitalData)
		{
		//Convert the input string to a JSON object
		 JsonObject itemObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		//Read the values from the JSON object
		 String Hid = itemObject.get("Hid").getAsString();
		 String companyName = itemObject.get("companyName").getAsString();
		 String contact = itemObject.get("contact").getAsString();
		 String email = itemObject.get("email").getAsString();
		 String address = itemObject.get("address").getAsString();
		 String services = itemObject.get("services").getAsString();
		 String userName = itemObject.get("userName").getAsString();
		 String password = itemObject.get("password").getAsString();
		 String output = hospital.updateHospital(Hid, companyName, contact, email, address,services,userName,password);
		return output;
		}
		
		//delete(remove) hospital
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteHospital(String hospitalData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String Hid = doc.select("Hid").text();
		 String output = hospital.deleteHospital(Hid);
		return output;
		}
	
		
		
		//read doctor details to add 
		@GET
		@Path("/addDoctor")
		@Produces(MediaType.TEXT_HTML)
		public String readDoctorForAdding() {

			return doctor.readDoctorForAdding();
		}
		
		// read doctor details which added
			@GET
			@Path("/readDoctor")
			@Produces(MediaType.TEXT_HTML)
			public String readAddedDoctor() {

				return doctor.readAddedDoctor();
			}
		
			
		// Inserting data doctor for hospital
			@POST
			@Path("/readDoctor")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
		public String insertDoctorHospital(@FormParam("Hid") String Hid,
			 @FormParam("Mid") String Mid)
			{
			 String output = doctor.insertDoctorHospital(Hid,Mid);
			return output;
			}

		//delete(remove) doctor
			@DELETE
			@Path("/readDoctor")
			@Consumes(MediaType.APPLICATION_XML)
			@Produces(MediaType.TEXT_PLAIN)
		public String deleteAddedDoctor(String DoctorData)
			{
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(DoctorData, "", Parser.xmlParser());

			
			 String Hid = doc.select("Hid").text();
			 String Mid = doc.select("Mid").text();
			 String output = doctor.deleteAddedDoctor(Hid,Mid);
			return output;
			}
	
}
