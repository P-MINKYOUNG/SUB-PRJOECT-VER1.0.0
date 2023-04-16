function email(){
	
}

email();

function click() {
  let selectedValue = "";
  const inquiryNo = document.querySelectorAll('input[name="inquiryNo"]');
  
  // 라디오 버튼 클릭 이벤트 등록
  for (let i = 0; i < inquiryNo.length; i++) {
    inquiryNo[i].addEventListener("click", () => {
      // 선택된 값 가져오기
      const checkedBtn = document.querySelector('input[name="inquiryNo"]:checked');
      if (checkedBtn) {
        selectedValue = checkedBtn.value;
      }
    });
  }
  
  // 버튼 클릭 이벤트 등록
  document.querySelector(".answerd").addEventListener("click", () => {
    // 선택된 값으로 새 창 열기
    if (selectedValue) {
      window.open("/askoneAnswer?inquiryNo=" + selectedValue, "판매자 신고 자세히", "width=500, height=500, left=100, top=50");
    } else {
      alert("라디오 버튼을 선택해주세요.");
    }
  });
  
  
}

click();
