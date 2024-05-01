const popupClose = document.getElementById("popupClose");
const popupLayer = document.getElementById("popupLayer");
const registerBtn = document.getElementById("registerBtn");
const talentDonationMain = document.querySelector("#talentDonationMain");
const a = document.querySelector("#a");

registerBtn.addEventListener("click", ()=> {

    if(loginMember != null){
        popupLayer.classList.remove("popup-hidden");
        a.classList.add("dark");
    }
    if(loginMember == null){
        alert("로그인 후 이용해 주세요");
        location.href="/member/login";
    }

});



popupClose.addEventListener("click",()=> {

    a.classList.remove("dark");
    popupLayer.classList.add("popup-hidden");
});


// ==========유효성 검사===================

const checkobj2 = {
    "name" : false,
    "tel" : false,
    "sort" : false,
    "date" : false

};

const TDRegisterName = document.getElementById("TDRegisterName");
const TDRegisterTel = document.getElementById("TDRegisterTel");
const TDRegisterDate = document.getElementById("TDRegisterDate");
const TDRegisterSort = document.getElementById("TDRegisterSort");



// 이름 유효성 검사
TDRegisterName.addEventListener("input",()=> {


    if(TDRegisterName.value.trim().length===0){
        TDRegisterName.value="";
        checkobj2.name=false;
        return;
    };

    const regExp = /^[가-힣\w\d]{2,10}$/;

    if(!regExp.test(TDRegisterName.value)){
        checkobj2.name=false;
        return;

    };
    checkobj2.name=true;
    console.log(checkobj2);
})





// 전화번호 유효성 검사
TDRegisterTel.addEventListener("input", ()=> {

    if(TDRegisterTel.value.trim().length===0){
        TDRegisterTel.value ="";
        checkobj2.tel=false;
        return;
    };

    const regExp = /^01[0-9]{1}[0-9]{3,4}[0-9]{4}$/;

    if(!regExp.test(TDRegisterTel.value)){
        checkobj2.tel=false;
        return;
    };

    checkobj2.tel=true;


})



// 분야 유효성 검사 
TDRegisterSort.addEventListener("input",()=> {


    if(TDRegisterSort.value.trim().length===0){
        TDRegisterSort.value="";
        checkobj2.sort=false;
        return;
    };

    const regExp = /^[가-힣\w\d]{2,13}$/;

    if(!regExp.test(TDRegisterSort.value)){
        checkobj2.sort=false;
        return;

    };
    checkobj2.sort=true;
    
})


// 날짜 유효성 검사
TDRegisterDate.addEventListener("input",()=> {

    console.log(TDRegisterDate.value);
    if(TDRegisterDate.value.trim().length!=10){
        checkobj2.date=false;
        return;
    };
    
    checkobj2.date = true;
})






//============ 검사 후 이상있으면 제출 막기
const talentDonationForm = document.getElementById("talentDonationForm");

talentDonationForm.addEventListener("submit",(e)=> {

    for(let key in checkobj2){
        if(!checkobj2[key]){

            let str;
            let idStr;

            switch(key){
                case "name" : str = "올바른 이름을 입력해주세요."; 
                            idStr = "TDRegisterName"; break;
                case "tel" : str = "올바른 전화번호를 입력해주세요.";
                            idStr="TDRegisterTel"; break;
                case "sort" : str= "분야를 작성해주세요."; 
                            idStr="TDRegisterSort"; break;
                case "date" : str= "날짜를 선택해주세요."; 
                            idStr="TDRegisterDate";  break;
                
            }
            alert(str);

            document.getElementById(idStr).focus();

            e.preventDefault();
            return;

        }
    }



});



