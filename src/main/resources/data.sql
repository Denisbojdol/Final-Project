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
INSERT INTO treatment (name , price,treatment_time) values ('Badanie',100.00,'01:00');
INSERT INTO treatment (name , price,treatment_time) values ('Badanie 2',150.00,'00:30');
INSERT INTO treatment (name , price,treatment_time) values ('Badanie 3',200.00,'02:30');
--
--


