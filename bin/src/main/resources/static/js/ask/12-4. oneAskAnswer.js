function close(){
    document.querySelector(".answerid").addEventListener("click", () => {self.close()});
}

close();