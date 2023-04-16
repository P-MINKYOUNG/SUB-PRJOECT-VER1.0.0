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

function getValue(){
    const $ct = document.getElementsByClassName("ct");
    const $ctt = document.getElementsByClassName("ctt");
    const $dtcate = document.querySelector("#dtcate");
    const $detailpage1= document.querySelector(".detailpage1");
    const $detailpage2 = document.querySelector(".detailpage2");
    const $detailpage3 = document.querySelector(".detailpage3");
    const $detailpage4 = document.querySelector(".detailpage4");
    const $detailpage5 = document.querySelector(".detailpage5");
    const $detailpage6 = document.querySelector(".detailpage6");


    $ct[0].addEventListener("click", () => $dtcate.innerHTML = $ctt[0].firstChild.textContent, () => {
        $detailpage1.style.display = "grid";
        $detailpage2.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage5.style.display = "none";
        $detailpage6.style.display = "none";
    });
    $ct[1].addEventListener("click", () => $dtcate.innerHTML = $ctt[1].firstChild.textContent, () => {
        $detailpage2.style.display = "grid";
        $detailpage1.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage5.style.display = "none";
        $detailpage6.style.display = "none";
    });
    $ct[2].addEventListener("click", () => $dtcate.innerHTML = $ctt[2].firstChild.textContent, () => {
                $detailpage3.style.display = "grid";
                $detailpage2.style.display = "none";
                $detailpage1.style.display = "none";
                $detailpage4.style.display = "none";
                $detailpage5.style.display = "none";
                $detailpage6.style.display = "none";
    });
    $ct[3].addEventListener("click", () => $dtcate.innerHTML = $ctt[3].firstChild.textContent, () => {
                $detailpage4.style.display = "grid";
                $detailpage2.style.display = "none";
                $detailpage3.style.display = "none";
                $detailpage1.style.display = "none";
                $detailpage5.style.display = "none";
                $detailpage6.style.display = "none";
    });
    $ct[4].addEventListener("click", () => $dtcate.innerHTML = $ctt[4].firstChild.textContent, () => {
        $detailpage5.style.display = "grid";
        $detailpage2.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage1.style.display = "none";
        $detailpage6.style.display = "none";
    });
    $ct[5].addEventListener("click", () => $dtcate.innerHTML = $ctt[5].firstChild.textContent, () => {
        $detailpage6.style.display = "grid";
        $detailpage2.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage5.style.display = "none";
        $detailpage1.style.display = "none";
    });

    $ct[0].addEventListener("click",() => {
        $detailpage1.style.display = "grid";
        $detailpage2.style.display = "grid";
        $detailpage3.style.display = "grid";
        $detailpage4.style.display = "grid";
        $detailpage5.style.display = "grid";
        $detailpage6.style.display = "grid";
    });
    $ct[1].addEventListener("click", () => {
        $detailpage2.style.display = "grid";
        $detailpage1.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage5.style.display = "none";
        $detailpage6.style.display = "none";
    });
    $ct[2].addEventListener("click", () => {
                $detailpage3.style.display = "grid";
                $detailpage2.style.display = "none";
                $detailpage1.style.display = "none";
                $detailpage4.style.display = "none";
                $detailpage5.style.display = "none";
                $detailpage6.style.display = "none";
    });
    $ct[3].addEventListener("click", () => {
                $detailpage4.style.display = "grid";
                $detailpage2.style.display = "none";
                $detailpage3.style.display = "none";
                $detailpage1.style.display = "none";
                $detailpage5.style.display = "none";
                $detailpage6.style.display = "none";
    });
    $ct[4].addEventListener("click", () => {
        $detailpage5.style.display = "grid";
        $detailpage2.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage1.style.display = "none";
        $detailpage6.style.display = "none";
    });
    $ct[5].addEventListener("click", () => {
        $detailpage6.style.display = "grid";
        $detailpage2.style.display = "none";
        $detailpage3.style.display = "none";
        $detailpage4.style.display = "none";
        $detailpage5.style.display = "none";
        $detailpage1.style.display = "none";
    });
}

getValue();