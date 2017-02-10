$(document).ready(cargarEv);

function cargarEv()
{
	$("#consult").click(function(e){
		e.preventDefault();
		$("#formu1").attr("action", "/show/");
		$("#formu1").submit();
	});
	$("#update").click(function(e){
		e.preventDefault();
		$("#formu1").attr("action", "/edit/");
		$("#formu1").submit();
	});
	$("#delete").click(function(e){
		e.preventDefault();
		$("#formu1").attr("action", "/delete/");
		$("#formu1").submit();
	});
}