
// /*수정*/
// const updatebtn = document.getElementById("update-btn").addEventListener("click", ()=> {
//     alert("수정완료")
// });


const boardTitle = document.getElementById("boardTitle");
const boardContent = document.getElementById("boardContent");

const checkobj = {
    "boardTitle" : false,
    "boardContent" : false
};

boardTitle.addEventListener("input",(e)=> {

    const inputTitle = e.target.value;

    if(inputTitle.trim().length === 0){
        checkobj.boardTitle = false;
        boardTitle.value = "";
        return;
    }

    checkobj.boardTitle = true;
    
});


boardContent.addEventListener("input",(e)=> {

    const inputContent = e.target.value;

    if(inputContent.trim().length <3){
        checkobj.boardContent = false;
     
        return;
    }

    checkobj.boardContent = true;
})



document.getElementById("qnaWriteForm").addEventListener("submit",(e)=> {

    
    for(let key in checkobj){
        if(!checkobj[key]){

            let str;

            switch(key){
                case "boardTitle" : str= "제목을 작성해주세요."; break;
                case "boardContent" : str = "5글자 이상 작성해주세요."; break;
            }
            alert(str);

            e.preventDefault();
            return;

        }
    }


});


