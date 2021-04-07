create table user_account (
	user_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	phone_number varchar(24) not null,
	email_address varchar(256) not null,
	user_password varchar(50) not null	
);



create table payment (
	payment_id serial primary key,
	credit_card_type varchar(50) not null,
	credit_card_number varchar(50) not null,
	security_code varchar(3) not null,
	user_id int references user_account (user_id)
);


select * from user_account ua 

select email_address from user_account where user_id = 59

select * from payment p 

select ua.user_id, ua.first_name , ua.last_name , ua.phone_number , ua.email_address ,
p.credit_card_type , p.credit_card_number , p.security_code from user_account ua 
inner join payment p on p.user_id = ua.user_id
where ua.email_address = 'iyad@shobaki.com' and ua.user_password = '1234';

select ua.user_id, ua.first_name , ua.last_name , ua.phone_number , ua.email_address ,
p.credit_card_type , p.credit_card_number , p.security_code from user_account ua 
inner join payment p on p.user_id = ua.user_id
where ua.email_address = 'glabba1@webs.com' and ua.user_password = '40x36L';

