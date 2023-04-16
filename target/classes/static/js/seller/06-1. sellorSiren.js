function click(){
    const $button3 = document.querySelector(".div2");
    
    console.log($button3);

    $button3.addEventListener("click", () => {window.open("06-4. 판매자 신고 자세히.html", "판매자 신고 자세히", "width=500, height=500, left=100, top=50")});
}

click();
