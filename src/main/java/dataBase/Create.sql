CREATE SEQUENCE games_id_seq;

CREATE TABLE games (
	id int DEFAULT NEXTVAL('games_id_seq'),
	name varchar (150) NOT NULL,
	genre varchar (150),
	date date NOT NULL,
	rate_im dec (2,1),
	rate_users dec (2,1),
	link char NOT NULL,
	PRIMARY KEY (id)
);