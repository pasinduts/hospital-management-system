<!DOCTYPE html>



<%@page import="java.sql.Connection"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>



<html lang="en">



<head>

<!-- #9999ff -->

<link rel="stylesheet" type="text/css" href="css/All.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<script type="text/javascript" src="js/clock.js"></script>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Update your card details</title>

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
					
<br><br>	
<h3>Update your Card Details</h3>

					
					
					<br><br>	
					
					
					<form action="Update_CardServlet" method="post">
					
					
				
						
						
						<div class="row">
							<div class="col-25">
								<p><b><b>Card no</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									
									<div class="input-group-prepend">
										<input type="text" value="" name="CardNo" required placeholder="">
									</div>
									
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-25">
								<p><b><b>card name</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									
									<div class="input-group-prepend">
										<input type="text" value="" name="CardName" required placeholder="">
									</div>
									
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-25">
								<p><b><b>card type</b></b></p>
							</div>
							<div class="col-65">
								<div class="input-group mb-3">
									
									<div class="input-group-prepend">
										<input type="text" value="" name="CardType" required placeholder="">
									</div>
								
								</div>
							</div>
						</div>
						
						
						
				
						<div class="row">
							
								<input type="submit" class="btn btn-secondary" value="Update ">
							
						</div>

<br><br>	
					</form>

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
	
	$(function () {
		  $('[data-toggle="popover"]').popover()
		});
	
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
	<script>
		var today = new Date().toISOString().split('T')[0];

		document.getElementsByName("dobirth")[0].setAttribute('max', today);

		function yesnoCheck() {
			if (document.getElementById('yesChecks').checked) {
				document.getElementById('ifYess').style.visibility = 'visible';
			} else
				document.getElementById('ifYess').style.visibility = 'hidden';

		}
	</script>



</body>

</html>
