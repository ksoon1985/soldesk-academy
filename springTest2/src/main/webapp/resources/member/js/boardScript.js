/*function sendData() {
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
}*/

function passwdCheck(s) {

	window.name = "parentForm";

	if (s == 'u') {
		document.parentForm.action = 'updateForm.sp';
	} else if (s == 'd') {
		document.parentForm.action = 'deletePro.sp';
	}

	window.open("passwdCheck.sp", "passwdCheck",
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
		
		/*
		// 수정일때 
		if(opener.document.parentForm.action.indexOf("updateForm") > -1) {

			// memberInfo 에서 regdate 값 바꿔주기
			// year < regArray -> 19년도
			var today = new Date();
			var year = today.getFullYear().substring(2, 3); // 년도 2020 1980
			var month = today.getMonth() + 1; // 월
			var date = today.getDate(); // 날짜

			var regArray = opener.document.parentForm.regdate.split('/'); // 20/06/07

			if (year < regArray[0])
				year = "19" + year;
			else
				year = "20" + year;

			opener.document.parentForm.regdate.value = year + "-" + regArray[1]
					+ "-" + regArray[2];
		}
		*/
		var f = opener.document.parentForm;

		f.submit();
		passwdCheck.window.close();

	} else {

		alert("비밀번호 오류");
		passwdCheck.window.close();
	}
}
