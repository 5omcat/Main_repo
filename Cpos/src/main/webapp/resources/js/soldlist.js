function allList() {
	
}

function searchList(member_id, division, pay_method, sell_date_s, sell_date_e) {
	$.getJSON({
		url: "/receipt/list",
		data: {division:division, pay_method:pay_method, str_date_s:sell_date_s, str_date_e:sell_date_e},
		success: function(list) {
			console.log(list);
			printList(list);
		}
	});
}

function printList(list){
	alert('list');
	console.log(list);
	$("#recList:first-child").nextAll().remove();
	for(let key of list){
		let ulTag = '<ul class="nav nav-pills nav-justified">';
		ulTag += '<li class="nav-item">'+key.sell_no+'</li>';
		ulTag += '<li class="nav-item"><a class="detailLink" href="#">'+key.receipt_no+'</a></li>';
		console.log(key.receipt_no);
		ulTag += '<li class="nav-item">'+key.pname+'</li>';
		ulTag += '<li class="nav-item">'+key.pay_method+'</li>';
		ulTag += '<li class="nav-item">'+key.sell_date+'</li>';
		$("#listArea").append(ulTag);
	}
}

function printDetail(rno){
	console.log('detail function')
	$.getJSON("/receipt/detail/"+rno, function(list) {
		console.log(list);
		console.log(typeof list);
		$("#thead:first-child").nextAll().remove();
		for(let rvo of list){
			 let tableTag = '<tbody><tr class="i">';
                 tableTag += '<td style="display: none">'+ rvo.sell_no +'</td>';
                 tableTag += '<td style="display: none">'+ rvo.barcode +'</td>';
                 tableTag += '<td>'+ rvo.pname +'</td>';
                 tableTag += '<td style="display:none">'+ rvo.category +'</td>';
                 tableTag += '<td>'+ rvo.sell_qnt+'</td>';
                 if(rvo.discount_rate>0){
                 tableTag += '<td>'+ ((rvo.sell_price)*rvo.sell_qnt)-(((rvo.sell_price)*rvo.sell_qnt)*(rvo.discount_rate)/100) +'</td>';
                 }else{
                	 tableTag += '<td>'+ (rvo.sell_price)*rvo.sell_qnt+'</td>';
                 }
                 tableTag += '<td>'+ rvo.pay_method +'</td>';
                 let strdate = (new Date(rvo.sell_date)).toString();
                 strdate = strdate.substring(0, strdate.lastIndexOf(":")+3);
                 console.log(strdate);
                 tableTag += '<td>'+ strdate +'</td>';
                 tableTag += '<td>'+ rvo.discount_rate +'% </td>';
                 tableTag += '<td>'+ rvo.receipt_no +'</td></tr></tbody>';
               $("#detable").append(tableTag); 
		}
	});
}

function displayTime(modd8){
	let today = new Date();
	let changeModd8 = new Date(modd8);
	
	let todayYear = today.getFullYear();
	let todayMonth = today.getMonth()+1; // 0~11
	let todayDate = today.getDate();
	
	let modYear = changeModd8.getFullYear();
	let modMonth = changeModd8.getMonth()+1;
	let modDate = changeModd8.getDate();
	
	let modHour = changeModd8.getHours();
	let modMin = changeModd8.getMinutes();
	let modSec = changeModd8.getSeconds();
	
	let hour = (modHour > 9 ? "" :"0") + modHour;
	let min = (modMin > 9 ? "" : "0") + modMin;
	let sec = (modSec > 9 ? "" : "0") + modSec;
	let month = (modMonth > 9 ? "" : "0") + modMonth;
	let day = (modDate > 9 ? "" : "0") + modDate;
	console.log(hour+":"+min+":"+sec);
	
	let diff = todayYear == modYear && todayMonth == modMonth && todayDate == modDate;
	let dateStr = modYear+"-"+month+"-"+day;
	let timeStr = hour+":"+min+":"+sec;
	console.log(dateStr + " / " + timeStr);
	return diff ? timeStr : dateStr + " " + timeStr;
}