var emailId = document.getElementById("emailId");
var domain = document.getElementById("domain");
         
function mailsend() {
	   const emailId = document.getElementById("emailId").value;
	   const domain = document.getElementById("domain").value;
	
	   $.ajax({
	      type : "POST",
	      url : "/member/mailsend",
	      data : {
			  "emailId" : emailId,
			  "domain" : domain 
		  },
	      success : function(data){
			  
			  
	         alert("해당 이메일로 인증번호 발송이 완료되었습니다. \n 확인부탁드립니다.")
	         
	         console.log("data : "+ data);
	         
	      }
	   })
	}



