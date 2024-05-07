const agreeChkAll = document.querySelector('input[name=agree_all]');
    agreeChkAll.addEventListener('change', (e) => {
    let agreeChk = document.querySelectorAll('input[name=agree]');
    for(let i = 0; i < agreeChk.length; i++){
      agreeChk[i].checked = e.target.checked;
    }
});


/* 탈퇴 */
const submitbtn = document.getElementById("submit-btn").addEventListener("click", () => {
  alert("회원탈퇴가 완료되었습니다.")
  location.href="/";
});

