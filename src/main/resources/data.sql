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
INSERT INTO VISITS(id, status, visit_date, doctors_id, users_id)
VALUES (2, 'ARRANGED', '2021-01-18 10:10:10', 1005, 1001),
       (3, 'ARRANGED', '2021-01-19 10:10:10', 1006, 1002),
       (4, 'CANCELED', '2021-01-20 10:10:10', 1007, 1003),
       (5, 'CANCELED', '2021-01-18 10:10:10', 1005, 1004),
       (6, 'FINISHED', '2021-01-19 10:10:10', 1005, 1001),
       (7, 'FINISHED', '2021-01-20 10:10:10', 1006, 1002);



