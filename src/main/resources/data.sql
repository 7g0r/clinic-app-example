INSERT INTO USERS(id, name, pin, second_name)
VALUES (1001, 'Krzysztof', 1234, 'Krawczyk'),
       (1002, 'Natalia', 4321, 'Kukulska'),
       (1003, 'Ian', 2143, 'Curtis'),
       (1004, 'Jeff', 3412, 'Beck');
INSERT INTO DOCTORS(id, name, second_name)
VALUES (1005, 'Adam', 'Mickiewicz'),
       (1006, 'Juliiusz', 'Słowacki'),
       (1007, 'Gal', 'Anonim'),
       (1008, 'Jan', 'Kochanowski');
INSERT INTO VISITS(id, status, visit_ends, visit_starts, doctors_id, users_id)
VALUES (2, 'ARRANGED', '2021-01-18','2021-01-18',1005,1001),
       (3, 'ARRANGED', '2021-01-19','2021-01-19',1006,1002),
       (4, 'CANCELED', '2021-01-20','2021-01-20',1007,1003),
       (5, 'CANCELED', '2021-01-18','2021-01-18',1005,1004),
       (6, 'FINISHED', '2021-01-19','2021-01-19',1005,1001),
       (7, 'FINISHED', '2021-01-20','2021-01-20',1006,1002);



