<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
 

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Examples for bootstrap-slider plugin">
    <meta name="author" content="">

    <title>Slider for Bootstrap Examples Page</title>

    <!-- core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-slider.min.css" rel="stylesheet">

   

    <style type='text/css'>
		#BC .slider-selection {
			background: #8283FF;
		}
		#BC .slider-handle {
			border-bottom-color: blue;
		}
    </style>
	<script type='text/javascript' src="/js/modernizr.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="examples">

      	<div class='slider-example'>
      		<h3>Example 6:</h3>
      		<p>Able to bind to 'slide' JQuery event on slider, which is triggered whenever the slider is used.</p>
      		<div class="well">
      		<!-- 
      			<input id="ex6" type="text" data-slider-min="-5" data-slider-max="20" data-slider-step="1" data-slider-value="3"/>
      		-->
	            <input type="text" id="ex6" value="" data-slider-min="0" data-slider-max="100" data-slider-step="5" data-slider-value="50" data-slider-id="BC"   />
      			<span id="ex6CurrentSliderValLabel">Current Slider Value: <span id="ex6SliderVal">50</span></span>
      		</div>
      	</div>



	  </div> <!-- /examples -->
    </div> <!-- /container -->


    <!-- core JavaScript
    ================================================== -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script type='text/javascript' src="/js/bootstrap-slider.min.js"></script>
    <script type='text/javascript'>
    	$(document).ready(function() {
			/* Example 6 */
			$("#ex6").slider();
			$("#ex6").on('slide', function(slideEvt) {

				if(slideEvt.value >=0 && slideEvt.value < 20) {
					$("#BC .slider-selection").css('background', 'rgb(255,0,0)');
				} else if(slideEvt.value >= 20 && slideEvt.value < 40) {
					$("#BC .slider-selection").css('background', 'rgb(200,200,0)');
				} else if(slideEvt.value >= 40 && slideEvt.value < 80) {
					$("#BC .slider-selection").css('background', 'rgb(0,255,0)');
				} else if(slideEvt.value >= 80 && slideEvt.value < 100) {
					$("#BC .slider-selection").css('background', 'rgb(0,0,255)');

				}

				
				$("#ex6SliderVal").text(slideEvt.value);
			});

			
		});
    </script>
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>


