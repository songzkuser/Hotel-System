# 宾馆管理系统

## 数据库表设计 

ht_user 用户表
	
	user_id int primary key , 用户ID 使用32bit无符号整数
	user_name varchar(30) not null, 用户姓名 字符串类型
	user_phone varchar(11) not null unique, 用户手机号字符串类型
	user_password varchar(32) not null, 用户密码MD5加密字符串类型
	user_register datetime default current_timestamp 用户注册时间 datetime 时间类型
	
ht_admin 管理员表

	admin_id unsigned int primary key, 管理员帐号 32bit无符号整数 
	admin_password varchar(32) not null 管理员密码 字符串MD5加密
	admin_tips varchar(255) not null default '员工' 管理员 员工信息备注

ht_order 订单表

	order_id unsigned bigint primary key, 用户订单号 64bit无符号整数 
	order_time datetime default current_timestamp 订单生成时间 timestamp 类型
	order_user int not null, 用户 ID 外键 关联 ht_user 表32bit 整数类型
	order_status char(1) default 'N' 订单状态 默认未消费 字符类型

ht_room 房间表

	room_id int auto_increment primary key, 房间ID 32bit整数
	room_type int not null, 房间类型 外键链接 ht_room_type 表 32bit整数
	room_status char(1) default 'Y' , 房间状态 Y 为可用 N 为有人 字符类型
	room_floor int default 1 not null, 房间楼层 32bit整数类型
	room_num  int not null unique  房间号 32 bit整数 类型


ht_room_type 房间类型表
	
	type_id int auto_increment primary key, 房间类型 int32bit 整数
	type_name varchar(32) not null 房间类型 字符串类型
 
ht_room_consumer 房间入住人员信息表
	
	consumer_id int auto_increment primary key, 32bit整数类型 住户id
	consumer_name varchar(32) not null, 字符串类型 住户姓名
	consumer_idcard varchar(24) not null,字符串类型 住户身份证信息
	

ht_room_status 房间入住状态表
	
	status_id bigint primary key auto_increment 房间状态 id 64bit整数
	status_room int not null, 当前状态的 房间号 外键 链接 ht_room 表
	status_consumer int not null 当前住户信息 外键 链接 ht_room_consumer
	

ht_keys 系统字典表用来做序列的

	key_id int primary key  字典表ID 32bit整数 
	key_name varchar(30) not null unique, 字典名称 字符串 
	key_val bigint not null default 1 字典内部的序列 当前增长情况 32bit 整数 