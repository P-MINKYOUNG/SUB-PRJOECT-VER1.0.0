function click(){
    const button1 = document.querySelector(".tt1")
    const button2 = document.querySelector(".tt2");

   button1.addEventListener("click", () => {location.href="/banner"});
   button2.addEventListener("click", () => {location.href="/youtube"});
}

click();