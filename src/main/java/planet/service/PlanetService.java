package planet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planet.dto.GalaxyDTO;
import planet.dto.PlanetDTO;
import planet.entity.Galaxy;
import planet.entity.Planet;
import planet.entity.PlanetAttribute;
import planet.entity.SunDistance;
import planet.repository.GalaxyRepository;
import planet.repository.PlanetRepository;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private GalaxyRepository galaxyRepository;

    public PlanetDTO savePlanet(PlanetDTO planetDTO) {
        Planet planet = new Planet();
        planet.setPlanetName(planetDTO.getName());

        PlanetAttribute planetAttribute = new PlanetAttribute();
        planetAttribute.setRadius(planetDTO.getRadius());
        planetAttribute.setGravity(planetDTO.getGravity());

        SunDistance sunDistance = new SunDistance();
        sunDistance.setDistance(planetDTO.getDistanceFromSun());

        planet.setPlanetAttribute(planetAttribute);
        planetAttribute.setPlanet(planet);

        sunDistance.setPlanet(planet);
        planet.setSunDistance(sunDistance);

        if (planetDTO.getGalaxyId() != null) {
            Optional<Galaxy> galaxyOptional = galaxyRepository.findById(planetDTO.getGalaxyId());
            if (galaxyOptional.isPresent()) {
                Galaxy galaxy = galaxyOptional.get();
                List<Planet> planets = new ArrayList<Planet>();
                planets.add(planet);

                planet.setGalaxy(galaxy);
                galaxy.setPlanetList(planets);
            }
        }

        Planet save = planetRepository.save(planet);

        GalaxyDTO galaxyDTO = new GalaxyDTO(save.getGalaxy().getId(),
                save.getGalaxy().getName());

        return new PlanetDTO(save.getId(), save.getPlanetName(), save.getSunDistance().getDistance(),
                save.getGravity(), save.getRadius(), galaxyDTO);
    }

    public List<PlanetDTO> findAllPlanets() {
        Iterable<Planet> all = planetRepository.findAll();
        List<PlanetDTO> planetDTOS = new ArrayList<>();

        for (Planet p : all) {
            GalaxyDTO galaxyDTO = null;
            if (p.getGalaxy() != null) {
                galaxyDTO = new GalaxyDTO();
                galaxyDTO.setId(p.getGalaxy().getId());
                galaxyDTO.setName(p.getGalaxy().getName());
            }
            planetDTOS.add(new PlanetDTO(
                    p.getId(), p.getPlanetName(), p.getSunDistance().getDistance(),
                    p.getGravity(), p.getRadius(), galaxyDTO));
        }

        return planetDTOS;
    }

    public PlanetDTO getPlanetById(Integer id) {
        Optional<Planet> planetOptional = planetRepository.findById(id);
        if (planetOptional.isPresent()) {
            Planet planet = planetOptional.get();
            GalaxyDTO galaxyDTO = new GalaxyDTO();
            galaxyDTO.setId(planet.getGalaxy().getId());
            galaxyDTO.setName(planet.getGalaxy().getName());

            return new PlanetDTO(
                    planet.getId(), planet.getPlanetName(), planet.getSunDistance().getDistance(),
                    planet.getGravity(), planet.getRadius(), galaxyDTO);
        }

        return null;
    }

    public boolean deletePlanet(Integer id) {
        boolean planetExists = planetRepository.existsById(id);
        if (planetExists) {
            planetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
