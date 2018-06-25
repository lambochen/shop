

-- 创建数据库
create database shop;

-- 使用数据库
use shop;

drop table if exists admin;

drop table if exists product;

drop table if exists supplier;

drop table if exists supplier_product;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   id                   int not null,
   name                 char(10) not null,
   password             char(20) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   id                   int not null,
   name                 char(30),
   price                decimal,
   type                 char(30),
   stock                int,
   discount             int,
   primary key (id)
);

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier
(
   id                   int not null,
   name                 char(10),
   telephone            char(12),
   primary key (id)
);

/*==============================================================*/
/* Table: supplier_product                                      */
/*==============================================================*/
create table supplier_product
(
   supplier_id          int not null,
   product_id           int not null,
   amount               int not null,
   primary key (supplier_id, product_id)
);

-- 设置主键自增
alter table admin change id  id int AUTO_INCREMENT;

alter table product change id  id int AUTO_INCREMENT;

alter table supplier change id  id int AUTO_INCREMENT;


-- 设置外键
alter table supplier_product add constraint FK_fk_product foreign key (product_id)
      references product (id) on delete restrict on update restrict;

alter table supplier_product add constraint FK_fk_supplier foreign key (supplier_id)
      references supplier (id) on delete restrict on update restrict;

-- 测试数据
insert into admin(name,password) value ("Bob","123456");

insert into product(name,price,type,stock,discount) value ("乐事薯片",12.0,"薯片",100,10);

insert into product(name,price,type,stock,discount) value ("农夫山泉",2.0,"矿泉水",100,10);

insert into supplier(name,telephone) value("罗笑","13008142323");
insert into supplier(name,telephone) value("张三","13002342343");

insert into supplier_product(supplier_id, product_id, amount) value (1,1,100);
insert into supplier_product(supplier_id, product_id, amount) value (2,2,100);