<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
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

		function setDPcker(flagDate, inputTag){
			let date = "";
			if (flagDate=="flag_hdate") {
				date = '<c:out value="${infOvo.flag_hdate}"/>';
			}else if(flagDate=="flag_tdate"){
				date = '<c:out value="${infOvo.flag_tdate}"/>';
			}
			let year = date.slice(0,4);
			let month = date.slice(4,6);
			let day = date.slice(6,8);
			date = year.concat("-",month,"-",day);
			$('#'+inputTag+'').val(date);
		}

		setDPcker("flag_hdate","date1");
		setDPcker("flag_tdate","date2");
		
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
		<h2>발주 리스트</h2>
		<c:if test="${mvo ne null}">
		<button type="button" class="btn btn-primary ordBtn" data-toggle="modal"
			data-target=".ordmodal">발주</button>
		</c:if>
		<!-- The Modal -->
		<div class="modal fade ordmodal">
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
							<div class="plistSlot"></div>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="largeCtg">선택된 상품:</label>
							<div class="selectedSlot"></div>
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" id="ord_insert_btn" class="btn btn-warning">등록</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
					</div>

				</div>
			</div>
		</div>
		
		
		<!-- The Modal2 -->
		<div class="modal fade" id="ordStatModal">
			<div style="overflow-x: initial !important;"
				class="modal-dialog modal-xl modal-dialog-centered">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">발주 상태 변경</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-header">
						<h4 class="modal-title">=======발주 내역=======</h4>
					</div>
					<!-- Modal body -->
					<div class="modal-body">
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" id="ord_done_btn" class="btn btn-warning">수령완료</button>
						<button type="button" id="ord_cancel_btn" class="btn btn-danger">발주취소</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<p>
			공지 <span>: 다음 주부터 칸쵸 1+1 행사가 진행됩니다.</span>
		</p>
		<span>기간 조회 : </span><input type="text" name="date1" id="date1"
			size="12"/> ~ <input type="text" name="date2" id="date2" size="12"/>
		<button type="button" id="ord_chkupBtn">조회</button>
		<c:choose>
			<c:when test="${ordWL ne null && ordWL.size() != 0 }">
				<c:forEach items="${ordWL}" var="ovol">
					<div class="media border p-3 ordBorder">
						<c:forEach items="${ovol}" var="ovo1" begin="0" end="0">
						
						<img src="/resources/img/<c:if test="${ovo1.status==0}">
						box_packaged.png</c:if>
						<c:if test="${ovo1.status==1}">box_opened.png</c:if>
						<c:if test="${ovo1.status==2}">box_canceled.png</c:if>" 
							alt="발주 상태 이미지"
							class="mr-3 mt-3 rounded-circle"
							style="width: 60px; margin-top: auto !important; margin-bottom: auto !important;">
						<div class="media-body">
								<h4>
									김 점장 <small><i>Ordered on ${ovo1.order_sdate}</i></small>
								</h4>
								
						<c:forEach items="${ovol}" var="ovo2">
						<span>${ovo2.pname} : </span>
						<span>${ovo2.order_qnt}개/</span>
						</c:forEach>
						</div>
						<div>
						<button id="ord_recivChk_btn" type="button" class="btn 
						<c:choose>
							<c:when test="${ovo1.status==0}">
							btn-outline-primary 
							</c:when>
							<c:when test="${ovo1.status==1}">
							btn-outline-success 
							</c:when>
							<c:when test="${ovo1.status==2}">
							btn-outline-dark 
							</c:when>
						</c:choose>
						text-dark" 
						 data-toggle="modal" data-target="#ordStatModal" data-stt="${ovo1.status}" data-wrpno="${ovo1.wrap_no}">
						<c:choose>
							<c:when test="${ovo1.status==0}">
							미수령
							</c:when>
							<c:when test="${ovo1.status==1}">
							수령완료
							</c:when>
							<c:when test="${ovo1.status==2}">
							발주취소
							</c:when>
						</c:choose>
						</button>
						</div>
						
						</c:forEach>
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
				href="/order/orderlist?member_id=${mvo.member_id }&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${pgvo.beginPagingNum-1}}">Prev</a></li>
		</c:if>

		<c:forEach begin="${pgvo.beginPagingNum }" end="${pgvo.endPagingNum }"
			var="i">
			<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : ''}">
				<a class="page-link"
				href="/order/orderlist?member_id=${mvo.member_id}&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${i }">${i}</a>
			</li>
		</c:forEach>

		<c:if test="${pgvo.next }">
			<li class="page-item"><a class="page-link"
				href="/order/orderlist?member_id=${mvo.member_id}&flag_hdate=${infOvo.flag_hdate}&flag_tdate=${infOvo.flag_tdate}&pageNum=${pgvo.endPagingNum + 1 }">Next</a></li>
		</c:if>
	</ul>
	</div>
</section>
<script>
	$(function() {
		$('#md_wdiv').hide();
		
		$('.ordmodal').on('hidden.bs.modal', function () {
			$(this).find('#largeCtg').val("-1");
			$(this).find('#mediumCtg').val("-1");
			$(this).find('.plistSlot').empty();
			$(this).find('.selectedSlot').empty();
		});
		
		$(document).on("click", "#ord_done_btn, #ord_cancel_btn",
				function(e){
			e.preventDefault();
			let btnId = $(this).attr('id');
			let stt;
			if (btnId=="ord_done_btn") {
				stt = 1;
			}else if(btnId=="ord_cancel_btn"){
				stt = 2;
			}
			let wrpno = this.dataset.wrpno;
			let id = "${mvo.member_id}";
			$.ajax({
				url:"/order/changeStatus",
				type:"POST",
				data:{wrap_no:wrpno,
					status:stt
				}
			}).done(function(){
				alert("요청이 완료됐습니다.");
				location.replace("/order/orderlist?member_id="+id+"&pageNum=1&flag_hdate=&flag_tdate=");
			}).fail(function(){
				alert("요청을 처리하지 못했습니다. 다시 시도해주세요.");
			});
		});
		
		$(document).on("click", "#ord_recivChk_btn",
				function(e){
			e.preventDefault();
			let stt = this.dataset.stt;
			let wrpno = this.dataset.wrpno;
			$("#ord_done_btn").attr("data-wrpno",wrpno);
			$("#ord_cancel_btn").attr("data-wrpno",wrpno);
			$("#ordStatModal .modal-body").empty();
			$(this).parent().prevAll('.media-body').clone().appendTo("#ordStatModal .modal-body");
			switch (stt) {
			case "0":
				$("#ord_done_btn").show();
				$("#ord_cancel_btn").show();	
				break;
			case "1":
				$("#ord_done_btn").hide();
				$("#ord_cancel_btn").hide();				
				break;
			case "2":
				$("#ordStatModal .modal-body span, #ordStatModal .media-body h4").css("text-decoration","line-through");
				$("#ordStatModal .media-body").append("<br><br><p>(취소된 발주)</p>");
				$("#ord_done_btn").hide();
				$("#ord_cancel_btn").hide();
				break;
			}
		});
		
		
		$('#largeCtg').change(function() {
			let large = "";
			large = $(this).val();
			console.log("selJA:");
			console.log(selectJsonArray.length);
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
		
		var selectJsonArray = new Array();
		var dataBox = new Object();
		var dataBoxCnt = 0;
		
		$('#mediumCtg').change(function() {
			$('.plistSlot').empty();
			let large = $('#largeCtg').val();
			let category = $(this).val();
			if (large!='-1'&&category!='-1') {			
				$.getJSON("/order/getHList/"+category, function(hList){
					dataBox[dataBoxCnt+1] = hList;
					dataBoxCnt += 1;
					for (let i = 0; i < hList.length; i++) {
						let btnTag = '<button type="button" class="btn btn-outline-primary hgetter" data-boxNum="'+dataBoxCnt+
						'" data-objNum="'+i+'">'+dataBox[dataBoxCnt][i].pname+'</button>';
						$(".plistSlot").append(btnTag);
					}

				});
			}else{
				return 'false';
			}
		});
		
		$(document).on("click",
		".hgetter",
		function(e){
		e.preventDefault();
		let boxNum = $(this).attr('data-boxNum');
		let objNum = $(this).attr('data-objNum');
		let chker = this.dataset.chker;
		if (chker == null) {
		$(this).attr('data-chker','true');
		}else{
			return false;
		}
				let selectItemTags = '<button type="button" class="btn btn-outline-primary coreBody" data-boxNum="'+boxNum+
				'" data-objNum="'+objNum+'">'+dataBox[boxNum][objNum].pname+'</button>'
				+'<button type="button" class="btn minus_btn">-</button>'
				+'<span>1</span>'
				+'<button type="button" class="btn plus_btn">+</button>';
				$(".selectedSlot").append(selectItemTags);
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

		$(document).on("click",
				"#ord_insert_btn",
				function(e){
			e.preventDefault();
			let slotLength = $(".selectedSlot").children().length;
			if (slotLength>0) {
				let wrpno = -1;
				$.ajax({
					url:"/order/getWrpno",
					type:"GET"
				}).done(function(result){
					wrpno = result;
					for (let i = 0; i < slotLength/4; i++) {
						let boxNum = $("div.selectedSlot button.coreBody:eq("+i+")").attr('data-boxNum');
						let objNum = $("div.selectedSlot button.coreBody:eq("+i+")").attr('data-objNum');
						let tempObj = dataBox[boxNum][objNum];
						tempObj.order_qnt = $("div.selectedSlot button.coreBody:eq("+i+")").nextAll("span").html();
						console.log("tempObj.order_qnt:");
						console.log(tempObj.order_qnt);
						tempObj.member_id = '<c:out value="${mvo.member_id}"/>';
						tempObj.wrap_no = wrpno;
						selectJsonArray.push(tempObj);
					}
					console.log("selectJsonArray:");
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
				location.reload();
			}
			
		});
		
	});
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>