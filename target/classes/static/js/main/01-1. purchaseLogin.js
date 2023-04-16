var slideIndex = 0;

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("banner");

    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    
    slides[slideIndex-1].style.display = "block";  

    setTimeout(showSlides, 2000);
}

showSlides();

/*function home(){
	document.querySelector(".store").addEventListener("click", () => {location.href="/store"});
	document.querySelector(".home").addEventListener("click", () => {location.href="/Mulbburi/login"});
	document.querySelector(".logout").addEventListener("click", ()=>{location.href="/Mulbburi"});
}

home();*/