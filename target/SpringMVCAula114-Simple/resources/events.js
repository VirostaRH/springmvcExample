$(document).ready(cargarEv);

function cargarEv()
{
	$("#consult").onClick(function(){
		$("#formu1").attr("action", "/show/");
		$(this).preventDefault;
		//$("#formu1").submit();
	});
}