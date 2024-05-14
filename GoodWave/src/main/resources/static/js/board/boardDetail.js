const board_sujeong_btn = document.querySelector("#board_sujeong_btn");



board_sujeong_btn.addEventListener("click", function(){

   

     if(confirm("정말 삭제하시겠습니까 ?")){
        location.href = `/editBoard/${boardNo}/delete?cp=${cp}`;
       
                         
     }

})