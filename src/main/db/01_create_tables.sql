create table whiskey
 (  Id             integer      not null
 ,  name          varchar(100) not null
 , brewery_id      integer      not null
 , type_whiskey_id integer      not null
 , remarks         varchar(100) null
 , description     varchar(4000) null
 );

create table brewery
( id     integer             not null
, name varchar(100)  not null
, location varchar(100) null
);


create table type_whiskey
( id integer not null
, description varchar(100) not null
);

commit;
