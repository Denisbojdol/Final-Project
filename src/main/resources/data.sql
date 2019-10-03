INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (3, 'ROLE_DOCTOR');

INSERT INTO user (username, password, enabled) VALUES ( 'user@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'admin@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'doctor1@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);
INSERT INTO user (username, password, enabled) VALUES ( 'doctor2@test.pl', '$2a$10$7yludK5VllyEIDmzaCpXaOBtk7eJ30kxx/vOoBz.1Twk1vZe3XuD.', 1);

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO office (id,begin,end,open,day) VALUES (1,'8:00','20:00',1,'Poniedzialek');
INSERT INTO office (id,begin,end,open,day) VALUES (2,'8:00','20:00',1,'Wtorek');
INSERT INTO office (id,begin,end,open,day) VALUES (3,'10:00','20:00',1,'Sroda');
INSERT INTO office (id,begin,end,open,day) VALUES (4,'8:00','20:00',1,'Czwartek');
INSERT INTO office (id,begin,end,open,day) VALUES (5,'9:00','18:00',1,'Piatek');
INSERT INTO office (id,begin,end,open,day) VALUES (6,'10:00','14:00',1,'Sobota');
INSERT INTO office (id,open,day) VALUES (7,0,'Niedziela');

INSERT INTO doctor (email, name, surname, user_id) VALUES ('doctor1@test.pl','Tomasz','Kosakowski',3);
INSERT INTO doctor (email, name, surname, user_id) VALUES ('doctor2@test.pl','Andrzej','Tomaszewski',4);

INSERT INTO patient (email, name, surname, user_id) values ('user@test.pl','Denis','Bojdol',1);

--
-- INSERT INTO treatment (name , price) values ('Masaz leczniczy',100.00);
-- INSERT INTO treatment (name , price) values ('Kinezoterapia',150.00);
-- INSERT INTO treatment (name , price) values ('Terapia manualna',200.00);
-- INSERT INTO treatment (name , price) values ('Fizykoterapia',200.00);
-- INSERT INTO treatment (name , price) values ('Masaz relaksacyjny',200.00);
-- INSERT INTO treatment (name , price) values ('Konsultacja fizjoterapeutyczna',50.00);
-- INSERT INTO treatment (name , price) values ('Rehabilitacja specjalistyczna',200.00);
--
--
-- INSERT INTO office (begin, end, open) values ('2019-09-16 08:00','2019-10-16 20:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-17 08:00','2019-10-17 20:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-18 08:00','2019-10-18 20:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-19 08:00','2019-10-19 18:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-20 08:00','2019-10-20 20:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-21 10:00','2019-10-21 16:00',1);
-- INSERT INTO office (begin, end, open) values ('2019-09-22 00:00','2019-10-22 00:00',0);
--
-- INSERT INTO physiotherapist (email,name,surname,user_id) values ('physiotherapist@test.pl','Jan','Kowalski',2);
-- INSERT INTO physiotherapist (email,name,surname,user_id) values ('physiotherapist2@test.pl','Andrzej','Nowak',4);
--

