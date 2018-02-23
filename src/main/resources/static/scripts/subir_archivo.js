function archivo(evt, output, contendor) {
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
            document.getElementById(output).innerHTML = ['<img class="img-responsive imagen mx-auto d-block" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
            imagen = document.getElementById(contendor);
            if(imagen){
               padre = imagen.parentNode;
               padre.removeChild(imagen);
            }
         };
      })(f);

      reader.readAsDataURL(f);
   }
}      