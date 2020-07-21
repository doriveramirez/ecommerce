<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up</h4>
				</div>
				<div class="panel-body">
					<sf:form method="POST" class="form-horizontal" id="registerForm"
						modelAttribute="user">
						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Name" />
									<sf:errors path="name" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" class="form-control"
									placeholder="format@format.com" />
									<sf:errors path="email" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" class="form-control"
									placeholder="Password" />
									<sf:errors path="password" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Admin?</label>
							<div class="col-md-8">
								<label class="radio-inline"> <sf:radiobutton path="admin"
										value="false" checked="checked" /> No
								</label> <label class="radio-inline"> <sf:radiobutton
										path="admin" value="true" /> Yes
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">Register</button>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>