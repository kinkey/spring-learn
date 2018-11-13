package planet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import planet.dto.GalaxyDTO;
import planet.dto.PlanetDTO;
import planet.service.GalaxyService;
import planet.service.PlanetService;

@Controller
public class ViewController extends BaseViewController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private GalaxyService galaxyService;

    @GetMapping(value = "/planets")
    public String planets(Model model) {
        List<PlanetDTO> allPlanets = planetService.findAllPlanets();

        model.addAttribute("planets", allPlanets);

        return "planets";
    }

    @GetMapping(value = "/galaxies")
    public String galaxies(Model model) {
        List<GalaxyDTO> allGalaxies = galaxyService.getAllGalaxies();

        model.addAttribute("galaxies", allGalaxies);

        return "galaxies";
    }
}