$(function(){
   $(".nav_ul").mouseover(function(){
      $(".section1").stop().slideDown(150)
      $(".section1").css("display", "grid")
   })
   
  $(".nav_ul").mouseout(function(){
   $(".section1").stop().slideUp(50)
     
   
   
  })
})

$(function(){
   $(".li_1").mouseover(function(){
      $(".stick").css("border", "3.5px solid rgb(106, 141, 218)");
      $(".stick").css("transform", ": scale(1.5)");
      $(".stick").css("width", "150px");
      $(".stick").css("transform-origin", "50% 50%");
   });
   $(".li_1").mouseout(function(){
      $(".stick").stop().css("transform", ": scale(0)");
      $(".stick").stop().css("border", "0px solid black");
      $(".stick").stop().css("width", "0px");
   })
   $(".li_2").mouseover(function(){
      $(".stick2").css("border", "3.5px solid rgb(106, 141, 218)");
      $(".stick2").css("transform", ": scale(1.5)");
      $(".stick2").css("width", "150px");
      $(".stick2").css("transform-origin", "50% 50%");
   });
   $(".li_2").mouseout(function(){
      $(".stick2").stop().css("transform", ": scale(0)");
      $(".stick2").stop().css("border", "0px solid black");
      $(".stick2").stop().css("width", "0px");
   })
   $(".li_3").mouseover(function(){
      $(".stick3").css("border", "3.5px solid rgb(106, 141, 218)");
      $(".stick3").css("transform", ": scale(1.5)");
      $(".stick3").css("width", "150px");
      $(".stick3").css("transform-origin", "50% 50%");
   });
   $(".li_3").mouseout(function(){
      $(".stick3").css("transform", ": scale(0)");
      $(".stick3").css("border", "0px solid black");
      $(".stick3").css("width", "0px");
   })
   $(".li_4").mouseover(function(){
      $(".stick4").css("border", "3.5px solid rgb(106, 141, 218)");
      $(".stick4").css("transform", ": scale(1.5)");
      $(".stick4").css("width", "150px");
      $(".stick4").css("transform-origin", "50% 50%");
   });
   $(".li_4").mouseout(function(){
      $(".stick4").css("transform", ": scale(0)");
      $(".stick4").css("border", "0px solid black");
      $(".stick4").css("width", "0px");
   })


})
$(function(){
   $(".middle_main").slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 2000,
    });
})

$(function(){

$(window).scroll(function(){
   var scrollTop  = $(window).scrollTop();

   if(scrollTop  >= 100){
      $("#bb").css("background-color","white")
      $("#bb").css("color","black")
      $(".donation_124213").css("color","black")
      $(".donation_124213").css("border-color","black")
   }else{
      $("#bb").css("background-color","transparent")
      $("#bb").css("color","white")
      $(".donation_124213").css("border-color","white")
      $(".donation_124213").css("color","white")
   }
})

})

$(function(){
   $(window).scroll(function(){

      var scrollTop = $(window).scrollTop();

      if(scrollTop > 300){
         $(".scrollTop_div").fadeIn(300)
      }else{
         $(".scrollTop_div").fadeOut(300)
      }

   })

   $(".scrollTop_div").click(function(){
      $("html").animate({"scrollTop":"0"}, 100)
   })
})

$(function(){
   $(".story_first_img_div").mouseover(function(){
      $(".story_first_img_div_img").css("transform", "scale(1.2)")
   })
   $(".story_first_img_div").mouseout(function(){
      $(".story_first_img_div_img").css("transform", "scale(1)")
   })


})




