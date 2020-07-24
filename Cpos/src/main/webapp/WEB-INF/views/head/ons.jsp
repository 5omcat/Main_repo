<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/gyj/yj.css" rel="stylesheet">
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<section class="pricing py-5">
  <div class="container">
    <div class="row custm_a1">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-muted text-uppercase text-center">가맹점관리</h5>
            <h6 class="card-price text-center">Store</h6>
            <hr>
            <ul class="fa-ul">
              <li><span class="fa-li"><i class="fas fa-check"></i></span>가맹점리스트</li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>가맹점등록</li>              
            </ul>
            <a href="/head/mlist" class="btn btn-block btn-success text-uppercase">GO</a>
          </div>
        </div>
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-muted text-uppercase text-center">상품관리</h5>
            <h6 class="card-price text-center">Product</h6>
            <hr>
            <ul class="fa-ul">
              <li><span class="fa-li"><i class="fas fa-check"></i></span>상품리스트</li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>상품 등록</li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>상품 수정</li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>상픔 삭제</li>
            </ul>
            <a href="/head/plist" class="btn btn-block btn-success text-uppercase">GO</a>
          </div>
        </div>
      </div>
    </div>
</section>
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>