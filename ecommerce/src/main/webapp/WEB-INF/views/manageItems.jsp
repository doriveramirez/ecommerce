<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Item Management</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="item"
						action="${contextRoot}/manage/items" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								item name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Item name" class="form-control" />
								<sf:errors path="name" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="price">Enter
								item price:</label>
							<div class="col-md-8">
								<sf:input type="number" value="0.01" path="price" id="price"
									step="0.01" min="0" class="form-control" />
								<sf:errors path="price" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="stock">Enter
								item stock:</label>
							<div class="col-md-8">
								<sf:input type="number" path="stock" id="stock"
									placeholder="Stock available" class="form-control" />
								<sf:errors path="stock" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Upload
								image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" style="color:red" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="id_catalog">Select
								catalog:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="id_catalog"
									path="id_catalog" items="${catalogs}" itemLabel="name"
									itemValue="id_catalog" />
								<c:if test="${item.id_item == 0}">
									<div class="text-right">
										</br>
										<button type="button" data-toggle="modal"
											data-target="#catalogModal" class="btn btn-warning btn-sm">Add
											a catalog</button>
									</div>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<div class="text-center">
									<input type="submit" name="submit" id="submit" value="Submit"
										class="btn btn-primary btn-block" />
								</div>
								<!-- Hidden fields -->
								<sf:hidden path="id_item" />
								<sf:hidden path="code" />
								<sf:hidden path="purchases" />
								<sf:hidden path="active" />
								<sf:hidden path="views" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h3>Available items</h3>
			</div>
			<div class="col-xs-12">
				<div style="overflow: auto">
					<table id="adminItemsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dissmissible">
					<button type="button" class="close" data-dismiss="alert"></button>
					${message}
				</div>
			</div>
		</c:if>
	</div>
	<div class="modal fade" id="catalogModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add new Catalog</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<sf:form id="catalogForm" modelAttribute="catalog" action="${contextRoot}/manage/catalog/" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="name" class="control-label col-md-4">Catalog name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="catalog_name" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Catalog" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>