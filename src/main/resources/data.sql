INSERT INTO role (id, name) VALUES (NULL, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (NULL, 'ROLE_PHYSIOTHERAPIST');
INSERT INTO role (id, name) VALUES (NULL, 'ROLE_ADMIN');

INSERT INTO user (username, password, enabled) VALUES ( 'user@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'physiotherapist@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'admin@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO treatment (name , price) values ('Masaż leczniczy',100.00);
INSERT INTO treatment (name , price) values ('Kinezoterapia',150.00);
INSERT INTO treatment (name , price) values ('Terapia Manualna',200.00);
INSERT INTO treatment (name , price) values ('Fizykoterapia',200.00);
INSERT INTO treatment (name , price) values ('Fizykoterapia',200.00);
INSERT INTO treatment (name , price) values ('Konsultacja fizjoterapeutyczna',50.00);
INSERT INTO treatment (name , price) values ('Rehabilitacja specjalistyczna',200.00);


INSERT INTO office (begin, end, open) values ('2019-09-16 08:00','2019-10-16 20:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-17 08:00','2019-10-17 20:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-18 08:00','2019-10-18 20:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-19 08:00','2019-10-19 18:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-20 08:00','2019-10-20 20:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-21 10:00','2019-10-21 16:00',1);
INSERT INTO office (begin, end, open) values ('2019-09-22 00:00','2019-10-22 00:00',0);

INSERT INTO physiotherapist (email,name,surname,user_id) values ('physiotherapist@test.pl','Jan','Kowalski',2);
