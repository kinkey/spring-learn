package planet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import planet.dto.GalaxyDTO;
import planet.entity.Galaxy;
import planet.repository.GalaxyRepository;

@Service
public class GalaxyService {

    @Autowired
    private GalaxyRepository galaxyRepository;

    @Transactional(readOnly = true)
    public GalaxyDTO getGalaxyById(Integer id) {
        Optional<Galaxy> galaxyOptional = galaxyRepository.findById(id);
        if (galaxyOptional.isPresent()) {
            return new GalaxyDTO(galaxyOptional.get().getId(), galaxyOptional.get().getName());
        }

        return null;
    }

    @Transactional(readOnly = true)
    public List<GalaxyDTO> getAllGalaxies() {
        Iterable<Galaxy> all = galaxyRepository.findAll();
        List<GalaxyDTO> galaxyDTOS = new ArrayList<>();
        for (Galaxy g : all) {
            galaxyDTOS.add(new GalaxyDTO(g.getId(), g.getName()));
        }
        return galaxyDTOS;
    }

    @Transactional
    public GalaxyDTO saveGalaxy(GalaxyDTO galaxyDTO) {
        Galaxy galaxy = new Galaxy();
        galaxy.setName(galaxyDTO.getName());

        galaxyRepository.save(galaxy);

        return new GalaxyDTO(galaxy.getId(), galaxy.getName());
    }

    public boolean deleteGalaxy(Integer id) {
        boolean galaxyExists = galaxyRepository.existsById(id);
        if (galaxyExists) {
            galaxyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}