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


// =============방문봉사 유효성 검사=================



const checkobj4 = {
    "name" : false, 
    "tel" : false,
    "date" : false
}


const TDRegisterName3 = document.getElementById("TDRegisterName3");
const TDRegisterTel3 = document.getElementById("TDRegisterTel3");
const TDRegisterDate3 = document.getElementById("TDRegisterDate3");

const b = document.getElementById("b");


// 이름 유효성 검사
TDRegisterName3.addEventListener("input",()=> {

    if(TDRegisterName3.value.trim().length==0){
        TDRegisterName3.value="";
        checkobj4.name=false;
        b.classList.add('error');
        return;
    };

    const regExp = /^[가-힣\w\d]{2,10}$/;

    if(!regExp.test(TDRegisterName3.value)){
        checkobj4.name=false;
        return;

    };
    checkobj4.name=true;
    
})





// 전화번호 유효성 검사
TDRegisterTel3.addEventListener("input", ()=> {

    if(TDRegisterTel3.value.trim().length==0){
        TDRegisterTel3.value ="";
        checkobj4.tel=false;
        return;
    };

    const regExp = /^01[0-9]{1}[0-9]{3,4}[0-9]{4}$/;

    if(!regExp.test(TDRegisterTel3.value)){
        checkobj4.tel=false;
        return;
    };

    checkobj4.tel=true;


})




// 날짜 유효성 검사
TDRegisterDate3.addEventListener("input",()=> {

    if(TDRegisterDate3.value.trim().length!=10){
        checkobj4.date=false;
        return;
    };
    
    checkobj4.date = true;
})





const visitForm = document.getElementById("visitForm");

visitForm.addEventListener("submit",(e)=> {


    
    for(let key in checkobj4){
        if(!checkobj4[key]){

            let str;
            let idStr;


            switch(key){
                case "name" : str = "올바른 이름을 입력해주세요."; 
                        idStr = "TDRegisterName3";break;
               
                case "tel" : str = "올바른 전화번호를 입력해주세요.";
                            idStr="TDRegisterTel3";break;
                case "date" : str= "날짜를 선택해주세요."; 
                             idStr="TDRegisterDate3"; break;
                
            }
            alert(str);

            document.getElementById(idStr).focus();

            e.preventDefault();
            return;

        }
    }


});

