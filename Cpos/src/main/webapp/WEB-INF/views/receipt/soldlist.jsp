<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<c:set var="ses" value="${mid}" scope="session"/>
<section class="py-5">
  <div class="container">
    <button type="button" class="btn btn-primary">전체보기</button>
      <div class="btn-group">
        <select name="category" class="custom-select" id="category">
			    <option selected value="-1">매출분류</option>
			    <option value="0">판매</option>
			    <option value="1">폐기</option>
			  </select>
      </div>
      <div class="btn-group">
        <select name="pay_method" class="custom-select" id="pay_method">
          <option selected value="null">결제수단</option>
          <option value="cash">현금</option>
          <option value="card">카드</option>
        </select>
      </div>
      <input type="date" id="sell_date_s"> - <input type="date" id="sell_date_e">
      <button type="button" class="btn btn-primary" id="schBtn">조회</button>
    </div>
  <div class="container listArea" style="overflow: auto">
    <ul class="nav nav-pills nav-justified" id="recList">
      <li class="nav-item">순번</li>
      <li class="nav-item">영수증번호</li>
      <li class="nav-item">품목</li>
      <li class="nav-item">결제수단</li>
      <li class="nav-item">판매일시</li>
    </ul>
    <c:if test="${not empty list}">
    	<c:forEach var="rvo" items="${list}" >
    	  <ul class="nav nav-pills nav-justified">
	    	<li class="nav-item">${rvo.sell_no}</li>
	      	<li class="nav-item">${rvo.receipt_no }</li>
	      	<li class="nav-item">${rvo.pname }</li>
	      	<c:choose>
	      		<c:when test="${rvo.pay_method eq 'cash'}">
	      			<li class="nav-item">현금</li>
	      		</c:when>
	      		<c:when test="${rvo.pay_method eq 'card'}">
	      			<li class="nav-item">카드</li>
	      		</c:when>
	      	</c:choose>
	      	<li class="nav-item">${rvo.sell_date }</li>
	      </ul>
    	</c:forEach>
    </c:if>
  </div>
  <div class="container detailArea">
    
  </div>
</section>
<script src="/resources/js/soldlist.js"></script>
<script>
  let today = new Date();
  console.log(today);
  var yyyy = today.getFullYear();
  var mm = today.getMonth()+1 > 9 ? today.getMonth()+1 : '0' + today.getMonth()+1;
  var dd = today.getDate() > 9 ? today.getDate() : '0' + today.getDate();
  $("#sell_date_e").val(yyyy+"-"+mm+"-"+dd);
  console.log($("#sell_date_s").val());
  console.log($("#sell_date_e").val());
  $(function() {
	  $("#schBtn").on("click", function() {
		  //null값대신 사용할 체크용 값 정해두기
		  console.log('sch click');
		  let member_id = '<c:out value="${ses}"/>';
		  let category = $("#category").val();
		  let pay_method = $("#pay_method").val();
		  let sell_date_s = "";
		  let sell_date_e = "";
		  if($("#sell_date_s").val() == ""){
			sell_date_s = new Date(1999, 1, 1, 00, 00, 00);
		  }else{
		  	sell_date_s = $("#sell_date_s").val();
		  }
		  if($("#sell_date_e").val() == ""){
			  sell_date_e = today;
		  }else{
			  sell_date_e = $("#sell_date_e").val();
			  console.log(sell_date_e);
		  }
		  console.log(member_id);
		  console.log(category+" "+pay_method);
		  console.log(typeof sell_date_s);
		  console.log(typeof sell_date_e);
		  searchList(member_id, category, pay_method, sell_date_s, sell_date_e);
	  });
});
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>