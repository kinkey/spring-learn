package planet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanetCalculatorApplication {

    //TODO make sure that we load in memory DB if MySql cannot be loaded.

    public static void main(String[] args) {
        SpringApplication.run(PlanetCalculatorApplication.class, args);
    }
}
