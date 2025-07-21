class ProductImg {
	constructor(container, file, src, width, height) {
		this.container = container;
		this.file = file;
		this.src = src;
		this.width = width;
		this.height = height;

		this.wrapper = document.createElement("div"); // wrapper
		this.header = document.createElement("div");  // header (삭제버튼 영역)
		this.img = document.createElement("img");     // 상품 이미지
		this.img.src = this.src;

		// 이미지 스타일
		this.img.style.width = this.width + "px";
		this.img.style.height = this.height + "px";

		// wrapper 스타일
		this.wrapper.style.width = this.width + "px";
		this.wrapper.style.height = (this.height + 20) + "px";
		this.wrapper.style.display = "inline-block";
		this.wrapper.style.margin = "2px";

		// header (삭제 버튼) 스타일
		this.header.innerHTML = "<a href='#'>X</a>";
		this.header.style.textAlign = "right";

		// 조립
		this.wrapper.appendChild(this.header);
		this.wrapper.appendChild(this.img);
		this.container.appendChild(this.wrapper); 

		// 삭제 이벤트 연결
		this.header.addEventListener("click", (e) => {
			e.preventDefault(); 
			this.remove();
		});
	}

	remove() {
		//화면에서만 제거한다.
		this.container.removeChild(this.wrapper); 
	
		//배열에서도 제거해야한다.
		//현재 객체가 보유한 file이 selectedFile배열의 몇번째 소속이 되어있는지 조사하여 사용자가 이 객체를 제거하면 같은 위치의 file도 제거한다.
		let index = selectedFile.indexOf(this.file);
		seletedFile.splice(index,1);
	}
}
