<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<section class="py-5">

	<div class="dropdown ml-5">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">대분류</button>
		<div class="dropdown-menu">
		
			<c:forEach items="${lList }" var="lvo">
				<a class="dropdown-item" href="/paysold/lmlist?large=${lvo.large }">${lvo.large }</a>
			</c:forEach>
		</div>
	</div>

	<div class="dropdown ml-5">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">중분류</button>
		<div class="dropdown-menu">
			<c:forEach items="${lmList }" var="lmvo">
				<a class="dropdown-item"
					href="/paysold/lmilist?large=${lmvo.large }&medium=${lmvo.medium}">${lmvo.medium }</a>
			</c:forEach>
		</div>
	</div>

	<div class="container">

		<table class="table">
			<tr class="table table-info">
				<th>상품명</th>
				<th>바코드</th>
				<th>판매가</th>
			</tr>
		</table>
		
		 <table class="table table-hover">
      <c:forEach items="${iList }" var="ivo">
        <tr class="i">
          <td>${ivo.pname }</td>
          <td>${ivo.barcode }</td>
          <td>${ivo.sell_price }</td>
        </tr>
      </c:forEach>
    </table>
    
		 <table class="table table-hover">
      <c:forEach items="${liList }" var="livo">
        <tr class="i">
          <td>${livo.pname }</td>
          <td>${livo.barcode }</td>
          <td>${livo.sell_price }</td>
        </tr>
      </c:forEach>
    </table>

		<table class="table table-hover">
			<c:forEach items="${lmiList }" var="lmivo">
				<tr class="i">
					<td>${lmivo.pname }</td>
					<td>${lmivo.barcode }</td>
					<td>${lmivo.sell_price }</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	
	<div  id="shoppinglist" >
	 <ul>
	   <li></li>
	 </ul>
	</div>
	
	

	<div class="mr-5" align="right">
		<button class="btn btn-success pull-right" data-toggle="modal"
			data-target="#myModal">현금</button>
		<button class="btn btn-info  pull-right" data-toggle="modal"
			data-target="#myModal">카드</button>
	</div>

	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">결제</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">결제내용</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="modOkBtn" class="btn btn-primary">확인</button>
					<button type="button" id="modOkBtn" class="btn btn-danger"
						data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>

</section>

<script>
	$(function() {
		  $(document).on("click", ".i", function(){
		    $(this).clone().appendTo("#shoppinglist");
		  });
	});
	

	
	
</script>

<jsp:include page="../common/footer.jsp"></jsp:include>

