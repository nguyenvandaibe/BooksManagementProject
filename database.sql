create table books (
	id int auto_increment not null ,
    name varchar(255) COLLATE utf8_unicode_ci not null,
    publisher varchar(255) COLLATE utf8_unicode_ci not null,
    price bigint not null,
    primary key (id)
);

create table users (
	username varchar(255) not null,
    password varchar(255) not null,
    primary key (username)
);

insert into users values ('test123', 'test123');
insert into books values ('1', 'The Godfather', 'Nha xuat ban tre', '100000');
insert into books values ('2', 'Conan tap 1', 'Nha xuat ban Kim Dong', '30000');
insert into books values ('3', 'Doraemon', 'Nha xuat ban Kim Dong', '30000');
insert into books values ('4', 'Kheo an noi se co duoc thien ha', 'Nha xuan ban Van hoa', '99000');
