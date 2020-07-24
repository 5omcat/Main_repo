<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>

<jsp:useBean id="now" class="java.util.Date" />

<h1>폐기할 리스트 화면~~~</h1>
  <label for="sel1">대분류:</label>
  <select class="form-control" id="lcate">
  <option value="x">대분류</option>
  <c:forEach items="${cate }" var="cate">
    <option value="${cate.large }">${cate.large }</option>
  </c:forEach>
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
        <td class="pname">${ivo.pname }</td>
        <td class="qnt">${ivo.inv_qnt }</td>
        <td class="cate">${ivo.category }</td>
        <td class="hidden">${ivo.discount_rate }
        <input type="hidden" name="ino" value="${ivo.inventory_no }">
        <input type="hidden" name="barcode" value="${ivo.barcode }">
        <input type="hidden" class="get_price" value="${ivo.get_price }">
        </td>
        <td class="ex_date">
        <input type="hidden" name="exdate" value="${ivo.expire_date }">${ivo.expire_date }</td>
        <fmt:formatDate value="${ivo.expire_date }" pattern="yyyy-MM-dd" var="expire"/>
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
    $.getJSON("/stockscrap/getExList/"+txt+".json",function(result){
      printList(result);
      }).fail(function(){
        alert("large주문 리스트 출력 실패");
      });
}

function  printList(pvo){
   let uls="";
    if(pvo.length != 0){
     for(svo of pvo){
      let exdate = displayTime(svo.expire_date);
      uls +='<tr>';
      uls +='<td class="pname">'+svo.pname+'</td>';
      uls +='<td class="qnt">'+svo.inv_qnt+'</td>';
      uls +='<td class="cate">'+svo.category+'</td>';
      uls +='<td class="hidden">'+svo.discount_rate+'<input type="hidden" name="barcode" value="'+svo.barcode+'">';
      uls +='<input type="hidden" name="ino" value="'+svo.inventory_no+'">';
      uls +='<input type="hidden" class="get_price" value="'+svo.get_price+'">'+'</td>';
      uls +='<td class="ex_date"><input type="hidden" name="exdate" value="'+svo.expire_date+'">'+exdate+'</td>';
      uls += exScrap(exdate) == 1 ? '<td><button type="button" class="scrapBtn">폐기</button></td>'
          :'<td>'+svo.status+'</td>';
      uls +='</tr>';
     }
    }else{
     uls += '<tr><td rowspan="6">해당 상품이 없습니다.</td></tr>';
   } 
     $("#tbody").html(uls);
}

$("#mcate").on("change", function() {
  let txt = $("#lcate").find(":selected").val();
    let txt2 = $(this).val();
    alert("선택한것: "+txt + "/" + txt2);
    
     $.getJSON("/stockscrap/getExList/"+txt+"/"+txt2+".json",function(result){
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
    var tags = document.getElementsByClassName("ex_date");
    console.log("tags");
    console.log(tags);
    //console.log("1번:"+tags[0].innerText);
    sclist=[];
     for ( let i = 0; i < tags.length; i++ ){
       sclist.push(tags[i].innerText);
       //if(exScrap(val)==1)
     }
       console.log(sclist);
    //console.log("z:"+$(".ex_date")[1].value);
    
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
  
  $(document).on("click", ".scrapBtn", function() {
	 console.log($(this));
	 let barcode = $(this).closest('tr').find(".hidden").find("input[name=barcode]").val();
	 let ex = $(this).closest('tr').find("input[name=exdate]").val();
	   console.log("ino="+$(this).closest('tr').find("input[name=ino]").val());
	   $.ajax({
	     type:"post",
	     url:"/stockscrap/scrap",
	     data: {barcode:barcode,
	       pname:$(this).closest('tr').find(".pname").text(),
	       category:$(this).closest('tr').find(".cate").text(),
	       scrap_qnt:$(this).closest('tr').find(".qnt").text(),
	       get_price:$(this).closest('tr').find(".get_price").val(), 
	       expire_date:ex,
	       ino:$(this).closest('tr').find("input[name=ino]").val()}
	   }).done(function(result) {
		alert(result=="1"?"폐기처리성공":"폐기처리실패");
	});
});
</script>
<%-- <jsp:include page="../common/footer.jsp"></jsp:include> --%>