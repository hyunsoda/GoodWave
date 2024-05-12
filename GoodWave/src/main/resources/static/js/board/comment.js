// 댓글 목록 조회
const selectCommentList = ()=> {

    fetch("/comment?boardNo="+boardNo)
    .then(resp => resp.json())
    .then(commentList => {
        console.log(commentList);
        const ul = document.querySelector("#commentList");
        ul.innerHTML="";
    
    
        for(let comment of commentList){
    
            const commentRow = document.createElement("li");
            commentRow.classList.add("comment-row")
    
            if(comment.originalCommentNo != 0) 
            commentRow.classList.add("child-comment");
    
            if(comment.commentDelFl == 'Y')
                comment.innerText = "삭제된 댓글 입니다.";
    
            else {
                const commentWriter = document.createElement("p");
                commentWriter.classList.add("comment-writer");
    
                // 이름
                const nickname = document.createElement("span");
                nickname.innerText = comment.memberName;
            
                // 날짜(작성일)
                const commentDate = document.createElement("span");
                commentDate.classList.add("comment-date");
                commentDate.innerText = comment.commentWriteDate;
    
                // 작성자 영역(commentWriter)에 이름, 날짜 추가
                commentWriter.append( nickname, commentDate);
            
                // 댓글 행에 작성자 영역 추가
                commentRow.append(commentWriter);
    
    
    
    
                // ----댓글 내용 -----
                const content = document.createElement("p");
                content.classList.add("comment-content");
                content.innerText = comment.commentContent;
    
                commentRow.append(content);
    
    
    
                // -----버튼------
                const commentBtnArea = document.createElement("div");
                commentBtnArea.classList.add("comment-btn-area");
    
    
                // 답글
                const childCommentBtn = document.createElement("button");
                childCommentBtn.innerText = "답글";
    
                childCommentBtn.setAttribute("onclick",
                `showInsertComment(${comment.commentNo}, this)`);
    
                commentBtnArea.append(childCommentBtn);
    
    
    
                // 댓글 수정/삭제
                if(loginMemberNo != null  && loginMemberNo == comment.memberNo){
    
                const updateBtn = document.createElement("button");
                updateBtn.innerText = "수정";
    
                // 수정 버튼에 onclick 이벤트 리스너 추가 
                updateBtn.setAttribute("onclick", 
                 `showUpdateComment(${comment.commentNo}, this)`); 
    
    
                // 삭제 버튼
                const deleteBtn = document.createElement("button");
                deleteBtn.innerText = "삭제";
    
                // 삭제 버튼에 onclick 이벤트 리스너 추가 
                deleteBtn.setAttribute("onclick", 
                `deleteComment(${comment.commentNo})`); 
    
    
                // 버튼 영역에 수정, 삭제 버튼 추가
                commentBtnArea.append(updateBtn, deleteBtn);
    
                }
                commentRow.append(commentBtnArea);
    
            }
            ul.append(commentRow);
        }
    });



}


selectCommentList();

const board_sujeong_btn = document.querySelector("#board_sujeong_btn");



board_sujeong_btn.addEventListener("click", function(){

   

     if(confirm("정말 삭제하시겠습니까 ?")){
        location.href = `/editBoard/${boardNo}/delete?cp=${cp}`;;
       
                         
     }

})
   