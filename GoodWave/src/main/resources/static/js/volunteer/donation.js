
const checkAll = document.querySelector('.checkbox_all .all');
const checkBoxesNormal = document.querySelectorAll('.checkbox .normal');
const checkBoxChecked = Array.from(checkBoxesNormal, (checkbox) => checkbox);
function paintCheckAll(y) {
    checkBoxChecked.map((e) => (e.checked = y));
}
function onCheckAllClick() {
    checkAll.checked ? paintCheckAll(true) : paintCheckAll(false);
}
function onBoxClick() {
    let is_checked = true;
    checkBoxChecked.forEach((box) => {
        is_checked = box.checked && is_checked;
    });
    checkAll.checked = is_checked;
}
checkAll.addEventListener('click', onCheckAllClick);
checkBoxesNormal.forEach((checkbox) => checkbox.addEventListener('click', onBoxClick));



$('.checkbox_all .all').click(function () {
    if ($(this).prop('checked')) {
        $('.checkbox .normal').prop('checked', true);
    } else {
        $('.checkbox .normal').prop('checked', false);
    }
});
$('.checkbox').on('click', '.normal', function () {
    var is_checked = true;
    $('.checkbox .normal').each(function () {
        is_checked = is_checked && $(this).is(':checked');
    });
    $('.checkbox_all .all').prop('checked', is_checked);
});






