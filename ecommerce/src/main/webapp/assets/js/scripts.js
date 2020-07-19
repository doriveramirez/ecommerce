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
					data: 'stock',
					mRender: function(data, type, row){
						if(data < 1){
							return '<span style="color:red">Out of stock!</span>';
						} else {
							return '<span style="color:green">' + data + '</span>';
						}
						return data;
					}
				},
				{
					data: 'price',
					mRender: function(data, type, row){
						return data + '&#8364;'
					}
				},
				{
					data: 'id_item',
					bSortable: false,
					mRender: function(data, type, row){
						var link = '';
						link += '<a href="'+ window.contextRoot + '/show/' + data + '/item" class="btn btn-primary">View</a>';
						if(row.stock < 1){
							link += '<a href="javascript:void(0)" class="btn btn-success disabled">Add to cart</a>';
						} else {
							link += '<a href="'+ window.contextRoot + '/cart/add/' + data + '/item" class="btn btn-success">Add to cart</a>';
						}
						
					return link;
					}
				}
			]
		});
	}
});