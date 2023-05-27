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
insert into type_product values  (2, 'củ'), (3, 'trái cây');
create table product(
	id int primary key auto_increment not null,
    name_product varchar(255),
    price bigint,
    weight float,
    descriptions varchar(1000),
    quantity_storage int,
    mfg date,
    exp date,
    image varchar(1000),
    id_type_product int,
    foreign key (id_type_product) references type_product(id)
);

insert into product(id,exp,mfg,descriptions,image,name_product,price,quantity_storage,weight,id_type_product)
values(2,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://suckhoedoisong.qltns.mediacdn.vn/324455921873985536/2021/10/29/caithaothumnail-163552301748427624753.jpg','Cải thảo',15000,200,200,1),
(3,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://bizweb.dktcdn.net/100/363/007/files/rau-muong-2.jpg?v=1655538300720','Rau muống',15000,200,200,1),
(4,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://images.baodantoc.vn/uploads/2022/Th%C3%A1ng%208/Ng%C3%A0y_18/Thanh/maxresdefault-1.jpg','Bắp cải',15000,200,200,1),
(5,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://images2.thanhnien.vn/Uploaded/ngocquy/2022_02_18/4-bong-cai-xanh-shutterstock-6875.jpg','Bông cải xanh',15000,200,200,1),
(6,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://www.btaskee.com/wp-content/uploads/2020/10/rau-cai-xoong-nhat.jpg','Rau cải xoong',15000,200,200,1),
(7,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://media1.nguoiduatin.vn/thumb_x1280x857/media/ngac-kim-giang/2020/12/14/them-buoc-nay-bao-quan-rau-mui3.jpg','Rau mùi',15000,200,200,1),
(8,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://suckhoedoisong.qltns.mediacdn.vn/324455921873985536/2021/9/25/tac-dung-cua-ca-chua-doi-voi-suc-khoe-1-1632310636-831-width640height427-1632567723926-16325677242441321628137.jpg','Cà chua',15000,200,200,1),
(9,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://phanbonhuunghi.vn/wp-content/uploads/2021/03/image8-3.png','Dưa leo',15000,200,200,1),
(10,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://cdn.tgdd.vn/2021/01/CookProduct/1-1200x676-7.jpg','Rau cải thìa',15000,200,200,1),
(11,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://skyfoodvietnam.vn/uploads/cai-ngot-thuy-canh.jpg','Cải ngọt',15000,200,200,1),
(12,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://suckhoe123.vn/uploads/suc-khoe/2021_05/khoai-tay.jpg','Khoai tây',15000,200,500,2),
(13,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://suckhoedoisong.qltns.mediacdn.vn/thumb_w/1200/324455921873985536/2021/8/10/ava-carot-1628613142139653627209-20-0-660-1024-crop-1628613159334685556069.jpg','Cà rốt',15000,200,500,2),
(14,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://vinmec-prod.s3.amazonaws.com/images/20190624_061927_754033_san-day-1.max-800x800.png','Sắn dây',15000,200,500,2),
(15,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://cdn.tgdd.vn/2021/06/CookProduct/thumb-1200x676-19.jpg','Củ cải đường',15000,200,500,2),
(16,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://vcdn1-suckhoe.vnecdn.net/2022/04/22/02-1650634118-2021-1650634163.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=LveJLgrM67EWSGRjVsU2QQ','Khoai lang',15000,200,500,2),
(17,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://images.baodantoc.vn/uploads/2021/Th%C3%A1ng%207/Ng%C3%A0y_22/Thanh/photo-1-1559118706962956654225-1.jpg','Củ hành',15000,200,500,2),
(18,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://cdn.tgdd.vn/Files/2017/08/17/1013951/bot-nang-va-bot-cu-nang-giong-nhau-hay-khac-nhau-3_800x400.jpg','Củ năng',15000,200,500,2),
(19,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://monngonmoingay.com/wp-content/uploads/2022/10/cu-dau-1.jpg','Củ đậu',15000,200,500,2),
(20,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://images2.thanhnien.vn/Uploaded/ngocthanh/2016_02_19/hanh-ta_RTNR.jpg?width=500','Củ hành tây',15000,200,500,2),
(21,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://vinmec-prod.s3.amazonaws.com/images/20210606_033037_851623_cucai.max-800x800.jpg','Củ cải trắng',15000,200,500,2),
(22,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://hoaquafuji.com/storage/app/media/anh-sua/cropped-images/tao-do-2-6-16-794-709-1623469683.jpg','Táo',25000,200,500,3),
(23,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://cdn-www.vinid.net/2020/04/55e5eb8c-gi%C3%A1-tr%E1%BB%8B-dinh-d%C6%B0%E1%BB%A1ng-c%E1%BB%A7a-qu%E1%BA%A3-chu%E1%BB%91i.jpg','Chuối',25000,200,500,3),
(24,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://image.vtc.vn/files/phamquy/2019/04/19/dua-chin-3-0115040.jpg','Dứa',25000,200,1000,3),
(25,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://suckhoedoisong.qltns.mediacdn.vn/Images/thanhloan/2016/06/05/tac-dung-cua-qua-cam-2.jpg','Cam',25000,200,1000,3),
(26,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://cdn.tgdd.vn/Files/2016/12/26/930385/meo-chon-dua-hau-ngon-ngot-cho-ngay-tet-3-760x367.jpg','Dưa hấu',25000,200,500,3),
(27,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://afamilycdn.com/150157425591193600/2020/7/1/foody-upload-api-foody-mobile-avar335-191015145656-1593576384830622268292.jpg','Dừa',25000,200,500,3),
(28,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://media-cdn-v2.laodong.vn/storage/newsportal/2021/10/21/965844/Kiwi.jpg','Kiwi',25000,200,500,3),
(29,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://chanhthu.com/wp-content/uploads/2022/07/chanh-thu-buoi-da-xanh-2.jpg','Bưởi',25000,200,500,3),
(30,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://goce.vn/files/common/qua-le-va-nhung-cong-dung-than-ky-7iac2.jpg','Lê',25000,200,500,3),
(31,'2023-05-23','2023-05-30','Ngon bổ rẻ','https://images2.thanhnien.vn/528068263637045248/2023/4/25/2-xoai-shutterstock-16824039784501393153165.jpg','Xoài',25000,200,500,3);
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
insert into bill values	(2, 'Lê Văn A', '0987654321', curdate(), 1, 2),
(4, 'Lê Văn A', '0987654321', curdate(), 1, 2),
(5, 'Lê Văn A', '0987654321', curdate(), 1, 2),
(6, 'Lê Văn A', '0987654321', curdate(), 1, 2),
(7, 'Lê Văn A', '0987654321', '2023-05-25', 1, 2),
(8, 'Lê Văn A', '0987654321', '2023-05-25', 1, 2),
(9, 'Lê Văn A', '0987654321', '2023-05-25', 1, 2),
(10, 'Lê Văn A', '0987654321', '2023-05-24', 1, 2),
(11, 'Lê Văn A', '0987654321', '2023-05-24', 1, 2),
(12, 'Lê Văn A', '0987654321', '2023-05-24', 1, 2),
(13, 'Lê Văn A', '0987654321', '2023-05-23', 1, 2),
(14, 'Lê Văn A', '0987654321', '2023-05-23', 1, 2),
(15, 'Lê Văn A', '0987654321', '2023-05-23', 1, 2);
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
insert into detail_bill values (2, 2, 1, 1, 8000),
 (3, 3, 1, 1, 8000),
(4, 4, 1, 2, 16000),
(5, 5, 1, 2, 16000),
(6, 6, 1, 4, 32000),
(7, 7, 1, 4, 32000),
(8, 8, 1, 2, 16000),
(9, 9, 1, 2, 16000),
(10, 10, 1, 3, 24000),
 (11, 11, 17, 1, 15000),
 (12, 12, 17, 1, 15000),
 (13, 13, 17, 1, 15000),
 (14, 14, 29, 1, 25000),
(15, 15, 1, 1, 8000);