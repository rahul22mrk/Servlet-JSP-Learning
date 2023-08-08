/*
create table covidinfo
(
    sno integer primary key auto_increment,
    idate date,
    state varchar(10),
    total integer,
    active integer,
    deaths integer,
    userid varchar(20)
);

create table stateadmins
(
    userid varchar(20) primary key,
    password varchar(15),
    state varchar(15),
    uname varchar(15),
    email varchar(20),
    address varchar(20),
    mobile varchar(20),
    status varchar(10)
);

create table users
(
    email varchar(20) primary key,
    password varchar(15),
    uname varchar(15),
    address varchar(50),
    mobile varchar(12)
);

*/
