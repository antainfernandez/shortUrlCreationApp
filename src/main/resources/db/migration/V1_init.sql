create sequence hibernate_sequence start with 1 increment by 1;
create table url (id bigint not null, original_url varchar(1000) not null, primary key (id));
INSERT INTO url (id,original_url) VALUES ( 1,'https://www.google.com/');