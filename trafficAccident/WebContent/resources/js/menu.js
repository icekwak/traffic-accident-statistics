$(document).ready(function(){
	$(document).on("click", ".menu li", function(){
		let check = $(this).attr("id");
		let url, max;
		
		$(".menu li").css("background-color", "#fff");
		$(this).css("background-color", "#efefef");
		
		$(".menu li a").css("color", "rgb(70, 77, 82)");
		$(this).children("a").css("color", "#000");
		
		$(".current").children().remove();
		$(".graph-box").removeClass("current");
		
		if(check === "menu-0"){
			url = "../../DBConnection/year.jsp";
			$("#graph-region").addClass("current");
			setSlideShow();
			max = 400000;
		}
		else if(check === "menu-1"){
			url = "../../DBConnection/region.jsp";
			$("#graph-region").addClass("current");
			setSlideShow();
			max = 160000;
		}
		else if(check === "menu-2"){
			url = "../../DBConnection/accident.jsp";
			$("#graph-accident").addClass("current");
			setSlideShow();
			max = 300000;
		}
		else if(check ==="menu-3"){
			url = "../../DBConnection/road.jsp";
			$("#graph-road").addClass("current");
			setSlideShow();
			max = 140000;
		}
		else{
			alert("fail to menu");
			return;
		}
		
		
		$.ajax({
			type: "post",
			url: url,
			dataType: "json",
			success: function(response){
				createGraph(response, max);
			},
			error: function(e){
				alert(e);
			}
		});
	});
});