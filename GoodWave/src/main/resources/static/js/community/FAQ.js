const btns = document.querySelectorAll(".faq__btn");

btns.forEach((btn) => {
  btn.addEventListener("click", () => {
    const faqItem = btn.parentNode;
    const isActive = faqItem.classList.contains("active");

    removeActiveClasses();

    if (!isActive) {
      faqItem.classList.add("active");
    }
  });
});

function removeActiveClasses() {
  btns.forEach((btn) => {
    btn.parentNode.classList.remove("active");
  });
}