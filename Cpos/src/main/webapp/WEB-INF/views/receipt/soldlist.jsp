<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<c:set var="ses" value="mvo" scope="session"/>
<section class="py-5">
  <div class="container">
    <button type="button" class="btn btn-primary">전체보기</button>
      <div class="btn-group">
        <select name="category" class="custom-select" id="category">
			    <option selected value="null">매출분류</option>
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
      <input type="date" id="sell_date">
      <button type="button" class="btn btn-primary" id="schBtn">조회</button>
    </div>
  <div class="container listArea" style="overflow: auto">
    <ul>
      <li>순번</li>
      <li>영수증번호</li>
      <li>품목</li>
      <li>결제수단</li>
      <li>판매일시</li>
    </ul>
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
  $("#sell_date").val(yyyy+"-"+mm+"-"+dd);
  
  $(function() {
	  
	  $("#schBtn").on("click", function() {
		  //null값대신 사용할 체크용 값 정해두기
		  console.log('sch click');
		  let member_id = '<c:out value=${ses}/>'
		  let category = $("#category").val();
		  let pay_method = $("#pay_method").val();
		  if($("#sell_date").val() == null){
			let sell_date = 'null';
		  }else{
		  	sell_date = $("#sell_date").val();
		  }
		  console.log(category+" "+pay_method+" "+sell_date);
		  searchList(member_id, category, pay_method, sell_date);
	  });
});
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>