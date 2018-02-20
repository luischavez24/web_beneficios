//contactos.js

$(document).ready(function(){
   
   // Funcion para borrar elemento
   function asignaEvento() {
      
      $(".btn_borrar").click(function(event) {
          var pk = $(this).val().split(",");
         $("#fila_eliminada_1").val(pk[0]);
         $("#fila_eliminada_2").val(pk[1]);
      });

      $("#btn_cancelar").click(function () {
         $("#fila_eliminada_1").val("");
         $("#fila_eliminada_2").val("");
      });
   }

   // Busquedas con Ajax
   $("#busq_contactos").submit(function(e) {
      e.preventDefault();  

      $.ajax({
         url: $(this).attr("/contactos/search"),
         type: $(this).attr("get"),
         data: $(this).serialize(),
         success : function (data) {
            if(data == "") {
               $("#contactos").html("<tr><td><center><span></span> No hay contactos para mostrar</center></td></tr>");
               $("#contactos > tr > td").attr('colspan', 6);
               $("#contactos > tr > td > center > span").attr({
                  'class': 'fa fa-search',
                  'aria-hidden': 'true'
               });
            } else {
               $("#contactos").html(data);
            }
            asignaEvento();
         },
         error: function(){
            $("#contactos").html("<tr><td><center><span></span>Ha ocurrido un error</center></td></tr>");
            $("#contactos > tr > td").attr('colspan', 6);
            $("#contactos > tr > td > center > span").attr({
               'class': 'fa fa-exclamation-triangle',
               'aria-hidden': 'true'
            });
         }
      });
         
   });
   // Fin de Busquedas con Ajax
   asignaEvento();
});