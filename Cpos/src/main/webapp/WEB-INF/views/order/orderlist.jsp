<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<section class="pricing py-5">
	<div class="container mt-3">
		<h2>발주 내역</h2>
		<p>
			공지 <span>: 다음 주부터 칸쵸 1+1 행사가 진행됩니다.</span>
		</p>
		<c:choose>
			<c:when test="${ordL ne null && ordL.size() != 0 }">
				<c:forEach items="${ordL}" var="ovo">
					<div class="media border p-3">
						<img src="/resources/img/order_picon1.png" alt="John Doe"
							class="mr-3 mt-3 rounded-circle"
							style="width: 60px; margin-top: auto !important; margin-bottom: auto !important;">
						<div class="media-body">
							<h4>
								김 점장 <small><i>Posted on ${ovo.order_sdate}</i></small>
							</h4>
							<p>${ovo.pname}</p>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="6"><h3 class="text-center">조회된 발주내역이 없습니다.</h3></th>
				</tr>
			</c:otherwise>
		</c:choose>
		<ul class="pagination">
			<c:if test="${pgvo.prev }">
				<li class="page-item"><a class="page-link"
					href="/order/orderlist?pageNum=${pgvo.beginPagingNum-1}&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Prev</a></li>
			</c:if>

			<c:forEach begin="${pgvo.beginPagingNum }"
				end="${pgvo.endPagingNum }" var="i">
				<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : ''}">
					<a class="page-link"
					href="/order/orderlist?pageNum=${i }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">${i}</a>
				</li>
			</c:forEach>

			<c:if test="${pgvo.next }">
				<li class="page-item"><a class="page-link"
					href="/order/orderlist?pageNum=${pgvo.endPagingNum + 1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Next</a></li>
			</c:if>

		</ul>
	</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>