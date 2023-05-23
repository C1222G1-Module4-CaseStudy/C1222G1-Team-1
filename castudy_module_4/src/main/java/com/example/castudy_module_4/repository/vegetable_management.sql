create database vegetable_management;
use vegetable_management;

create table type_blog
(
    id_type   int primary key auto_increment not null,
    name_blog varchar(45)
);

create table blog
(
    id          int primary key auto_increment not null,
    title       varchar(45),
    content     varchar(1000),
    post_date   date,
    id_category int,
    foreign key (id_category) references type_blog (id_type)
);
create table type_customer
(
    id_type_customer   int primary key auto_increment,
    name_type_customer varchar(45)
);
create table customers
(
    id               int primary key auto_increment,
    full_name        varchar(45),
    gender           varchar(45),
    email            varchar(45),
    number_phone     varchar(11),
    address          varchar(45),
    id_type_customer int,
    foreign key (id_type_customer) references type_customer (id_type_customer)
);

create table type_employee
(
    id_type_employee   int primary key auto_increment not null,
    name_type_employee varchar(50)
);

create table employee
(
    id               int primary key auto_increment not null,
    full_name        varchar(50),
    email            varchar(50),
    gender           varchar(45),
    address          varchar(100),
    number_phone     varchar(11),
    id_type_employee int,
    id_blog          int,
    foreign key (id_type_employee) references type_employee (id_type_employee),
    foreign key (id_blog) references blog (id)
);

create table type_product
(
    id        int primary key auto_increment not null,
    name_type varchar(45)
);

create table product
(
    id              int primary key auto_increment not null,
    name_product    varchar(255),
    img             varbinary(255),
    price           bigint,
    weight          float,
    descriptions    varchar(1000),
    mfg             date,
    exp             date,
    id_type_product int,
    foreign key (id_type_product) references type_product (id)
);

create table orders
(
    id           int primary key auto_increment not null,
    status_order varchar(40),
    id_employee  int,
    id_customer  int,
    foreign key (id_employee) references employee (id),
    foreign key (id_customer) references customers (id)
);

create table detail_order
(
    id_detail  int primary key auto_increment not null,
    id_order   int,
    id_product int,
    foreign key (id_order) references orders (id),
    foreign key (id_product) references product (id)
);
alter table detail_order
    add column amount int;