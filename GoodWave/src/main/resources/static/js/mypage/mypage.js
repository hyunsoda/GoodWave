function resetClass(element, classname){
  element.classList.remove(classname);
}

document.getElementsByClassName("show-info")[0].addEventListener("click",function(){
  let form = document.getElementsByClassName("mypage")[0];
  resetClass(form, "dlist");
  resetClass(form, "alist");
  form.classList.add("info");

  document.getElementsByClassName("mypage-elements").innerText = "hi";
});

document.getElementsByClassName("show-dlist")[0].addEventListener("click",function(){
  let form = document.getElementsByClassName("mypage")[0];
  resetClass(form, "info");
  resetClass(form, "alist");
  form.classList.add("dlist");

  document.getElementsByClassName("donate-list").innerText = "hi";

});
document.getElementsByClassName("show-alist")[0].addEventListener("click",function(){
  let form = document.getElementsByClassName("mypage")[0];
  resetClass(form, "info");
  resetClass(form, "dlist");
  form.classList.add("alist");

  document.getElementsByClassName("donate-list").innerText = "hi";

});