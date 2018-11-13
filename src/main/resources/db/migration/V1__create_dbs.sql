use planet_db;

create table galaxy(
  id int unique AUTO_INCREMENT,
  name varchar(50),
  primary key (id)
);

create table planet(
  id int unique AUTO_INCREMENT,
  planetName varchar(50),
  galaxyId int,
  primary key (id)
);

create table planet_attribute(
  id int AUTO_INCREMENT,
  planetId int,
  radius double,
  gravity double,
  primary key (id)
);

create table sun_distance(
  id int AUTO_INCREMENT,
  planetId int unique ,
  distance int ,
  primary key (id)
);