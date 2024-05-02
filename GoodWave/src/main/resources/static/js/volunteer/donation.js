
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




const email = document.getElementById("email");
const pw = document.getElementById("pw");
const pwConfirm = document.getElementById("pwConfirm");
const memberName = document.getElementById("name");
const tel = document.getElementById("tel");
const check = document.getElementById("check");
const id = document.getElementById("id");
const amount = document.getElementById("amount");


const emailSpan = document.getElementById("emailSpan")
const pwSpan = document.getElementById("pwSpan");
const pwConfirmSpan = document.getElementById("pwConfirmSpan");
const nameSpan = document.getElementById("nameSpan");
const telSpan = document.getElementById("telSpan");
const idSpan = document.getElementById("idSpan");
const amountSpan = document.getElementById("amountSpan");


const checkobj = {

    "name" : false,
    "email" : false,
    "tel" : false,
    "amount" : false
};



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



    emailSpan.classList.add('confirm');
    emailSpan.classList.remove('error');
    checkobj.email = true;


})



// 전화번호 유효성 검사
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


amount.addEventListener("input",(e)=>{

    if(amount.value.trim().length==0){
        amountSpan.classList.remove("confirm");
        amountSpan.classList.add("error");
        amount.value ="";
        checkobj.amount=false;
        return;
    };
    if(amount.value <10000){
        amountSpan.innerText="10,000원이상 입력해주세요";
        amountSpan.classList.remove("confirm");
        amountSpan.classList.add("error");
        checkobj.amount=false;
        return;
    };
    

    if(amount.value % 5000!=0){
        amountSpan.innerText="5000원 단위로 입력해주세요";
        amountSpan.classList.remove("confirm");
        amountSpan.classList.add("error");
        checkobj.amount=false;
        return;
    };


    
        amountSpan.innerText="*";
        amountSpan.classList.remove("error");
        amountSpan.classList.add("confirm");
        checkobj.amount=true;
    




  
})





const donationForm = document.getElementById("donationForm");



// ========== 형식 안 맞으면 제출 막기

donationForm.addEventListener("submit",(e)=> {

    for(let key in checkobj){
        if(!checkobj[key]){

            let str;

            switch(key){
                case "name" : str = "이름이 유효하지 않습니다."; break;
                case "email" : str = "이메일이 유효하지 않습니다."; break;
                case "tel" : str = "전화번호가 유효하지 않습니다."; break;
                case "amount" : str = "10,000원 이상 입력해주세요."; break;
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








