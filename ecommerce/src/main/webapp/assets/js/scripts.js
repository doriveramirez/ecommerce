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
})