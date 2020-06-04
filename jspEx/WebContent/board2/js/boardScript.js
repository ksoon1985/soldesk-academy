function sendData() {
	if (document.writeForm.subject.value == "") {
		alert("제목은 필수 입니다. ");
		document.writeForm.subject.focus();

		return false;
	}

	if (document.writeForm.content.value == "") {
		alert("내용은 필수 입니다. ");
		document.writeForm.content.focus();

		return false;
	}

	if (document.writeForm.passwd.value == "") {
		alert("비밀번호는 필수 입니다. ");
		document.writeForm.passwd.focus();

		return false;
	}
}

function pwCheck(s) {

	window.name = "parentForm";

	if (s == 'u') {
		document.parentForm.action = 'updateForm.do';
	} else if (s == 'd') {
		document.parentForm.action = 'deletePro.do';
	}

	window.open("/jspEx/board2/idCheck.jsp", "idCheck",
			"width=500, height=200,  resizable = no, scrollbars = no");

}

function setParentText() {
	// opener : 자기자신을 연 기존창의 window객체 참조
	opener.document.parentForm.cpass.value = document.getElementById("pwCheck").value;

	window.close();
	compare();
}

function compare() {
	var check;
	var pw = opener.document.parentForm.passwd.value;
	var cpw = opener.document.parentForm.cpass.value;
	alert(pw + ":" + cpw);

	if (pw == cpw) {
		
		window.alert(opener.document.parentForm.action);
		
		/*
		if (opener.document.parentForm.action == 'http://localhost:8090/jspEx/board/deletePro.jsp') 
		{
			check = window.confirm("정말 삭제 하시겠습니까 ? ");
			
			if(!check)
			{
				
			}
		}
		*/
		
		var f = opener.document.parentForm;

		f.submit();
		idCheck.window.close();

	} else {

		alert("비밀번호 오류");
		idCheck.window.close();
	}
}
