$(document).ready(function(){
	let url = ["../../DBConnection/rankAcc.jsp", "../../DBConnection/rankRoad.jsp", "../../DBConnection/rankSi.jsp", "../../DBConnection/rankSigu.jsp"];
	
	for(let i=0; i<4; i++){
		$.ajax({
			type: "post",
			url: url[i],
			dataType: "json",
			success: function(response){
				createRanking(response, i);
			},
			error: function(e){
				alert(e);
			}
		});
	}
	
	function createRanking(response, n){
		let data;
		
		for(let i=0; i<5; i++){
			data = response[i];
			$(`#rank-${n}`).append(`<li>${i+1} | ${data.rankId}</li>`);
		}
	}
});

