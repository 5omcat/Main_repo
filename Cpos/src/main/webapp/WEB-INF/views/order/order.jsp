<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<section class="py-5">
	<div class="container">
		<div class="form-group">
			<label for="largeCtg">상품 대분류:</label> <select class="form-control"
				id="LgCtgSlc" name="largeCtg">
				<option selected>선택</option>
				<option value="냉장">냉장</option>
				<option value="냉동">냉동</option>
				<option value="실온">실온</option>
				<option value="생필품">생필품</option>
				<option value="기호품">기호품</option>
			</select>
		</div>

		<div class="form-group">
			<label for="sel1">상품 중분류:</label> <select class="form-control" id="MdCtgSlc"
				name="mediumCtg">
				<!-- <option selected>선택</option> //쿼리 동적 insert hidden > open when
					large select //+DB category insert Dummy in// barcode hddn  상품 name.
					<option value=""></option> -->
			</select>
		</div>

		<form action="/order/order" method="post">
		 <!-- span tag with index pname - INPUT NUM TAG+ BTN  -->
		 
		<button type="submit" class="btn btn-primary">발주 등록</button>
		<button type="button" class="btn btn-danger"
			onclick="location.repace('order.jsp')">취소</button>
		</form>
		
	</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>