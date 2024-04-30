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






