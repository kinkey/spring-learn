package planet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planet.model.Planet;
import planet.repository.PlanetRepository;

@Service
public class MassCalculatorService {

    // m = (a * r^2) / G
    private static final Double G_CONSTANT = 6.6726d;

    @Autowired
    private PlanetRepository planetRepository;

    public Double getMassOfPlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        Double mass = calculateMass(planet.getAcceleration(), planet.getRadius());
        return mass;
    }

    private Double calculateMass(Double accelration, Double radius) {
        return (accelration * (radius * radius)) / G_CONSTANT;
    }
}
