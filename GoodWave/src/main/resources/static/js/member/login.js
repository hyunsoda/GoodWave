const checkobj={
    "inputId" : false,
    "inputPw" : false
};

document.getElementById("loginId").addEventListener("input",(e)=>{
    inputId = e.target.value;
    if(inputId.trim().length===0){
        inputId = false;
        // inputId="";
        return;
    }
    checkobj.inputId = true;
});




document.getElementById("loginPw").addEventListener("input",(e)=>{
    inputPw = e.target.value;
    if(inputPw.trim().length===0){
        inputPw = false;
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