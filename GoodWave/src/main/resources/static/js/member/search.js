const checkobj = {
    "searchId" : false,
    "searchEmail" : false
}

const searchId = document.getElementById("searchId");
const searchEmail = document.getElementById("searchEmail");

searchId.addEventListener("input", ()=> {

    if(searchId.value.trim().length===0){
        checkobj.searchId = false;
        searchId.value="";
        return;
    }


})



