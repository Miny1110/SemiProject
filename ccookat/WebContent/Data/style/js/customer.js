function sendIt() {
		
		var f = document.myForm;
		
		if(!f.customerId.value) {
			alert("아이디를 입력하세요.");
			f.customerId.focus();
			return;
		}
		
		/*if(f.idFormat.value != "idFmcheck"){
			alert("올바른 아이디 형식이 아닙니다.")
			f.customerId.focus();
			return;
		}*/
		
		if(f.idDuplication.value != "idcheck"){
			alert("아이디 중복체크를 해주세요.")
			return;
		}
		
		if(!f.customerPwd.value){
			alert("비밀번호를 입력하세요.");
			f.customerPwd.focus();
			return;
		}
		
		if(!f.customerPwd2.value){
			alert("비밀번호를 다시 한번 입력하세요.");
			f.customerPwd2.focus();
			return;
		}
		
		if(f.customerPwd.value != f.customerPwd2.value){
			alert("비밀번호가 다릅니다.");t
			f.customerPwd2.focus();
			return;
		}
		
		if(!f.customerName.value){
			alert("이름을 입력하세요.");
			f.customerName.focus();
			return;
		}
		
		
		if(f.nameDuplication.value != "namecheck"){
			alert("올바른 이름 형식이 아닙니다.")
			f.customerName.focus();
			return;
		}
		
		if(!f.customerEmail.value){
			alert("이메일을 입력하세요.");
			f.customerEmail.focus();
			return;
		}
		
		if(f.emailDuplication.value != "emailcheck"){
			alert("올바른 이메일 형식이 아닙니다.")
			f.customerEmail.focus();
			return;
		}
		
		if(!f.customerTel.value){
			alert("전화번호를 입력하세요.");
			f.customerTel.focus();
			return;
		}
		
		if(f.telDuplication.value != "telcheck"){
			alert("올바른 전화번호 형식이 아닙니다.");
			f.customerTel.focus();
			return;
		}
		
		if(!f.customerZipcode.value){
			alert("우편번호를 입력하세요.");
			f.customerZipcode.focus();
			return;
		}
		
		if(!f.customerAddr1.value){
			alert("주소를 입력하세요.");
			f.customerAddr1.focus();
			return;
		}
		
		if(!f.customerAddr2.value){
			alert("상세주소를 입력하세요.");
			f.customerAddr2.focus();
			return;
		}
		
		
		f.action = "/ccookat/main/customer/created_ok.do";
		f.submit();
}

	
	

// E-Mail 검사
function isValidEmail(customerEmail) {
	var format = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
    if (customerEmail.search(format) != -1){
    	return true; //올바른 포맷 형식
    }else{
    	return false;
    }
}
	
function checkFmEmail(){
	
	var f= document.myForm;
	var customerEmail = f.customerEmail.value;
	
	if(!isValidEmail(customerEmail)){
		alert("올바른 이메일 형식이 아닙니다.");
		f.emailDuplication.value = "emailUncheck";
		setTimeout(function(){f.customerEmail.focus();}, 10);
		return;
	}else{
		f.emailDuplication.value = "emailcheck";
	}
	
}



//한글 필터링
function isValidKorean(customerName){
     // UTF-8 코드 중 AC00부터 D7A3 값이지 검사
	var format = /^[가-힣]{2,4}$/;
    if (customerName.search(format) != -1)
        return true; //올바른 포맷 형식
    return false;
}

function checkFmName(){
	
	var f = document.myForm;
	var customerName = f.customerName.value;
	
	if(!isValidKorean(customerName)){
		alert("올바른 이름 형식이 아닙니다.");
		f.nameDuplication.value = "nameUncheck";
		setTimeout(function(){f.customerName.focus();}, 10);
		return false;
	}else{
		f.nameDuplication.value = "namecheck";
		return true;
	}
	
}



//전화번호
function isValidTel(customerTel) {
    
	var format = /^[0-9]{8,13}$/;
	if(customerTel.search(format) != -1)
		return true;
	return false;
}

function checkFmTel(){
	
	var f = document.myForm;
	var customerTel = f.customerTel.value;
	
	if(!isValidTel(customerTel)){
		alert("올바른 전화번호 형식이 아닙니다.");
		f.telDuplication.value = "telUncheck";
		setTimeout(function(){f.customerTel.focus();}, 10);
		return;
	}else{
		f.telDuplication.value = "telcheck";
	}
	
}


function openIdChk(){
	
	//idChk.jsp는 자식창 / signUp.jsp는 부모창
	
	var customerId_chk = document.getElementById("customerId").value;
	
	if(customerId_chk){
		
		//window.name = "부모창 이름";
		window.name = "myForm";
		
		url = "idChk.do?customerId="+customerId_chk;
		
		//window.open("open할 window","자식창 이름","팝업창 옵션");
		openWin = window.open(url,"아이디확인",
		"width=400px,height=200px,resizable=no,left=700,top=100");
	}else {
		alert("아이디를 입력하세요");
	}
	
	
}


/*function idChk(){
	
	var f = document.myForm;
	
	if(!f.customerId.value){
		alert("아이디를 입력하세요");
		f.customerId.focus();
		return;
	}else{
		f.action = "/ccookat/main/customer/idcheck.do";
		f.submit();
	}
}*/


/*//아이디 형식 검사
function isValidId(customerId){
	
	var format = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
	if(customerId.search(format) != -1)
		return true;
	return false;
}

function checkFmId(){
	
	var f = document.myForm;
	var customerId = f.customerId.value;
	
	if(!isValidId(customerId)){
		alert("올바른 아이디 형식이 아닙니다.");
		f.idFormat.value = "idFmUncheck";
		setTimeout(function(){f.customerId.focus();}, 10);
		return;
	}else{
		f.idFormat.value = "idFmcheck";
	}
	
}*/


function customerPwdChk(){
	
	var f = document.myForm;
	
	if(!f.customerPwd.value){
		alert("비밀번호를 입력하세요");
		f.customerPwd.focus();
		return;
	}
	
	f.action = "/ccookat/main/customer/customerPwdChk_ok.do";
	f.submit();
	
}


function updated(){
	
	var f = document.myForm;
	
	if(f.customerPwd.value != f.customerPwd2.value){
		alert("비밀번호가 다릅니다.");
		f.customerPwd2.focus();
		return;
	}
	
	alert("수정이 완료되었습니다.");
	f.action = "/ccookat/main/customer/updated_ok.do";
	f.submit();
	
}


function deleted(){
	
	var f = document.myForm;
	var msg = "정말 탈퇴하시겠습니까?";
	
	if(!confirm(msg)){
		alert("취소되었습니다.");
	}else {
		alert("탈퇴되었습니다.");
		f.action = "/ccookat/main/customer/deleted_ok.do";
		f.submit();
	}


}





