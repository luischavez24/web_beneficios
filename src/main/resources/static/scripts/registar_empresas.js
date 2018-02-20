//registrar_empresas.js

$(document).ready(function(){
   function archivo(evt) {
      var files = evt.target.files; // FileList object
       
        //Obtenemos la imagen del campo "file". 
      for (var i = 0, f; f = files[i]; i++) {         
         //Solo admitimos imágenes.
         if (!f.type.match('image.*')) {
            continue;
         }

         var reader = new FileReader();

         reader.onload = (function(theFile) {
            return function(e) {
               // Creamos la imagen.
               document.getElementById("list").innerHTML = ['<img class="img-responsive imagen mx-auto d-block" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
               imagen = document.getElementById('img_defecto');
               if(imagen){
                  padre = imagen.parentNode;
                  padre.removeChild(imagen);
               }
            };
         })(f);

         reader.readAsDataURL(f);
      }
   }         
   document.getElementById('imagen_empresa').addEventListener('change', archivo, false);
});