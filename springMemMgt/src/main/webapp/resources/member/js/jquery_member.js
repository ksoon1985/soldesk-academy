$(function(){
  $('#list').click(function(){
	  location.href='memberList.mg';
	  });
  
	var wirteformObj = $("form[name='joinForm']");
   $('#submit1').click(function(){
		if(fn_valiChk()){
			return false;
		}
	   wirteformObj.submit();
	});

  
    $('#passwd').keyup(function(){
     $('font[id=check]').text('');
     if($('#passwd').val()!=$('#passwd2').val()){
         $('font[id=check]').text('');
         $('font[id=check]').text("비밀번호 다름");
        }else{
         $('font[id=check]').text('');
         $('font[id=check]').text("비밀번호 같음");
        }
    });
    $('#passwd2').keyup(function(){
     if($('#passwd').val()!=$('#passwd2').val()){
      $('font[id=check]').text('');
      $('font[id=check]').text("비밀번호 다름");
     }else{
      $('font[id=check]').text('');
      $('font[id=check]').attr('color','blue');
      $('font[id=check]').text("비밀번호 같음");
     }
    });
    //propertychange change keyup paste"
    //id check
     $("#idchk").on("propertychange change input paste", function() {
    	 $.ajax({
          	  async: true,
              type : 'post',
              url : "idcheck.mg",
              data: { "memid" : $("#idchk").val()},
              dataType : "json",
              success : function(data) {
            	  if (data > 0) {
                    	$('font[id=warning]').text('');
                        $('font[id=warning]').attr('color','red');
                        $('font[id=warning]').text('이미 존재하는 아이디 입니다.');
                        $("#memid").focus();
                    } else {
                    	$('font[id=warning]').text('');
                        $('font[id=warning]').attr('color','blue');
                        $('font[id=warning]').text('사용가능한 아이디입니다.');
                        $("#memid").focus();
                        idck = 1; // idck 1이 아니면 submit못하게 하려고 
                    }
              },
              error : function(error) {
                  alert("error : ");
              }
         });
    });
  });
  
  function fn_valiChk(){
		var regForm = $("form[name='joinForm'] .chk").length;
		for(var i = 0; i<regForm; i++){
			if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
				alert($(".chk").eq(i).attr("title")+"은(/는) 필수입력입니다.");
				$(".chk").eq(i).focus();
				return true;
			}
		}
	}
  
  

  
  