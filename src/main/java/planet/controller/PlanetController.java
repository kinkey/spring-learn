package planet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import planet.dto.PlanetDTO;
import planet.service.PlanetService;

@RestController
public class PlanetController extends BaseRestController {

    //TODO Add validator in Planet Entity

    @Autowired
    private PlanetService planetService;

    @GetMapping(value = "/planet/{id}", produces = "application/json")
    public PlanetDTO getPlanetDtoById(@PathVariable Integer id) {
        PlanetDTO planetById = planetService.getPlanetById(id);
        if (planetById == null) {
            return new PlanetDTO();
        }

        return planetById;
    }

    @PostMapping(value = "/planet",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<PlanetDTO> createPlanet(@RequestBody PlanetDTO planetDTO) {
        if (planetDTO != null) {
            PlanetDTO savedPlanet = planetService.savePlanet(planetDTO);
            return new ResponseEntity<>(savedPlanet, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/planet/{id}")
    public ResponseEntity<?> deletePlanetById(@PathVariable Integer id) {
        if (id != null && planetService.deletePlanet(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/planets")
    public ResponseEntity<List<PlanetDTO>> getAllGalaxies() {
        List<PlanetDTO> allGalaxies = planetService.findAllPlanets();
        if (allGalaxies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allGalaxies, HttpStatus.OK);
    }
}