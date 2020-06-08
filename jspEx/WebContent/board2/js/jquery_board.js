$(function(){
	
	$('#reply').click(function(){
		document.parentForm.action='writeForm.do';
		document.parentForm.submit();
	});
	
	$('#list1').click(function(){
		//javascript:location.href = 'list.do';
		document.parentForm.action='list.do';
		document.parentForm.submit();
	});
	 
	
})