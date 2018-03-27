ALTER TABLE users RENAME TO userr;

ALTER TABLE userr ALTER COLUMN id SET DEFAULT nextval('example_sequence');