<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Be Careful</title>
	<link rel="stylesheet" type="text/css" href="./resources/css/wrap.css?ver=1.5"/>
	<link rel="stylesheet" type="text/css" href="./resources/css/main.css?ver=1.5"/>
	<link rel="stylesheet" type="text/css" href="./resources/css/header.css?ver=1.7"/>
	<link rel="stylesheet" type="text/css" href="./resources/css/footer.css?ver=1.5"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	<script type="text/javascript" src="./resources/js/slideShow.js?ver=1.6"></script>
	<script type="text/javascript" src="./resources/js/mainGraph.js?ver=1.6"></script>
	<script type="text/javascript" src="./resources/js/graph.js?ver=1.5"></script>
	<script type="text/javascript" src="./resources/js/menu.js?ver=1.5"></script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div id="icon">
				<a href="/"><span>교통사고 통계</span></a>
			</div>
		</div>
		<div class="main">
			<ul class="menu">
				<li id="menu-0"><a href="#"><img src="./resources/images/bar-graph.svg"/>5년간 통계</a></li>
				<li id="menu-1"><a href="#"><img src="./resources/images/korea.png"/>지역별 통계</a></li>
				<li id="menu-2"><a href="#"><img src="./resources/images/car-run-over-man.png"/>사고 유형별 통계</a></li>
				<li id="menu-3"><a href="#"><img src="./resources/images/traffic-cone.png"/>도로 유형별 통계</a></li>
			</ul>
			<div class="contents">
				<ul class="graph-box current" id="graph-year"></ul>
				<ul class="graph-box" id="graph-accident"></ul>
				<ul class="graph-box" id="graph-road"></ul>
				<ul class="graph-box" id="graph-region"></ul>
				<div class="controls">
					<span class="prev">&lt;</span>
					<span class="next">&gt;</span>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="info">
				<p id="email">문의: icekwak@gmail.com</p>
				<p>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></p>
			</div>
			<ul class="link">
				<li id="link-0"><a href="https://www.data.go.kr" target="_blank"><img src="./resources/images/공공데이터.PNG"/></a></li>
				<li id="link-1"><a href="https://www.koroad.or.kr" target="_blank"><img src="./resources/images/도로교통공단.jpg"/></a></li>
				<li id="link-2"><a href="http://taas.koroad.or.kr" target="_blank"><img src="./resources/images/TAAS.PNG"/></a></li>
			</ul>
		</div>
	</div>
</body>
</html>