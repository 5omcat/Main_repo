<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<link href="/resources/css/ksy/sy.css" rel="stylesheet">

<title>재고/폐기</title>

<section class="pricing py-5">
  <div class="container">
    <div class="row custm_a1">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-muted text-uppercase text-center">재고관리</h5>
            <h6 class="card-price text-center text-info">Stock</h6>
            <hr>
            <ul class="fa-ul">
              <li><span class="fa-li"><i class="fas fa-check"></i></span>점포 재고 현황 파악 </li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>점포 재고 수량 확인 </li>
            </ul>
            <hr>
            <a href="/stockscrap/inventory" class="btn btn-block btn-info text-uppercase">GO</a>
          </div>
        </div>
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-muted text-uppercase text-center">폐기관리</h5>
            <h6 class="card-price text-center">Scrap</h6>
            <hr>
            <ul class="fa-ul">
              <li><span class="fa-li"><i class="fas fa-check"></i></span>점포 폐기 대상 파악 <i class="fas fa-check"></i></li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>점포 재고 폐기 처분 <i class="fas fa-check"></i></li>
            </ul>
            <hr>
            <a href="/stockscrap/exscrap" class="btn btn-block btn-dark text-uppercase">GO</a>
          </div>
        </div>
      </div>
    </div>
</section>
<jsp:include page="../common/footer.jsp"/>