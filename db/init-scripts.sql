CREATE DATABASE estafet;
GRANT ALL PRIVILEGES ON DATABASE estafet TO estaf;
CREATE TABLE IF NOT EXISTS task
(
    id          serial       NOT NULL,
    title       varchar(45)  NOT NULL,
    description varchar(450) NOT NULL,
    finished    boolean      NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS customer
(
    id      serial       NOT NULL,
    name    varchar(45)  NOT NULL,
    surname varchar(450) NOT NULL,
    created date         not null,
    PRIMARY KEY (id)
);
alter table customer add column tasks int[];
alter table task add column customer_id serial;