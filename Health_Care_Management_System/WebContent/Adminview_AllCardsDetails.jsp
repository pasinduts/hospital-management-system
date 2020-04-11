<!DOCTYPE html>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>

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

<title>View & Delete Medicines</title>

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
<br>
<br>
<br>
					<h3>Your Card Details</h3>


<br>
					

					<br>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">number</th>
								<th scope="col">Name</th>
								<th scope="col">email</th>
								<th scope="col">mobile</th>
								<th scope="col">note</th>
								<th scope="col">appoiment no</th>							
								<th scope="col">total bill</th>
								<th scope="col">card no</th>
								<th scope="col">card name</th>							
								<th scope="col">card type</th>
								<th scope="col">delete</th>
								
							</tr>
						</thead>
						<tbody>
						
							

							<tr>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								<td>a</td>
								
								<td><a href="Delete_BillerServlet?"> delete 
									<img src="images/delete.png" alt="" border=3 height=23 width=23 style="float: center; margin-right: 0.5em">
									</a>
								</td>
							</tr>
							<tr>


							
							
						</tbody>
					</table>
 					
				</div>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="_footer.jsp"></jsp:include>
			</div>


		</div>

	</div>


	<!-- /#page-content-wrapper -->





	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		
	</script>



</body>

</html>
