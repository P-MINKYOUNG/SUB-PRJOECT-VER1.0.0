window.onload = function() {


	/* 아이디 중복 체크 */
	if(document.getElementById("duplicationCheck")) {

        const $duplication = document.getElementById("duplicationCheck");

        $duplication.onclick = function() {
            let memberId = document.getElementById("memberId").value.trim();

            fetch("/member/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({memberId: memberId})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));

        }
    }
    
    
    
    
}

function check() {
	
	if(comform.memberName.value.length == 0) {
		alert("이름을 입력해 주세요.");
		comform.memberName.focus();
		return false;
	}
	
	var memberId = document.getElementById("memberId")
	if(memberId < 8 && memberId > 16) {
		alert("아이디를 8자 ~ 16자로 입력해주세요.");
		comform.memberId.focus();
		return false;
	}
	
	var memberPwd = document.getElementById("memberPwd")
	if()
}





