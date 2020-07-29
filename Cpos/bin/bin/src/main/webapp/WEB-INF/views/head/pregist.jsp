<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>
<section class="py-5">
  <div class="container">
    <h1>상품 등록</h1>
    <form action="/head/plist" method="post">
      <div class="form-group">
        <label for="pname">상품명:</label> 
        <input type="text" class="form-control" name="pname">
      </div>
      <div class="form-group">
        <label for="barcode">바코드:</label> 
        <input type="text" class="form-control" name="barcode" id="barcode">
      </div>
      <button type="button" id="bBtn">바코드생성</button>
      <div class="form-group">
        <label for="large">대분류</label>
        <input type="text" class="from-control" name="large" id="large">
      </div>
       <div class="form-group">
        <label for="medium">소분류</label>
        <input type="text" class="from-control" name="medium" id="medium">
      </div> 
      <div class="form-group">
        <label for="expire_term">유통기간</label>
        <input type="number" class="from-control" name="expire_term">
      </div>
      <div class="form-group">
        <label for="get_price">도매가</label>
        <input type="number" class="from-control" name="get_price">
      </div>
      <div class="form-group">
        <label for="sell_price">판매가</label>
        <input type="number" class="from-control" name="sell_price">
      </div>
      <div class="form-group">
        <label for="discount_rate">할인률</label>
        <input type="number" class="from-control" name="discount_rate">
      </div>
      <button type="submit" class="btn btn-dark">등록</button>       
    </form>
  </div>
</section>

<jsp:include page="../common/footer.jsp"></jsp:include>