package com.paf.service;

	
import com.paf.controller.PatientController;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Patient")
	
public class PatientService	{
		
	PatientController ptnt = new PatientController();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient()
	 {
	 return ptnt.readPatient();
	 }
	}	


