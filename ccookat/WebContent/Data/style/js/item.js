function insertItem(){
	
	f = document.myForm;
	
	//상품명
	str = f.itemName.value;
	str = str.trim();
	if(!str){
		alert("상품명을 입력하세요");
		f.itemName.focus();
		return;
	}
	f.itemName.value = str;
	
	//상품가격
	str = f.itemPrice.value;
	str = str.trim();
	if(!str){
		alert("상품가격을 입력하세요");
		f.itemPrice.focus();
		return;
	}
	f.itemPrice.value = str;
	
	//상품할인
	str = f.itemDiscount.value;
	str = str.trim();
	if(!str){
		alert("할인율을 입력하세요");
		f.itemDiscount.focus();
		return;
	}
	f.itemDiscount.value = str;
	
	//상품카테고리
	str = f.itemType.value;
	str = str.trim();
	if(!str){
		alert("상품 카테고리를 선택하세요");
		f.itemType.focus();
		return;
	}
	f.itemType.value = str;
	
	//상품내용
	str = f.itemContent.value;
	str = str.trim();
	if(!str){
		alert("상품설명을 입력하세요");
		f.itemContent.focus();
		return;
	}
	f.itemContent.value = str;
	
	//상품이미지1
	str = f.itemImage1.value;
	str = str.trim();
	if(!str){
		alert("상품사진을 첨부하세요");
		f.itemImage1.focus();
		return;
	}
	f.itemImage1.value = str;
	
	//상품이미지2
	str = f.itemImage2.value;
	str = str.trim();
	if(!str){
		alert("상품사진을 첨부하세요");
		f.itemImage2.focus();
		return;
	}
	f.itemImage2.value = str;
	
	//상품이미지3
	str = f.itemImage3.value;
	str = str.trim();
	if(!str){
		alert("상품사진을 첨부하세요");
		f.itemImage3.focus();
		return;
	}
	f.itemImage3.value = str;
	
	//상품이미지4
	str = f.itemImage4.value;
	str = str.trim();
	if(!str){
		alert("상품사진을 첨부하세요");
		f.itemImage4.focus();
		return;
	}
	f.itemImage4.value = str;
	
	f.action = "/ccookat/main/item/created_ok.do";
	f.submit();
	
}

