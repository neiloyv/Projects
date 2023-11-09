--liquibase formatted sql

--changeset neiloyv:1
CREATE TABLE IF NOT EXISTS teacher
(
    id            BIGSERIAL PRIMARY KEY,
    firstname     VARCHAR(64)  NOT NULL,
    lastname      VARCHAR(64)  NOT NULL,
    middlename    VARCHAR(64)  NOT NULL,
    birthday      TIMESTAMP    NOT NULL,
    passport      VARCHAR(64)  NOT NULL,
    authority     VARCHAR(128) NOT NULL,
    date_of_issue TIMESTAMP    NOT NULL,
    tax_number    VARCHAR(32)  NOT NULL

);

--changeset neiloyv:2
CREATE TABLE IF NOT EXISTS groups
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(128)                   NOT NULL,
    teacher_id BIGINT REFERENCES teacher (id) NOT NULL
);

--changeset neiloyv:3
CREATE TABLE IF NOT EXISTS parent
(
    id         BIGSERIAL PRIMARY KEY,
    firstname  VARCHAR(64) NOT NULL,
    lastname   VARCHAR(64) NOT NULL,
    middlename VARCHAR(64),
    phone      VARCHAR(13) not null
);

--changeset neiloyv:4
CREATE TABLE IF NOT EXISTS client
(
    id         BIGSERIAL PRIMARY KEY,
    firstname  VARCHAR(64)                   NOT NULL,
    lastname   VARCHAR(64)                   NOT NULL,
    middlename VARCHAR(64)                   NOT NULL,
    birthday   TIMESTAMP                     NOT NULL,
    parent_id  BIGINT REFERENCES parent (id) NOT NULL,
    groups_id  INT REFERENCES groups (id) NOT NULL

);