package planet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class PlanetDTO {

    private Integer id;
    private String name;
    private Integer distanceFromSun;
    private Double gravity;
    private Double radius;
    private GalaxyDTO galaxy;
    private Integer galaxyId;

    public PlanetDTO(Integer id, String name, Integer distanceFromSun, Double gravity, Double radius,
            GalaxyDTO galaxyDto) {
        this.id = id;
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.gravity = gravity;
        this.radius = radius;
        this.galaxy = galaxyDto;
    }

    public PlanetDTO() {
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Integer getDistanceFromSun() {
        return distanceFromSun;
    }

    @JsonSetter
    public void setDistanceFromSun(Integer distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Double getGravity() {
        return gravity;
    }

    @JsonSetter
    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Double getRadius() {
        return radius;
    }

    @JsonSetter
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Integer getId() {
        return id;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public GalaxyDTO getGalaxy() {
        return galaxy;
    }

    @JsonSetter
    public void setGalaxy(GalaxyDTO galaxy) {
        this.galaxy = galaxy;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Integer getGalaxyId() {
        return galaxyId;
    }
}
