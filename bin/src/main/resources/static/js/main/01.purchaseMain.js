/*function hello(){
    const $search = document.querySelector("#search");
    const $rsearch = document.querySelector("#rsearch"); 
    let value = $search.value;

    console.log(value);

    $rsearch.addEventListener('click', () => {window.location.replace=`https://www.naver.com`});
};

hello();*/

let slideIndex = 0;

function showSlides() {
    let i;
    const slides = document.getElementsByClassName("banner");

    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    
    slides[slideIndex-1].style.display = "block";  

    setTimeout(showSlides, 2000);
}

showSlides();
