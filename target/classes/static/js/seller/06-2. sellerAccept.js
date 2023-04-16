function click(){
    const $button3 = document.querySelector(".div2");
    
    console.log($button3);

    $button3.addEventListener("click", () => {window.open("/acceptDetail", "width=500, height=500, left=100, top=50")});
}

click();