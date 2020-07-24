function randomNum(num00,num11){
	let rmNum = Math.floor(Math.random()*(num11 - num00 + 1)) + num00;
}
function makeBarcodeCategory(largeVal,mediumVal,rnNum){   
	temp = String(largeVal)+String(mediumVal)+String(rnNum);
    document.getElementById('barcode').value = Number(temp);
    temp1 = String(largeVal)+String(mediumVal);    
}
function makeCategory(largeVal,mediumVal){
	temp1 = String(largeVal)+String(mediumVal);
	document.getElementById('category').value = Number(temp1);
	console.log('temp1'+temp1);
	console.log(typeof temp1);
}





