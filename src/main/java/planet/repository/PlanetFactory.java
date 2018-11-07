package planet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import planet.model.Earth;
import planet.model.Planet;
import planet.model.Pluto;

@Component
public class PlanetFactory {

    @Autowired
    private Earth earth;

    @Autowired
    private Pluto pluto;

    public Planet getPlanetByName(String planetName) {
        switch (planetName.toLowerCase()) {
        case "earth":
            return earth;

        case "pluto":
            return pluto;

        default:
            return null;
        }
    }

}
