function randomNum(num00,num11){
	let num = Math.floor(Math.random()*(num11 - num00 + 1)) + num00;
	console.log(num);
	return num;
}

function makeBarcode(cateVal,rnNum){   
	temp = String(cateVal)+String(rnNum);
	console.log("temp:"+temp);
	return temp;  	
}
function makeCategory(largeVal,mediumVal){
	cateNum = String(largeVal)+String(mediumVal);
	document.getElementById('category').value = Number(cateNum);
}








