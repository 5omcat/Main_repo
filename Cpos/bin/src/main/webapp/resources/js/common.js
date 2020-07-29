function makeBarcode(){
   let large = document.getElementById('large').value;
   let medium = document.getElementById('medium').value;
   let rmNum = Math.floor(Math.random()*10000);
   
   temp = String(large)+String(medium)+String(rnNum);
  
   document.getElementById('barcode').value = Number(temp);   
}




