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


// 회원 목록 조회 (비동기)

//조회버튼
const selectDonationList = document.querySelector("#selectDonationList");

//tbody
const doantionList = document.querySelector("#doantionList");

//td 요소를 만들고 text 추가 후 반환
const createTd = (text) => {
    const td = document.createElement("td");
    td.innerText = text;
    return td; //<td>1</td> //<td>user01@or.kr</td>//<td>유저일</td>
}


//조회 버튼 클릭 시
selectDonationList.addEventListener("click", ()=> {

    //1) 비동기로 회원 목록 조회
    //   (응답에 포함되어 있어야 할 번호, 이메일, 닉네임, 탈퇴여부)

    fetch("/mypage/selectdonationList")
    .then(response => response.json()) //JSON.parse(response)
    .then(list => {

        //const data = JSON.parse(list);

        //list 바로 이용 -> JS 객체 배열
        //data-> JS 객체 배열

        //이전 내용 삭제
        doantionList.innerHTML = "";

        //tbody 에 들어갈 요소 만들기 + 값 세팅 후에 tbody에 추가
        list.forEach((member,index) => {
            //member :현재 반복 접근 중인 요소
            //index : 현재 접근 중인 인덱스

            //tr 만들어서 그 안에 td 만들고, append 후
            //다시 tbody 에 append
            const keyList = ['moneyDonationTotal'];  //오류 : memberDelFl : undifined 으로 뜸

            const tr = document.createElement("tr");
            // <tr></tr>
            keyList.forEach( key => tr.append( createTd(member[key]) ));

            //tbody 자식으로 tr 추가
            doantionList.append(tr);

        });

    })
    
});







/********************************************************************************************** */
/* 신청내역 확인 */