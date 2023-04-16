function click(){
	  document.querySelector(".t2").addEventListener("click", () => {location.href = "/screen/08-4. bannerList"});
      document.querySelector(".t1").addEventListener("click", () => {location.href = "/banner"});
}

click();

function dropdown(){
    document.querySelector(".arrow").addEventListener("click", () => {document.querySelector(".mydropdown").classList.toggle("active")});
}

dropdown();

function upload(){
	document.querySelector("#submit").addeaddEventListener("click", () => {location.href = "regist/banner"});
}