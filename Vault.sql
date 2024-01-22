-- drop database vault;
create database Vault;
use Vault;

create table admins(
id int not null auto_increment,
username varchar(255),
password varchar(255),
primary key (id));

insert into admins(username, password) values ("adminjil", "jil123");

create table users(
id int not null auto_increment,
firstname varchar(255),
lastname varchar(255),
username varchar(255),
password varchar(255),
tablename varchar(255),
dates varchar(255),
primary key (id));