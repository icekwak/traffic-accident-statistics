## 주제
교통사고 통계 웹사이트

## 개발 요약 (설명)
본 프로젝트는 교통사고 통계를 <strong>지역 및 5년간 발생한 사고와 사고 유형, 도로 유형별로 일어난 사고에 대해 사고건수, 사망자수, 부상자수</strong>로 나누어 그래프를 통해 보여줍니다.<br><br>
그래프는 `오픈소스(Chart.js)` 를 활용하여 사용자가 쉽게 데이터를 볼 수 있도록 하였고, 교통사고 공공데이터를 데이터베이스에 저장하고 `자바빈즈` 를 통해 `데이터베이스 연동(DBCP)` 및 데이터 저장하고 전송하였습니다.<br><br>
사용자에게 정보만 제공하는 용도로 제작한 본 프로젝트의 특성을 고려해 `ajax` 를 사용하여 웹 페이지를 `reload` 하지 않고 콘텐츠 부분의 데이터만 바뀌는 방식으로 제작하였고, 슬라이드 효과를 사용하여 작은 공간에 많은 데이터를 보여주도록 제작하였습니다.<br><br>
데이터베이스와 자바빈즈를 통해 교통사고 데이터를 내림차순으로 정렬하여 어느 지역이 교통사고 많이 일어나는지, 또는 어떤 유형의 교통사고가 많이 일어나는지 볼 수 있도록 교통사고 발생 순위를 제공합니다.<br><br>
마지막으로 교통과 관련된 여러 사이트와 연결하여 사용자에게 다양한 정보를 제공할 수 있도록 하였습니다.

[시연 영상](https://youtu.be/NUrw-Rd56Ak)

## 기술 스택
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white"/></a>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white"/></a>
<img src="https://img.shields.io/badge/javaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/></a>
<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white"/></a>

<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/></a>
<img src="https://img.shields.io/badge/JSP-000?style=flat-square" /></a>
<img src="https://img.shields.io/badge/MySQL-5.7-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a>

<img src="https://img.shields.io/badge/Tomcat-9.0.46-F8DC75?style=flat-square&logo=Apache Tomcat&logoColor=white"/>

## 오픈 소스
|[Chart.js](https://www.chartjs.org)|[공공데이터포털](https://www.data.go.kr/)|
|:---:|:---:|
|![Chart.js](https://user-images.githubusercontent.com/77434165/127616286-986d29ff-1cf7-429a-a0e7-da446d41ec42.png)|![공공데이터](https://user-images.githubusercontent.com/77434165/127616644-455e17c9-7769-4cf1-8b1f-aac45f0d0255.PNG)||

사용한 데이터 : 도로교통공단 교통사고 통계 데이터 (.csv)
아이콘 : [flaticon](https://www.flaticon.com)

## 실행 환경 조건
1. tomcat 다운로드
2. 데이터베이스 구축

## 개발 배경
교통사고는 우리나라 뿐만 아니라 전 세계적으로 많이 일어나는 사고 중 하나입니다.<br>
사람들이 안전 운전을 하고, 교통사고가 얼마나 위험한지 인지하고 있습니다.<br>
하지만, 매년 줄어들지 않는 교통사고 건수만 봐도 알 수 있듯이 무단횡단을 하고, 나만 아니면 된다는 생각을 가지고 크게 신경을 쓰지 않는 모습들이 보입니다.<br>
그래서 본 프로젝트는 사람들에게 시각을 교통사고 통계를 그래프로 보여줌으로써 교통사고에 대한 경각심을 다시 일깨워주고 교통과 관련된 정보들을 쉽게 접할 수 있도록 교통사고 통계 웹 사이트를 개발하였습니다.

## 개발 내용
<strong>1. 데이터 처리 및 데이터베이스 연동</strong><br>
교통사고 데이터는 `csv` 파일로 만들어진 공공데이터를 사용하여 데이터베이스에 저장하고,<br>
데이터베이스 연동은 효율적인 데이터베이스 커넥션을 위해 `DBCP` 를 사용하였습니다.<br><hr>

<strong>2. 교통사고 통계 그래프</strong><br>
교통사고 통계 데이터는 총 4개<strong>(연도별, 지역별, 사고 유형별, 도로 유형별)</strong>의 데이터를 사용합니다.<br>
메뉴 클릭 시 `ajax` 를 통해 웹 페이지를 `reload` 하지 않고 교통사고 데이터만 바뀌는 방식으로 제작하였습니다.<br>
또한, 작은 공간에 많은 데이터를 보여주기 위해 `overflow` 와 `transition` 을 사용하여 생동감 있는 슬라이드 효과를 주었습니다.<br><br>
그래프는 `Chart.js` 오픈소스를 사용하여 시각적으로 교통사고 데이터를 사용자가 쉽게 볼 수 있도록 하였고,<br>
그래프의 y축 값을 고정값으로 설정하여 다른 데이터와 쉽게 비교할 수 있고 그래프 색상을 차갑고 비슷한 색상으로 설정하여 사용자가 보았을 때,<br>
화려함 속에 전달하려고 하는 데이터가 묻히지 않도록 하였습니다.<br><hr>

<strong>3. 교통사고 발생 순위</strong><br>
교통사고 발생 순위는 총 4개<strong>(사고 유형, 도로 유형, 시도, 시군구)</strong>의 교통사고 발생 순위를 보여줍니다.<br>
이 데이터는 데이터베이스에서 데이터를 가져올 때, 사고건수에 대해 내림차순으로 정렬하여 가져옵니다.<br>
이후, 내림차순으로 정렬된 데이터를 유형에 맞게 배치하여 사용자에게 보여줍니다.<br><hr>

<strong>4. 하단 정보 (footer)</strong><br>
하단 부분은 개발자의 정보 및 아이콘의 출처를 표시하였으며, 3개(공공데이터, 도로교통공단, 교통사고분석시스템)의 교통과 관련된 웹 사이트 링크를 생성하여 사용자가 다양한 교통 정보를 볼 수 있습니다.

## 구현 결과
<div align="center">
  
  ![image](https://user-images.githubusercontent.com/77434165/127618299-327bb8ef-ac7e-4d1a-b192-b5c318edadfe.png)
  ![image](https://user-images.githubusercontent.com/77434165/127618307-40ebbed4-a75b-40f0-a0b3-b351f9e08f75.png)
  <br><strong>[그림 1] 교통사고 통계 그래프(상: 5년간 통계, 하: 지역별 통계)</strong>

  <strong>[그림 1]</strong>은 (연도별, 지역별, 사고 유형별, 도로 유형별)로 교통사고 통계를 그래프로 보여줍니다.<br><br><hr>

  ![image](https://user-images.githubusercontent.com/77434165/127618328-84d47fcf-7d7f-4750-a88f-691c9fff3d01.png)
  <br><strong>[그림 2] 교통사고 발생 순위</strong>

  <strong>[그림 2]</strong>는 교통사고가 자주 발생하는 지역 및 사고, 도로 유형별로 순위를 매겨서 보여줍니다.<br><br><hr>

  ![image](https://user-images.githubusercontent.com/77434165/127618345-2fd9fb97-4c1b-4dc6-ba83-54264ff9d85a.png)
  <br><strong>[그림 3] 하단정보 (footer)</strong>

  <strong>[그림 3]</strong>은 웹 사이트 제작자 정보 및 아이콘 사용 출처와 교통 관련 웹 사이트 연결 링크가 있습니다.
  
</div>

## 기대효과
간편하고 쉬운 구성으로 누구나 쉽게 사용할 수 있고, 교통사고 통계를 그래프로 보여줌으로써 사용자가 정보를 쉽게 볼 수 있습니다.<br>
또한, 교통과 관련된 여러 웹 사이트와 연결하여 사용자는 다양한 정보를 얻을 수 있습니다.<br>
자연스럽게 교통과 관련된 정보들을 접하다 보면 무덤덤해지는 교통사고에 대한 경각심을 다시 일깨워 줄 수 있습니다.
