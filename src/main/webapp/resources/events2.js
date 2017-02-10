$(document).ready(cargarEv);

function cargarEv()
{
	$("#cancel").click(function(e){
		e.preventDefault();
		$("#formu1").attr("action", "/employee");
		$("#formu1").submit();
	});
}