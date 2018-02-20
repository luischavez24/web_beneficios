// empresas.js
$(document).ready(function(){
   // Asignar evento de borrado
   function asignaEvento() {
      $(".btn_borrar").click(function(event) {
         $("#fila_eliminada").val($(this).val());
      });

      $("#btn_cancelar").click(function () { $("#fila_eliminada").val("");});
   }
   
   // Busquedas con Ajax
   $("#busq_empresas").submit(function(e) {
      e.preventDefault();
      $.ajax({
         url: $(this).attr("/empresas/search"),
         type: $(this).attr("get"),
         data: $(this).serialize(),
         success: function (data) {
            if(data == "") {
               $("#empresas").html("<tr><td><center><span></span> No hay empresas para mostrar</center></td></tr>");
               $("#empresas > tr > td").attr('colspan', 5);
               $("#empresas > tr > td > center > span").attr({
                  'class': 'fa fa-search',
                  'aria-hidden': 'true'
               });
            } else {
               $("#empresas").html(data);
            }
            
            asignaEvento();
         }
      });
   });
   // Fin de Busquedas con Ajax
   asignaEvento();
});