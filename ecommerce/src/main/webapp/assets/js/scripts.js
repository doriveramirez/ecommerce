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
	
	var items = [
		
					['1', 'ABC'],
					['2', 'AFD'],
					['3', 'SDD'],
					['4', 'GFG'],
					['5', 'FWE'],
					['6', 'VDF'],
					['7', 'BET'],
					['8', 'FEW'],
	];

	var $table = $('#itemListTable');
	if ($table.length){
		$table.DataTable({
			data: items
		})
	}
});