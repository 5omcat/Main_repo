<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<h3>재고 등록 페이지</h3>
<form action="/stockscap/add">
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="바코드입력">
</div>
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="상품명입력">
</div>
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="수량입력">
</div>
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="카테고리입력">
</div>
<div class="form-group">
<input type="text" id="barcode" name="barcode" placeholder="유통기한입력">
</div>
</form>

<jsp:include page="../common/footer.jsp"></jsp:include>