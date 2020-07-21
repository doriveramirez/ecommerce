<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">MHP Online Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="nav navbar-nav navbar-left">
				<security:authorize access="isAnonymous()">
					<li id="register" class="nav-item"><a class="nav-link"
						href="${contextRoot}/register">Register</a></li>
					<li id="listItems" class="nav-item"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="javascript:void(0)"
						class="btn btn-default dropdown-toggle" id="dropdownMenu1"
						data-toggle="dropdown"> User <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<%-- <li><a href="${contextRoot}/cart"> <span class="badge">&#128722;
									${userModel.cart.units}</span>${userModel.cart.totalPrice} &#8364;
						</a></li> --%>
							<security:authorize access="hasAuthority('USER')">
								<li><a href="${contextRoot}/cart"> <span class="badge">&#128722;</span>
										View cart
								</a></li>
								<li class="divider" role="separator"></li>
							</security:authorize>
							<li><a href="${contextRoot}/perform-logout">Logout</a></li>
						</ul></li>
				</security:authorize>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li id="home" class="nav-item"><a class="nav-link"
					href="${contextRoot}/home">Home</a></li>
				<li id="listItems" class="nav-item"><a class="nav-link"
					href="${contextRoot}/show/all/items">All Items</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageItems" class="nav-item"><a class="nav-link"
						href="${contextRoot}/manage/items">Manage Items</a></li>
				</security:authorize>
				<li id="about" class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li id="contact" class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>