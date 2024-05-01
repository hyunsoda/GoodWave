const donationBtn = document.querySelector(".donation_124213");
const donationBtn2 = document.querySelector(".donation2");

donationBtn.addEventListener("click", ()=> {

    
    if(loginMember != null){
        location.href="/volunteer/donation";

    }
    if(loginMember == null){
        location.href="/member/login";
    }

})


