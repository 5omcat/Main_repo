----------1.tbl_head----------
create table tbl_product(
barcode number(8,0) constraint pk_head primary key,
pname varchar2(100) not null,
category number(4,0),
expire_term number(4,0),
get_price number(4,0),
sell_price number(4,0),
discount_rate number(4,0),
status number(2,0)
);

----------3.tbl_inventory----------
create table tbl_inventory(
inventory_no number(5,0) constraint pk_inventory primary key,
member_id varchar2(100),
inv_qnt number(4,0),
barcode number(8,0),
pname varchar2(100),
category number(4,0),
get_price number(4,0),
sell_price number(4,0),
expire_date date,
discount_rate number(4,0),
status number(4,0)
);

create sequence seq_inventory_no
start with 1
increment by 1
nocycle nocache;

----------4.tbl_category----------
create table tbl_category (
category number(4,0) constraint pk_category primary key,
large varchar2(100),
medium varchar2(100)
);


----------5.tbl_member----------
create table tbl_member(
member_id varchar2(100) constraint pk_member primary key,
member_pwd varchar2(100),
store_name varchar2(50),
opt number(4,0) default 0
);


----------6.tbl_sell----------
create table tbl_sell(
sell_no number(10,0) constraint pk_sell primary key,
member_id varchar2(100),
barcode number(8,0),
sell_qnt number(4,0),
pay_method varchar2(100),
sell_date date,
discount_rate number(4,0),
receipt_no number(14,0)

create sequence seq_sell_no
start with 1
increment by 1
nocycle nocache;


----------7.tbl_order----------
create table tbl_order(
order_no number(10,0) constraint pk_order primary key,
member_id varchar2(100),
barcode number(8,0),
pname varchar2(100),
order_qnt number(4,0),
order_date date,
get_date date,
wrap_no number(4,0),
expire_term number(4,0),
status number(2,0)
);

create sequence seq_order_no
start with 1
increment by 1
nocycle nocache;


----------8.tbl_scrap----------
create table tbl_scrap(
scrap_no number(5,0) constraint pk_scrap primary key,
member_id varchar2(100),
barcode number(8,0),
category number(4,0),
get_price number(4,0),
scrap_date date,
expire_date date
);

create sequence seq_scrap_no 
start with 1
increment by 1
nocycle nocache;
























