function click(){
    const button1 = document.querySelector("#siren");
    const button2 = document.querySelector("#accept");
  
    button1.addEventListener("click", () => {location.href="/siren"});
    button2.addEventListener("click", () => {location.href = "/accept"});
}

click();
