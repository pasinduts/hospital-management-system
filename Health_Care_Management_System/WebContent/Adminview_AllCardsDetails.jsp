<!DOCTYPE html>


<%@page import="bill_package.BillDao"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="bill_package.BillDao"%>

<html lang="en">

<%
	
%>


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

<title>View and Delete Medicines</title>

</head>

<body>
<body onload="startTime()">


	<div class="d-flex" id="sidebar-wrapper">

		<!-- Sidebar -->

		<jsp:include page="_sidebar.jsp"></jsp:include>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div class=container-fluid>
			<div id="content">
				<jsp:include page="_navbar.jsp"></jsp:include>


				<div class="container">

					<!-- /#Type Body Here -->
					<br> <br> <br>
				
<h3 style="color: black;">Your Card Details</h3>

	<br>	

<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>


				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<%
					BillDao itemObj = new BillDao();
					out.print(itemObj.readAllBills());
					out.print(session.getAttribute("statusMsg"));
				%>





				</div>
				<br>
				<br>	<br>	<br>	<br>
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
