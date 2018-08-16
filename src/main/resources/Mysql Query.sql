UPDATE UNIT_MY_TASKS SET NAME = REPLACE(NAME, 'Copy contacts', 'Copy property data');
select * FROM INFORMATION_SCHEMA.COLUMNS where COLUMN_TYPE like 'enum%COPY_PROP%' \G;