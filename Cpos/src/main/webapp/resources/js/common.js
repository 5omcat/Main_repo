function makeBarcode(largeVal,mediumVal,rnNum){   
	temp = String(largeVal)+String(mediumVal)+String(rnNum);
    document.getElementById('barcode').value = Number(temp);   
}




