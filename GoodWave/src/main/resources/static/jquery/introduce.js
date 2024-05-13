$(document).ready(function() {
    $(window).scrollTop(0);
    
$(".introducePage_h2_font1").css("transform","translateY(0px)");
$(".introducePage_h2_font1").css("opacity","1");

setTimeout(function(){
   $(".introducePage_h2_font2").css("transform","translateY(0px)");
   $(".introducePage_h2_font2").css("opacity","1");
},200)
 });




$(function(){
    $(".nav_ul").mouseover(function(){
        $(".section1").stop().slideDown(150);
        $(".section1").css("display", "grid");
     })
     
    $(".nav_ul").mouseout(function(){
     $(".section1").stop().slideUp(50);
  })



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

 $(window).scroll(function(){
    let scrollTopWindow = $(this).scrollTop();

   
    
   

    if(scrollTopWindow > 300){
        $(".introduce_h2_font_introdroduce").css("opacity", "1");
    }

    if(scrollTopWindow > 400){
        $(".introduce_div_2_box").css("opacity", "1");
        $(".introduce_div_2_box").css("transform","translateY(0px)");
    }

    if(scrollTopWindow > 1000){
        $(".introduce_middle_main_font_p1").css("opacity", "1");
        $(".introduce_middle_main_font_p1").css("transform","translateX(0px)");
    }

    if(scrollTopWindow > 1100){
        $(".introduce_middle_main_font_p2").css("opacity", "1");
        $(".introduce_middle_main_font_p2").css("transform","translateX(0px)");
    }

    if(scrollTopWindow > 1500){
      $(".histroy_wrap_box_flex_box").eq(0).css("opacity", "1");
      $(".histroy_wrap_box_flex_box").eq(0).css("transform","translateY(0px)");

      setTimeout(function(){
         $(".histroy_wrap_box_flex_box").eq(1).css("opacity", "1");
         $(".histroy_wrap_box_flex_box").eq(1).css("transform","translateY(0px)");
   
      },200)

      setTimeout(function(){
         $(".histroy_wrap_box_flex_box").eq(2).css("opacity", "1");
         $(".histroy_wrap_box_flex_box").eq(2).css("transform","translateY(0px)");
      },400)
      
     
      setTimeout(function(){
         $(".histroy_wrap_box_flex_box").eq(3).css("opacity", "1");
         $(".histroy_wrap_box_flex_box").eq(3).css("transform","translateY(0px)");
      },600)

      setTimeout(function(){
         $(".histroy_wrap_box_flex_box").eq(4).css("opacity", "1");
         $(".histroy_wrap_box_flex_box").eq(4).css("transform","translateY(0px)");
      },800)

        setTimeout(function(){
         $(".histroy_wrap_box_flex_box").eq(5).css("opacity", "1");
         $(".histroy_wrap_box_flex_box").eq(5).css("transform","translateY(0px)");
   
      },1000)   
    }

    if(scrollTopWindow > 2350){
      $(".introduce_main_six_div_p1").css("opacity", "1");
      $(".introduce_main_six_div_p1").css("transform","translateX(0px)");
  

      setTimeout(function(){
         $(".introduce_main_six_div_p2").css("opacity", "1");
         $(".introduce_main_six_div_p2").css("transform","translateY(0px)");     
      },300)
   }

   if(scrollTopWindow > 2500){
      $(".introduce_grid_box_div1").css("opacity", "1");
      $(".introduce_grid_box_div1").css("transform","translateX(0px)"); 

      setTimeout(function(){
         $(".introduce_grid_box_div2").css("opacity", "1");
      $(".introduce_grid_box_div2").css("transform","translateX(0px)"); 
      },200)

      setTimeout(function(){
         $(".introduce_grid_box_div3").css("opacity", "1");
      $(".introduce_grid_box_div3").css("transform","translateY(0px)"); 
      },400)

      setTimeout(function(){
         $(".introduce_grid_box_div4").css("opacity", "1");
      $(".introduce_grid_box_div4").css("transform","translatex(0px)"); 
      },600)

      setTimeout(function(){
         $(".introduce_grid_box_div5").css("opacity", "1");
      $(".introduce_grid_box_div5").css("transform","translatex(0px)"); 
      },800)
      
   }

   if(scrollTopWindow > 1150){
      $(".purpose_p").css("opacity","1");
      $(".purpose_p").css("transform","translateY(0px)");

      setTimeout(function(){
         $(".purpose_p_span").css("opacity","1");
         $(".purpose_p_span").css("transform","translateY(0px)");
      },200)

      setTimeout(function(){
         $(".mental_p2").css("opacity","1");
         $(".mental_p2").css("transform","translateY(0px)");
      },400)
   }

   if(scrollTopWindow  > 1600){
      $(".core_font_h2").css("opacity","1");
      $(".core_font_h2").css("transform","translateY(0px)");

      setTimeout(function(){
         $(".core_font_span").css("opacity","1");
         $(".core_font_span").css("transform","translateY(0px)")
      },300)
   }

   if(scrollTopWindow > 2500){
      $(".core_box_values_box1").css("opacity","1");
      $(".core_box_values_box1").css("transform","translateX(0px)");

      setTimeout(function(){
         $(".core_box_values_box2").css("opacity","1");
         $(".core_box_values_box2").css("transform","translateY(0px)");
      },200)

      setTimeout(function(){
         $(".core_box_values_box3").css("opacity","1");
         $(".core_box_values_box3").css("transform","translateX(0px)");
      },400)

      setTimeout(function(){
         $(".core_box_values_box4").css("opacity","1");
         $(".core_box_values_box4").css("transform","translateY(0px)");
      },600)

      setTimeout(function(){
         $(".core_box_values_box5").css("opacity","1");
         $(".core_box_values_box5").css("transform","translateX(0px)");
      },800)
      
      setTimeout(function(){
         $(".core_box_values_box6").css("opacity","1");
         $(".core_box_values_box6").css("transform","translateY(0px)");
      },800)

      setTimeout(function(){
         $(".core_box_values_box7").css("opacity","1");
         $(".core_box_values_box7").css("transform","translateX(0px)");
      },800)

      setTimeout(function(){
         $(".core_box_values_box8").css("opacity","1");
         $(".core_box_values_box8").css("transform","translateY(0px)");
      },1000)
   }
 })


 $(function(){

   let a = 0;
   let b = 0;

   $(".userMyPage").click(function(){
        a++;
        b = a % 2;

        if(b == 1){
         $("#myPageForm").css("display","grid");
        }else{
         $("#myPageForm").css("display","none");
        }
   }) 

})

//  $(window).scroll(function(){
//     alert($(this).scrollTop());
//   })

let c = 0;
let d = 0;

$(".main_user_img").click(function(){
    c++;
    d = c % 2;

    if(d == 1){
      $(".gggg").fadeIn(100);
      $(".gggg").css("padding","15px");
      $(".gggg").css("width","250px")
      $(".fkfkfk").css("transform","translateX(-250px)");
    }else{
      
      $(".gggg").css("padding","0px");
      $(".gggg").css("width","0px");
      $(".fkfkfk").css("transform","translateX(0px)");

      setTimeout(function(){
         $(".gggg").css("display","none");
      },200)
    }

  
   
})

})

