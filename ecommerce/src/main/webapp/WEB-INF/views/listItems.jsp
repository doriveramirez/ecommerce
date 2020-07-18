<div class="container">
	<div class="row">
		<!-- Sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- Items -->
		<div class="col-md-9">
			<!-- Breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllItems == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li class="active">/All items</li>
						</ol>
					</c:if>
					<c:if test="${userClickCatalog == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>/Catalog</li>
							<li class="active">/${catalog.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="itemListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>