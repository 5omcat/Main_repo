package com.somcat.cpos.domain;

import java.sql.Date;

public class InventoryVO {

   private int inventory_no;
   private String member_id;
   private int inv_qnt;
   private int barcode;
   private String pname;
   private int category;
   private CategoryVO catelm;
   private int get_price;
   private int sell_price;
   private int discount_rate;
   private Date expire_date;
   private int status;
   
   public InventoryVO() {}

   public InventoryVO(int inventory_no, int inv_qnt, int discount_rate, int status) {
      this.inventory_no = inventory_no;
      this.inv_qnt = inv_qnt;
      this.status = status;
   }

   public InventoryVO(int inventory_no, String member_id, int inv_qnt, int barcode, String pname, int category,
         int get_price, int sell_price, Date expire_date, int discount_rate, int status) {
      this.inventory_no = inventory_no;
      this.member_id = member_id;
      this.inv_qnt = inv_qnt;
      this.barcode = barcode;
      this.pname = pname;
      this.category = category;
      this.get_price = get_price;
      this.sell_price = sell_price;
      this.expire_date = expire_date;
      this.discount_rate = discount_rate;
      this.status = status;
   }
   
   public InventoryVO(int inventory_no, int inv_qnt, int barcode, String pname, int category, 
         String large, String medium, int get_price, Date expire_date, int status) {
      this.inventory_no = inventory_no;
      this.inv_qnt = inv_qnt;
      this.barcode = barcode;
      this.pname = pname;
      this.category = category;
      this.catelm = new CategoryVO(large, medium);
      this.get_price = get_price;
      this.expire_date = expire_date;
      this.status = status;
   }

   public InventoryVO(int inventory_no, int inv_qnt, String pname, int category,
         String large, String medium, int discount_rate, Date expire_date, int status) {
      this.inventory_no = inventory_no;
      this.inv_qnt = inv_qnt;
      this.pname = pname;
      this.category = category;
      this.catelm = new CategoryVO(large, medium);
      this.discount_rate = discount_rate;
      this.expire_date = expire_date;
      this.status = status;
   }

   public int getInventory_no() {
      return inventory_no;
   }

   public void setInventory_no(int inventory_no) {
      this.inventory_no = inventory_no;
   }

   public String getMember_id() {
      return member_id;
   }

   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }

   public int getInv_qnt() {
      return inv_qnt;
   }

   public void setInv_qnt(int inv_qnt) {
      this.inv_qnt = inv_qnt;
   }

   public int getBarcode() {
      return barcode;
   }

   public void setBarcode(int barcode) {
      this.barcode = barcode;
   }

   public String getPname() {
      return pname;
   }

   public void setPname(String pname) {
      this.pname = pname;
   }

   public int getCategory() {
      return category;
   }

   public void setCategory(int category) {
      this.category = category;
   }

   public int getGet_price() {
      return get_price;
   }

   public void setGet_price(int get_price) {
      this.get_price = get_price;
   }

   public int getSell_price() {
      return sell_price;
   }

   public void setSell_price(int sell_price) {
      this.sell_price = sell_price;
   }

   public int getDiscount_rate() {
      return discount_rate;
   }

   public void setDiscount_rate(int discount_rate) {
      this.discount_rate = discount_rate;
   }

   public Date getExpire_date() {
      return expire_date;
   }

   public void setExpire_date(Date expire_date) {
      this.expire_date = expire_date;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   
   public String getLarge() { 
      if(catelm == null) {
         return "";
      }else
         return catelm.getLarge();
   }
    

   public void setLarge(String large) {
      this.catelm = new CategoryVO(large);
   }

   
   public String getMedium() {
      if(catelm == null) {
         return "";
      }else
         return catelm.getMedium();
   }
    

   public void setMedium(String medium) {
      catelm.setMedium(medium);
   }
}