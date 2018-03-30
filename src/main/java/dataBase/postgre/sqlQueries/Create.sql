CREATE TABLE games (
	id SERIAL PRIMARY KEY,
	title varchar (150) NOT NULL,
	genre varchar (150),
	rel_date date,
	rate_im dec (3,1),
	rate_users dec (3,1),
	link text NOT NULL
);