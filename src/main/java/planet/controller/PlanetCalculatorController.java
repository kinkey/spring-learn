package planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import planet.service.MassCalculatorService;

@Component
public class PlanetCalculatorController {

    @Autowired
    private MassCalculatorService massCalculatorService;

    public void run(String planet) {
        System.out.println("Calculating mass of planet " + planet);
        Double massOfPlanet = massCalculatorService.getMassOfPlanet(planet);
        System.out.println("Mass is : " + massOfPlanet);
    }

    public PlanetCalculatorController() {
    }
}
