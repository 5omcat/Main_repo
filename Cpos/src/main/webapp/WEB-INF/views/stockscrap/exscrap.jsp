<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<jsp:useBean id="now" class="java.util.Date" />

<div class="container">
<h1 class="text-center">폐기할 리스트</h1>
  <label for="sel1" class="ml-3">대분류:</label>
  <select class="btn btn-outline-secondary scrap" id="lcate">
  <option class="btn-light text-dark" value="x">전체</option>
  <c:forEach items="${cate }" var="cate">
    <option class="btn-light text-dark" value="${cate.large }">${cate.large }</option>
  </c:forEach>
  </select>
  <label for="sel2" class="ml-3">중분류:</label>
  <select class="btn btn-outline-secondary scrap" id="mcate">
    <option class="btn-light text-dark" value="전체">전체</option>
  </select>

  <table class="table table-hover text-center mt-3">
    <thead>
    <tr class="table-secondary">
      <th>상품명</th>
      <th>카테고리</th>
      <th></th>
      <th>수량</th>
      <th>유통기한</th>
      <th>상태</th>
    </tr>
    </thead>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
    <tbody id="tbody">
    <c:forEach items="${iList.ilist }" var="ivo">
      <tr>
        <td class="pname">${ivo.pname }</td>
        <td class="qnt">${ivo.inv_qnt }</td>
        <td><input type="hidden" class="cate" value="${ivo.category }">${ivo.large }/${ivo.medium }</td>
        <td class="hidden">${ivo.discount_rate }
        <input type="hidden" class="ino" name="ino" value="${ivo.inventory_no }">
        <input type="hidden" class="barcode" name ="barcode" value="${ivo.barcode }">
        <input type="hidden" class="get_price" value="${ivo.get_price }">
        </td>
        <td class="ex_date">
        <fmt:formatDate value="${ivo.expire_date }" pattern="yyyy-MM-dd" var="expire"/>
        <input type="hidden" class="exdate" value="${ivo.expire_date }" disabled>${expire }</td>
        <c:choose>
        <c:when test="${expire <= today }">
        <td><button type="button" class="scrapBtn">폐기</button></td>
        </c:when>
        <c:otherwise>
          <td>${ivo.status }</td>
        </c:otherwise>
        </c:choose>
      </tr>
    </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="6" class="text-left"><button type="button" class="btn btn-outline-secondary" id="allscrap">현재 페이지 전체 폐기</button></td>
      </tr>
    </tfoot>
  </table>
  <div id="itemPaging">
  </div>
</div>

<script>
exlistUp("x","전체",1);
$("#lcate").on("change", function(e) {
  let large = $(this).val();
  let c1 = ["음료","채소/과일","정육"];
  let c2 = ["아이스","가공식품"];
  let c3 = ["과자류","라면","조미료"];
  let c4 = ["의류","위생용품","기타"];
  let c5 = ["주류","담배"];
  var target = document.getElementById("mcate");
  
  let data;
  if($(this).val() != "x"){
    if($(this).val() == "냉장")
      data = c1;
    else if($(this).val() == "냉동")
      data = c2;
    else if($(this).val() == "실온")
      data = c3;
    else if($(this).val() == "생필품")
      data = c4;
    else if($(this).val() == "기호품")
      data = c5;
    data.unshift("전체");
  }else{
	  data = ["전체"];
  }
  target.options.length = 0;
  
  for(x in data){
    var opt = document.createElement("option");
    opt.value = data[x];
    opt.innerHTML = data[x];
    target.appendChild(opt);
  }
  exlistUp(large,"전체",1);
});
function exlistUp(large, medium, page) {
  	let pageNo = page>1? page:1;
    $.getJSON("/stockscrap/getExList/"+large+"/"+medium+"/"+pageNo+".json",function(idto){
      exprintList(idto.ilist, idto.itemCnt, pageNo);
      }).fail(function(){
        alert("large주문 리스트 출력 실패");
      });
}

function  exprintList(list, itemTotal, page){
   let uls="";
    if(list.length != 0){
     for(svo of list){
      let exdate = displayTime(svo.expire_date);
      uls +='<tr>';
      uls +='<td class="pname">'+svo.pname+'</td>';
      uls +='<td class="text-warning"><input type="hidden" class="category" value="'+svo.category+'">'+svo.large+"/"+svo.medium+'</td>';
      uls +='<td class="hidden"><input type="hidden" class="barcode" value="'+svo.barcode+'">';
      uls +='<input type="hidden" class="ino" name="ino" value="'+svo.inventory_no+'">';
      uls +='<input type="hidden" class="get_price" value="'+svo.get_price+'">'+'</td>';
      uls +='<td class="qnt text-success">'+svo.inv_qnt+'</td>';
      uls +='<td class="ex_date text-danger"><input type="hidden" class="exdate" name="exdate" value="'+exdate+'">'+exdate+'</td>';
      uls += exScrap(exdate) == 1 ? '<td><button type="button btn-outline-dark" class="scrapBtn">폐기 <span class="spinner-border spinner-border-sm"></span></button></td>'
          :'<td>'+svo.status+'</td>';
      uls +='</tr>';
     }
    }else{
     uls += '<tr><td rowspan="6">해당 상품이 없습니다.</td></tr>';
   } 
     $("#tbody").html(uls);
     printPaging(itemTotal, page);
}

$("#mcate").on("change", function() {
  let large = $("#lcate").find(":selected").val();
    let medium = $(this).val();
    exlistUp(large, medium, 1);
  });
  
  $("#allscrap").on("click", function() {
    var tags = document.getElementsByClassName("ex_date");
    let barcodes = $(".barcode");
    let datas = [];
    for (let i = 0; i <barcodes.length; i++) {
        let scData = {member_id:"posSomcat",
        		barcode:$(".barcode").eq(i).val(),
        		pname:$(".pname").eq(i).text(),
        		category:$(".cate").eq(i).val(),
        		get_price:$(".get_price").eq(i).val(), 
        		expire_date:$(".exdate").eq(i).val(), 
        		scrap_qnt:$(".qnt").eq(i).text(),
        		ino:$(".ino").eq(i).val()};
        datas.push(scData);
    }
    jQuery.ajaxSettings.traditional = true;
    $.ajax({
    	url:"/stockscrap/allScrap",
    	type:"POST",
    	dataType:"json",
    	data:JSON.stringify(datas),
    	contentType: "application/json; charset=utf-8",
    	success: function(data) {
            alert(data==1?"처리완료!":"처리 실패"+data);
            let page = $("li.active a").text();
            if(page > Math.ceil(page/10.0)*10)
               exlistUp($("#lcate").val(), $("#mcate").val(), $("li.active a").text());
            else
               exlistUp($("#lcate").val(), $("#mcate").val(), $("li.active a").text()-1);
         },
    	error: function(e) {
    		alert("에러메시지:관리자에게 문의하세요~");
    		console.log(e);
    	}
		});
  });
  
  function exScrap(date) {
    let today = displayTime(new Date());
    let diff = date <= today;
    return diff?1:0;
  }
  
  function displayTime(d8) {
      let changeModd8 = new Date(d8);
      
      let modYear = changeModd8.getFullYear();
      let modMonth = changeModd8.getMonth()+1;
      let modDate = changeModd8.getDate();
      
      let modHour = changeModd8.getHours();
      let modMin = changeModd8.getMinutes();
      let modSec = changeModd8.getSeconds();
      
      let hour = (modHour > 9 ? "" : "0") + modHour;
      let min = (modMin > 9 ? "" : "0")+modMin;
      let sec = (modSec > 9 ? "" : "0")+modSec;
      let month = (modMonth > 9 ? "" : "0")+modMonth;
      let day = (modDate > 9 ? "" : "0")+modDate;
      
      let dateStr = modYear + "-" + month + "-" + day;
      let timeStr = hour + ":"+min+":"+sec;
      
      return dateStr;
    }
  
  $(document).on("click", ".scrapBtn", function() {
	 let barcode = $(this).closest('tr').find(".hidden").find("input[name=barcode]").val();
	 let ex = $(this).closest('tr').find(".exdate").val();
	 let ex2 = $(this).closest('tr').find(".exdate").text();
	   $.ajax({
	     type:"post",
	     url:"/stockscrap/scrap",
	     data: {barcode:barcode,
	       pname:$(this).closest('tr').find(".pname").text(),
	       category:$(this).closest('tr').find(".cate").val(),
	       scrap_qnt:$(this).closest('tr').find(".qnt").text(),
	       get_price:$(this).closest('tr').find(".get_price").val(), 
	       expire_date:ex,
	       ino:$(this).closest('tr').find("input[name=ino]").val()}
	   }).done(function(result) {
		   alert(result=="1"?"폐기처리성공":"폐기처리실패");
		   let page = $("li.active a").text();
	       exlistUp($("#lcate").val(), $("#mcate").val(), page);
	       let li_list = $("#tbody tr");
	       if(li_list.length == 1){
	          exlistUp($("#lcate").val(), $("#mcate").val(), page-1);
	       }
	   }).fail(function(e) {
		   alert("관리자에게 문의하세요~~");
		   console.log(e);
	   });
});
  
  function printPaging(itemTotal, page) {
	    let itemPage = '<ul class="pagination justify-content-center secondary">';
	    let endPagingNum = Math.ceil(page/10.0)*10;
	    let beginPagingNum = endPagingNum-9;
	    let prev = beginPagingNum != 1;
	    let next = false;
	    
	    if(endPagingNum*10 >= itemTotal){
	      endPagingNum = Math.ceil(itemTotal/7.0);
	    }else{
	      next = true;
	    }
	    
	    if(prev){
	      itemPage += '<li class="page-item">';
	      itemPage += '<a class="page-link" href="'+(beginPagingNum-1)+'">Prev</a></li>';
	    }
	    for(var i=beginPagingNum; i<=endPagingNum; i++){
	      let classActive = page == i? 'active' : '';
	      itemPage += '<li class="page-item '+classActive+'">';
	      itemPage += '<a class="page-link" href="'+i+'">'+i+'</a></li>';
	    }
	    if(next){
	      itemPage += '<li class="page-item">';
	      itemPage += '<a class="page-link" href="'+(endPagingNum+1)+'">Next</a></li>';
	    }
	    itemPage += '</ul>';
	    $("#itemPaging").html(itemPage);
	  }
	  
	  $(document).on("click", "#itemPaging li a", function(e) {
	      e.preventDefault();
	      let large = $("#lcate").val();
	      let medium = $("#mcate").val();
	      exlistUp(large, medium, $(this).attr("href"));
	    });
</script>
<jsp:include page="../common/footer.jsp"/>