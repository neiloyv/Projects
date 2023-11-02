--liquibase formatted sql

--changeset neiloyv:1
CREATE TABLE teacher
(
    id            BIGSERIAL PRIMARY KEY,
    firstname     VARCHAR(64) NOT NULL,
    lastname      VARCHAR(64) NOT NULL,
    middlename    VARCHAR(64) NOT NULL,
    birthday      TIMESTAMP   NOT NULL,
    passport      VARCHAR(64),
    authority     VARCHAR(128),
    date_of_issue TIMESTAMP,
    tax_number    VARCHAR(32)

);