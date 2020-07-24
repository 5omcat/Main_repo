function allList() {
	
}

function searchList(member_id, category, pay_method, sell_date) {
	$.ajax({
		url: "/receipt/soldlist",
		data: {category:category, pay_method:pay_method, sell_date:sell_date},
	}).done( function(result) {
		printList(result);
	});
}

function printList(list){
	for(let rvo of list){
		let ul = "<ul>";
		let ulTag = '<ul class="nav nav-pills nav-justified">';
		ulTag += '<li class="nav-item">'+rvo.receipt_no+'</li>';
		ulTag += '<li class="nav-item"><a href="/receipt/soldlist/"'+rvo.receipt_no+'">'+rvo.pname+' 등 </li>';
		ulTag += '<li class="nav-item">'+displayTime(rvo.sell_date)+'</li>';
		$("#cmtList").append(ulTag);
	}
}

function printDetail(rno){
	$.ajax({
		url:"/receipt/soldlist/"+rno
	}).done(function(rvo) {
		for(let key in rvo){
			console.log(key+":"+rvo[key]);
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