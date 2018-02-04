$("#r_usuario").click(function(event) {
    
    console.log("Hola")
	$.ajax({
		url: '/usuarios/new',
		type: 'get',
		success
		 : function (data) {
			$("body>").html(data);
			$("#my_modal").show();
		}
	});
});