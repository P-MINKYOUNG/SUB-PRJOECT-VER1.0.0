function click(){
    const one = document.querySelector(".tt1");
    const two = document.querySelector(".tt2");
    const three = document.querySelector(".tt3");

    one.addEventListener("click", () => {location.href = "/askone"});
    two.addEventListener("click", () => {location.href = "consumer/write"});
    three.addEventListener("click", () => {location.href = "faq/regist"});
    
     document.querySelector(".tt1").addEventListener("click", () => {location.href="askone"});
}

click();