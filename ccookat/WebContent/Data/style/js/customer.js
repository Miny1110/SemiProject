function sendIt() {
		
		var f = document.myForm;
		
		if(!f.customerId.value) {
			alert("아이디를 입력하세요.");
			f.customerId.focus();
			return;
		}
		
/*		if(!f.idDuplication.value) {
			alert("아이디 중복체크를 해주세요.");
			return;
		}*/
		
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
		
		if(!f.customerEmail.value){
			alert("이메일을 입력하세요.");
			f.customerEmail.focus();
			return;
		}
		
		if(!f.customerTel.value){
			alert("전화번호를 입력하세요.");
			f.customerTel.focus();
			return;
		}
		
		f.action = "/ccookat/main/customer/created_ok.do";
		f.submit();
}



//id 중복체크
function checkId() {

	var f = document.myForm;

	if(f.customerID.value == "") {
		alert("아이디를 입력하세요.");
		f.customId.focus();
		return;
	} else {

		f.action = "/ccookat/main/customer/created.do";
	}
	f.submit();

	/*
	
	if(f.customerId.value != customerId.value){
		alert("사용 가능한 아이디 입니다.");
		f.customerId.focus();
		return;
	}
	else
	alert("이미 사용중인 아이디 입니다.");
	f.customerId.focus();
	
}

//email 중복/형식 체크
function checkEmail(){
	
	var f = document.myForm;
	
	if(f.customerEmail.value = customerEmail.value){
		alert("이미 사용중인 이메일 입니다.");
		f.customerId.focus();
		return;
	}
	
	
	if(f.email.value){
		
		if(!isValidEmail(f.email.value)){
			alert("\n올바른 E-MAIL이 아닙니다.");
			f.email.focus();
			return;
		}
		
		f.submit();
}   
 */
	
	
	

// E-Mail 검사
function isValidEmail(customerEmail) {
	var format = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
    if (customerEmail.search(format) != -1)
        return true; //올바른 포맷 형식
    return false;
}
	
	


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


}



