alter table sun_distance add foreign key (planetId) references planet(id);

alter table planet add foreign key (galaxyId) references galaxy(id);

alter table planet_attribute add foreign key (planetId) references planet(id);