$(function(){
	switch(menu){
		default: 
			if(menu == "Home") break;
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break
		case'Home':
			$('#home').addClass('active');
			break;
		case'About MHP':
			$('#about').addClass('active');
			break;
		case'Contact MHP':
			$('#contact').addClass('active');
			break;
		case'All Items':
			$('#listItems').addClass('active');
			break;
	}
	

	var $table = $('#itemListTable');
	if ($table.length){
		var jsonUrl = '';
		if(window.id_catalog == ''){
			jsonUrl = window.contextRoot + '/json/data/all/items';
		} else {
			jsonUrl = window.contextRoot + '/json/data/catalog/' + window.id_catalog + '/items';
		}
		$table.DataTable({
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					mRender: function(data,type,row){
						return '<img src="'+window.contextRoot+'/resources/images/' + data + '.jpg" class="dataTableImg"/>';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'stock'
				},
				{
					data: 'price',
					mRender: function(data, type, row){
						return data + '&#36;'
					}
				},
				{
					data: 'id_item',
					bSortable: false,
					mRender: function(data, type, row){
						var link = '';
						link += '<a href="'+ window.contextRoot + '/show/' + data + '/item" class="btn btn-primary">View</a>';
						link += '<a href="'+ window.contextRoot + '/cart/add/' + data + '/item" class="btn btn-success">Add to cart</a>';
					return link;
					}
				}
			]
		});
	}
});