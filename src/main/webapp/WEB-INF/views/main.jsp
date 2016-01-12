<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://52.68.249.96/carte/img/ricon.ico" type="image/ico">
	<title>iCarte</title>
</head>

<body>
    <!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
		<div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="carte.php">iCarte</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="carte.php">Home</a>
                    </li>
                    <li>
                        <a href="favorites.php">Favorites</a>
                    </li>
                    <li>
                        <a href="map.php">Map</a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
	</nav>

    <!-- Header -->
    <div class="intro-header">
    	<div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>예마당 구내식당</h1>
                        <div id="message"><h3>내 몸에 좋은 건강한 식단을 제공합니다.</h3></div>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                        	<li>
                                <a href="https://www.facebook.com/profile.php?id=100010751708406" class="btn btn-default btn-lg"><i class="fa fa-facebook fa-fw"></i> <span class="network-name">fackbook</span></a>
                            </li>
                            <li>
                                <a href="https://twitter.com" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- /.container -->
    </div><!-- /.intro-header -->
    
	<hr class="intro-divider">
		<c:forEach var="map" items="${list}" varStatus="status">
			<c:if test="${ map.day == today }"> 
			 
				<c:set var="string1" value="${fn:substring(map.day, 0, 4)}" />
				<c:set var="string2" value="${fn:substring(map.day, 5, 7)}" />
				<c:set var="string3" value="${fn:substring(map.day, 8, 10)}" />
				
				<div class="content-section-c">
			        <div class="container">
			            <div class="row">
			                <div class="col-lg-5 col-sm-6">
			                    <hr class="section-heading-spacer-c">
			                    <div class="clearfix"></div>
			                    <h2 class="section-heading">${string1}년${string2}월${string3}일</h2>
			                    <hr class="section-heading-spacer-c">
			                </div>;
			            </div>
			        </div><!-- /.container -->
			    </div><!-- /.content-section-a -->
			    
				    <div class="content-section-a">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-5 col-sm-6">
				                    <hr class="section-heading-spacer">
				                    <div class="clearfix"></div>
				                    <h2 class="section-heading">테마가 있는 중식 A</h2>
				                    <p class="lead">${map.lunch_a}</p>
				                    <p class="lead">${map.lunch_a_dir}</p>
				                </div>
				                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
				                    <img class="img-responsive" src="/carte/img/food01.png" alt="">
				                </div>
				            </div>
				        </div><!-- /.container -->
				    </div><!-- /.content-section-a -->
				    
				    <div class="content-section-b">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
				                    <hr class="section-heading-spacer">
				                    <div class="clearfix"></div>
				                    <h2 class="section-heading">테마가 있는 중식 B</h2>
				                    <p class="lead">${map.lunch_b}</p>
				                    <p class="lead">${map.lunch_b_dir}</p>
				                </div>
				                <div class="col-lg-5 col-sm-pull-6  col-sm-6">
				                    <img class="img-responsive" src="/carte/img/food02.png" alt="">
				                </div>
				            </div>
				        </div><!-- /.container -->
				    </div><!-- /.content-section-b -->
				
					<div class="content-section-a">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-5 col-sm-6">
				                    <hr class="section-heading-spacer">
				                    <div class="clearfix"></div>
				                    <h2 class="section-heading">활기찬 조식</h2>
				                    <p class="lead">${map.breakfast}</p>
				                    <p class="lead">${map.breakfast_dir}</p>
				                </div>
				                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
				                    <img class="img-responsive" src="/carte/img/food03.png" alt="">
				                </div>
				            </div>
				        </div><!-- /.container -->
				    </div><!-- /.content-section-a -->
	    
					<div class="content-section-b">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
				                    <hr class="section-heading-spacer">
				                    <div class="clearfix"></div>
				                    <h2 class="section-heading">알찬 석식</h2>
				                    <p class="lead">${map.dinner}</p>
				                    <p class="lead">${map.dinner_dir}</p>
				                </div>
				                <div class="col-lg-5 col-sm-pull-6  col-sm-6">
				                    <img class="img-responsive" src="/carte/img/food04.png" alt="">
				                </div>
				            </div>
				        </div><!-- /.container -->
			    	</div><!-- /.content-section-b -->
					<div class="banner">
				        <div class="container">
				            <div class="row">
				                <div class="col-lg-6">
				                    <h3>원산지:</h3>
				                    <p class="lead">쇠고기(호주산) 돼지고기(국내산) 닭고기(국내산) 배추김치(배추:국내산, 고춧가루:국내산) 쌀(국내산), 가공류(게시메뉴참고)</p>
				                    <h3>식사시간:</h3>
				                    <p class="lead">조식 : 8:00~9:00 / 중식 : 11:30~13:30 / 석식 : 17:30~19:30</p>
				                </div>
				            </div>
				        </div><!-- /.container -->
					</div><!-- /.banner -->
			</c:if>
			<c:if test="${ map.day != today }"> 
				<div class="container">
					<div class="row">
			        	<div class="caption">
							<img src="/img/holiday.png" alt="Responsive image" class="img-responsive">
			      		</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

<%@ include file="/common/footer.jsp" %>

</body>

</html>