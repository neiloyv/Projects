--liquibase formatted sql

--changeset neiloyv:1
INSERT INTO teacher (firstname, lastname, middlename, birthday, passport, authority, date_of_issue, tax_number)
VALUES ('Віта', 'Князєва', 'Григорівна', '1985-01-01', 'CM809070', 'Обухівський РВГУ МВС України в Київській області',
        '2018-01-01', '3142893290'),
       ('Катерина', 'Чичик', 'Миколаївна', '1990-01-01', 'CM802010', 'Обухівський РВГУ МВС України в Київській області',
        '2020-01-01', '3142893210'),
       ('Світлана', 'Мохіня', 'Іванівна', '1975-01-01', 'CM809070', 'Обухівський РВГУ МВС України в Київській області',
        '2012-01-01', '3142893220');

--changeset neiloyv:2
INSERT INTO groups (name, teacher_id)
VALUES ('Вт-Чт 16.00', 1),
       ('Вт-Чт 17.00', 1),
       ('Вт-Чт 18.00', 1),
       ('Пн-Ср 16.30', 2),
       ('Пн-Ср 17.30', 2),
       ('Пн-Ср 18.30', 2),
       ('Садок', 3),
       ('ГПД', 3);

--changeset neiloyv:3
INSERT INTO parent (firstname, lastname, middlename, phone)
VALUES ('Олена', 'Пустовіт', 'Григорівна', '+380991122333'),
       ('Катерина', 'Линько', 'Михайлівна', '+380992233444'),
       ('Роман', 'Тищенко', 'Олегович', '+380993344555');

--changeset neiloyv:4
INSERT INTO client (firstname, lastname, middlename, birthday, parent_id, groups_id)
VALUES ('Люба', 'Пустовіт', 'Батьківна', '2017-01-01', 1, (SELECT g.id FROM groups g WHERE g.name = 'Вт-Чт 16.00')),
       ('Іванка', 'Линько', 'Батьківна', '2019-01-01', 2, (SELECT g.id FROM groups g WHERE g.name = 'Вт-Чт 16.00')),
       ('Іван', 'Пустовіт', 'Батькович', '2018-01-01', 1, (SELECT g.id FROM groups g WHERE g.name = 'Пн-Ср 16.30')),
       ('Григорій', 'Тищенко', 'Батькович', '2019-01-01', 3, (SELECT g.id FROM groups g WHERE g.name = 'Пн-Ср 16.30')),
       ('Люба', 'Пустовіт', 'Батьківна', '2017-01-01', 1, (SELECT g.id FROM groups g WHERE g.name = 'Садок')),
       ('Евгеній', 'Тищенко', 'Батькович', '2017-01-01', 3, (SELECT g.id FROM groups g WHERE g.name = 'Садок')),
       ('Люба', 'Пустовіт', 'Батьківна', '2017-01-01', 1, (SELECT g.id FROM groups g WHERE g.name = 'ГПД'));
