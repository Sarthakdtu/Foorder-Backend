
CREATE TABLE CITY(
    name TEXT PRIMARY KEY NOT NULL
);

insert into city values('Delhi');


CREATE TABLE STREET(name TEXT NOT NULL, cityName TEXT NOT NULL, pincode TEXT NOT NULL, id TEXT, PRIMARY KEY(name, cityName));

INSERT INTO STREET(name, cityName, pincode) values('gandhi marg', 'Delhi', '201301');