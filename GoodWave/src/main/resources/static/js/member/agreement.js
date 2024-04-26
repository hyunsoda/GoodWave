const popupLayer = document.querySelector("#popupLayer");
const popupTodoNo = document.querySelector("#popupTodoNo");
const popupTodoTitle = document.querySelector("#popupTodoTitle");
const popupComplete = document.querySelector("#popupComplete");
const popupRegDate = document.querySelector("#popupRegDate");
const popupTodoContent = document.querySelector("#popupTodoContent");
const popupClose = document.querySelector("#popupClose");





function agreement(){

    fetch("/member/agreement")
    .then{resp =>resp.text()}
    .then

}


popupClose.addEventListener("click", () => {
    // 숨기는 class를 추가
    popupLayer.classList.add("popup-hidden");
})
