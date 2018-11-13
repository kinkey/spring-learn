package planet.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import planet.entity.Planet;
import planet.entity.PlanetAttribute;
import planet.service.MassCalculatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MassCalculatorServiceTest {

    @InjectMocks
    private MassCalculatorService massCalculatorService;

    @Test
    public void shouldReturnCorrectCase1(){
        Planet planetToTest = createPlanetWithAttributes(12d, 3d);

        Double aDouble = massCalculatorService.calculateMassOfPlanet(planetToTest);

        Double expectedValue =  64.74237928243863d;
        Assert.assertEquals(expectedValue, aDouble);
    }

    @Test
    public void shouldReturnCorrectCase2(){
        Planet planetToTest = createPlanetWithAttributes(3d, 12d);

        Double aDouble = massCalculatorService.calculateMassOfPlanet(planetToTest);

        Double expectedValue =  16.18559482060966d;
        Assert.assertEquals(expectedValue, aDouble);
    }

    @Test
    public void shouldReturnCorrectCase3(){
        Planet planetToTest = createPlanetWithAttributes(3d, Double.NaN);

        Double aDouble = massCalculatorService.calculateMassOfPlanet(planetToTest);

        Double expectedValue =  Double.NaN;
        Assert.assertEquals(expectedValue, aDouble);
    }

    @Test
    public void shouldReturnCorrectCase4(){
        Planet planetToTest = createPlanetWithAttributes(Double.NaN, 3d);

        Double aDouble = massCalculatorService.calculateMassOfPlanet(planetToTest);

        Double expectedValue =  Double.NaN;
        Assert.assertEquals(expectedValue, aDouble);
    }

    @Test
    public void shouldReturnCorrectCase5(){
        Planet planetToTest = createPlanetWithAttributes(Double.NaN, Double.NaN);

        Double aDouble = massCalculatorService.calculateMassOfPlanet(planetToTest);

        Double expectedValue =  Double.NaN;
        Assert.assertEquals(expectedValue, aDouble);
    }

    private Planet createPlanetWithAttributes(Double radius, Double gravity){
        Planet planet = new Planet();

        PlanetAttribute planetAttribute = new PlanetAttribute();
        planetAttribute.setGravity(gravity);
        planetAttribute.setRadius(radius);

        planet.setPlanetAttribute(planetAttribute);

        return planet;
    }
}
