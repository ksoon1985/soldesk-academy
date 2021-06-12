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
	 
	$('#list2').click(function(){
		javascript:location.href = 'list.do';
		//document.parentForm.submit();
	});
	
	$('#list3').click(function(){
		document.updateForm.action = 'list.do';
		document.updateForm.submit();
	});
})