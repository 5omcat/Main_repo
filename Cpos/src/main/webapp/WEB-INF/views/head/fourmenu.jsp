<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<section class="pricing py-5" id="fourmenusec">
	<div class="container" id="fourmenu">
		<div class="row" id="custm_01">
			<div class="card">
				<div class="card-body">
					<h1 class="card-title text-muted text-uppercase text-center"><a href="/pay/payment">결재</a></h1>
				</div>
			</div>
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-muted text-uppercase text-center"><a href="/stockscrap/ssmenu">재고/폐기관리</a></h5>
				</div>
			</div>
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-muted text-uppercase text-center"><a href="/receipt/soldlist">조회</a></h5>
				</div>
			</div>
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-muted text-uppercase text-center"><a href="/order/ons">발주/통계관리</a></h5>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>