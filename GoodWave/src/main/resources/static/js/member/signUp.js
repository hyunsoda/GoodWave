/* 다음 주소 API 활용 */

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            } 

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

// 주소 검색 버튼 클릭 시
document.querySelector("#searchAddress").addEventListener("click", execDaumPostcode);


const submitBtn = document.getElementById("submitBtn");

submitBtn.addEventListener("click",()=> {

})




const checkId = document.querySelector("#checkId");
const emailCheckSpan = document.querySelector("#emailCheckSpan");
const emailcheckbtn = document.querySelector("#emailcheckbtn");
const checkAll = document.querySelector('.checkbox_all .all');
const checkBoxesNormal = document.querySelectorAll('.checkbox .normal');
const checkBoxChecked = Array.from(checkBoxesNormal, (checkbox) => checkbox);
function paintCheckAll(y) {
    checkBoxChecked.map((e) => (e.checked = y));
}
function onCheckAllClick() {
    checkAll.checked ? paintCheckAll(true) : paintCheckAll(false);
}
function onBoxClick() {
    let is_checked = true;
    checkBoxChecked.forEach((box) => {
        is_checked = box.checked && is_checked;
    });
    checkAll.checked = is_checked;
    
}
checkAll.addEventListener('click', onCheckAllClick);
checkBoxesNormal.forEach((checkbox) => checkbox.addEventListener('click', onBoxClick));







$('.checkbox_all .all').click(function () {
    if ($(this).prop('checked')) {
        $('.checkbox .normal').prop('checked', true);
    } else {
        $('.checkbox .normal').prop('checked', false);
    }
});
$('.checkbox').on('click', '.normal', function () {
    var is_checked = true;
    $('.checkbox .normal').each(function () {
        is_checked = is_checked && $(this).is(':checked');
    });
    $('.checkbox_all .all').prop('checked', is_checked);
});



// ======================유효성 검사=====================

const email = document.getElementById("email");
const pw = document.getElementById("pw");
const pwConfirm = document.getElementById("pwConfirm");
const memberName = document.getElementById("name");
const tel = document.getElementById("tel");
const check = document.getElementById("check");
const id = document.getElementById("id");


const emailSpan = document.getElementById("emailSpan")
const pwSpan = document.getElementById("pwSpan");
const pwConfirmSpan = document.getElementById("pwConfirmSpan");
const nameSpan = document.getElementById("nameSpan");
const telSpan = document.getElementById("telSpan");
const idSpan = document.getElementById("idSpan");


const checkobj = {
    "id" : false,
    "email" : false,
    "pw" : false,
    "pwConfirm" : false,
    "name" : false,
    "tel" : false

};

// =======이메일 유효성 검사
email.addEventListener("input",(e)=> {

    const inputEmail = e.target.value;

    if(inputEmail.trim().length == 0){
        emailSpan.classList.remove("confirm");
        emailSpan.classList.add("error");
        checkobj.email = false;
        email.value="";
        return;
    };

    const regExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if( !regExp.test(inputEmail)){
        emailSpan.classList.remove("confirm");
        emailSpan.classList.add("error");
        checkobj.email = false;
        return;
    };

    // ==== 나중에====
    /////======================= 이메일 중복 검사 추가하기=============

   
       emailcheckbtn.addEventListener("click", function(){
        fetch("/member/emailCheck?memberEmail=" + email.value)
        .then(respones => {
            return respones.text();
        }).then(result => {
            if(result > 0){
                emailCheckSpan.innerHTML = "";
                emailCheckSpan.innerHTML = "중복된 이메일이 있습니다";
                emailCheckSpan.classList.add("error");
                emailCheckSpan.classList.remove("confirm");
                emailSpan.classList.add("error");
                emailSpan.classList.remove("confirm");
                checkobj.email = false;
               return;
    
            }

            emailCheckSpan.innerHTML = "";
            emailCheckSpan.innerHTML = "사용가능한 이메일 입니다";
            emailCheckSpan.classList.remove("error");
                emailCheckSpan.classList.add("confirm");
            emailSpan.classList.add("confirm");
            emailSpan.classList.remove("error");
            checkobj.email = true;
        }).catch(error => {
            console.log(error);
        })
       }) 

        
   

   



    emailSpan.classList.add('confirm');
    emailSpan.classList.remove('error');
    checkobj.email = true;

})




//  비밀번호 유효성 검사
pw.addEventListener("input",(e) => {

    const inputPw = e.target.value;

    if(inputPw.trim().length===0){
        pwSpan.classList.remove("confirm");
        pwSpan.classList.add("error");
        checkobj.pw = false;
        pw.value="";
        return;
    }

    const regExp = /^[a-zA-Z0-9!@#_-]{6,20}$/;

    if(!regExp.test(inputPw)){
        pwSpan.classList.remove("confirm");
        pwSpan.classList.add("error");
        checkobj.pw = false;
        return;
    }

    pwSpan.classList.add('confirm');
    pwSpan.classList.remove('error');
    checkobj.pw = true;
})



// 비밀번호랑 비밀번호 확인 일치하는지 검사 

const checkPw = () => {

    // 같을 경우
    if(pw.value === pwConfirm.value){
        checkobj.pwConfirm = true;
        pwConfirmSpan.classList.add("confirm");
        pwConfirmSpan.classList.remove("error");
        return;
    }

    pwConfirmSpan.classList.add("error");
    pwConfirmSpan.classList.remove("confirm");
    checkobj.pwConfirm = false;
    


};



// 비밀번호 확인 유효성 검사
pwConfirm.addEventListener("input",(e)=> {


    const inputPwConfirm = e.target.value;

    if(inputPwConfirm.trim().length ==0){
        pwConfirmSpan.classList.remove("confirm");
        pwConfirmSpan.classList.add("error");
        pwConfirm.value="";
        checkobj.pwConfirm=false;
        return;
    }

    if(checkobj.pw){
        checkPw();
        return;
    }
    
    checkobj.pwConfirm = false;

})



// 이름 유효성 검사
memberName.addEventListener("input",()=> {

    if(memberName.value.trim().length==0){
        nameSpan.classList.remove("confirm");
        nameSpan.classList.add('error');
        name.value="";
        checkobj.name=false;
        return;
    };

    const regExp = /^[가-힣\w\d]{2,10}$/;
    if(!regExp.test(memberName.value)){
        nameSpan.classList.remove("confirm");
        nameSpan.classList.add('error');
        checkobj.name=false;
        return;

    };
    nameSpan.classList.remove("error");
    nameSpan.classList.add('confirm');
    checkobj.name=true;


})


tel.addEventListener("input", ()=> {

    if(tel.value.trim().length==0){
        telSpan.classList.remove("confirm");
        telSpan.classList.add("error");
        tel.value ="";
        checkobj.tel=false;
        return;
    };

    const regExp = /^01[0-9]{1}[0-9]{3,4}[0-9]{4}$/;

    if(!regExp.test(tel.value)){
        telSpan.classList.remove("confirm");
        telSpan.classList.add("error");
        checkobj.tel=false;
        return;
    };

    telSpan.classList.remove("error");
    telSpan.classList.add("confirm");
    checkobj.tel=true;


})


id.addEventListener("input", (e)=>{

    if(id.value.trim().length===0){
        idSpan.classList.remove("confirm");
        idSpan.classList.add("error");
        id.value="";
        checkobj.id=false;
        return;
    };

    const regExp = /^[a-z0-9]{5,15}$/;

    if(!regExp.test(id.value)){
        idSpan.classList.remove("confirm");
        idSpan.classList.add("error");
        checkobj.id=false;
        return;
    };

    idSpan.classList.remove("error");
    idSpan.classList.add("confirm");
    checkobj.id=true;


    fetch("/member/checkMemberId?memberId=" + e.target.value)
    .then(response => {
          return response.text();
    }).then(result => {

        checkId.innerText = ""
        

        if(result == 1){
            checkId.innerText = "중복된 아이디가 있습니다";
            checkId.classList.remove("confirm");
            checkId.classList.add("error");
            idSpan.classList.remove("confirm");
            idSpan.classList.add("error");
            checkobj.id=false;
            return;
        }


    })


})


// ========== 형식 안 맞으면 제출 막기
const signUpForm = document.getElementById("signUpForm");

signUpForm.addEventListener("submit",(e)=> {

    for(let key in checkobj){
        if(!checkobj[key]){

            let str;

            switch(key){
                case "id" : str= "아이디를 올바른 형식으로 작성해주세요."; break;
                case "email" : str = "이메일올바른 형식으로 작성해주세요."; break;
                case "pw" : str = "비밀번호를 올바른 형식으로 작성해주세요."; break;
                case "pwConfirm" : str = "비밀번호가 일치하지 않습니다."; break;
                case "name" : str = "이름을 올바른 형식으로 작성해주세요."; break;
                case "tel" : str = "전화번호를 올바른 형식으로 작성해주세요."; break;

            }
            alert(str);

            document.getElementById(key).focus();

            e.preventDefault();
            return;

        }
    }

    if(!check.checked){
        alert("약관에 동의해주세요");
        e.preventDefault();
        return;
    }

});
