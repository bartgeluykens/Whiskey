alter table brewery
  add constraint bre_pk primary key  (id)
;
alter table type_whiskey
  add constraint twh_pk primary key  (id)
;
alter table whiskey
  add constraint whi_pk primary key  (id)
;

ALTER TABLE whiskey
    ADD CONSTRAINT whi_bre_fk FOREIGN KEY (brewery_id)
    REFERENCES brewery (id)
;

ALTER TABLE whiskey
    ADD CONSTRAINT twh_bre_fk FOREIGN KEY (type_whiskey_id)
    REFERENCES type_whiskey (id)
;
