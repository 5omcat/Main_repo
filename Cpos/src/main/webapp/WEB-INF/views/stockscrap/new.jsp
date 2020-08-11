<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<h3>재고 등록 페이지</h3>
<div class="px-5">
<form action="/stockscap/add">
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="바코드입력">
</div>
<div class="form-group">
<input type="text" id="pname" name="pname" placeholder="상품명입력">
</div>
<div class="form-group">
<input type="text" id="i_qnt" name="inv_qnt" placeholder="수량입력">
</div>
<div class="form-group">
  <label for="sel1">대분류:</label>
  <select class="btn btn-light text-dark" id="lcate">
    <option value="10">냉장</option>
    <option value="20">냉동</option>
    <option value="30">실온</option>
    <option value="40">생필품</option>
    <option value="50">기호품</option>
  </select>
  <label for="sel2" class="ml-3">중분류:</label>
  <select class="btn btn-outline-light text-dark scrap" id="mcate">
    <option class="btn-light text-dark" value="전체">전체</option>
  </select>
</div>
<div class="form-group">
<label>유통기한:</label>
<input type="date" id="expire_date" name="expire_date">
</div>
<div class="form-group">
<button type="submit" id="sbm">확인</button>
</div>
</form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>