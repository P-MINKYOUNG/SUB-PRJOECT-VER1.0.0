function dropdown(){
    document.querySelector(".arrow").addEventListener("click", () => {document.querySelector(".mydropdown").classList.toggle("active")});
}

dropdown();