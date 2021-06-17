$(document).ready(function(){
	$("#menu-0 a").css("color", "#000");
	$("#menu-0").css("background-color", "#efefef");

	$.ajax({
		type: "post",
		url: "../../DBConnection/year.jsp",
		dataType: "json",
		success: function(response){
			tcreateGraph(response, 400000);
			setSlideShow();
		},
		error: function(e){
			alert(e);
		}
	});
});