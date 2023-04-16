function click(){
    document.querySelector(".t2").addEventListener("click", () => {location.href = "select/youtube"});
    document.querySelector(".t1").addEventListener("click", () => {location.href = "/youtube"});
}

click();

function dropdown(){
    document.querySelector(".arrow").addEventListener("click", () => {document.querySelector(".mydropdown").classList.toggle("active")});
}

dropdown();


function deleteYoutube(){
		
		document.querySelector(".t1").addEventListener("click", () => {location.href="delete/youtube"});
		
}

deleteYoutube();

function path(){
	document.querySelector(".path2").addEventListener("click", () => {alert("embed 주소를 입력해주세요.")});
} 

path();