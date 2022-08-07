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
		
		if(f.customerPwd.value != customerPwd2.value){
			alert("비밀번호가 다릅니다.");
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


function jungbokId() {

	var f = document.myForm;
	
	if (!f.customerId.value) {
		alert("아이디를 입력하세요.");
		f.customerId.focus();
		return;
	}

	f.submit();
}


function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 주소변수 문자열과 참고항목 문자열 합치기.
                addr += extraAddr;
            
            } else {
                addr += '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}


function sendIt() {
	
	var f= document.myForm;
	
	f.action = "/ccookat/main/customer/updated_ok.do";
	f.submit();
}	


function login() {
	
	var f = document.myForm;

	if(!f.customerId.value){
		alert("아이디를 입력하세요");
		f.customerId.focus();
		return;
	}
	
	if(!f.customerPwd.value) {
		alert("패스워드를 입력해주세요");
		f.customerPwd.focus();
		return;
	}
	
	f.action = "/ccookat/main/customer/login_ok.do";
	f.submit();
	
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
	
	f.action = "/ccookat/main/customer/updated_ok.do";
	f.submit();
	
}







