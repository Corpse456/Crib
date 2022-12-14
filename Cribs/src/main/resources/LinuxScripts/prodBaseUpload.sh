#!/bin/bash
mvn liquibase:dropAll
mysql -upropertyview -ppropertyview propertyview < /opt/pveDumps/20180726_fetch_descr.sql 

update DATABASECHANGELOG set FILENAME = 'db/db.changelog-master-unit.xml' where FILENAME = 'db/db.changelog-master.xml';
update DATABASECHANGELOG set FILENAME = 'db/db.changelog-unit.xml' where FILENAME = 'db/db.changelog.xml';

mvn liquibase:update -Dliquibase.contexts=prod

update MDS_USERS set PASSWORD = '9e3e274ba1fca28ff6e1ddf3d05c71633ef71cb9d8d29bc0aaad831d97cafc14' where NAME = 'admin';
update MDS_USERS set SALT = '7d86434ac693ef7fa334c5133407cbf68763fef3a9401338bb5761ae' where NAME = 'admin';
update MDS_WEB_SITE set E_MAIL = 'propertyview-test@gpsolutions.com';


