create database vegetable_management;
use vegetable_management;


create table app_role(
id_role int primary key auto_increment not null,
name_role varchar(50)
);



create table users(
id int primary key auto_increment not null,
full_name varchar(50),
email varchar(50),
gender varchar(45),
address varchar(100),
phone_number varchar(11),
image varchar(45),
username varchar(45),
password varchar(45)
);
create table user_role(
id int primary key auto_increment not null ,
id_user int ,
id_role int , 
foreign key (id_user) references users(id),
foreign key (id_role) references app_role(id_role)
);

create table type_product(
	id int primary key auto_increment not null,
    name_type varchar(45)
);

create table product(
	id int primary key auto_increment not null,
    name_product varchar(255),
    price bigint,
    weight float,
    descriptions varchar(1000),
    mfg date,
    exp date,
    image varchar(45),
    id_type_product int,
    foreign key (id_type_product) references type_product(id)
);

create table bill(
	id int primary key auto_increment not null,
    name_customer varchar(45) , 
    phone_number varchar(11),
    sale_date date ,
    id_user int ,
    foreign key (id_user) references users(id)
);
create table payment(
	id int primary key auto_increment not null, 
    type_payment varchar(45),
    id_bill int ,
    foreign key(id_bill) references bill(id)
);

create table detail_bill(
	id_detail int primary key auto_increment not null,
    id_bill int,
    id_product int,
    quantity int ,
    total float ,
    foreign key (id_bill) references bill(id),
    foreign key (id_product) references product(id)
);
