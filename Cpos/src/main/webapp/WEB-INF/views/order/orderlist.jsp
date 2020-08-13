<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="/resources/css/ksy/order.css" rel="stylesheet">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/resources/js/ksy/datepicker-ko.js"></script>
<script type="text/javascript">

<c:set var="ses" value="${mid}" scope="session"/>

	$(function() {
		$("#date1").datepicker({
			showOn : "both",
			buttonImage : "/resources/img/ksy/calendar.png",
			buttonImageOnly : true,
			altFormat : "yy-mm-dd",
			altField : "#date1",
			changeYear : true,
			changeMonth : true
		});

		$("#date2").datepicker({
			showOn : "both",
			buttonImage : "/resources/img/ksy/calendar.png",
			buttonImageOnly : true,
			altField : "#date2",
			altFormat : "yy-mm-dd",
			changeYear : true,
			changeMonth : true
		});

		$("#ord_chkupBtn").click(
				function(e) {
					e.preventDefault();
					let flag_hdate = $("#date1").val();
					let hdateArr = flag_hdate.split('-');
					flag_hdate = hdateArr[0] + hdateArr[1] + hdateArr[2];
					let flag_tdate = $("#date2").val();
					let tdateArr = flag_tdate.split('-');
					flag_tdate = tdateArr[0] + tdateArr[1] + tdateArr[2];
					let pageNum = 1;
					let member_id = '<c:out value="${mvo.member_id}"/>';
					location.href = '/order/orderlist?member_id=' + member_id
							+ '&pageNum=' + pageNum + '&flag_hdate='
							+ flag_hdate + '&flag_tdate=' + flag_tdate;
				});
	});
</script>

<section class="pricing py-5">
	<div class="container mt-3">
		<h2>발주 내역</h2>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">발주</button>
		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div style="overflow-x: initial !important;"
				class="modal-dialog modal-xl modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">발주 등록</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group">
							<label for="largeCtg">대분류:</label> <select class="form-control"
								id="largeCtg" name="largeCtg">
								<option value="-1" selected>선택</option>
								<option value="10">냉장</option>
								<option value="20">냉동</option>
								<option value="30">실온</option>
								<option value="40">생필품</option>
								<option value="50">기호품</option>
							</select>
						</div>
						<!-- 스트립트 임시 -->
						<div class="form-group" id="md_wdiv">
							<label for="mediumCtg">중분류:</label> <select class="form-control"
								id="mediumCtg" name="mediumCtg">
								<option value="-1" selected>선택</option>
							</select>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="largeCtg">상품 리스트:</label>
							<div class="scrollHList"></div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="largeCtg">선택된 상품:</label>
							<div class="SelectList"></div>
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" id="ord_insert_btn" class="btn btn-warning">등록</button>
						<button type="button" id="ord_cancel_btn" class="btn btn-danger"
							data-dismiss="modal">취소</button>
					</div>

				</div>
			</div>
		</div>
		<p>
			공지 <span>: 다음 주부터 칸쵸 1+1 행사가 진행됩니다.</span>
		</p>
		<span>기간 조회 : </span><input type="text" name="date1" id="date1"
			size="12" /> ~ <input type="text" name="date2" id="date2" size="12" />
		<button type="button" id="ord_chkupBtn">조회</button>
		<c:choose>
			<c:when test="${ordWL ne null && ordWL.size() != 0 }">
				<c:forEach items="${ordWL}" var="ovol">
					<div class="media border p-3">
						<img src="/resources/img/order_picon1.png" alt="상자이미지"
							class="mr-3 mt-3 rounded-circle"
							style="width: 60px; margin-top: auto !important; margin-bottom: auto !important;">
						<div class="media-body">
								<h4>
									<c:forEach items="${ovol}" var="ovo" begin="0" end="0">
									김 점장 <small><i>Ordered on ${ovo.order_sdate}</i></small>
								</h4>
									</c:forEach>
						<c:forEach items="${ovol}" var="ovo">
						<span>${ovo.pname} : </span>
						<span>${ovo.order_qnt}개/</span>

						</c:forEach>
						</div>
						<div>
						<button type="button" class="btn btn-outline-light text-dark">
						<c:set var="stt" value="${ovol[0].status}"/>
						<c:choose>
							<c:when test="${stt == 0 }">
							미수령
							</c:when>
						</c:choose>
						</button>
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
				href="/order/orderlist?member_id=${infOvo.member_id }&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${pgvo.beginPagingNum-1}}">Prev</a></li>
		</c:if>

		<c:forEach begin="${pgvo.beginPagingNum }" end="${pgvo.endPagingNum }"
			var="i">
			<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : ''}">
				<a class="page-link"
				href="/order/orderlist?member_id=${infOvo.member_id}&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${i }">${i}</a>
			</li>
		</c:forEach>

		<c:if test="${pgvo.next }">
			<li class="page-item"><a class="page-link"
				href="/order/orderlist?member_id=${infOvo.member_id}&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${pgvo.endPagingNum + 1 }">Next</a></li>
		</c:if>
	</ul>
	</div>
</section>
<script>
	$(function() {
		$('#md_wdiv').hide();
		
		$('#largeCtg').change(function() {
			let large = "";
			large = $(this).val();
			if (large != '-1') {
				$.getJSON("/order/getMCtgs/"+large, function(mCtgs){
					$('#mediumCtg option:first-child').nextAll("option").remove();
					for (let md of mCtgs) {
						let optionTag = '<option value="'+md.category+'">';
						optionTag += ''+md.medium+'</option>';
						$("#mediumCtg").append(optionTag);
					}
				});
				$('#md_wdiv').show();
			}
		});
		
		var aJsonArray = new Array();
		var selectJsonArray = new Array();
		var hJsn = new Object();
		var tempObj = new Object();
		
		$('#mediumCtg').change(function() {
			let large = $('#largeCtg').val();
			let category = $(this).val();
			if (large!='-1'&&category!='-1') {			
				$.getJSON("/order/getHList/"+category, function(hList){
					for (let i = 0; i < hList.length; i++) {
						tempObj = hList[i];
						delete tempObj.category;
						delete tempObj.discount_rate;
						delete tempObj.get_price;
						delete tempObj.sell_price;
						aJsonArray.push(tempObj);
					}
					$('.scrollHList').empty();
 					for (let i = 0; i < aJsonArray.length; i++) {
						let btnTag = '<button type="button" class="btn btn-outline-primary hgetter" id="hl'+i+'">'+hList[i].pname+'</button>';
						$(".scrollHList").append(btnTag);
					}
				});
			}else{
				return 'false';
			}
		});
		
		var flag_ord_jsnArr = new Array();
		
		$(document).on("click",
		".hgetter",
		function(e){
		e.preventDefault();
		let hlnum = ""; 
		hlnum =	$(this).attr('id');
		hlnum = hlnum.substring(2,hlnum.length);
		hJsn = aJsonArray[hlnum];
				let selectItemTags = '<button type="button" class="btn btn-secondary pnmNest" id="'+hlnum+'">'+hJsn.pname+'</button>'
				+'<button type="button" class="btn btn-secondary minus_btn">-</button>'
				+'<span>1</span>'	
				+'<button type="button" class="btn btn-secondary plus_btn">+</button>';				
				+'<input type="hidden" style="width: 50px;" value="'+hJsn.barcode+'"/>'
				$(".SelectList").append(selectItemTags);
				$("#"+hlnum+"").attr('value',hJsn.pname);
				flag_ord_jsnArr.push(hlnum);
		});
		
		$(document).on("click",
				".minus_btn",
				function(e){
			e.preventDefault();
			if($(this).next('span').html()==1){
				alert("더이상 줄일 수 없습니다.");				
			}else{
				$(this).next('span').html($(this).next('span').html()-1);
			}
		});
		
		$(document).on("click",
				".plus_btn",
				function(e){
			e.preventDefault();
				$(this).prev('span').html(Number($(this).prev('span').html())+1);
		});
		
		$(document).on("focus",
				".plus_btn",
				function(e){
			e.preventDefault();
				$(this).prev('span').html(Number($(this).prev('span').html())+1);
		});

		
		$("#ord_insert_btn").on("click",function(e){
			e.preventDefault();
			if (flag_ord_jsnArr.length>0) {
				let wrpno = -1;
				$.ajax({
					url:"/order/getWrpno",
					type:"GET",
					data:{wrap_no:wrpno}
				}).done(function(result){
					wrpno = result;
					for (let i = 0; i < flag_ord_jsnArr.length; i++) {
					tempObj = aJsonArray[flag_ord_jsnArr[i]];
					let pname = $(".SelectList").find("#"+flag_ord_jsnArr[i]+"").val();
					if (tempObj.pname==pname) {
						tempObj.order_qnt = $(".SelectList").find("#"+flag_ord_jsnArr[i]+"").nextAll("span").html();
						tempObj.member_id = '<c:out value="${mvo.member_id}"/>';
						tempObj.wrap_no = wrpno;
						selectJsonArray.push(tempObj);
					}
					}
					console.log(selectJsonArray);
				
					$.ajax({
						url:"/order/registOrder",
						type:"POST",
						data:JSON.stringify(selectJsonArray),
						contentType: "application/json; charset=utf-8;"
					}).done(function(result){
						alert("등록이 완료됐습니다.");
						location.reload();
				}).fail(function(result){
					alert("발주등록 실패. 관리자에게 문의하세요");
				});
				
				
				
				
				}).fail(function(result){
					alert("wrap_no 가져오기 실패");
				});

				
			
			}else{
				alert("orderlist_258 error. 관리자에 문의하세요.");
				return 'false';
			}
	});

		
	});
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>