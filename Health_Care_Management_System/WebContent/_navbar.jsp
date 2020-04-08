
<nav class="navbar navbar-expand-lg navbar-light " style="background: linear-gradient(to right, #373737 0%, #FFF 100%); margin-left: -15px; margin-right: -15px; width: 102%;">
	<div class="container-fluid" style="margin-left: 0px;">
	<img src="images/menu.png" id="sidebarCollapse" alt="" border=3 height=22 width=29 style="margin-left: -20px; float: left; margin-right: 0.5em"> 
	<i class="fas fa-align-left">
	</i> 
	<span>
	</span>



		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon">
			</span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

				<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
				%>
				<li class="nav-link">
				<%=df.format(new java.util.Date())%>
				</li>

				<li class="nav-link" id="txt" style="font-color: #fffff">
				</li>

				<li>
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup=ue" aria-expanded="false"> 
						<b> 
						<img src="images/active.png" alt="" border=3 height=8 width=8 style="float: left;"> aaa
						</b>
					</a>
							
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
						
						
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="LogoutServlet">Logout</a>
						<a class="dropdown-item" href="AdminProfile.jsp">My Profile</a> 
					</div>
			</ul>
			
		</div>


	</div>

</nav>

