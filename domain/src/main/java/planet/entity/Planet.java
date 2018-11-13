package planet.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planet")
    @JsonManagedReference
    private PlanetAttribute planetAttribute;

    @ManyToOne
    @JoinColumn(name = "galaxyId")
    @JsonBackReference
    private Galaxy galaxy;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planet")
    @JsonManagedReference
    private SunDistance sunDistance;

    private String planetName;

    @Override public String toString() {
        return "Planet{" +
                "id=" + id +
                ", radius=" + (Objects.nonNull(planetAttribute) ? planetAttribute.getRadius() : Strings.EMPTY) +
                ", gravity=" + (Objects.nonNull(planetAttribute) ? planetAttribute.getGravity() : Strings.EMPTY) +
                ", galaxy=" + (Objects.nonNull(planetAttribute) ? galaxy.getName() : Strings.EMPTY) +
                ", sunDistance=" + (Objects.nonNull(sunDistance) ? sunDistance.getDistance() : Strings.EMPTY) +
                ", planetName='" + planetName + '\'' +
                '}';
    }

    public String getPlanetName() {
        return planetName;
    }

    public Double getGravity() {
        return (Objects.nonNull(planetAttribute) ? planetAttribute.getGravity() : Double.NaN);
    }

    public Double getRadius() {
        return (Objects.nonNull(planetAttribute) ? planetAttribute.getRadius() : Double.NaN);
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setPlanetAttribute(PlanetAttribute planetAttribute) {
        this.planetAttribute = planetAttribute;
    }

    public Integer getId() {
        return id;
    }

    public SunDistance getSunDistance() {
        return sunDistance;
    }

    public void setSunDistance(SunDistance sunDistance) {
        this.sunDistance = sunDistance;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public static class Resource {

        public static final String PLANET = "planet";
        public static final String PLANETS = "planets";
    }
}