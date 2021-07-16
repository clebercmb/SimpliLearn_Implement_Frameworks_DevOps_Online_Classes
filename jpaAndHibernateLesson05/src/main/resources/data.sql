insert into course(id, name, created_date, last_updated_date) values (1001, 'JPA Course', sysdate(), sysdate() );
insert into course(id, name, created_date, last_updated_date) values (1002, 'Spring Course', sysdate(), sysdate() );
insert into course(id, name, created_date, last_updated_date) values (1003, 'Spring Boot Course', sysdate(), sysdate() );

insert into passport(id, number) values (4001, 'E234324');
insert into passport(id, number) values (4002, 'N432323');
insert into passport(id, number) values (4003, 'L983433');

insert into student(id, name, passport_id) values (2001, 'Hulk', 4001);
insert into student(id, name, passport_id) values (2002, 'Iron man', 4002);
insert into student(id, name, passport_id) values (2003, 'Thor', 4003);

insert into review (id, rating, description) values (5001, '5', 'Great Course');
insert into review (id, rating, description) values (5002, '4', 'Wonderful Course');
insert into review (id, rating, description) values (5003, '5', 'Awesome Course');


