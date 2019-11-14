-- Customers
insert into customer (username, password, email, first_name, last_name) values ('danseremet', '123456', 'dan@gmail.com', 'Dan', 'S');
insert into customer (username, password, email, first_name, last_name) values ('johndoe', '123456', 'john@gmail.com', 'John', 'Doe');
insert into customer (username, password, email, first_name, last_name) values ('janedoe', '123eqw', 'jane@gmail.com','Jane', 'Doe');
insert into customer (username, password, email, first_name, last_name) values ('dan', 'hello', 'jane@gmail.com','Dan', 'S');

-- Salon owners
insert into salon_owner (username, password, email, first_name, last_name) values ('TheHairPerson', 'nopass', 'hairsalonowner@gmail.com','hair', 'person');
insert into salon_owner (username, password, email, first_name, last_name) values ('TheArtPerson', 'nopass', 'artsalonowner@gmail.com','art', 'person');

-- Salon example 1 with services
insert into salon_service (name) values ('Clean hair');
insert into salon_service (name) values ('Dry hair');
insert into salon_service (name) values ('Cut hair');
insert into salon (name, owner_id) values ('Hair Salon', 1);
insert into salon_available_services (salon_id, available_services_id) values (1, 1);
insert into salon_available_services (salon_id, available_services_id) values (1, 2);
insert into salon_available_services (salon_id, available_services_id) values (1, 3);


-- Salon example 2 with services
insert into salon_service (name) values ('Read a book');
insert into salon_service (name) values ('Sing a song');
insert into salon_service (name) values ('Make a dance');
insert into salon (name, owner_id) values ('Arts Salon', 2);
insert into salon_available_services (salon_id, available_services_id) values (2, 4);
insert into salon_available_services (salon_id, available_services_id) values (2, 5);
insert into salon_available_services (salon_id, available_services_id) values (2, 6);
