const agreeChkAll = document.querySelector('input[name=agree_all]');
    agreeChkAll.addEventListener('change', (e) => {
    let agreeChk = document.querySelectorAll('input[name=agree]');
    for(let i = 0; i < agreeChk.length; i++){
      agreeChk[i].checked = e.target.checked;
    }
});


/************************************************************************************************ */
// ------------------------------------------------------------
/* 탈퇴 유효성 검사 */

//탈퇴 form 태그
const withdrawal = document.querySelector("#withdrawal");

if(withdrawal != null){

  withdrawal.addEventListener("submit", e => {

        const memberPw = document.querySelector("#memberPw");
        const agree1 = document.querySelector("#agree1");
        const agree2 = document.querySelector("#agree2");

        // - 비밀번호 입력 되었는지 확인
        if(memberPw.value.trim().length == 0){
            alert("비밀번호를 입력해주세요");
            e.preventDefault(); //제출막기
            return;
        }

        // 약관 동의 체크 확인
        //checkbox 또는 radio checked 속성
        //-checked -> 체크 시 true, 미체크시 false 반환

        if(!agree1.checked){ //체크 안됐을 때
            alert("약관에 동의해주세요");
            e.preventDefault();
            return;
        }
        if(!agree2.checked){ //체크 안됐을 때
            alert("약관에 동의해주세요");
            e.preventDefault();
            return;
        }

        // 정말 탈퇴하시겠습니까? 라고 물어보기
        if( !confirm("정말 탈퇴하시겠습니까?")){
            alert("취소되었습니다");
            e.preventDefault();
            return;
        }

    });

}