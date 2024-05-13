/*회원 정보 수정 페이지 */
const mypage= document.querySelector("#mypage"); //form 태그

//#updateInfo 요소가 존재 할 떄만 수행
if(mypage != null){

    //form 제출 시
    mypage.addEventListener("submit" , e => {

        const memberName = document.querySelector("#memberName");
        const memberTel = document.querySelector("#memberTel");
        const memberAddress = document.querySelectorAll("[name= 'memberAddress']");

        //닉네임 유효성 검사
        if(memberName.value.trim().length === 0 ){
            alert("닉네임을 입력해 주세요");
            e.preventDefault(); //제출막기
            return;
        }

        //닉네임 정규식
        let regExp = /^[가-힣\w\d]{2,10}$/;
        if( !regExp.test(memberName.value)){
            alert("닉네임이 유효하지 않습니다");
            e.preventDefault(); //제출막기
            return;
        }

         //********************* */
        //닉네임 중복검사는 개별적으로
        //테스트 시 닉네임 중복 안되게 조심하기!
        //********************* */


        //전화번호 유효성 검사
        if(memberTel.value.trim().length === 0 ){
            alert("전화번호를 입력해 주세요");
            e.preventDefault();
            return;
        }

        //전화번호 정규식에 맞지 않으면
        regExp =  /^01[0-9]{1}[0-9]{3,4}[0-9]{4}$/;
        if(!regExp.test(memberTel.value)){
            alert("전화번호가 유효하지 않습니다");
            e.preventDefault();
            return;
        }

        //주소 유효성 검사
        // 입력을 안하면 전부 안해야되고
        //입력을 하면 3군데 input 전부 해야한다.

        const addr0 = memberAddress[0].value.trim().length == 0;
        const addr1 = memberAddress[1].value.trim().length == 0;
        const addr2 = memberAddress[2].value.trim().length == 0;

        //모두 true 인 경우만 true 저장
        const result1 = addr0 && addr1 && addr2; //아무것도 입력안한 경우

        //모두 false 인 경우만 true 저장
        const result2 = !(addr0 || addr1 || addr2); //모두 다 입력한 경우

        //모두 입력 또는 모두 미입력이 아니면
        if( !(result1 || result2) ){
            alert("주소를 모두 작성 또는 미작성 해주세요");
            e.preventDefault();
        }


    });
}


/********************************************************************************************** */
/* 다음 주소 API 활용하기 */
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


//주소 검색 버튼 클릭 시
document.querySelector("#searchAddress").addEventListener("click", execDaumPostcode);


/********************************************************************************************** */
/* 후원내역 확인 */

//조회버튼
const donationList = document.querySelector("#tab-2");

// //tbody
const dList = document.querySelector("#dList");

// 후원 내역 감싸는 div 요소
const noDList = document.querySelector("#noDList");


// //td 요소를 만들고 text 추가 후 반환
const createTd = (text) => {
     const sub = document.createElement("sub");
     sub.innerText = text;
    return sub; //<td>1</td> //<td>user01@or.kr //</td>//<td>유저일</td>
 }


// //조회 버튼 클릭 시
donationList.addEventListener("click", ()=> {


    

    
     fetch("/mypage/donationList")
     .then(response => response.json()) //JSON.parse(response)
     .then(list => {



        console.log(list);

        dList.innerHTML = "";


        if(list.length == 0) {

            noDList.classList.remove("hiddenNoDList");
           
        } else {

            noDList.classList.add("hiddenNoDList");

            list.forEach((item,index) => {
   
                const tr = document.createElement("tr");
    
                const sub1 = document.createElement("sub1");
                sub1.innerText = "  금액 : "+ item.moneyDonationTotal;
    
                const sub2 = document.createElement("sub2");
                sub2.innerText = "  계정 : "+  item.memberEmail;
    
                const sub3 = document.createElement("sub3");
                sub3.innerText = "      ";

                const sub4 = document.createTextNode("\u00a0\u00a0\u00a0\u00a0\u00a0");
              
                tr.append(sub1);

                tr.append(sub4);

                tr.append(sub2);

                
                tr.append(sub3);
    
                dList.append(tr);
    
            });
        }


   })
    
 });




/********************************************************************************************** */
/* 신청내역 확인 */


//조회버튼
const applyList = document.querySelector("#tab-3");

// 신청 내역 감싸는 div 요소
const noAList = document.querySelector("#noAList");

// //tbody
const aList = document.querySelector("#aList");



// //td 요소를 만들고 text 추가 후 반환
const createTd2 = (text) => {
     const td = document.createElement("td");
     td.innerText = text;
    return td; //<td>1</td> //<td>user01@or.kr</td>//<td>유저일</td>
 }

 const getApplyList = () => {
    fetch("/mypage/applyList")
    .then(response => response.json()) //JSON.parse(response)
    .then(list => {

       console.log(list);

      aList.innerHTML = "";



      if(list.length == 0) {

        noAList.classList.remove("hiddenNoAList");

      } else {
        
        noAList.classList.add("hiddenNoAList");
            
        list.forEach((item,index) => {


            const keyList = ['registryDate', 'actName', 'field']; 

          

            const tr = document.createElement("tr");
           

            const button= document.createElement("button");
            button.classList.add("cancle-btn");
            button.id = item.volunteerNo;
            button.innerText = "취소" ;


           keyList.forEach( key => tr.append( createTd2(item[key]) ));

          
           aList.append(tr);
           tr.append(button);

        });


        const cancleBtnArr = document.querySelectorAll(".cancle-btn");

        cancleBtnArr.forEach((item, index) => {

            //item.id = index;
            
            item.addEventListener("click", (e) => {
                
                console.log(e.target.id);

                applyCancle(e.target.id);

            })
        })

      }


  })
 }


/************************************************************************************************ */


// //조회 버튼 클릭 시
applyList.addEventListener("click", ()=> {
    getApplyList();
    
 });






 /** 신청 취소
 * @param {*} volunteerNo
 */
const applyCancle = volunteerNo => {

    // 취소 선택 시
    if(!confirm("취소 하시겠습니까?")) return;
  
    fetch("/mypage/applyCancle ",{
      method : "POST",
      headers : {"Content-Type" : "application/json"},
      body : JSON.stringify({"volunteerNo" : volunteerNo} )
    })
    .then( resp => resp.text() )
    .then( result => {
  
      if(result > 0){
        alert("취소 되었습니다");
        getApplyList();

      } else {
        alert("취소 실패");
      }
  
    })
    .catch( err => console.log(err));
  
  }



