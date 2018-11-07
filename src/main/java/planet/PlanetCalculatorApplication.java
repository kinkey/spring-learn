package planet;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import planet.controller.PlanetCalculatorController;

@SpringBootApplication(scanBasePackages = {
        "planet" })
public class PlanetCalculatorApplication {

    private static PlanetCalculatorController planetCalculatorController;

    @Autowired
    public PlanetCalculatorApplication(PlanetCalculatorController planetCalculatorController){
        this.planetCalculatorController = planetCalculatorController;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PlanetCalculatorApplication.class, args);

        planetCalculatorController.run("earth");

        SpringApplication.exit(context, () -> 0);
    }
}
