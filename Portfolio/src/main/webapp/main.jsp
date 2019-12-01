<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>LGS</title>
	
	<!-- Custom fonts for this theme -->
	<link href="${context}/resources/css/all.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- Smart Editor -->
	<script type="text/javascript" src="${context}/smartEditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	
	<!-- Theme CSS -->
	<link href="${context}/resources/css/freelancer.css" rel="stylesheet">
	
	<!-- main CSS -->
	<link href="${context}/resources/css/pfmain.css" rel="stylesheet">
</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger font-customA" href="#page-top">Lee Gyu Seob</a>

			<button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				Menu
				<i class="fas fa-bars"></i>
			</button>

			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mx-0 mx-lg-1">
		 		 <a class="nav-link py-3 px-0 px-lg-2 rounded js-scroll-trigger" href="#about">About</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
					<a class="nav-link py-3 px-0 px-lg-2 rounded js-scroll-trigger" href="#profile">Profile</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
		 		 <a class="nav-link py-3 px-0 px-lg-2 rounded js-scroll-trigger" href="#skill">Skill</a> 
					</li>
					<li class="nav-item mx-0 mx-lg-1">
				<a class="nav-link py-3 px-0 px-lg-2 rounded js-scroll-trigger" href="#portfolio">Portfolio</a>
					</li>
				</ul>
			</div>
			
		</div>
	</nav>
	
	<!-- Masthead -->
	<header class="masthead bg-customA text-white text-center">
		<div class="container d-flex align-items-center flex-column padding-customA">
	
			<!-- Masthead Heading -->
			<h1 class="masthead-heading mb-0">LGS - PortFolio</h1>
	
			<!-- Icon Divider -->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-user-tie"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
	
			<!-- Masthead Subheading -->
			<p class="masthead-subheading font-weight-light mb-0">안녕하세요</p>
			<p class="masthead-subheading font-weight-light mb-0">신입 웹 개발자 이규섭의 포트폴리오 홈페이지 입니다.</p>
			<a class="rounded js-scroll-trigger" href="#portfolio">↓포트폴리오↓</a>
	
		</div>
	</header>
	
	
	
	<!-- About Section -->
	<section class="page-section mb-0" id="about">
		<div class="container">
	
			<!-- About Section Heading -->
			<h2 class="page-section-heading text-center text-uppercase">About</h2>
	
			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-user-circle"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
	
			<!-- About Section Content -->
			<div class="row">
				<div class="col-md-12">
					<span class="font-customB">안녕하세요. 신입 웹 개발자 이규섭입니다.<br/>
			전기정보과를 전공하였으나 뒤늦게 프로그래밍에 흥미를 느껴 국비지원 웹 개발자 교육을 받게 되었습니다.&nbsp;&nbsp;
			6.5개월의 교육기간동안 많은 것을 배울 수 있었으며, 끈기있게 개발역량을 쌓아올려왔습니다.<br/>
			이를 바탕으로 저는 개발자라는 끝없는 배움의 길에 오르려 합니다.&nbsp;&nbsp;아직 신입이고 앞으로 어려운점이 많겠지만
			포기하지 않고 배워나갈것이며 항상 발전하는 모습을 보여 드리겠습니다.
					</span>
				</div>
			</div>
		</div>
	</section>
	
	<!-- Profile Section -->
	<section class="page-section mb-0 bg-customB" id="profile">
		<div class="container">
	
			<!-- Profile Section Heading -->
			<h2 class="page-section-heading text-center text-uppercase">Profile</h2>
	
			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-user-edit"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
	
			<!-- Profile Section Content -->
			<div class="row">
				<div class="col-md-12">
					 <ul class="ul-customA">
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			이름
					 		</p>
					 		<p>이규섭</p>
					 	</li>
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			생년
					 		</p>
					 			<p>1991年</p>
					 	</li>
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			학력
					 		</p>
					 			<p>인하공업전문대학: 전기정보과 졸업</p>
					 	</li>
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			이수교육
					 		</p>
					 			<p>쌍용강북교육센터: 자바기반 융합형 SW개발자 양성과정 수료</p>
					 	</li>
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			자격증
					 		</p>
					 			<p>전기산업기사 (한국산업인력공단)</p>
					 	</li>
					 	<li class="li-custom-margin">
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			Phone
					 		</p>
					 			<p>010-6779-3570</p>
					 	</li>
					 	<li>
					 		<p class="font-customC li-custom-name">
					 			<i class="fas fa-circle"></i>
					 			Email
					 		</p>
					 			<p>alhard01@gmail.com</p>
					 	</li>
					 </ul>
				</div>
			</div>
		</div>
	</section>
	
	<!-- Skill Section -->
	<section class="page-section" id="skill">
		<div class="container">
	
			<!-- Skill Section Heading -->
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Skill</h2>
	
			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
	
			<!-- Skill Index -->
			<div>
				<label class="label-customA">언어</label>
				<ul type="square">
					<li><u>Java</u></li>
					<ul type="circle">
						<li>자바 기초 문법을 활용하여 프로그램을 만들고 웹 프로젝트와 연동가능</li>
						<li>외부 API를 가져와 사용가능</li>
					</ul>
					<li><u>JSP / Servlet</u></li>
					<ul type="circle">
						<li>jsp파일로부터 mapping된 주소로 Servlet파일로 이동하여 프로그램 처리하고 jsp파일로 데이터 전송가능</li>
					</ul>
					<li><u>HTML / CSS</u></li>
					<ul type="circle">
						<li>태그를 사용해 원하는 디자인을 대략적으로 형성할 수 있으며, 스타일을 작성해 사용가능</li>
					</ul>
					<li><u>JavaScript / JQuery</u></li>
					<ul type="circle">
						<li>html안에 요소를 만들거나 선택하여 조작하거나 속성을 조회, 변경하여 값을 저장하여 동적인 페이지를 만들며, 데이터를 원하는 페이지로 전송가능</li>
					</ul>
				</ul>
				<label class="label-customA">DataBase</label>
				<ul type="square">
					<li><u>Oracle</u></li>
					<ul type="circle">
						<li>Oracle 데이터베이스의 쿼리를 사용해 테이블을 만들고 컬럼을 생성해 데이터 입출력 가능</li>
					</ul>
				</ul>
				<label class="label-customA">FrameWork</label>
				<ul type="square">
					<li><u>Spring / MyBatis</u></li>
					<ul type="circle">
						<li>스프링 프레임워크를 사용하여 웹 프로젝트를 개발하고, MyBatis를 연동하여 DB로부터 데이터입출력 가능</li>
					</ul>
				</ul>
			</div>
	
		</div>
	</section>
	
	<!-- Portfolio Section -->
	<section class="page-section portfolio bg-customB" id="portfolio">
		<div class="container">
	
			<!-- Portfolio Section Heading -->
			<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Portfolio</h2>
	
			<!-- Icon Divider -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-edit"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
	
			<!-- Portfolio Grid Items -->
			<div class="row">
	
				<!-- Portfolio Item 1 -->
				<div class="col-md-6 col-lg-6">
					<div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal1">
						<div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid" src="${context}/resources/img/mainpf.png" alt="">
					</div>
				</div>
	
				<!-- Portfolio Item 2 -->
				<div class="col-md-6 col-lg-6">
					<div class="portfolio-item mx-auto item-custom" data-toggle="modal" data-target="#portfolioModal2">
						<div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid" src="${context}/resources/img/mainpfetc.png" alt="">
					</div>
				</div>
	
			</div>
			<!-- /.row -->
	
		</div>
	</section>
	
	<!-- Portfolio Modals -->
	
	<!-- Portfolio Modal 1 -->
	<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-labelledby="portfolioModal1Label" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">
						<i class="fas fa-times"></i>
					</span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
								<!-- Portfolio Modal - Title -->
								<h2 class="portfolio-modal-title text-secondary text-uppercase mb-0">PortFolio-main</h2>
								<!-- Icon Divider -->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
								<!-- Portfolio Modal - Image -->
								<img class="img-fluid rounded mb-5" src="${context}/resources/img/mainPF/pf1_main.png" alt="">
								<!-- Portfolio Modal - Text -->
								<div class="row mainPFDiv">
									<div class="col-md-12">
										<span class="font-customB"><h3>Sunnyside Theater</h3>
										<b>프로젝트명</b>: 영화 예매 사이트<br/>
										<b>기간</b>: 2019.8 ~ 10 (약 10주)<br/>
										<b>참여인원</b>: 총 6명<br/>
										<b>GitHub</b>: <a target="_blank" href="https://github.com/HR-Kim/SUNNYSIDE3">https://github.com/HR-Kim/SUNNYSIDE3</a><br/>
										<b>AWS</b>: <a target="_blank" href="http://ec2-13-209-5-35.ap-northeast-2.compute.amazonaws.com:8080/SUNNYSIDE_MYSQL/main/main.do">SUNNYSIDE</a><br/>
										(관리자아이디로 로그인하여 모든 컨텐츠를 보실 수 있습니다.)<br/>
										(admin / 123)<br/>
										<hr/>
										<h5>개발 Platform</h5>
										<ul type="disc">
											<li>Java SE 8</li>
											<li>Oracle 12g (AWS에 업로드하면서 MySql로 전환)</li>
											<li>Apache Tomcat 8.5</li>
											<li>Github</li>
											<li>STS</li>
										</ul>
										<hr/>
										<h5>맡은업무</h5>
										<ul type="disc">
											<li>영화예매 (영화선택~좌석선택~결제)</li>
											<li>극장편성 및 관리</li>
											<ul type="circle">
												<li>영화관 지점 편집</li>
												<li>지점내 상영관 편집</li>
												<li>좌석 편집</li>
												<li>상영영화 편성</li>
											</ul>
											<li>맡은파트 다국어처리</li>
										</ul>
										&nbsp;&nbsp;&nbsp;+ AWS<br/>
										<hr/>
										<h5>프로젝트 특징</h5><br/>
										<b>사이트 로드맵</b>
										<img class="img-fluid rounded mb-5" src="${context}/resources/img/mainPF/map.png" alt=""><br/>
										<b>각종 API 사용</b><br/>
										<u>결제</u>: 아임포트 결제API를 사용하여 가상결제를 구현해 리얼리티를 살렸습니다.<br/>
										<u>영화</u>: 한국영화데이터베이스, 영화진흥위원회의 오픈API를 사용해 7만건 가량의 영화정보를 받아올 수 있었습니다<br/>
										<u>지도</u>: 다음지도API로 영화관의 위치를 알리는 페이지를 만들 수 있었습니다.<br/>
										<u>로그인</u>: 네이버아이디로도 로그인이 가능하도록 했습니다.<br/>
										<b>다국어</b><br/>
										<p>모든 페이지에 다국어처리를 하여 영어페이지를 지원합니다.</p>
										<b>스케줄러</b><br/>
										<p>자동 회원등급up 및 좌석데이터 정리를 위해 스케줄러를 사용하여 일정한 시간마다 자동으로 프로그램이 돌아가도록 했습니다.</p>
										<b>AWS</b><br/>
										<p>AWS의 프리티어로 EC2서버를 구축하여 배포하였습니다. 또한 아마존에서 제공하는 관계형 데이터베이스 서비스(RDS)를 사용해 데이터베이스(Mysql)를 구축했습니다.</p>
										<b>형상관리 및 작업관리</b><br/>
										<p>GitHub와 카카오톡 메신저로 작업내용을 공유하였습니다.</p>
										<br/>
										<p><u>이 프로젝트는</u> <font size="2">6.5개월의 교육기간중 진행한 마지막 프로젝트입니다.  총원 6명이 제작하였으며, 교육기간동안 배운 지식을 모두 활용하였습니다. 
										부족한 부분은 구글링하거나 책을 찾아보는 등의 개인적인 공부로 해결하였습니다. 프로젝트를 하면서 공부가 많이 된 것 같습니다.<br/>
										제가 담당한 부분은 극장편집페이지, 영화편성페이지와 영화예매페이지 입니다.
										</font></p>
										<p><u>극장편집페이지는</u> <font size="2">극장과 상영관을 추가, 삭제하거나 이름을 바꿀 수 있습니다. 그리고 상영관에 좌석을 추가할 수 있으며, 좌석을 시각적으로 보면서 위치를 편집해 넣을 수 있습니다.
										</font></p>
										<p><u>영화편성페이지는</u> <font size="2">상영관에 상영할 영화를 편성할 수 있습니다. 영화를 선택하고 시간대와 가격을 설정할 수 있습니다.
										</font></p>
										<p><u>극장과 영화편성페이지는</u> <font size="2">게시판을 응용하여 만들었습니다. 단순히 DB에 데이터를 입출력하고 보여주는 역할을 하기만 하면 되기떄문에 큰 어려움은 없었으나 처음에 설계를 엉성하게 하는 바람에 처음에 어떻게 만들어야 할지 틀을 잡는 과정은 조금 오래걸렸습니다. 이 부분에서 초기 설계의 중요성을 절실히 느꼈습니다.
										</font></p>
										<p><u>영화예매페이지는</u> <font size="2">영화편성페이지에서 편성된 영화를 선택하고 좌석을 선택해 티켓을 예매하는 페이지 입니다.
										아임포트 가상결제 API를 사용해 리얼리티를 살렸습니다. 이 페이지는 동적인 페이지를 위해 Ajax를 적극 활용했습니다.
										</font></p>
										<br/>
										<hr/>
										<h5>맡은업무 설명</h5><br/>
										<h5>극장관리페이지</h5>
										<button id="mainpf-Btn-a" class="btn btn-sm btn-warning" onclick="javascript:mainpf_btn('a');">보기</button>
										<div class="mainpf-a font-customD">
											- 관리자만 볼 수 있는 페이지입니다.<br/>
											- 이 페이지는 극장의 지점과 상영관을 생성 및 편집하고 좌석을 생성할 수 있습니다.<br/>
											- 동적 페이지를 만들기 위해 Ajax를 적극 활용하였습니다. <br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_1.png" alt=""><br/>
											(미리 생성한 홍대점의 1관과 그 좌석)<br/>
											<br/>
											- 좌석생성버튼을 누르면 빈 상영관에 좌석을 생성할 수 있습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_2.png" alt=""><br/>
											<br/>
											- 새 창으로 생성창이 띄워집니다.<br/>
											- 클릭&드래그로 사용할 좌석을 지정할 수 있습니다.<br/>
											- 하얀색은 통로, 파란색은 좌석이며, 이 장면은 처음에 회색이었던 모든 버튼을 캡쳐전에 미리 설정해놓은 상태입니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_3.png" alt=""><br/>
											<br/>
											- 만약 상영관에 영화가 상영중이면 해당 상영관의 좌석현황을 볼 수 있습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_4.png" alt=""><br/>
											<br/>
											- 붉은 버튼은 티켓을 예매한 관객입니다.<br/>
											- 버튼을 클릭하여 좌석을 비울 수도 있습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_5.png" alt=""><br/>
											<hr/>
										</div>
										<h5>영화편성페이지</h5>
										<button id="mainpf-Btn-b" class="btn btn-sm btn-warning" onclick="javascript:mainpf_btn('b');">보기</button>
										<div class="mainpf-b font-customD">
											- 관리자만 볼 수 있는 페이지입니다.<br/>
											- 상영할 영화를 미리 편성할 수 있으며, 편성된 영화들은 예매페이지에 적용됩니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_6.png" alt=""><br/>
											(홍대점의 1관에 미리 편성한 영화들이 출력중)<br/>
											<br/>
											- 영화추가버튼을 누르면 DB에 저장된 모든 영화목록이 출력되며 개봉, 미개봉, 개봉예정 카테고리별로 조회 가능합니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_7.png" alt=""><br/>
											<br/>
											- 표시되고 있는 영화테이블 뒤쪽은 스타일의 z-index로 dim레이어를 만들어 띄워서 현재 작업을 방해하는 다른 버튼을 누를 수 없도록 처리했습니다.<br/>
											- 영화정보버튼을 클릭하면 선택한 영화의 정보를 볼 수 있습니다.<br/>
											- 캡쳐에 띄워진 영화테이블과 영화정보창은 드래그하여 이동시킬 수 있습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_8.png" alt=""><br/>
											<br/>
											- 영화테이블에서 선택을 누르고 상영시간과 가격을 정할 수 있습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_9.png" alt=""><br/>
											<br/>
											- 페이지 하단의 편성을 누르면 마지막 확인창이 표시되고 확인을 누르면 영화가 편성됩니다.<br/>
											- 편성된 영화목록이며 전체 혹은 오늘날짜만 조회 가능합니다.<br/>
											- 테이블 오른쪽의 회차는 DB쿼리로 오늘의 편성영화 개수를 조회하여 자동으로 증가되어 적용됩니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_10.png" alt=""><br/>
											<br/>
										</div>
										<h5>영화 예매 페이지</h5>
										<button id="mainpf-Btn-c" class="btn btn-sm btn-warning" onclick="javascript:mainpf_btn('c');">보기</button>
										<div class="mainpf-c font-customD">
											- 상영중인 영화 목록입니다.<br/>
											- 포스터에 마우스를 올리면 예매하기와 상세보기버튼이 띄워지며 예매하기 버튼을 누르면 해당영화로 자동 포커스 됩니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_11.png" alt=""><br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_12.png" alt=""><br/>
											<br/>
											- 영화를 선택하면 편성된 영화 정보에 따라서 극장과 날짜, 상영시간이 출력되어 사용자가 선택할 수 있도록 합니다.<br/>
											- 상영시간이 끝난 영화는 상영시간표에 표시는 되지만 클릭할 수 없습니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_13.png" alt=""><br/>
											<br/>
											- 다음단계를 클릭시 미리 편성된 좌석배치가 나오며 클릭하여 선택가능합니다.<br/>
											- 인원선택에서 선택한 인원만큼 선택해야 결제하기 버튼이 표시됩니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_14.png" alt=""><br/>
											<br/>
											- 결제하기 버튼을 누르면 결제화면으로 넘어가며 쿠폰을 사용할 수 있습니다.<br/>
 											- 쿠폰은 이전에 사용했다면 표시는 되지만 사용할 수 없습니다.<br/>
											<img class="borderLine borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_15.png" alt=""><br/>
											<br/>
											- 결제하기 버튼을 누르면 아임포트API를 이용한 가상결제가 동작됩니다.<br/>
 											- 카카오페이로 결제할 수 있도록 했으며 QR코드 혹은 카톡메시지로 결제 가능합니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_16.png" alt=""><br/>
											<br/>
											- 실제 카카오톡으로 온 메시지이며, 결제완료 시 돈이 실제로 빠져나갑니다.<br/>
 											- 가상결제이므로 일정시간 후에 자동 환불됩니다.<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_17.png" alt=""><br/>
											<br/>
											- 결제완료시 표시되는 페이지입니다.<br/>
											- 선택한 좌석수만큼 좌석의 티켓코드가 출력됩니다.<br/>
											(캡쳐파일이 꼬여서 영화결제내역이 서로 다른점이 있지만 실제 기능은 제대로 적용됩니다.)<br/>
											<img class="borderLine img-fluid rounded mb-5" src="${context}/resources/img/mainPF/mainpf_18.png" alt=""><br/>
											<br/>
											<b>여기까지 담당파트였습니다. 감사합니다.</b>
										</div>
										</span>
									</div>
								</div>
								<button class="btn btn-primary" href="#" data-dismiss="modal">
									<i class="fas fa-times fa-fw"></i>
									창 닫기
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Portfolio Modal 2 -->
	<div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-labelledby="portfolioModal2Label" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">
						<i class="fas fa-times"></i>
					</span>
				</button>
				<div class="modal-body text-center">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-8">
							
								<!-- Portfolio Modal - Title -->
								<h2 class="portfolio-modal-title text-secondary text-uppercase mb-0">Portfolio-Board</h2>
								<!-- Icon Divider -->
								<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
									<div class="divider-custom-line"></div>
								</div>
							 </div>
						 </div>
					 
						 <!-- Board -->
						 <div class="list">
							<input type="hidden" id="hd_searchDiv" value="">
							<input type="hidden" id="hd_searchWord" value="">
							
							<div class="searchBox">
								<select id="searchDiv">
									<option value="1" selected="selected">제목</option>
									<option value="2" >글쓴이</option>
									<option value="3" >내용</option>
									<option value="4" >구분</option>
								</select>
								<input type="text" id="searchWord" alt="검색어">
								<button id="searchBtn" class="btn btn-sm">검색</button>
								<button id="renewBtn" class="btn btn-sm">새로고침</button>
							</div>
							
							<br/>
							<table class="table table-bordered table-hover table-condensed" id="table_pf">
							 	<thead>
									<tr>
										<td class="re-col-xs-2 re-col-sm-2 re-col-md-1 re-col-lg-1 th-font">번호</td>
										<td class="hidden-xs hidden-sm re-col-md-1 re-col-lg-1 th-font">구분</td>
										<td class="re-col-xs-7 re-col-sm-5 re-col-md-5 re-col-lg-4 th-font">제목</td>
										<td class="re-col-xs-3 re-col-sm-3 re-col-md-2 re-col-lg-2 th-font">글쓴이</td>
										<td class="hidden-xs hidden-sm re-col-md-2 re-col-lg-2 th-font">작성일</td>
										<td class="hidden-xs re-col-sm-2 re-col-md-1 re-col-lg-1 th-font">조회</td>
									</tr>
							 	</thead>
							 	<tbody>
							 		 <td colspan="99">게시물이 존재하지 않습니다.</td>
							 	</tbody>
							</table>
						 	<button id="writeBtn" class="btn btn-sm">글쓰기</button>
						 	
							<!-- Paging -->
							<div id="main_pagination"></div>
						</div>
							 
						<!-- Board Contents -->
						<div class="contents">
							<div id="pfBoard-view">
								<div class="pfBoard-viewBtns">
									<button id="goIndex">목록</button>
									<div class='view-btnRight'>
										<button id="goPWConfirm">수정</button>
										<button id="godelete">삭제</button>
									</div>
									<br/>
								</div>
								<div class="pfBoard-viewTop">
								</div>
								<div class="pfBoard-viewTopInfo">
								</div>
								<div class="pfBoard-viewContents">
								</div>
								<div id="comment-view">
								<hr/>
								</div>
							</div>
							<div id="emptyCommentBox">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="writeDiv">
		<div>
			<button class="btn btn-md pfBoard-btn-cancel" onclick="javascript:closeWriteWindow(true);">취소</button>
			<button class="btn btn-md pfBoard-btn-submit" id="saveBtn">등록</button>
			<button class="btn btn-md pfBoard-btn-submit" id="updateBtn">수정</button>
		</div>
		<br/>
		<div>
			<label for="pfBoard-divNm">구분</label>
			<select id="pfBoard-divNm">
				<option value="1" selected="selected">일반</option>
				<option value="2">공지</option>
			</select>	
			<label for="pfBoard-userId">이름&nbsp;<input type="text" id="pfBoard-userId" alt="이름"></label>
			<label for="pfBoard-password">비밀번호&nbsp;<input type="text" id="pfBoard-password" alt="비밀번호"></label>
			<br/>
			<label for="pfBoard-title">제목&nbsp;<input class="pfBoard-title" type="text" id="pfBoard-title" alt="제목을 입력해주세요."></label>
		</div>
	</div>
	
	<!-- Footer -->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
	
				<!-- Footer Location -->
				<div class="col-lg-12 mb-12 mb-lg-12">
					<h4 class="text-uppercase mb-12">Contact</h4>
					<p class="lead mb-0">alhard01@gmail.com
						<br>010-6779-3570</p>
				</div>
	
			</div>
		</div>
	</footer>
	
	<!-- Copyright Section -->
	<section class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright © 2019 LeeGyuSeob All Rights Reserved.</small>
		</div>
	</section>
	
	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
			<i class="fa fa-chevron-up"></i>
		</a>
	</div>
	
	<!-- Bootstrap core JavaScript -->
	<script src="${context}/resources/js/jquery.min.js"></script>
	<script src="${context}/resources/js/bootstrap.bundle.js"></script>
	
	<!-- Plugin JavaScript -->
	<script src="${context}/resources/js/jquery.easing.1.3.js"></script>
	
	<!-- Contact Form JavaScript -->
	<script src="${context}/resources/js/jqBootstrapValidation.js"></script>
	<script src="${context}/resources/js/contact_me.js"></script>
	
	<!-- Custom scripts for this template -->
	<script src="${context}/resources/js/freelancer.js"></script>
	
	<!-- main scripts -->
	<script src="${context}/resources/js/pfmain.js"></script>
</body>
</html>
