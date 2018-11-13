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

import planet.dto.GalaxyDTO;
import planet.service.GalaxyService;

@RestController
public class GalaxyController extends BaseRestController {

    //TODO Add validator in Galaxy Entity

    @Autowired
    private GalaxyService galaxyService;

    @GetMapping(value = "/galaxy/{id}", produces = "application/json")
    public GalaxyDTO getGalaxyDtoById(@PathVariable Integer id) {
        GalaxyDTO galaxyById = galaxyService.getGalaxyById(id);
        if (galaxyById == null) {
            return new GalaxyDTO();
        }

        return new GalaxyDTO(galaxyById.getId(), galaxyById.getName());
    }

    @PostMapping(value = "/galaxy",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<GalaxyDTO> createGalaxy(@RequestBody GalaxyDTO galaxyDTO) {
        if (galaxyDTO != null) {
            GalaxyDTO savedGalaxy = galaxyService.saveGalaxy(galaxyDTO);
            return new ResponseEntity<>(savedGalaxy, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/galaxy/{id}")
    public ResponseEntity<?> deleteGalaxyById(@PathVariable Integer id) {
        if (id != null && galaxyService.deleteGalaxy(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/galaxies")
    public ResponseEntity<List<GalaxyDTO>> getAllGalaxies() {
        List<GalaxyDTO> allGalaxies = galaxyService.getAllGalaxies();
        if (allGalaxies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allGalaxies, HttpStatus.OK);
    }

}