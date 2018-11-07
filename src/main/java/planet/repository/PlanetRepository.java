package planet.repository;

import planet.model.Planet;

public interface PlanetRepository {
    Planet findByName(String name);
}
