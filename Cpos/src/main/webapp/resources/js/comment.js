function listComment(param_pno, page) {
	let pageNo = page>1 ? page : 1;
	$.getJSON("/comment/list/"+param_pno+"/"+pageNo+".json", function(cdto){ //진짜 많이 쓰이는 기법. 
		printListComment(cdto.clist, cdto.cmtCnt, pageNo);
	}).fail(function() {
		alert("댓글 리스트 출력 실패");
	});
}

function printListComment(listArr, cmtTotal, page) {
	$("#cmtList ul:first-child").nextAll().remove();
	for (let cvo of listArr) {
		let ulTag = '<ul class="nav nav-pills nav-justified">';
		ulTag += '<li class="nav-item">'+ cvo.writer+'</>';
		ulTag += '<li class="nav-item">'+ cvo.content+'</>';
		ulTag += '<li class="nav-item">'+ displayTime(cvo.modd8)+'</>';
		ulTag += '<li class="nav-item"><button data-toggle="modal" data-target="#myModal" class="btn btn-outline-warning modBtn" data-cno="'+ cvo.cno+'">수정</button>';
		ulTag += '<button class="btn btn-outline-danger delBtn" data-cno="'+cvo.cno+'">삭제</button></li></ul>';
		$("#cmtList").append(ulTag);
	}
	printCmtPaging(cmtTotal, page);
}

function displayTime(modd8) {
	let today = new Date();
	let changeModd8 = new Date(modd8);
	
	let todayYear = today.getFullYear();
	let todayMonth = today.getMonth()+1;
	let todayDate = today.getDate();
	
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
	
	let diff = todayYear == modYear && todayMonth == modMonth && todayDate == modDate;
	let dateStr = modYear + "-" + month + "-" + day;
	let timeStr = hour + ":"+min+":"+sec;
	
	return diff? timeStr : dateStr + " " + timeStr;
}

function printCmtPaging(cmtTotal, page) {
	let cmtPagingObj = '<ul class="pagination">';
	let endPagingNum = Math.ceil(page/10.0)*10;
	let beginPagingNum = endPagingNum-9;
	let prev = beginPagingNum != 1;
	let next = false;
	
	if(endPagingNum*10 >= cmtTotal){
		endPagingNum = Math.ceil(cmtTotal/10.0);
	}else{
		next = true;
	}
	
	if(prev){
		cmtPagingObj += '<li class="page-item">';
		cmtPagingObj += '<a class="page-link" href="'+(beginPagingNum-1)+'">Prev</a></li>';
	}
	for(var i=beginPagingNum; i <= endPagingNum; i++){
		let classActive = page == i? ' active' : '';
		cmtPagingObj += '<li class="page-item'+classActive+'">';
		cmtPagingObj += '<a class="page-link" href="'+i+'">'+i+'</a></li>';
	}
	if(next){
		cmtPagingObj += '<li class="page-item">';
		cmtPagingObj += '<a class="page-link" href="'+(endPagingNum+1)+'">Next</a></li>';
	}
	cmtPagingObj += '</ul>';
	$("#cmtPaging").html(cmtPagingObj);
}

function transferToModal(writer,content,cno) {
	$(document).find(".modal-title").text(writer);
	let modInput = '<input class="form-control" data-cno="'+cno+'" type="text" value="'+content+'" id="modInput">';
	$(document).find(".modal-body").html(modInput);
}

function modifySubmit(pno,content,cno) {
	let modData = {content:content,cno:cno};
	$.ajax({
		url: "/comment/"+cno,
		type: "put",
		data: JSON.stringify(modData),
		contentType: "application/json; charset=utf-8"
	}).done(function(result) {
		alert(result);
		listComment(pno);
	});
}

function removeComment(cno,pno){
	//let pno = param.data.pno;
	//let mythis = param.data.myObj;
	//console.log("pno => "+ pno);
	//console.log(mythis);
	$.ajax({
		url: "/comment/"+cno,
		type: "delete"
	}).done(function(result) {
		alert(result);
		listComment(pno);
	});
}