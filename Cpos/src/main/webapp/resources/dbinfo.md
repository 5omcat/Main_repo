<html>
<body>
	
This is code of DB.
somcat 0^4
	
```
CREATE TABLE SOMCATUSER.TBL_MEMBER (
member_id varchar2(100),
member_pwd varchar2(100),
opt number(4,0) DEFAULT 0
);

alter table SOMCATUSER.tbl_member add constraint pk_member
primary key(member_id);

CREATE TABLE SOMCATUSER.TBL_HEAD (
barcode number(8,0),
pname varchar2(100)
);


alter table SOMCATUSER.tbl_head add constraint pk_head
primary key(barcode);

CREATE TABLE SOMCATUSER.TBL_CATEGORY (
category number(4,0),
large varchar2(100),
medium varchar2(100)
);

alter table SOMCATUSER.tbl_category add constraint pk_category
primary key(category);

CREATE TABLE SOMCATUSER.TBL_inventory (
inventory_no number(5,0),
member_id varchar2(100),
inv_qnt number(4,0),
barcode number(8,0),
pname varchar2(100),
category number(4,0),
get_price number(4,0),
sell_price number(4,0),
expire_date DATE,
discount_rate number(4,0),
status number(4,0) DEFAULT 0
);

drop SEQUENCE seq_inventory_inventory_no;

create sequence seq_inventory_no
start with 1
increment by 1
nocycle nocache;

alter table SOMCATUSER.tbl_inventory add constraint pk_inventory
primary key(inventory_no);

CREATE TABLE SOMCATUSER.TBL_order (
order_no number(10,0),
member_id varchar2(100),
barcode number(8,0),
pname varchar2(100),
order_qnt number(4,0),
order_date DATE,
get_date DATE,
wrap_no number(4,0),
expire_term number(4,0)
);


alter table SOMCATUSER.tbl_order add constraint pk_order
primary key(order_no);

drop SEQUENCE seq_order_order_no;

create sequence seq_order_no
start with 1
increment by 1
nocycle nocache;

CREATE TABLE SOMCATUSER.TBL_sell (
sell_no number(10,0),
member_id varchar2(100),
barcode number(8,0),
sell_qnt number(4,0),
pay_method varchar2(100),
sell_date DATE,
discount_rate number(4,0),
receipt_no number(14,0)
);


alter table SOMCATUSER.tbl_sell add constraint pk_sell
primary key(sell_no);


create sequence seq_sell_no
start with 1
increment by 1
nocycle nocache;

CREATE TABLE SOMCATUSER.TBL_product (
barcode number(8,0),
pname varchar2(100),
category number(4,0),
expire_term number(4,0),
get_price number(4,0),
sell_price number(4,0),
discount_rate number(4,0)
);


alter table SOMCATUSER.TBL_PRODUCT add constraint pk_product
primary key(barcode);



CREATE TABLE SOMCATUSER.TBL_scrap (
scrap_no number(5,0),
member_id varchar2(100),
barcode number(8,0),
category number(4,0),
get_price number(4,0),
scrap_date DATE,
expire_date DATE
);


alter table SOMCATUSER.TBL_scrap add constraint pk_scrap
primary key(scrap_no);


create sequence seq_scrap_no
start with 1
increment by 1
nocycle nocache;
````

</body>
</html>