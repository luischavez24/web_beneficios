// beneficios.js

$(function(){
   $('.btn-details').click(function(e) {
      e.preventDefault();
      $.ajax({
         url: '/beneficios/details',
         type: 'get',
         dataType: 'html',
         data: {
            nroBeneficio: $(this).val()
         },
         beforeSend: function(){
            $('#list_beneficio').fadeOut(function(){
               $('#detalle').removeClass("d-none");
               $('#detalle').fadeIn(function(){
                  $("#load").removeClass('d-none');
               });
            });
         },
         success: function(data) {
            $("#load").css('display', 'none');
            $('#detalle_content').html(data);
            console.log($("#detalle").offset().top);
            $("html, body").animate({
               scrollTop: $("#list_beneficio").offset().top
            }, 500);
            asignarEvento();
         },
         error: function(){
            $("#load").css('display', 'none');
            $('#detalle_content').html("Hubo un error");
         }
      });
   });
   
   function asignarEvento(){
      $("#cerrar").click(function(){
         console.log("Cerrando");
         $('#detalle').fadeOut(function(){
            $('#detalle').addClass("d-none");
            $('#list_beneficio').fadeIn(function(){
               $("#load").addClass('d-none');
            });
         });
      });
   }
});