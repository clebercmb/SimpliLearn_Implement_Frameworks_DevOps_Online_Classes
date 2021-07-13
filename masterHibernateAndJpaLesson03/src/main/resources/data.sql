/*create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);
*/


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1001, 'Tom', 'Miami', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1002, 'Hulk', 'New York', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1003, 'Thor', 'San Francisco', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (1004, 'Iron man', 'Toronto', sysdate());
