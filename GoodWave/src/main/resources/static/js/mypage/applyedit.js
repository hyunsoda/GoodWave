const popupClose = document.getElementById("popupClose");
const popupLayer = document.getElementById("popupLayer");
const editbtn = document.getElementById("editbtn");
const mypage = document.querySelector("#mypage");
const a = document.querySelector("#a");

editbtn.addEventListener("click", ()=> {

    // if(loginMember != null){
        popupLayer.classList.remove("popup-hidden");
        a.classList.add("dark");
    // }
    // if(loginMember == null){
    //     alert("로그인 후 이용해 주세요");
    //     location.href="/member/login";
    // }

});



popupClose.addEventListener("click",()=> {

    a.classList.remove("dark");
    popupLayer.classList.add("popup-hidden");
});




// ===================== 연탄봉사============

const yeontanForm = document.getElementById("yeontanForm");

const checkobj3 = {
    "name" : false, 
    "tel" : false,
    "date" : false
};


const TDRegisterName2 = document.getElementById("TDRegisterName2");
const TDRegisterTel2 = document.getElementById("TDRegisterTel2");
const TDRegisterDate2 = document.getElementById("TDRegisterDate2");



// 이름 유효성 검사
TDRegisterName2.addEventListener("input",()=> {


    if(TDRegisterName2.value.trim().length===0){
        TDRegisterName2.value="";
        checkobj3.name=false;
        return;
    };

    const regExp = /^[가-힣\w\d]{2,10}$/;

    if(!regExp.test(TDRegisterName2.value)){
        checkobj3.name=false;
        return;

    };
    checkobj3.name=true;
    
})





// 전화번호 유효성 검사
TDRegisterTel2.addEventListener("input", ()=> {

    if(TDRegisterTel2.value.trim().length==0){
        TDRegisterTel2.value ="";
        checkobj3.tel=false;
        return;
    };

    const regExp = /^01[0-9]{1}[0-9]{3,4}[0-9]{4}$/;

    if(!regExp.test(TDRegisterTel2.value)){
        checkobj3.tel=false;
        return;
    };

    checkobj3.tel=true;


})




// 날짜 유효성 검사
TDRegisterDate2.addEventListener("input",()=> {

    if(TDRegisterDate2.value.trim().length!=10){
        checkobj3.date=false;
        return;
    };
    console.log(checkobj3);
    checkobj3.date = true;

})





//============ 검사 후 이상있으면 제출 막기

yeontanForm.addEventListener("submit",(e)=> {

    for(let key in checkobj3){
        if(!checkobj3[key]){

            let str;
            let idStr;

            switch(key){
                case "name" : str = "올바른 이름을 입력해주세요."; 
                             idStr = "TDRegisterName2"; break;
                case "tel" : str = "올바른 전화번호를 입력해주세요.";
                            idStr="TDRegisterTel2"; break;
                case "date" : str= "날짜를 선택해주세요."; 
                            idStr="TDRegisterDate2"; break;
                
            }
            alert(str);

            document.getElementById(idStr).focus();

            e.preventDefault();
            return;

        }
    }



});



const activityList = document.getElementById("tab-3");

activityList.addEventListener("click",()=> {

    fetch("/mypage/activityList")
    .then(resp =>resp.text())
    .then(result=>{
        
        const apply = document.getElementById("apply-area");

        for(let i = 0; i<map.length();i++){
            
        }

    })

})
