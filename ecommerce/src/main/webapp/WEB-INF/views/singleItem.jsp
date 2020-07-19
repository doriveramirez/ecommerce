<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/show/all/items">All items</a></li>
				<li>&nbsp;/&nbsp;</li>
				<li><a href="${contextRoot}/show/catalog/${item.id_catalog}/items">${catalog.name}</a></li>
				<li>&nbsp;/&nbsp;</li>
				<li class="active">${item.name}</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<!-- Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${item.code}.jpg" class="responsive" />
			</div>
		</div>
		<!-- Name -->
		<div class="col-xs-12 col-sm-8">
			<h3>${item.name}</h3>
			<h4>
				Price: <strong>${item.price}&#8364;</strong>
			</h4>
			<c:choose>
				<c:when test="${item.stock < 1}">
					<h6>Stock: <span style="color:red">Out of stock</span></h6>
					<a href="javascript:void(0)" class="btn btn-success disabled">Add to cart</a>
				</c:when>
				<c:otherwise>
					<h6>Stock: <span style="color:green">${item.stock}</span></h6>
					<a href="${contextRoot}/cart/add/${Item.id}/item" class="btn btn-success">Add to cart</a>
				</c:otherwise>
			</c:choose>
			 <a href="${contextRoot}/show/all/items" class="btn btn-primary">Back</a>
		</div>
	</div>
</div>