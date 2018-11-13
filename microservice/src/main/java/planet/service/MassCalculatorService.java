package planet.service;

import org.springframework.stereotype.Service;

import planet.entity.Planet;

@Service
public class MassCalculatorService {

    // m = (a * r^2) / G
    private static final Double G_CONSTANT = 6.6726d;

    public Double calculateMassOfPlanet(Planet planet) {
        Double radius = planet.getRadius();
        Double gravity = planet.getGravity();

        return (gravity * (radius * radius)) / G_CONSTANT;
    }
}
