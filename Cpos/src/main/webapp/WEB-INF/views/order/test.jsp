<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>CPOS</title>

<!-- Bootstrap core CSS -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/common.js"></script>

<!-- Custom styles for this template -->
<link href="/resources/css/custom.css" rel="stylesheet">
<style type="text/css">
div.scrollHList {
	background-color: #333;
	overflow: auto;
	white-space: nowrap;
}

div.scrollHList span {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

div.scrollHList span:hover {
	background-color: #ff7;
}
</style>
<body>
	<div class="form-group">
		<input type="hidden" value="${mid}" id="hddn_mid" />
	</div>

	<section class="pricing py-5">
		<div class="container mt-3">
			<div class="form-group">
			
				<label for="largeCtg">상품 리스트:</label>
				<div class="scrollHList">
					<span>
						Home
						<button type="button" class="btn btn-outline-primary">-</button>
						<input style="width: 50px;" type="number" />
						<button type="button" class="btn btn-outline-primary">+</button>
					</span>
					<span>
						<a href="#home">Home</a>
						<button type="button" class="btn btn-outline-primary">-</button>
						<input style="width: 50px;" type="number" />
						<button type="button" class="btn btn-outline-primary">+</button>
					</span>
					<span>
						<a href="#home">Home</a>
						<button type="button" class="btn btn-outline-primary">-</button>
						<input style="width: 50px;" type="number" />
						<button type="button" class="btn btn-outline-primary">+</button>
					</span>
					<span>
						<a href="#home">Home</a>
						<button type="button" class="btn btn-outline-primary">-</button>
						<input style="width: 50px;" type="number" />
						<button type="button" class="btn btn-outline-primary">+</button>
					</span>
				</div>
			</div>
		</div>
	</section>
</body>
</html>