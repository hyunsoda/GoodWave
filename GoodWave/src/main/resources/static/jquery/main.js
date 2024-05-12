

$(document).ready(function() {
   $(window).scrollTop(0);
   

});

$(window).on('beforeunload', function() {
   $(window).scrollTop(0);
});

$(function(){
   $(".middle_main").slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 2000,
    });
})

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
      $(".stick2 .stick3 .stick4").css("border","0px solid black");
      $(".stick2 .stick3 .stick4").css("width", "0px");
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
      $(".stick1 .stick3 .stick4").css("border","0px solid black");
      $(".stick1 .stick3 .stick4").css("width", "0px");
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
      $(".stick1 .stick2 .stick4").css("border","0px solid black");
      $(".stick1 .stick2 .stick4").css("width", "0px");
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
      $(".stick1 .stick2 .stick3").css("border","0px solid black");
      $(".stick1 .stick2 .stick3").css("width", "0px");
   });
   $(".li_4").mouseout(function(){
      $(".stick4").css("transform", ": scale(0)");
      $(".stick4").css("border", "0px solid black");
      $(".stick4").css("width", "0px");
   })
 

  
    
   

   $(".story_div_box_box_first").mouseover(function(){
      $(".story_first_img_div_img").css("transform", "scale(1.2)");
   })
   $(".story_div_box_box_first").mouseout(function(){
      $(".story_first_img_div_img").css("transform", "scale(1)");
   })

   $(".story_flex_box").eq(0).mouseover(function(){
      $("#img_1").css("transform", "scale(1.2)");
   })

   $(".story_flex_box").eq(0).mouseout(function(){
      $("#img_1").css("transform", "scale(1)");
   })

   $(".story_flex_box").eq(1).mouseover(function(){
      $(".img_2").css("transform", "scale(1.2)");
   })

   $(".story_flex_box").eq(1).mouseout(function(){
      $(".img_2").css("transform", "scale(1)");
   })

   $(".story_flex_box").eq(2).mouseover(function(){
      $("#img_3").css("transform", "scale(1.2)");
   })

   $(".story_flex_box").eq(2).mouseout(function(){
      $("#img_3").css("transform", "scale(1)");
   })

   $(".story_flex_box").eq(3).mouseover(function(){
      $("#img_4").css("transform", "scale(1.2)");
   })

   $(".story_flex_box").eq(3).mouseout(function(){
      $("#img_4").css("transform", "scale(1)");
   })

   
      


})


// -- count up


var isCounted = false; // 전역 변수로 설정

$(window).scroll(function(){
    var scrollWindow = $(this).scrollTop();
  
    if(scrollWindow >= 1600 && !isCounted){
        isCounted = true; // 한 번 실행되었음을 표시

        var count_up = 0;
        counterFn();

        function counterFn(){
            id0 = setInterval(function(){
                counterUp();
            }, 50)

            function counterUp(){
                count_up++;
                if(count_up > 46){
                    clearInterval(id0);
                }else{
                    $(".history_fourty").text(count_up);
                }
            }
        }

        var count_upd = 0;
        counterFnd();

        function counterFnd(){
            id0d = setInterval(function(){
                counterUpd();
            }, 50)

            function counterUpd(){
                count_upd++;
                if(count_upd > 20){
                    clearInterval(id0d);
                }else{
                    $(".warm_people").text(count_upd);
                }
            }
        }

        var count_ups = 0;
        counterFns();

        function counterFns(){
            id0s = setInterval(function(){
                counterUps();
            }, 20)

            function counterUps(){
                count_ups++;
                if(count_ups > 101){
                    clearInterval(id0s);
                }else{
                    $(".happy_peoples").text(count_ups);
                }
            }
        }
    }


    $(".more_view").mouseover(function(){
      $(this).css("backgroundColor","#63A3D0");
   })

   $(".more_view").mouseout(function(){
      $(this).css("backgroundColor","transparent");
   })

   $(window).scroll(function(){
         // 100
      let windowScrollTop = $(this).scrollTop();

      if(windowScrollTop > 1){
         $(".gggg").css("border","3px solid black");
         $("#bb").css("backgroundColor","white");
         $("#bb").css("color","black");
         $(".donation_124213").css("color", "black");
         $(".donation_124213").css("border-color", "black");
      }else{
         $(".gggg").css("border","3px solid white");
         $("#bb").css("backgroundColor","transparent");
         $("#bb").css("color","white");
         $(".donation_124213").css("color", "white");
         $(".donation_124213").css("border-color", "white");
      }

      if(windowScrollTop > 130){
         $(".story_h2_font").css("transform","translateY(0px)");
         $(".story_h2_font").css("opacity","1");
      }

      if(windowScrollTop > 350){
         
         $(".story_div_box_box_first").css("transform","translateX(0px)");
         $(".story_div_box_box_first").css("opacity","1");

         setTimeout(function(){
            $("#story_flex_box_1").css("transform","translateX(0px)")
            $("#story_flex_box_1").css("opacity","1");
         },100)

         
        
  
         setTimeout(function(){
            $("#story_flex_box_2").css("transform","translateX(0px)")
            $("#story_flex_box_2").css("opacity","1");
         },300)
         
      setTimeout(function(){
                $("#story_flex_box_3").css("transform","translateX(0px)")
                $("#story_flex_box_3").css("opacity","1");
         },500)

         setTimeout(function(){
            $("#story_flex_box_4").css("transform","translateX(0px)")
            $("#story_flex_box_4").css("opacity","1");
         },700)

         


      }

   })
     


         
});

//  $(window).scroll(function(){
//    alert($(this).scrollTop());
//   })

$(function(){

   $(".plus_span").mouseover(function(){
      $(this).css("transform","rotate(360deg)");
   });
   $(".plus_span").mouseout(function(){
      $(this).css("transform","rotate(0)");
   });

   $(window).scroll(function(){
      var scrollTopWindow = $(this).scrollTop();

      if(scrollTopWindow > 1100){
         $(".h2_give_font").css("transform","translateY(0px)");
         $(".h2_give_font").css("opacity","1");
      }

     


      if(scrollTopWindow > 2000){

         $(".volunteer_h2").css("transform","translateY(0px)");
         $(".volunteer_h2").css("opacity","1");

         setTimeout(function(){
            $(".volunteer_box_1").css("transform","translateX(0px)");
            $(".volunteer_box_1").css("opacity","1");
         },100)
        

         setTimeout(function(){
            $(".volunteer_box_2").css("transform","translateY(0px)");
            $(".volunteer_box_2").css("opacity","1");
         },300)

         setTimeout(function(){
            $(".volunteer_box_3").css("transform","translateY(0px)");
            $(".volunteer_box_3").css("opacity","1");
         },500)
         
      }

      if(scrollTopWindow > 3100){
         $(".gongji_h2").css("transform","translateY(0px)");
         $(".gongji_h2").css("opacity","1");
         setTimeout(function(){
            $(".gongi_div_p").css("transform","translateY(0px)");
            $(".gongi_div_p").css("opacity","1");
         },300)
        

    

      }

      if(scrollTopWindow > 3200){
         setTimeout(function(){
            $(".gongi_div_1").css("transform","translateY(0px)");
            $(".gongi_div_1").css("opacity","1");

         },200)

         setTimeout(function(){
            $(".gongi_div_2").css("transform","translateY(0px)");
            $(".gongi_div_2").css("opacity","1");

         },400)

         setTimeout(function(){
            $(".gongi_div_3").css("transform","translateY(0px)");
            $(".gongi_div_3").css("opacity","1");

         },600)
         setTimeout(function(){
            $(".gongi_div_4").css("transform","translateY(0px)");
            $(".gongi_div_4").css("opacity","1");

         },800)
      }
   });


   $(window).scroll(function(){
      if($(this).scrollTop() > 200){
         $(".scrollTop_div").css("display","block");
         $("#volunteer_a").css("display","block");
      }else{
         $(".scrollTop_div").css("display","none");
         $("#volunteer_a").css("display","none");
      }
   })

   $(".scrollTop_div").click(function(){
      $("html").animate({"scrollTop":"0"}, 100);
   })

   

   

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

  /* padding: 15px; */
   /* border: 3px solid white; */
   /* display: none; */

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







