package planet.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "planet_attribute")
public class PlanetAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "planetId")
    @JsonBackReference
    private Planet planet;

    private Double gravity;

    private Double radius;

    @Override public String toString() {
        return "PlanetAttribute{" +
                "id=" + id +
                ", planetName=" + (Objects.nonNull(planet) ? planet.getPlanetName() : Strings.EMPTY) +
                ", gravity=" + gravity +
                ", radius=" + radius +
                '}';
    }

    public Double getGravity() {
        return gravity;
    }

    public Double getRadius() {
        return radius;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
