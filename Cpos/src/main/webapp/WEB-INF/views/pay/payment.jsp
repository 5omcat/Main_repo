<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>

<c:set var="ses" value="${mid}" scope="session"/>


<section class="py-5" style="background-color: #fffff0;">
  <!-- 처음row -->
	<div class="row">

		<div class="col-2" style="display:inline-block; text-align:center; background-color: #46aaff;">
			<label for="sel1" class="text-white mt-3" style="font-weight: bolder; ">대분류</label> 
			<select	class="form-control mb-3" id="lcate">
				<option value="alllcate">전체보기</option>
				<c:forEach items="${lList }" var="lvo">
					<option value="${lvo.large }">${lvo.large }</option>
				</c:forEach>
			</select> 
			<label for="sel2" class="text-white" style="font-weight: bolder;">중분류</label> 
			<select	class="form-control" id="mcate">
				<option value="allmcate">전체보기</option>
			</select>
		</div>

		<div class="container col-3 scrollspy" style="height: 760px;overflow: auto; display:inline-block; text-align:center;">
			<table class="table table-hover" id="thead">
				<thead>
					<tr class="table-primary">
						<th style="display: none">ino</th>
						<th>재고량</th>
						<th style="display: none">바코드</th>
						<th>상품명</th>
						<th style="display: none">카테고리</th>
						<th style="display: none">원가</th>
						<th>판매가</th>
						<th>할인률(%)</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${iList }" var="ivo">
						<tr class="i">
							<td style="display: none">${ivo.inventory_no }</td>
							<td >${ivo.inv_qnt }</td>
							<td style="display: none">${ivo.barcode }</td>
							<td>${ivo.pname }</td>
							<td style="display: none">${ivo.category }</td>
							<td style="display: none">${ivo.get_price }</td>
							<td>${ivo.sell_price }</td>
							<td>${ivo.discount_rate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="col scrollspy" id="shoppinglist" 
		style="display: inline-block;text-align: center; height: 760px;overflow: auto;background-color: #dcdcdc; padding:0px;">
			<table class="table">
				<thead>
					<tr class="table-primary">
						<th style="display: none">ino</th>
						<th style="display: none">재고량</th>
						<th>바코드</th>
						<th style="padding-right:30px;">상품명</th>
						<th style="display: none">카테고리</th>
						<th style="display: none">원가</th>
						<th style="padding-left:0px;">판매가</th>
						<th style="padding-right:0px;">할인률(%)</th>
						<th style="padding-right:35px;">수량</th>
						<th style="padding-right:30px;">합계</th>
						<th style="padding-right:25px;">삭제</th>
					</tr>
				</thead>
			</table>
		</div>
		
	</div>
	<!-- 처음 row 끝 -->
	
	<!-- 두번째 row -->
	<div class="row">
		<div class="col-sm-5">
			<span></span>
		</div>
		<div class="col-sm-2">
      <span></span>
    </div>
		<div class="col-sm-5 mt-2">
			<span>합계 </span><input type="text" name="totalsum" readonly><span>원</span>
			<button class="btn btn-success" data-toggle="modal"	data-target="#Modal" name="method">현금</button>
			<button class="btn btn-info" data-toggle="modal" data-target="#Modal" name="method">카드</button>
			<button class="btn btn-outline-danger" type="button" id="alldel">전체삭제</button>
		</div>
	</div>
	<!-- 두번째 row 끝 -->

	<!-- cash Modal -->
	<div class="modal fade" id="Modal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header" style="display: inline-block;text-align: center;">
					<h4 class="modal-title">현금결제</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body mb-3" style="display: inline-block;text-align: center;" id="pay">
					<table class="table">
						<thead>
							<tr class="table-primary">
								<th style="display: none">ino</th>
								<th style="display: none">재고량</th>
								<th style="display:none">바코드</th>
								<th style="padding-left:20px;">상품명</th>
								<th style="display:none">카테고리</th>
								<th style="display:none">원가</th>
								<th style="padding-left:20px;">판매가</th>
								<th style="padding-left:0px;">할인률(%)</th>
								<th style="padding-right:40px;">수량</th>
								<th style="padding-right:30px;">합계</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
				  <span>총계</span><input type="text" class="sum" readonly size="3">
				  <span>수령액</span><input type="text" class="get" size="3">
				  <span>차액</span><input type="text" class="rest" readonly size="3">
				  
				  <span>카드번호</span><input type="text" class="" readonly size="1">
		          <span>-</span><input type="text" class="" readonly size="1">
		          <span>-</span><input type="text" class="" readonly size="1">
		          <span>-</span><input type="text" class="" readonly size="1">
					<button type="button" class="btn btn-primary" name="payComplete" >결제완료</button>
					<button type="button" class="btn btn-danger" name="ccBtn" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
</section>

<script>
	$(function() {
		let slist = []
		let totallist = []
		
		/* 쇼핑리스트 전체삭제  */
		$(document).on("click", "#alldel", function(){
			if (slist.length == 0) {
				alert("삭제할 상품이 없습니다.");	
			} else if(slist.length > 0){
				alert("쇼핑리스트 전체삭제");
			      $("#shoppinglist table:first-child").nextAll().remove();
			      slist.length = 0;
			      caltotal();
			      console.log("slist.length : " + slist.length);
			}
		});
		
		/* 상품리스트에서 누른애들 쇼핑리스트로 보내는 애 */
	    $(document).on("click", ".i", function() {
	      let parentsUl = $(this).closest("tr");
	      let inventory_no = $(parentsUl).find("td:first-child").text();
	      let inv_qnt = $(parentsUl).find("td:nth-child(2)").text();
	      let barcode = $(parentsUl).find("td:nth-child(3)").text();
	      let pname = $(parentsUl).find("td:nth-child(4)").text();
	      let category = $(parentsUl).find("td:nth-child(5)").text();
	      let get_price = $(parentsUl).find("td:nth-child(6)").text();
	      let sell_price = $(parentsUl).find("td:nth-child(7)").text();
	      let discount_rate = $(parentsUl).find("td:nth-child(8)").text();
	      addshoppinglist(inventory_no, inv_qnt, barcode, pname, category, get_price, sell_price, discount_rate);
	    });
		
		/* 인벤토리 받아서, 중복체크하고 배열에 넣는 애 */
	  function addshoppinglist(inventory_no, inv_qnt, barcode, pname, category, get_price, sell_price, discount_rate){
	    let dupleChk = slist.findIndex(i => i.pname == pname);
	    console.log("dupleChk : " + dupleChk)
	    
	    if (parseInt(inv_qnt) <= 0) {
			alert("재고가 부족합니다")
		} else if (dupleChk < 0  && parseInt(inv_qnt) > 0) {
	      slist.push({
	    	  		"inventory_no":inventory_no,
	    	  		"inv_qnt":inv_qnt,
	                "barcode":barcode, 
	                "pname":pname, 
	                "category":category,
	                "get_price":get_price, 
	                "sell_price":sell_price, 
	                "discount_rate":discount_rate
	               });
	      getlist(inventory_no, inv_qnt, barcode, pname, category, get_price, sell_price, discount_rate);
	    } else {
	      alert("이미 존재하는 상품입니다. 수량을 조정해주세요");
	    }
	    
	  }
		
		/* 쇼핑 리스트보여주는 애 */
		function getlist(inventory_no, inv_qnt, barcode, pname, category, get_price, sell_price, discount_rate){
	              let ulTag = '<ul class="nav nav-pills nav-justified">';
	              ulTag += '<li class="nav-item" style="display:none">' + inventory_no + '</li>';
	              ulTag += '<li class="nav-item" style="display: none">' + inv_qnt + '</li>';
	              ulTag += '<li class="nav-item">' + barcode + '</li>';
	              ulTag += '<li class="nav-item">' + pname + '</li>';
	              ulTag += '<li class="nav-item" style="display:none">' + category + '</li>';
	              ulTag += '<li class="nav-item" style="display:none">' + get_price + '</li>';
	              ulTag += '<li class="nav-item">' + sell_price + '</li>';
	              ulTag += '<li class="nav-item">' + discount_rate + '</li>';
	              ulTag += '<li class="nav-item">'+
	                         '<button type="button" class="btn btn-outline-primary btn-sm" name="minus">◁</button>'+
	                         '<span> 1 </span>'+
	                         '<button type="button" class="btn btn-outline-primary btn-sm" name="plus">▷</button>';
	              ulTag += '<li class="nav-item"><span>'+parseInt(sell_price)*(1-parseInt(discount_rate)*1/100)+'</sapn></li>';
	              ulTag += '<li class="nav-item"><button type="button" class="btn btn-outline-danger btn-sm" name="del">삭제</button></li>';
	              $("#shoppinglist").append(ulTag);
	              caltotal();
		}
		
		/* 쇼핑리스트 수량조절*/
	  $(document).on("click", "button[name='minus']", function(){
			let nowNumVal = $(this).closest("ul").find("li:nth-child(9)").find("button:first-child").next().text();
			if (nowNumVal > 1) {
				nowNumVal --;
		  } else{
			  alert("수량은 1개 이상이여야 합니다.")
		  }
			$(this).closest("ul").find("li:nth-child(9)").find("button:first-child").next().text(" "+nowNumVal+" ");
			let nowSellPrice = $(this).closest("ul").find("li:nth-child(7)").text();
			console.log("nowSellPrice : " + nowSellPrice)
			let dc = $(this).closest("ul").find("li:nth-child(8)").text();
      		console.log("dc : " + dc);
      		nowTotalPrice = (nowNumVal * nowSellPrice * ( 1- parseInt(dc)*1/100 ));
			console.log("nowTotalPrice : " + nowTotalPrice);
			$(this).closest("ul").find("li:nth-child(10)").find("span:first-child").text(nowTotalPrice);
			caltotal();
	  });
		
		$(document).on("click", "button[name='plus']", function (){
			let nowNumVal = $(this).closest("ul").find("li:nth-child(9)").find("button:first-child").next().text();
			console.log("nowNumVal : " + nowNumVal);
			
			let stockVal = $(this).closest("ul").find("li:nth-child(2)").text();
			console.log("stockVal : " + stockVal);
			
			if (parseInt(nowNumVal) >= parseInt(stockVal)) {
				alert("재고량이 모자랍니다.");
			} else{
				nowNumVal ++;
				$(this).closest("ul").find("li:nth-child(9)").find("button:first-child").next().text(" "+nowNumVal+" ");	
			}
			
			let nowSellPrice = $(this).closest("ul").find("li:nth-child(7)").text();
			console.log("nowSellPrice : " + nowSellPrice)
			let dc = $(this).closest("ul").find("li:nth-child(8)").text();
			console.log("dc : " + dc);
			nowTotalPrice = (nowNumVal * nowSellPrice * ( 1- parseInt(dc)*1/100 ));
			console.log("nowTotalPrice : " + nowTotalPrice);
			$(this).closest("ul").find("li:nth-child(10)").find("span:first-child").text(nowTotalPrice);
			caltotal();
		});
		
		/* 쇼핑리스트 항목 삭제 */
		$(document).on("click", "button[name='del']", function(){
         alert("상품이 삭제되었습니다.");
         $(this).closest("ul").remove();
         let pname = $(this).closest("ul").find("li:nth-child(2)").text();
         let place = slist.findIndex(i => i.pname == pname);
         slist.splice(place , 1);
         caltotal();
         
	  });
		
	/* 총상품가격계산 */
    function caltotal(){
      let total = 0;
      let ultag = $(document).find("#shoppinglist").find("ul");
      console.log(">>>>>>>ultag.length : " + ultag.length);
      for (var i = 0; i < ultag.length; i++) {
        let li = ultag[i];
        
        let sell_price = li.childNodes[6].textContent;
        let dc = li.childNodes[7].textContent;
        let count = li.childNodes[8].childNodes[1].textContent;
        
        let parseSellPrice = parseInt(sell_price);
        let parseDc = parseInt(dc);
        let parseCount = parseInt(count);
        
        let realTotal = parseCount * parseSellPrice * (1-(parseDc*1/100));
        total += realTotal;
      }
      $("input[name='totalsum']").val(total);
    }
		
    /* 결제모달 */
    $(document).on("click", "button[name='method']", function(){
    	console.log($(this).text());
    		console.log("모달눌렀을때");
    	      $(".modal-body table:first-child").nextAll().remove();
    	      let ultag = $(document).find("#shoppinglist").find("ul");
    	      let receipt = createReceiptNo();
    	      for (var i = 0; i < ultag.length; i++) {
    	        let li = ultag[i];
    	        let modaltag = '<ul class="nav nav-pills nav-justified">';
    	        modaltag += '<li class="nav-item" style="display:none">' + li.childNodes[0].textContent + '</li>';
    	        modaltag += '<li class="nav-item" style="display:none">' + li.childNodes[1].textContent + '</li>';
    	        modaltag += '<li class="nav-item" style="display:none">' + li.childNodes[2].textContent + '</li>';
    	        modaltag += '<li class="nav-item">' + li.childNodes[3].textContent + '</li>';
    	        modaltag += '<li class="nav-item" style="display:none">' + li.childNodes[4].textContent + '</li>';
    	        modaltag += '<li class="nav-item" style="display:none">' + li.childNodes[5].textContent + '</li>';
    	        modaltag += '<li class="nav-item">' + li.childNodes[6].textContent + '</li>';
    	        modaltag += '<li class="nav-item">' + li.childNodes[7].textContent + '</li>';
    	        modaltag += '<li class="nav-item">' +li.childNodes[8].childNodes[1].textContent+'</li>';
    	        modaltag += '<li class="nav-item">' +li.childNodes[9].textContent+ '</li></ul>';
    	        
    	        addpaylist("<c:out value="${mid}"/>",
    	           li.childNodes[2].textContent, 
    	           li.childNodes[3].textContent, 
    	           li.childNodes[4].textContent, 
    	           li.childNodes[8].childNodes[1].textContent, 
    	           li.childNodes[5].textContent, 
    	           li.childNodes[6].textContent, 
    	           $(this).text(), 
    	           li.childNodes[7].textContent, 
    	           receipt
    	        );
    	        
    	          $(".modal-body").append(modaltag);
    	      }
      let totalsum = $("input[name='totalsum']").val();
      let sum = $(".sum").val(totalsum);
      $(".get").on("keyup", function(){
        let get = $(".get").val();
        let rest = parseInt(get) - parseInt(totalsum);
        $(".rest").val(rest);
      });
      console.log("totallist.length : " + totallist.length);
    });
    
    /* 결제목록 배열에 넣기 */
    function addpaylist(member_id, barcode, pname, category, 
        sell_qnt ,get_price, sell_price, pay_method, discount_rate, receipt_no){
      totallist.push({
          "member_id":member_id, 
          "barcode":barcode, 
          "pname":pname, 
          "category":category,
          "sell_qnt":sell_qnt,
          "get_price":get_price, 
          "sell_price":sell_price,
          "pay_method":pay_method,
          "discount_rate":discount_rate, 
          "receipt_no":receipt_no,
      });
    }
      
    /* 결제완료창을 눌렀을 때 */
    $(document).on("click", "button[name='payComplete']", function(){
      console.log("totallist.length : " + totallist.length);
             if (totallist.length != 0) {
               $.ajax({
                      url: "/pay/update",
                      type: "POST",
                      data: JSON.stringify(totallist),
                      contentType: "application/json; charset=utf-8"
                    }).done(function(result){
                      console.log(result);
                      alert("결제 성공");
                      location.reload();
                    }).fail(function(result){
                      console.log(result);
                      alert("결제 실패");
                    });
                } else {
                  alert("구매할 상품이 없습니다.");
                }
             $(".get").val("");
             $(".rest").val("");
             
             let ultag = $(document).find("#pay").find("ul");
             for (var i = 0; i < ultag.length; i++) {
               let li = ultag[i];
               let inventory_no = li.childNodes[0].textContent;
               let inv_qnt = li.childNodes[1].textContent;
               let sell_qnt = li.childNodes[8].textContent;
               console.log("inv_qnt : " + inv_qnt);
               console.log("sell_qnt : " + sell_qnt);
               
               let calstock = parseInt(inv_qnt) - parseInt(sell_qnt);
               console.log(calstock);
               
				$.ajax({
			   			type: "post",
			   			url: "/pay/qntmodify",
			   			data: {inventory_no:inventory_no,inv_qnt:calstock}
			   			}).done(function(result) {
			   			result==1?console.log("수량변경 성공 result: " + result):console.log("수량변경 실패 result : " + result);
			   			}).fail(function(e) {
			   			console.log("error:"+e);
			   			});	
             }
     });
    
    /* 결제취소창을 눌렀을 때 */
    $(document).on("click", "button[name='ccBtn']", function(){
      totallist.length = 0;
      $(".get").val("");
      $(".rest").val("");
    });
    
    /* 영수증 번호 생성(중복체크O) */
      function createReceiptNo(){
          let today = new Date();   
          let year = String(today.getFullYear()); // 년도
          let month = today.getMonth() + 1;// 월
          let zeroPlusMonth = (month > 9 ? "" : "0") + month; // 0 + 월
          let date = String(today.getDate());  // 날짜
          let yyyymmdd = year + zeroPlusMonth + date;
          
          let ranNum = Math.floor(Math.random() * 1000000) + 100000;
          if (ranNum>1000000) {
              ramNum = ranNum - 100000;
              }
          
          let receipt_no = yyyymmdd + String(ranNum);
          console.log(receipt_no);
          
          $.ajax({
            url : "/pay/receiptNoChk",
            type : "get",
            data : {receipt_no:receipt_no}
          }).done(function(result){
            console.log("영수증중복체크성공 result: " + result);
            if(result == 1){
              createReceiptNo();
            }
          }).fail(function(){
            alert("중복체크실패 관리자에게 문의하세요");
          });
          return receipt_no
      }
		
    /* 인벤토리가져오기 */
    $("#lcate").on("change", function(){
      let nowlarge = $(this).val();
      console.log(nowlarge);
      if (nowlarge == "alllcate") {
        $("#thead thead:first-child").nextAll().remove();
        $.getJSON("/pay/getilist", function(ilist){
          console.log("all:"+ilist)
          if (ilist != null) {
            for (let ivo of ilist) {
                     let tableTag = '<tbody><tr class="i">'
                    	tableTag += '<td style="display: none">'+ ivo.inventory_no +'</td>'
                    	tableTag += '<td>'+ ivo.inv_qnt +'</td>'
                        tableTag += '<td style="display:none">'+ ivo.barcode +'</td>'
                        tableTag += '<td>'+ ivo.pname +'</td>'
                        tableTag += '<td style="display:none">'+ ivo.category +'</td>'
                        tableTag += '<td style="display:none">'+ ivo.get_price +'</td>'
                        tableTag += '<td>'+ ivo.sell_price +'</td>'
                        tableTag += '<td>'+ ivo.discount_rate +'</td></tr></tbody>'
                    $("#thead").append(tableTag);
                  }
          } else {
            alert("해당 상품이 존재하지 않습니다.");
          }
        }).fail(function(){
          alert("전체 인벤토리리스트 출력실패");
        });
      } else {
    	  $("#thead thead:first-child").nextAll().remove();
    	    $.getJSON("/pay/getlilist/"+nowlarge+".json", function(lilist){
    	        console.log(lilist);
    	        if (lilist != null) {
    	          for (let livo of lilist) {
    	                  let tableTag = '<tbody><tr class="i">'
    	                	  tableTag += '<td style="display: none">'+ livo.inventory_no +'</td>'
    	                      tableTag += '<td>'+ livo.inv_qnt +'</td>'
    	                      tableTag += '<td style="display:none">'+ livo.barcode +'</td>'
    	                      tableTag += '<td>'+ livo.pname +'</td>'
    	                      tableTag += '<td style="display:none">'+ livo.category +'</td>'
    	                      tableTag += '<td style="display:none">'+ livo.get_price +'</td>'
    	                      tableTag += '<td>'+ livo.sell_price +'</td>'
    	                      tableTag += '<td>'+ livo.discount_rate +'</td></tr></tbody>'
    	                  $("#thead").append(tableTag);
    	                }
    	        }else {
    	          alert("해당 상품이 존재하지 않습니다.")
    	        }
    	      }).fail(function(){
    	         alert("large인벤토리리스트 출력실패")
    	      });
      }
    });
	    
    $("#mcate").on("change", function(){
          let nowlarge = $("#lcate").val();
          console.log("nowlarge : " +nowlarge)
          let nowmedium = $(this).val();
          console.log("nowmedium : " + nowmedium);
          
          if (nowmedium == "allmcate") {
        	  $("#thead thead:first-child").nextAll().remove();
              $.getJSON("/pay/getlilist/"+nowlarge+".json", function(lilist){
                console.log(lilist);
                if (lilist != null) {
                  for (let livo of lilist) {
                        	 let tableTag = '<tbody><tr class="i">'
                        	  tableTag += '<td style="display: none">'+ livo.inventory_no +'</td>'
                              tableTag += '<td>'+ livo.inv_qnt +'</td>'
                              tableTag += '<td style="display:none">'+ livo.barcode +'</td>'
                              tableTag += '<td>'+ livo.pname +'</td>'
                              tableTag += '<td style="display:none">'+ livo.category +'</td>'
                              tableTag += '<td style="display:none">'+ livo.get_price +'</td>'
                              tableTag += '<td>'+ livo.sell_price +'</td>'
                              tableTag += '<td>'+ livo.discount_rate +'</td></tr></tbody>'
                          $("#thead").append(tableTag);
                        }
                }else {
                  alert("해당 상품이 존재하지 않습니다.")
                }
              }).fail(function(){
                 alert("large인벤토리리스트 출력실패")
              });        	  
        	} else {
        		$("#thead thead:first-child").nextAll().remove();
                $.getJSON("/pay/getlmilist/"+nowlarge+"/"+nowmedium+".json", function(lmilist){
                  if (lmilist != null) {
                    for (let lmivo of lmilist) {
                                  let tableTag = '<tbody><tr class="i">'
                                	  tableTag += '<td style="display: none">'+ lmivo.inventory_no +'</td>'
                                      tableTag += '<td>'+ lmivo.inv_qnt +'</td>'
                                      tableTag += '<td style="display:none">'+ lmivo.barcode +'</td>'
                                      tableTag += '<td>'+ lmivo.pname +'</td>'
                                      tableTag += '<td style="display:none">'+ lmivo.category +'</td>'
                                      tableTag += '<td style="display:none">'+ lmivo.get_price +'</td>'
                                      tableTag += '<td>'+ lmivo.sell_price +'</td>'
                                      tableTag += '<td>'+ lmivo.discount_rate +'</td></tr></tbody>'
                                  $("#thead").append(tableTag);
                          }
                    }else {
                      alert("해당 상품이 존재하지 않습니다.")
                    }
                }).fail(function(){
                  alert("large medium 인벤토리 리스트 출력실패")
                });
        	}
          
          
        });
	    
     /* 카테고리 */
    $("#lcate").on("change", function(){
          let nowlarge = $(this).val();
          console.log(nowlarge);
          $("#mcate option:first-child").nextAll().remove();
          $.getJSON("/pay/getlmlist/"+nowlarge+".json", function(lmlist){
            console.log(lmlist);
            for (let lmvo of lmlist) {
              let optionTag = '<option value="'+lmvo.medium+'">'+lmvo.medium+'</option>' 
              $("#mcate").append(optionTag);
            }
          }).fail(function(){
             alert("large인벤토리리스트 출력실패")
          });
        });
	});
		
</script>

<jsp:include page="../common/footer.jsp"></jsp:include>

