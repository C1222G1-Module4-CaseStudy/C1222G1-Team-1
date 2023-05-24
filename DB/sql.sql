create database vegetable_management;
use vegetable_management;

create table app_role(
id_role int primary key auto_increment not null,
name_role varchar(50)
);
insert into app_role values (1, 'ROLE_MANAGER'),(2, 'ROLE_EMPLOYEE');
create table users(
id int primary key auto_increment not null,
full_name varchar(50),
email varchar(50),
gender varchar(45),
address varchar(100),
phone_number varchar(11),
image varchar(1000),
username varchar(45),
password varchar(1000)
);
alter table users modify column image varchar(1000);
alter table users modify column password varchar(1000);
insert into users values (1, 'Nguyễn Viết Hoàng', 'hoang@gmail.com', 'nam', 'Sơn Trà, Đà Nẵng', '0987654321', 'https://ik.imagekit.io/nguyenhoang/lotteria_images/drink/drink_7upmelonpeach.png', 'manager1', '$2a$12$AooU/ktCl9X9QGJMuJ6lneMuWrPOR12ol/16w1cb2hvup7gfqdIEa');
create table user_role(
id int primary key auto_increment not null ,
id_user int ,
id_role int , 
foreign key (id_user) references users(id),
foreign key (id_role) references app_role(id_role)
);
insert into user_role values (1, 1, 1);
create table type_product(
	id int primary key auto_increment not null,
    name_type varchar(45)
);
insert into type_product values (1, 'rau');
create table product(
	id int primary key auto_increment not null,
    name_product varchar(255),
    price bigint,
    weight float,
    descriptions varchar(1000),
    quantity_storage int,
    mfg date,
    exp date,
    image varchar(45),
    id_type_product int,
    foreign key (id_type_product) references type_product(id)
);

alter table product add column quantity int;

alter table product modify column image varchar(1000);
insert into product values (1, 'rau muống', 8000, '0.5', 'rau muống sạch', 50, '2023-05-23', '2023-05-30', 'https://ik.imagekit.io/nguyenhoang/lotteria_images/drink/drink_7upmelonpeach.png', 1);
create table payment(
	id int primary key auto_increment not null, 
    type_payment varchar(45)
);
insert into payment values (1, 'thẻ ngân hàng'), (2, 'thanh toán trực tiếp');
create table bill(
	id int primary key auto_increment not null,
    name_customer varchar(45) , 
    phone_number varchar(11),
    sale_date date ,
    id_user int ,
    id_payment int,
    foreign key (id_user) references users(id),
    foreign key (id_payment) references payment(id)
);
insert into bill values (1, 'Lê Văn A', '0987654321', curdate(), 1, 2);
create table detail_bill(
	id_detail int primary key auto_increment not null,
    id_bill int,
    id_product int,
    quantity_order int ,
    total float ,
    foreign key (id_bill) references bill(id),
    foreign key (id_product) references product(id)
);
insert into detail_bill values (1, 1, 1, 1, 8000);

alter table detail_bill drop column id;