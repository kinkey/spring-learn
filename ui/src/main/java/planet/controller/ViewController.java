package planet.controller;

import static planet.entity.Galaxy.Resource.GALAXIES;
import static planet.entity.Planet.Resource.PLANET;
import static planet.entity.Planet.Resource.PLANETS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import planet.dto.GalaxyDTO;
import planet.dto.PlanetDTO;
import planet.entity.Galaxy;

@Controller
public class ViewController extends BaseViewController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = PLANET)
    public String planets(Model model) {
        ResponseEntity<List<PlanetDTO>> planets = restTemplate
                .exchange(PLANETS,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<PlanetDTO>>() {
                        });

        List<PlanetDTO> allPlanets = planets.getBody();

        model.addAttribute("planets", allPlanets);

        return "planets";
    }

    @GetMapping(value = GALAXIES)
    public String galaxies(Model model) {
        ResponseEntity<List<GalaxyDTO>> galaxies = restTemplate
                .exchange(GALAXIES,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GalaxyDTO>>() {
                        });

        model.addAttribute("galaxies", galaxies.getBody());

        return "galaxies";
    }
}