insert into type_whiskey( id , description) values (1, 'Malt');
insert into type_whiskey( id , description) values (2, 'Blend');
insert into type_whiskey( id , description) values (3, 'Grain');
insert into type_whiskey( id , description) values (4, 'Bourbon');
insert into type_whiskey( id , description) values (5, 'Blended Malt');
insert into type_whiskey( id , description) values (6, 'Pure Pot Still Whiskey');
insert into type_whiskey( id , description) values (7, 'Rye');
insert into type_whiskey( id , description) values (8, 'Tenessee Whiskey');


insert into brewery ( id, name , location) values (1,'Laphroaig','Port Ellen, Isle of Islay');

insert into whiskey(  Id  ,  name , brewery_id  , type_whiskey_id ) values (1, 'Laphroaig 10 Years', 1, 1);