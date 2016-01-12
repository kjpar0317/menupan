<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<title>Responsive Web Mobile</title>

	<!-- Set the viewport width to device width for mobile -->
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Included Bootstrap CSS Files -->
	<link rel="stylesheet" href="./css/bootstrap.min.css" />
	
	<!-- Css -->	
	<link rel="stylesheet" href="./css/style.css" />

</head>
<body id="start">

	<!-- This is the overlay DIV that is displayed while loading a new page -->
	<div id="loader"></div>

	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="hero-unit">
					<h1>Infinite Scroll</h1>
					<p class="">here is a simple example of a infinite scroll!</p>
				</div>
			</div>
		</div>

		<!-- This is the main container (#scroll-container) -->
		<div id="scroll-container" class="row">
			<div class="content">
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 1</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 2</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 3</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 4</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 5</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 6</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 7</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 8</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 9</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 10</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 11</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
				<div class="span3">
					<div class="item">
						<div class="img"></div>
						<div class="caption">
							<h4>Lorem Ipsum 12</h4>
							<p>dolore sit amen</p>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>

	<!-- These are all the links that can be loaded. -->
	<div id="pages">
		<a href="./index.html"></a>
		<a href="./page2.html"></a>
		<a href="./page3.html"></a>
		<a href="./page4.html"></a>
		<a href="./page5.html"></a>
		<a href="./page6.html"></a>
	</div>
	

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/infinite-scroll.js"></script>
</body>
</html>