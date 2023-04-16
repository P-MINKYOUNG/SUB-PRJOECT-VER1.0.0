   if(document.getElementById("delivery")) {
    
     const form = document.getElementById('delivery');

    form.addEventListener('submit', (e) => {
      e.preventDefault();

      const formData = new FormData(form);

      fetch('/member/mypage/orderDetail', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        },
        body: formData,
      })
      .then(res => res.json())
      .then(data => console.log(data));
    })
    
    
 };   
    
    
    const link1 = 'localhost:8018/member/mypage/orderDetail'
    
    function hrefLink1() {
		location.href = link1;
	}