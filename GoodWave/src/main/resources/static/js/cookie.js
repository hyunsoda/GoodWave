const getCookie = (key) => {
    const cookies = document.cookie; // "k=v"
 
    console.log(cookies);
 
 
   const cookieList = cookies.split("; ")// ["k=v", "k=v"]
        .map( el => el.split("=") );
     //   console.log(cookieList);
       // 배열 -> 객체로 변환 (그래야 다루기 쉽다)
 
       console.log(cookieList);
 
       const obj = {};
 
       for(let i = 0; i < cookieList.length; i++){
         const k = cookieList[i][0]; //key 값
         const v = cookieList[i][1]; //value값
 
         obj[k] = v;
       }
 
       console.log(obj);
 
 
   return obj[key]; //매개변수로 전달 받은 key와 
                 // obj 객체에 저장된 키가 일치하는 요소의 value 값 반환
 
 };
 
 
 const loginId = document.querySelector("#loginId");
 
 // 로그인 안된 상태인 경우에 수행
 
 if(loginId != null){ // 로그인창의 이메일 입력부분이 화면에 있을 때
   
   // 쿠키 중 key 값이 "saveId" 인 요소의 value 값 얻어오기
   const saveId = getCookie("saveId"); //undefined 또는 이메일 
 
   if(saveId != undefined){
    loginId.value = saveId; //쿠키에서 얻어온 값을 input에 value로 세팅
  
          //아이디 저장 체크박스에 체크해두기
         document.querySelector("input[name='saveId']").checked = true;
   }
 
 };

