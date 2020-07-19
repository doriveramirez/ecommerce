<h1 class="my-4">Catalog</h1>
<div class="list-group">
<a href="${contextRoot}/show/all/items" class="list-group-item">All items</a>
	<c:forEach items="${catalogs}" var="catalog">
		<a href="${contextRoot}/show/catalog/${catalog.id_catalog}/items" class="list-group-item" id="a_${catalog.name}">${catalog.name}</a>
	</c:forEach>
</div>