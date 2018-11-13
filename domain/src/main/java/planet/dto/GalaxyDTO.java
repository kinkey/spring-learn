package planet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class GalaxyDTO {

    private Integer id;
    private String name;

    public GalaxyDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GalaxyDTO() {
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Integer getId() {
        return id;
    }

    @JsonProperty
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
}
