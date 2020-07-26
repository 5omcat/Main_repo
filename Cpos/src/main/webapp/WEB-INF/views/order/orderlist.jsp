<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/resources/js/ksy/datepicker-ko.js"></script>
<script type="text/javascript">

$(function(){
    $("#date1").datepicker({
        showOn: "both",
        buttonImage: "/resources/img/ksy/calendar.png",
        buttonImageOnly: true,
        altFormat: "yy-mm-dd",
        altField: "#date1",
        changeYear: true,
        changeMonth: true
    });
    
    $("#date2").datepicker({
        showOn: "both",
        buttonImage: "/resources/img/ksy/calendar.png",
        buttonImageOnly: true,
        altField: "#date2",
        altFormat: "yy-mm-dd",
        changeYear: true,
        changeMonth: true
    });
    
    $("#ord_chkupBtn").click(function(e){
    	e.preventDefault();
    	let flag_hdate = $("#date1").val();
    	let hdateArr = flag_hdate.split('-');
    	flag_hdate = hdateArr[0] + hdateArr[1] + hdateArr[2];
    	let flag_tdate = $("#date2").val();
    	let tdateArr = flag_tdate.split('-');
    	flag_tdate = tdateArr[0] + tdateArr[1] + tdateArr[2];
    	let pageNum = 1;
    	/* let member_id = $('<c:out value="mvo.member_id"/>'); */
    	 let member_id = $("#hddn_mid").val();
    	//console.log(member_id);
    	//console.log(typeof(member_id));
    	//console.log("hdate:");
    	//console.log(typeof(flag_hdate));
    	location.href='/order/orderlist?member_id='+member_id+'&pageNum='+pageNum+'&flag_hdate='+flag_hdate+'&flag_tdate='+flag_tdate;
    	/* $.ajax({
			type : "get",
			url : "/order/orderlist",
			data : {
				flag_hdate : flag_hdate,
				flag_tdate : flag_tdate,
				member_id : member_id,
				pageNum : pageNum
			}
		}).done(function(result) {
			alert(result);
		}).fail(function(){
			alert("flag_hdate : "+flag_hdate);
			alert("flag_tdate : "+flag_tdate);
			alert("member_id : "+member_id);
			alert("pageNum : "+pageNum);
		}); */
    });
});

</script>

<section class="pricing py-5">
	<div class="container mt-3">
		<h2>발주 내역</h2>
		<p>
			공지 <span>: 다음 주부터 칸쵸 1+1 행사가 진행됩니다.</span>
		</p>
		<span>기간 조회 : </span><input type="text" name="date1" id="date1" size="12" /> ~ 
		<input type="text" name="date2" id="date2" size="12" /><button type="button" id="ord_chkupBtn">조회</button>
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
		<c:forEach items="${ordL}" var="ovo2" begin="1" end="1" step="1">
		<ul class="pagination">
			<c:if test="${pgvo.prev }">
				<li class="page-item"><a class="page-link"
					href="/order/orderlist?member_id=${ovo2.member_id }&flag_hdate=${ovo2.flag_hdate}&flag_tdate=${ovo2.flag_tdate}&pageNum=${pgvo.beginPagingNum-1}&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Prev</a></li>
			</c:if>

			<c:forEach begin="${pgvo.beginPagingNum }"
				end="${pgvo.endPagingNum }" var="i">
				<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : ''}">
					<a class="page-link"
					href="/order/orderlist?member_id=${ovo2.member_id}&flag_hdate=${ovo2.flag_hdate}&flag_tdate=${ovo2.flag_tdate}&pageNum=${i }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">${i}</a>
				</li>
			</c:forEach>

			<c:if test="${pgvo.next }">
				<li class="page-item"><a class="page-link"
					href="/order/orderlist?member_id=${ovo2.member_id}&flag_hdate=${ovo2.flag_hdate}&flag_tdate=${ovo2.flag_tdate}&pageNum=${pgvo.endPagingNum + 1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Next</a></li>
			</c:if>
		</ul>
		</c:forEach>
	</div>
</section>

<jsp:include page="../common/footer.jsp"></jsp:include>