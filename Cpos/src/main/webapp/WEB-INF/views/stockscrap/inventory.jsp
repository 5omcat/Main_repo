<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<jsp:useBean id="now" class="java.util.Date" />

<section class="pt-5 pb-2 ivory">
<div class="container">
  <h1 class="text-center">재고리스트</h1>
  <!-- <a href="/stockscrap/new" class="text-right">재고 추가하기</a><br> -->
  <div class="cate">
  <label class="ml-3">대분류:</label>
  <select class="btn btn-outline-primary ml-3" id="lcate">
  <option value="x" class="btn-light text-dark">대분류</option>
  <c:forEach items="${cate }" var="cate">
    <option class="btn-light text-dark" value="${cate.large }">${cate.large }</option>
  </c:forEach>
  </select>
  <label class="ml-3">중분류:</label>
  <select class="btn btn-outline-primary ml-3" id="mcate">
    <option value="전체">전체보기</option>
  </select>
  </div>
  
  <table class="table table-hover mt-3 text-center card-ivory">
    <thead>
    <tr class="table-primary">
      <th>카테고리</th>
      <th>상품명</th>
      <th>수량</th>
      <th>수량수정</th>
      <th>할인율</th>
      <th>유통기한</th>
      <th>상태</th>
    </tr>
    </thead>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
    <tbody id="tbody">
    </tbody>
    </table>
    <span id="scrapListBtn"><a class="btn btn-secondary" href="/stockscrap/exscrap">폐기리스트</a></span>
    <!-- <tfoot>
      <tr>
        <td colspan="6" class="text-left"><a class="btn btn-secondary" href="/stockscrap/exscrap">폐기리스트</a></td>
      </tr>
    </tfoot> 
  </table> -->
  <div id="itemPaging" class="mb-5">
  </div>
</div>
  </section>
<script>
listUp("x","전체",1);
$("#lcate").on("change", function(e) {
	let large = $(this).val();
	//alert("선택한것: "+txt);
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
	listUp(large,"전체",1);
});
function listUp(large, medium, page) {
	let pageNo = page>1? page:1;
	//console.log("pageNo="+pageNo);
    $.getJSON("/stockscrap/getIlist/"+large+"/"+medium+"/"+pageNo+".json",function(idto){
    	  //console.log("cnt="+idto.itemCnt);
      printList(idto.ilist, idto.itemCnt, pageNo);
      }).fail(function(){
        alert("large주문 리스트 출력 실패");
      });
}

function  printList(list, itemTotal, page){
	 let uls="";
	  if(list.length != 0){
     for(svo of list){
    	 let exdate = displayTime(svo.expire_date);
      uls +='<tr>';
      uls +='<td class="text-info"><input type="hidden" class="category" value="'+svo.category+'">'+svo.large+"/"+svo.medium+'</td>';
      uls +='<td><input type="hidden" value="'+svo.inventory_no+'" class="ino">'+svo.pname+'</td>';
      uls +='<td class="text-success"><input type="number" value="'+svo.inv_qnt+'" class="qnt" min="0" readonly></td>';
      uls +='<td><button type="button" class="mod_qntBtn btn btn-warning">수정</button></td>';
      uls +='<td>'+svo.discount_rate+' %'+'</td>';
      uls +='<td class="ex_date">'+exdate+'</td>';
      uls += exScrap(exdate) == 1 ? '<td class="text-danger">폐기예정</td>'
    		  :'<td class="text-success">'+"여유"+'</td>';
     }
	  }else{
		 uls += '<tr><td rowspan="6">해당 상품이 없습니다.</td>';
	 } 
	   uls += '</tr>';
     $("#tbody").html(uls);
     printPaging(itemTotal, page);
}

$("#mcate").on("change", function() {
	let large = $("#lcate").find(":selected").val();
	  let medium = $(this).val();
	  listUp(large, medium, 1);
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
	
	$(document).on("click",".mod_qntBtn", function() {
		$(this).closest('tr').find("td:nth-child(3) input:first-child").attr("readonly",false);
		let modbtn = '<button type="button" class="modBtn btn btn-outline-success">수정완료</button>';
		$(this).after(modbtn).trigger("create");
		$(this).remove();
	});
	
	$(document).on("click", ".modBtn", function() {
		let val = $(this).closest('tr').find(".qnt").val();
		let ino = $(this).closest('tr').find(".ino").val();
		
		$.ajax({
			type: "post",
			url: "/stockscrap/qntmodify",
			data: {inventory_no:ino,inv_qnt:val}
		}).done(function(result) {
			result==1?alert("수량변경 성공"):alert("수량변경 실패");
		}).fail(function(e) {
			console.log("error:"+e);
		});
		location.replace("/stockscrap/inventory");
	});
	
	function printPaging(itemTotal, page) {
		let itemPage = '<ul class="pagination justify-content-center">';
		let endPagingNum = Math.ceil(page/10.0)*10;
		let beginPagingNum = endPagingNum-9;
		let prev = beginPagingNum != 1;
		let next = false;
		
		if(endPagingNum*10 >= itemTotal){
			endPagingNum = Math.ceil(itemTotal/10.0);
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
	    listUp(large, medium, $(this).attr("href"));
	  });
	
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>