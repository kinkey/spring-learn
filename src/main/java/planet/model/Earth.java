package planet.model;

import org.springframework.stereotype.Component;

@Component
public class Earth implements Planet {

    private double acceleration = 0.98;
    private double radius = 6378d;

    @Override public Double getRadius() {
        return radius;
    }

    @Override public Double getAcceleration() {
        return acceleration;
    }
}
