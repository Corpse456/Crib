ALTER TABLE users RENAME TO userr;

ALTER TABLE userr ALTER COLUMN id SET DEFAULT nextval('example_sequence');

ALTER TABLE t_user rename COLUMN id TO user_id;

ALTER TABLE public.t_book ALTER COLUMN date_prod DROP NOT NULL;

ALTER TABLE t_autor add unique(autor_name);

ALTER TABLE public.t_autor ALTER COLUMN autor_name TYPE varchar(60) USING autor_name::varchar ;