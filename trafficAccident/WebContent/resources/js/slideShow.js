let graphBox = null;
let graphItems = null;
let currentIndex = 0;
let itemCount = 0;
let itemWidth = 300;
let itemMargin = 20;

$(document).ready(function(){
	function moveSlide(num){
		graphBox.style.left = (-num * 320 + 20) + "px";
		currentIndex = num;
	}
	
	$(document).on("click", ".next", function(){
		if(currentIndex < itemCount + 1){
			moveSlide(currentIndex + 4);	
		}
		else{
			moveSlide(0);
		}
	});
	
	$(document).on("click", ".prev", function(){
		if(currentIndex > 0){
			moveSlide(currentIndex - 4);	
		}
		else{
			moveSlide(itemCount + 4);
		}
	});
});

function setSlideShow(){
	graphBox = document.querySelector(".current");
	graphItems = document.querySelectorAll(".current li");
	currentIndex = 0;
	itemCount = graphItems.length;
	itemWidth = 300;
	itemMargin = 20;
	
	graphBox.style.left = "20px";
	graphBox.style.width = (itemWidth + itemMargin) * itemCount - itemMargin + "px";
}