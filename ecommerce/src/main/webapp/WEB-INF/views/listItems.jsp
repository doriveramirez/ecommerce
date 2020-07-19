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
						<script>
							window.id_catalog = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>&nbsp;/&nbsp;</li>
							<li class="active">All items</li>
						</ol>
					</c:if>
					<c:if test="${userClickCatalog == true}">
						<script>
							window.id_catalog = '${catalog.id_catalog}';
						</script>
						<ol class="breadcrumb">
							<li class="active">${item.name}</li>
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>&nbsp;/&nbsp;</li>
							<li><a href="${contextRoot}/show/all/items">All items</a></li>
							<li>&nbsp;/&nbsp;</li>
							<li class="active">${catalog.name}</li>
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
								<th></th>
								<th>Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>