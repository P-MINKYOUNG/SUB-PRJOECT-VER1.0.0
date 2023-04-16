(function(){
    document.querySelector(".arrow").addEventListener("click", () => {document.querySelector(".mydropdown").classList.toggle("active")});
})();

function click(){
    document.querySelector(".answerd").addEventListener("click", () => window.open("/askoneAnswer", "판매자 신고 자세히", "width=500, height=500, left=100, top=50"));
}

click();