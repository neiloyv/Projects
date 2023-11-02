--liquibase formatted sql

--changeset neiloyv:1
INSERT INTO teacher (firstname, lastname, middlename, birthday, passport, authority, date_of_issue, tax_number)
VALUES ('Jon', 'Linkwood', 'Henriovich', '2000-01-01', 'CM809070', 'Kievskaya oblast, Obuhovskiy RVGU Ukraini', '2018-01-01', '3142893290');
