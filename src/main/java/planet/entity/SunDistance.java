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
@Table(name = "sun_distance")
public class SunDistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "planetId")
    @JsonBackReference
    private Planet planet;

    private Integer distance;

    @Override public String toString() {
        return "SunDistance{" +
                "id=" + id +
                ", planet=" + (Objects.nonNull(planet) ? planet.getPlanetName() : Strings.EMPTY) +
                ", distance=" + distance +
                '}';
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public Planet getPlanet() {
        return planet;
    }
}
