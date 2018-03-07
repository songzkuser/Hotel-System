INSERT INTO ht_keys(key_name,key_val) VALUES ('HOTEL_USER_ID',1073741828);
INSERT INTO ht_keys(key_name,key_val) VALUES ('HOTEL_ADMIN_ID',536871939);
INSERT INTO ht_keys(key_name,key_val) VALUES ('HOTEL_ORDER_ID',1073741829);



INSERT INTO ht_user(user_id,user_name,user_phone,user_password) VALUES (1073741825,'user1','18033736426','lxy951119');
INSERT INTO ht_user(user_id,user_name,user_phone,user_password) VALUES (1073741826,'user2','13081038498','lxy951119');
INSERT INTO ht_user(user_id,user_name,user_phone,user_password) VALUES (1073741827,'user3','13081038410','lxy951119');


INSERT INTO ht_admin(admin_id,admin_password,admin_tips,admin_role) VALUES (536871937,'lxy951119','超级管理员','Y');
INSERT INTO ht_admin(admin_id,admin_password,admin_tips,admin_role) VALUES (536871938,'lxy951119','管理员','N');

INSERT INTO ht_order(order_id,order_user,order_status,order_type) VALUES (1073741825,1073741825,'N',1);
INSERT INTO ht_order(order_id,order_user,order_status,order_type) VALUES (1073741826,1073741825,'N',1);
INSERT INTO ht_order(order_id,order_user,order_status,order_type) VALUES (1073741827,1073741827,'N',2);
INSERT INTO ht_order(order_id,order_user,order_status,order_type) VALUES (1073741828,1073741826,'N',3);

INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,301);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,302);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,303);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,304);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,305);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,306);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,307);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,308);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,309);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,310);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (1,'Y',3,311);

INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,401);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,402);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,403);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,404);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,405);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,406);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,407);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,408);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,409);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (2,'Y',4,410);

INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (3,'Y',5,510);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (3,'Y',5,520);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (3,'Y',5,530);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (3,'Y',5,540);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (3,'Y',5,550);

INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,610);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,620);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,630);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,640);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,650);
INSERT INTO ht_room(room_type,room_status,room_floor,room_num) VALUES (4,'Y',6,670);


INSERT INTO ht_room_type(type_id,type_name,type_pic,type_num) VALUES (1,'大床房','/pic/big',11);
INSERT INTO ht_room_type(type_id,type_name,type_pic,type_num) VALUES (2,'标准间','/pic/big',10);
INSERT INTO ht_room_type(type_id,type_name,type_pic,type_num) VALUES (3,'总统套房','/pic/big',5);
INSERT INTO ht_room_type(type_id,type_name,type_pic,type_num) VALUES (4,'主题套房','/pic/big',7);