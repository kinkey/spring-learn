INSERT INTO planet_db.galaxy (id, name) VALUES (1, 'Milky Way');

INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (1, 'Mercury', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (2, 'Venus', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (3, 'Earth', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (4, 'Mars', 1);

INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (1, 1, 2439.7, 3.7);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (2, 2, 6051.8, 8.87);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (3, 3, 6371, 9.8);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (4, 4, 3389.5, 3.7);

INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (1, 1, 58);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (2, 2, 108);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (3, 3, 149);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (4, 4, 228);