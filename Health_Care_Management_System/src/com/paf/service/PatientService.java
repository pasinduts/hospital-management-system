package com.paf.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import com.paf.controller.PatientController;
import com.paf.model.PatientModel;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Patient")
public class PatientService {
	
	PatientController PatientController = new PatientController();

	@GET
	@Path("/read")
	@Produces({ MediaType.TEXT_PLAIN })
	public String readPatient() {
		return new Gson().toJson(PatientController.readPatient());
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String AddPatient(@FormParam("Pname") String Pname, @FormParam("Gender") String Gender,
			@FormParam("Age") String Age, @FormParam("Blood_group") String Blood_group, @FormParam("Pcontact") String Pcontact
			) throws ParseException {

		PatientModel patient = new PatientModel();
		patient.setPname(Pname);
		patient.setGender(Gender);
		patient.setAge(Integer.parseInt(Age));
		patient.setBlood_group(Blood_group);
		patient.setPcontact(Pcontact);

		return PatientController.AddPatient(patient);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(@PathParam("id")String PID) {

		return PatientController.deletePatient(PID);
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(@FormParam("Pname") String Pname, @FormParam("Gender") String Gender,
			@FormParam("Age") String Age, @FormParam("Blood_group") String Blood_group, @FormParam("Pcontact") String Pcontact
			) throws ParseException {

		PatientModel patient = new PatientModel();
		patient.setPname(Pname);
		patient.setGender(Gender);
		patient.setAge(Integer.parseInt(Age));
		patient.setBlood_group(Blood_group);
		patient.setPcontact(Pcontact);

		return PatientController.updatePatient(patient);
	}
	
	

}
