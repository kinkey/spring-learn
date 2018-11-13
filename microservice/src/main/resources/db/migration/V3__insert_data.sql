INSERT INTO planet_db.galaxy (id, name) VALUES (1, 'Milky Way');
INSERT INTO planet_db.galaxy (id, name) VALUES (2, 'Andromeda');
INSERT INTO planet_db.galaxy (id, name) VALUES (3, 'Sombrero');
INSERT INTO planet_db.galaxy (id, name) VALUES (4, 'Sunflower');

INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (1, 'Mercury', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (2, 'Venus', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (3, 'Earth', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (4, 'Mars', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (5, 'Jupiter', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (6, 'Saturn', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (7, 'Uranus', 1);
INSERT INTO planet_db.planet (id, planetName, galaxyId) VALUES (8, 'Neputune', 1);

INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (1, 1, 2439.7, 3.7);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (2, 2, 6051.8, 8.87);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (3, 3, 6371, 9.8);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (4, 4, 3389.5, 3.7);

INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (5, 5, 69911, 2.28);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (6, 6, 58232, 1.065);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (7, 7, 25362, 0886);
INSERT INTO planet_db.planet_attribute (id, planetId, radius, gravity) VALUES (8, 8, 24622, 1.14);

INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (1, 1, 58);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (2, 2, 108);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (3, 3, 149);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (4, 4, 228);

INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (5, 5, 778);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (6, 6, 1434);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (7, 7, 2871);
INSERT INTO planet_db.sun_distance (id, planetId, distance) VALUES (8, 8, 4495);