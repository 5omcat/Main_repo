<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<section class="py-5">
  <div class="container" id="modifyform">
    <form action="/head/pmodify" method="post">
    <input type="hidden" name="pageNum" value="${cri.pageNum }">
    <input type="hidden" name="amount" value="${cri.amount }">    
     
      <div class="form-group">
        <label for="pname">상품명:</label> 
        <input type="text" class="form-control " value="${hvo.pname }" name="pname">
      </div>
      <div class="form-group">
        <label for="barcode">바코드:</label> 
        <input type="text" class="form-control " value="${hvo.barcode }" name="barcode" id="barcode" readonly>
      </div>
      <div class="form-group">
        <label for="category">카테고리</label>
        <input type="text" class="from-control " value="${hvo.category }" name="category" id="category" readonly>
      </div>
      <div class="form-group">
        <label for="expire_term">유통기간:</label>
        <input type="number" class="from-control " value="${hvo.expire_term }" name="expire_term">
      </div>
      <div class="form-group">
        <label for="get_price">도매가:</label>
        <input type="number" class="from-control " value="${hvo.get_price }" name="get_price">
      </div>
      <div class="form-group">
        <label for="sell_price">판매가:</label>
        <input type="number" class="from-control " value="${hvo.sell_price }" name="sell_price">
      </div>
      <div class="form-group">
        <label for="discount_rate">할인률:</label>
        <input type="number" class="from-control " value="${hvo.discount_rate }" name="discount_rate">
      </div>
      <div class="form-group">
        <label for="discount_rate">상태:</label>
        <input type="number" class="from-control " value="${hvo.status }" name="discount_rate">
      </div>
      <button type="submit" class="btn btn-dark" id="modBtn">수정</button> 
      <a class="btn btn-dark" href="/head/plist">취소</a>
    </form>
    </div>
  
</section>


