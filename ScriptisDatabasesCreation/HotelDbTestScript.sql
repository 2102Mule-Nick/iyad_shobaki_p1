create table hotel (
	hotel_id serial primary key,
	hotel_name varchar(50) not null,
	email_address varchar(256) not null,
	state varchar(100) not null,
	city varchar(100) not null,
	street varchar(100) not null
);

create table room_type (
	room_type_id serial primary key,
	room_type varchar(50) not null,
	price_per_night float not null
	
);

create table room (
	room_id serial primary key,
	room_number varchar(50) not null,
    hotel_id int references hotel (hotel_id),
    room_type_id int references room_type (room_type_id)
);


select * from hotel h2 

select * from room_type rt 

select r.room_number from room r where hotel_id =1 and room_type_id =1

