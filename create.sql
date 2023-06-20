create sequence testing_seq start with 1 increment by 50;
create table testing (id bigint not null, name varchar(100) not null, email_adress varchar(255), primary key (id));
