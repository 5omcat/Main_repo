<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<jsp:useBean id="now" class="java.util.Date" />

<h1>재고리스트 화면~~~~~~~</h1>
  <a href="/stockscrap/new">재고 추가하기</a><br>
  <label for="sel1">대분류:</label>
  <select class="form-control" id="lcate">
  <option value="x">대분류</option>
  <c:forEach items="${cate }" var="cate">
    <option value="${cate.large }">${cate.large }</option>
  </c:forEach>
    <!-- <option value="10">냉장</option>
    <option value="20">냉동</option>
    <option value="30">실온</option>
    <option value="40">생필품</option>
    <option value="50">기호품</option> -->
  </select>
  <label for="sel2">중분류:</label>
  <select class="form-control" id="mcate">
    <option value="0">중분류</option>
  </select>

  <table class="table table-hover">
    <thead>
    <tr class="table-info">
      <th>상품명</th>
      <th>수량</th>
      <th>수량수정</th>
      <th>카테고리</th>
      <th>할인율</th>
      <th>유통기한</th>
      <th>상태</th>
    </tr>
    </thead>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
    <tbody id="tbody">
    <c:forEach items="${iList }" var="ivo">
      <tr>
        <td>
        <input type="hidden" value="${ivo.inventory_no }" class="ino">
        ${ivo.pname }</td>
        <td><input type="number" value="${ivo.inv_qnt }" class="qnt" min="0" readonly></td>
        <td><button type="button" class="mod_qntBtn">수정</button></td>
        <td>${ivo.category }</td>
        <td>${ivo.discount_rate }</td>
        <td class="ex_date">${ivo.expire_date }</td>
        <fmt:formatDate value="${ivo.expire_date }" pattern="yyyy-MM-dd" var="expire"/>
        <c:choose>
        <c:when test="${expire <= today }">
        <td>폐기예정</td>
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
        <td colspan="6"><button type="button"><a class="btn" href="/stockscrap/exscrap">폐기리스트</a></button></td>
      </tr>
      <tr>
        <td colspan="6"><button type="button" id="allscrap">오늘자 전체 폐기</button></td>
      </tr>
    </tfoot>
  </table>

<script>
$("#lcate").on("change", function(e) {
	let txt = $(this).val();
	//alert("선택한것: "+txt);
	let c1 = ["음료","채소/과일","정육"];
	let c2 = ["아이스","가공식품"];
	let c3 = ["과자류","라면","조미료"];
	let c4 = ["의류","위생용품","기타"];
	let c5 = ["주류","담배"];
	var target = document.getElementById("mcate");
	
	//alert($(this).val());
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
		data.unshift("중분류");
	}else{
	    data = ["중분류"];
	  }
	
	target.options.length = 0;
	
	for(x in data){
		var opt = document.createElement("option");
		opt.value = data[x];
		opt.innerHTML = data[x];
		target.appendChild(opt);
	}
	listUp(txt);
});
function listUp(txt) {
    $.getJSON("/stockscrap/getIlist/"+txt+".json",function(result){
    	  //console.log("받은 리스트:"+String.valueOf(result));
    	  //console.log("받은 리스트:"+Object.keys(result));
    	  //console.log("받은 리스트:"+Object.keys(result["0"]));
    	  //console.log("받은 리스트_ex:"+result["0"]["expire_date"]);
      printList(result);
      }).fail(function(){
        alert("large주문 리스트 출력 실패");
      });
}

function  printList(pvo){
	 let uls="";
	  if(pvo.length != 0){
     for(svo of pvo){
    	 //let a = typeof svo.expire_date;
    	 //let a = moment(expire,'YYYY-MM-DD');
    	 //let exdate = new Date(svo.expire_date).toString("YYYY-MM-DD");
    	 //console.log("기한이:"+new Date(svo.expire_date).toString("YYYY-MM-DD"));
    	 //console.log("기한:"+exdate);
    	 //console.log("투데이:"+today);
    	 //let a = Convert.ToDateTime(expire).ToString("YYYY-MM-DD");
    	 let exdate = displayTime(svo.expire_date);
      uls +='<tr>';
      uls +='<td><input type="hidden" value="'+svo.inventory_no+'" class="ino">'+svo.pname+'</td>';
      uls +='<td><input type="number" value="'+svo.inv_qnt+'" class="qnt" min="0"></td>';
      uls +='<td><button type="button" class="mod_qntBtn">수정</button></td>';
      uls +='<td>'+svo.category+'</td>';
      uls +='<td>'+svo.discount_rate+'</td>';
      uls +='<td class="ex_date">'+exdate+'</td>';
      //uls +='<td class="ex_date">'+svo.expire_date+'</td>';
      // uls +='<fmt:formatDate value="${svo.expire_date }" pattern="yyyy-MM-dd" var="expire"/>';
      uls += exScrap(exdate) == 1 ? '<td>폐기예정</td>'
    		  :'<td>'+svo.status+'</td>';
     }
	  }else{
		 uls += '<tr><td rowspan="6">해당 상품이 없습니다.</td></tr>';
	 } 
     $("#tbody").html(uls);
     //let aa = moment($(".ex_date").text()).format('YYYY-MM-DD');
     //alert("??????는"+$(".ex_date").text());
     //alert("시간 포맷2은"+aa);
     /* $(".ex_date").html(moment($(".ex_date").text()).format('YYYY-MM-DD')); */
}
//$(".ex_date").html(moment($(".ex_date").text()).format('YYYY-MM-DD'));

$("#mcate").on("change", function() {
	let txt = $("#lcate").find(":selected").val();
	  let txt2 = $(this).val();
	  alert("선택한것: "+txt + "/" + txt2);
	  
	   $.getJSON("/stockscrap/getIlist/"+txt+"/"+txt2+".json",function(result){
	        //console.log(result);
	      printList(result);
	      }).fail(function(){
	        alert("주문 리스트 출력 실패");
	      });
	  
	   /* $.ajax({
		    type: "post",
		    url: "/stockscrap/getIlist",
		    data: {large:txt, medium:txt2}
		  }).done(function(result){
		    alert(result);
		    printList(result);
		    //listInventory(cate);
		  });  */
		  
	});
	
	$("#allscrap").on("click", function() {
		//let sclist = new ArrayList<String>();
		var tags = document.getElementsByClassName("ex_date");
		//console.log("tags");
		//console.log(tags);
		//console.log("1번:"+tags[0].innerText);
		let list = [];
     for ( let i = 0; i < tags.length; i++ ){
    	 let val = tags[i].innerText;
    	 list.push(val);
    	 if(exScrap(val)==1)
    	 console.log(val);
     }
		//console.log("z:"+$(".ex_date")[1].value);
		
		location.replace("/stockscrap/getget?list="+list);
		//let a = document.getElementsbyClassName("ex_date")[i].val;
		//sclist.add(a);
		//console.log(sclist);
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
		  
		  //return diff? timeStr : dateStr + " " + timeStr;
		  return dateStr;
		}
	
	$(".qnt").on("change", function() {
		//alert("hi");
		
	});
	
	$(document).on("click",".mod_qntBtn", function() {
		//alert("qnt?="+$(this).closest('tr').find(".qnt").val());
		//console.log($(this).closest('tr').find("td:nth-child(2) input:first-child"));
		$(this).closest('tr').find("td:nth-child(2) input:first-child").attr("readonly",false);
		let modbtn = '<button type="button" class="modBtn">수정완료</button>';
		$(this).after(modbtn).trigger("create");
		$(this).remove();
	});
	
	$(document).on("click", ".modBtn", function() {
		let val = $(this).closest('tr').find("td:nth-child(2) input:first-child").val();
		let ino = $(this).closest('tr').find(".ino").val();
		//console.log(ino+"번 상품 "+val+"개");
		
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
	
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>