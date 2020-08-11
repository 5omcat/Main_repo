<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<section class="py-5">
	<div class="container">
  <h2>상품상세내용</h2>
  <ul class="list-group">    
    <li class="list-group-item list-group-item-primary" name="barcode" >바코드 : ${hvo.barcode }</li>
    <li class="list-group-item list-group-item-primary" name="pname">상품명 : ${hvo.pname }</li>
    <li class="list-group-item list-group-item-primary" name="category">카테고리 : ${hvo.category }</li>
    <li class="list-group-item list-group-item-primary" name="expire_term">유통기간 : ${hvo.expire_term }</li>
    <li class="list-group-item list-group-item-primary" name="get_price">도매가 : ${hvo.get_price }</li>
    <li class="list-group-item list-group-item-primary" name="sell_price">판매가 : ${hvo.sell_price }</li>
    <li class="list-group-item list-group-item-primary" name="discount_rate">할인률 : ${hvo.discount_rate }</li> 
    <li class="list-group-item list-group-item-primary" name="discount_rate">상태 : ${hvo.status }</li>    
  </ul>
  <div class="btn-group">
			  <a href="/head/plist" class="btn btn-primary">리스트로</a>
 	</div>    
</div>
</section>
