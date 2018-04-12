ALTER TABLE users RENAME TO userr;

ALTER TABLE userr ALTER COLUMN id SET DEFAULT nextval('example_sequence');

ALTER TABLE t_user rename COLUMN id TO user_id;

ALTER TABLE public.t_book ALTER COLUMN date_prod DROP NOT NULL;