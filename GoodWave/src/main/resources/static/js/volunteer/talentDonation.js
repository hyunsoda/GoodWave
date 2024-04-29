const popupClose = document.getElementById("popupClose");
const popupLayer = document.getElementById("popupLayer");
const registerBtn = document.getElementById("registerBtn");
const talentDonationMain = document.querySelector("#talentDonationMain");
const a = document.querySelector("#a");

registerBtn.addEventListener("click", ()=> {

    popupLayer.classList.remove("popup-hidden");
    a.classList.add("dark");

});



popupClose.addEventListener("click",()=> {

    a.classList.remove("dark");
    popupLayer.classList.add("popup-hidden");
});