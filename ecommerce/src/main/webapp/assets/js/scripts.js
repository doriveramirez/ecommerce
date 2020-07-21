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
		case'Manage Items':
			$('#manageItems').addClass('active');
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
	
	//Alert dissmiss after 3 seconds
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		} , 3000)
	}
	
	var $adminItemsTable = $('#adminItemsTable');
	if ($adminItemsTable.length){
		var jsonUrl = window.contextRoot + '/json/data/admin/all/items';
		$adminItemsTable.DataTable({
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id_item'
				},
				{
					data: 'code',
					mRender: function(data,type,row){
						return '<img src="'+window.contextRoot+'/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
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
					data: 'active',
					bSortable: false,
					mRender: function(data,type,row){
						var slider = '';
						slider += '<label class="switch">';
						if(data) {
							slider += '<input type="checkbox" checked="checked" value="'+row.id_item+'" />';
						} else{
							slider += '<input type="checkbox" value="'+row.id_item+'" />';
						}
						slider += '<div class="slider"/></label>';
						return slider;
					}
				},
				{
					data: 'id_item',
					bSortable: false,
					mRender: function(data, type, row){
						var edit = '';
						edit += '<td><a href="'+window.contextRoot+'/manage/'+data+'/item" class="btn btn-warning">&#9999;</a></td>';
						return edit;
					}
				}
			],
				initComplete: function(){
					var api = this.api();
					api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dialogMessage = (checked)? 'Want to active the item?':'Want to deactivate the item?'
					var value = checkbox.prop('value');
					bootbox.confirm({
						size: 'medium',
						title: 'Item activation',
						message: dialogMessage,
						callback: function(confirmed){
							if(confirmed){
								var activationUrl = window.contextRoot = '/manage/item/' + value + '/activation/';
								$.post(activationUrl, function(data){
									bootbox.alert({
									size: 'medium',
									title: 'Information',
									message: data
									});
								});
							} else {
								checkbox.prop('checked', !checked);
							}
						}
					});
				});
			}
		});
	}
	
	var $catalogForm = $('#catalogForm');
	if($catalogForm.length){
		$catalogForm.validate({
			rules : {
				name : {
					required: true,
					minLength: 2
				}
			},
			messages : {
				name : {
					required: 'Catalog name must be added.',
					minlength: 'The name can´t be less than 2 characters'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	var $loginForm = $('#loginForm');
	if($loginForm.length){
		$loginForm.validate({
			rules : {
				username : {
					required: true,
					email: true
				},
				password : {
					required: true
				}
			},
			messages : {
				username : {
					required: 'Username must be entered.',
					email: 'Valid email must be entered.'
				},
				password: {
					required: 'Password must be entered.'
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	// csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length > 0){
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header, token);
		});
	}
});