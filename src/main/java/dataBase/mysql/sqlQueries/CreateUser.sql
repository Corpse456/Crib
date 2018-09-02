create user 'wtn'@'localhost' identified by 'wtnpassword';
grant all privileges on *.* to "wtn"@"localhost" identified by "wtnpassword";
flush privileges;

drop database if exists kinopoisk;
create database kinopoisk CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;