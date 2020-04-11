<!DOCTYPE html>


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

<title>Payment Page</title>

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
					<br>
					<br>
					<br>


					<h4>
						<a href='CardDetails_Add.jsp' style="float: right">Save card
							details</a>
					</h4>
					<br>

					<h4>
						<a href='CardDetails_Update.jsp' style="float: right">Update
							card details</a>
					</h4>
					<br>

					<h4>
						<a href='CardDetails_ViewNDelete.jsp' style="float: right">View
							& delete card details</a>
					</h4>
					<br>


					<form class="forms" action="Add_BillServlet" method="post">


						<%
							if (null != session.getAttribute("Successed")) {
						%>

						<div class="alert alert-success" role="alert">Successfully
							redirecting..</div>

						<%
							} else if (null != session.getAttribute("error")) {
						%>

						<div class="alert alert-danger" role="alert">Cannot add
							redirect..</div>

						<%
							}
						%>

						<br> <br>
						<h3 style="color: black;">Bills Payment</h3>
						<br> <br>



						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Customer No</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customerno" placeholder=""
										style='width: 90.5%' disabled>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Customer Name</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customername" placeholder=""
										style='width: 90.5%' disabled>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Customer Email</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customeremail" placeholder=""
										style='width: 90.5%' disabled>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Customer Mobile</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customermobile" placeholder=""
										style='width: 90.5%' disabled>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Note</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customernote" placeholder=""
										style='width: 90.5%' disabled>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Appointment No</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customerappoinmemtno" placeholder=""
										style='width: 30.5%' disabled>
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Date</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<%
											java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
										%>
										<li class="nav-link"><%=df.format(new java.util.Date())%></li>
									</div>
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Total bill</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="customertotalbill" placeholder=""
										style='width: 30.5%' disabled>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Card number</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="cardno" placeholder=""
										style='width: 90.5%' required>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Card Name</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="cardname" placeholder=""
										style='width: 90.5%' required>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Card type</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="typecard" placeholder=""
										style='width: 90.5%' required> </select>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-25">
								<p>
									<b><b>Cvv number</b></b>
								</p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									<input type="text" name="cvv" placeholder=""
										style='width: 90.5%' required>
								</div>
							</div>
						</div>

						<br>
						<br> <br>
						<br>

						<div class="row">
							<input type="submit" value="Pay your bill" style='width: 40.5%'>
						</div>

						<br> <br>

						<div class="row">
							<input type="reset" value="Clear" style='width: 40.5%'>
						</div>
						<br>
						<br> <br>
						<br>


					</form>



					<br>
					<br>
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
