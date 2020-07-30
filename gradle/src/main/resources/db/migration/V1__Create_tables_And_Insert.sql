
DROP TABLE IF EXISTS first.message;
CREATE TABLE first.message (
    id int NOT NULL primary key,
    username text  NOT NULL,
    password text  NOT NULL
);


INSERT INTO first.message VALUES ('1', 'admin', '$2a$10$V5iwRgfXKN10XuAuR4lng.uFCQMFmsPu00wa7.YN.9JQJdGH9LAeW');



