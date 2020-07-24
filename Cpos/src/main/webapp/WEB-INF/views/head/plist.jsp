<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/header.jsp"></jsp:include>
<section class="py-5">
	<div class="container col-sm-3">
		<div>
			<c:choose>
				<c:when test="${pList ne null && pList.size() !=0 }">
					<c:forEach items="${pList }" var="pvo">
						<div class="card bg-success text-white">
							<div class="card-body">바코드 : ${hvo.barcode }</div>
					   	<div class="card-body">상품명 : ${hvo.pname }</div>
							<div class="card-body">카테고리 : ${hvo.category }</div>
							<a href="/head/pregist" class="btn btn-success">상품등록</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div>등록된 상품이 없쟈나쟈나</div>
					<a href="/head/pregist" class="btn btn-success">상품등록</a>
				</c:otherwise>
			</c:choose>
			<c:if test="sesInfo.id ne null">
				<div>
					<a href="/head/pregist" class="btn btn-success">상품등록</a>
				</div>
			</c:if>
		</div>
		<div>
			<ul class="pagination">
				<c:if test="${pgvo.prev }">
					<li class="page-item"><a class="page-link"
						href="/head/plist?pageNum=${pgvo.beginPagingNum - 1 }&amount=${pgvo.cri.amount }">Prev</a></li>
				</c:if>
				<c:forEach begin="${pgvo.beginPagingNum }"
					end="${pgvo.endPagingNum }" var="i">
					<li class="page-item active"><a class="page-link"
						href="/head/plist?pageNum=${i }&amount=${pgvo.cri.amount }">${i }</a></li>
				</c:forEach>
				<c:if test="">
					<li class="page-item"><a class="page-link"
						href="/head/plist?pageNum=${pgvo.endPagingNum + 1 }&amount=${pgvo.cri.amount}">Next</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</section>


<jsp:include page="../common/footer.jsp"></jsp:include>

