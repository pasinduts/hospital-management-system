
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
  //initialize
    session.setAttribute("statusMsg","");
    System.out.println("Trying to process...");

    	//Save---------------------------------
    	if (request.getParameter("itemCode") != null)
    	{
    		BillDao itemObj = new BillDao();
    		String stsMsg = "";

    		//Insert-------------------------- 
    		if (request.getParameter("hidIDSave") == "")
    		{
    			stsMsg = itemObj.insertCard(
    					request.getParameter("id"), 
    					request.getParameter("custID"),
    					request.getParameter("cardNo"),
    					request.getParameter("cardName"),
    					request.getParameter("cardType"));
    		} else
    		//Update---------------------- 
    		{
    			stsMsg = itemObj.updateCard(
    					request.getParameter("id"), 
    					request.getParameter("custID"),
    					request.getParameter("cardNo"),
    					request.getParameter("cardName"),
    					request.getParameter("cardType"));
    		}

    		session.setAttribute("statusMsg", stsMsg);
    	}

    	//Delete----------------------------- 
    	if (request.getParameter("hidItemIDDelete") != null)
    	{
    		BillDao itemObj = new BillDao();
    		String stsMsg = itemObj.deleteCard(request.getParameter("id"));
    		session.setAttribute("statusMsg", stsMsg);
    	}
    %>
    

<!DOCTYPE html>

<%@page import="bill_package.BillDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<html lang="en">



<head>

<!-- #9999ff -->

<link rel="stylesheet" type="text/css" href="css/All.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<script type="text/javascript" src="js/clock.js"></script>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Save card details</title>

</head>

<body>
<body onload="startTime()">

	<div class="d-flex" id="sidebar-wrapper">

		<!-- Sidebar -->
		<jsp:include page="_sidebar.jsp"></jsp:include>

		<!-- Page Content -->
		<div class=container-fluid>
			<div id="content">
				<jsp:include page="_navbar.jsp"></jsp:include>

				<div class="container">
					<br> <br> <br>

					
					<form class="forms" action="Add_CardServlet" method="post">


					
						<h3 style="color: black;">Save card details</h3>
						<br> <br>
<div class="row">
							<div class="col-25">
								<p><b><b>Customer number</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" id="custID" name="custID" placeholder=""	style='width: 90.5%' required>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p><b><b>Card number</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" id="cardNo" name="cardNo" placeholder=""	style='width: 90.5%' required>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-25">
								<p><b><b>Card Name</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" id="cardName" name="cardName" placeholder="" style='width: 90.5%' required>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p><b><b>Card type</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text"  id="cardType" name="cardType" placeholder="" style='width: 90.5%' required> 
								</div>
							</div>
						</div>

 <br>

						<div class="row">
							<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary" style='width: 40.5%'>
						</div>

						
						<br> 


					</form>
<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>


				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<%
					BillDao itemObj = new BillDao();
					out.print(itemObj.readcardDetail());
					out.print(session.getAttribute("statusMsg"));
				%>


					<br> <br>	<br> <br>
				</div>
				<jsp:include page="_footer.jsp"></jsp:include>
			</div>
		</div>
	</div>


	<!-- /#page-content-wrapper -->




	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("active");
		});

		$(document).ready(function() {

			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});

		});

		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}

		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>



</body>

</html>
