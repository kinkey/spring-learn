package planet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import planet.model.Planet;

@Component
public class HardcodedPlanetRepository implements PlanetRepository {

    @Autowired
    PlanetFactory planetFactory;

    @Override public Planet findByName(String name) {
        return planetFactory.getPlanetByName(name);
    }
}
