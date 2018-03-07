DROP TABLE IF EXISTS ht_keys;
CREATE TABLE ht_keys(
  key_id INT PRIMARY KEY AUTO_INCREMENT,
  key_name VARCHAR(255) NOT NULL,
  key_val BIGINT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS ht_user;
CREATE TABLE ht_user(
  user_id int primary key,
  user_name varchar(30) not null,
  user_phone varchar(11) not null unique,
  user_password varchar(32) not null,
  user_register datetime default current_timestamp
);

DROP TABLE IF EXISTS ht_admin;
CREATE TABLE ht_admin(
  admin_id int primary key,
  admin_password varchar(32) not null,
  admin_tips varchar(255) not null default '员工',
  admin_role CHAR(1) NOT NULL DEFAULT 'Y'
);

DROP TABLE IF EXISTS ht_order;
CREATE TABLE ht_order(
  order_id bigint primary key,
  order_time datetime default current_timestamp,
  order_user int not null,
  order_status char(1) default 'N',
  order_type int NOT NULL
);

DROP TABLE IF EXISTS ht_room;
CREATE TABLE ht_room(
  room_id int auto_increment primary key,
  room_type int not null,
  room_status char(1) default 'Y',
  room_floor int default 1 not null,
  room_num  int not null unique
);

DROP TABLE IF EXISTS ht_room_type;
CREATE TABLE ht_room_type(
  type_id int auto_increment primary key,
  type_name varchar(32) not null,
  type_pic varchar(255) not NULL ,
  type_num INT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS ht_room_consumer;
CREATE TABLE ht_room_consumer(
  consumer_id int auto_increment primary key,
  consumer_name varchar(32) not null ,
  consumer_idcard varchar(24) not null,
  consumer_status BIGINT NOT NULL
);

DROP TABLE IF EXISTS ht_room_status;
CREATE TABLE ht_room_status(
  status_id bigint primary key auto_increment,
  status_room int not null,
  status_time datetime default current_timestamp
);

DROP TABLE IF EXISTS ht_status_consumer;
CREATE TABLE ht_status_consumer(
  sc_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
  sc_status BIGINT NOT NULL ,
  sc_consumer INT NOT NULL
)


