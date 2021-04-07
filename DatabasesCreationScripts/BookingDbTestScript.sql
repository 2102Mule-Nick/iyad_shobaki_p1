create table status (
	status_id serial primary key,
	reservation_status varchar(50) not null
);

create table booking (
	booking_id serial primary key,
	hotel_id int not null,
	room_id int not null,
	user_id int not null,
	check_in date not null,
	check_out date not null,
	status_id int references status (status_id)
	
);

insert into booking (hotel_id, room_id, user_id, check_in, check_out, status_id)
values (1,1,1,'2021-03-03', '2021-04-02', 1)

delete from booking where booking_id  =6

select * from booking b 

select current_date 

select * from booking b  where hotel_id =1 and (check_in >= current_date or check_out >= current_date);