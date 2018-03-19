CREATE TABLE games (
	id int (5) AUTO_INCREMENT,
	name varchar (150) NOT NULL,
	genre varchar (150),
	date date NOT NULL,
	rate_im dec (2,1),
	rate_users dec (2,1),
	link vachar NOT NULL,
	PRIMARY KEY (id)
);