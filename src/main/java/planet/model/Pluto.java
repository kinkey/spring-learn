package planet.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Pluto implements Planet {

    @Value("${planet.pluto.acceleration}")
    private Double acceleration;

    @Value("${planet.pluto.radius}")
    private Double radius;

    @Override public Double getRadius() {
        return radius;
    }

    @Override public Double getAcceleration() {
        return acceleration;
    }
}
