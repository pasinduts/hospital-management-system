package bill_package;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

@Path("/Bills")
public class BillService {

	BillDao billdao = new BillDao();

//-------reading all billers---------------------------
	@GET
	@Path("/readbill")
	@Produces(MediaType.TEXT_HTML)
	public String readAllBillers() {
		// return "Hello";
		return billdao.readAllBills();
	}

	// ---------insert bill details--------------------------

	@POST
	@Path("/addbill")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertbillDetails(@FormParam("billNo") String billNo, @FormParam("cno") String cno,
			@FormParam("cname") String cname, @FormParam("cemail") String cemail, @FormParam("cmobile") String cmobile,
			@FormParam("cnote") String cnote, @FormParam("cappoinmnetno") String cappoinmnetno,
			@FormParam("ctotal") String ctotal) {
		String output = billdao.addBill(billNo, cno, cname, cemail, cmobile, cnote, cappoinmnetno, ctotal);
		return output;
	}

//
//	// --------delete bill details-----------------------------
//
	@DELETE
	@Path("/deletebill")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBill(String itemBill) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(itemBill, "", Parser.xmlParser());
		// Read the value from the element <itemID>
		String billNo = doc.select("billNo").text();

		String output = billdao.deleteBill(billNo);
		return output;

	}

}
