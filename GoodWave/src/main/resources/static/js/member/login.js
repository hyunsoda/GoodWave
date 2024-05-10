
const checkobj={
    "inputId" : false,
    "inputPw" : false
};

const loginId2 = document.getElementById("loginId");


if(loginId2.value.trim().length>1){
    checkobj.inputId = true;
   
};


loginId2.addEventListener("input",(e)=>{

    const inputId = e.target.value;

    if(inputId.trim().length===0){
        checkobj.inputId = false;
        // inputId="";
        return;
    }
    checkobj.inputId = true;
});




document.getElementById("loginPw").addEventListener("input",(e)=>{
    
    const inputPw = e.target.value;

    if(inputPw.trim().length===0){
        checkobj.inputPw = false;
        inputPw="";
        return;
    }
    checkobj.inputPw = true;
});






const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit",(e)=> {
    for(let key in checkobj){
        if(!checkobj[key]){

            let str;

            switch(key){
                case "inputId" : str= "아이디를 작성해주세요."; break;
                case "inputPw" : str = "비밀번호를 작성해주세요."; break;
                
            }
            alert(str);

       

            e.preventDefault();
            return;

        }
    }

});