package planet.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import planet.dto.GalaxyDTO;
import planet.entity.Galaxy;
import planet.repository.GalaxyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class GalaxyServiceTest {

    private String GALAXY_EXPECTED_NAME = "test_name";
    private Integer GALAXY_EXPECTED_ID = 5;

    @InjectMocks
    private GalaxyService galaxyService;

    @Mock
    private GalaxyRepository galaxyRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnExpectedGalaxy() {
        when(galaxyRepository.findById(GALAXY_EXPECTED_ID)).thenReturn(Optional.of(createTestGalaxyObject()));

        GalaxyDTO shouldBeCorrectGalaxy = galaxyService.getGalaxyById(GALAXY_EXPECTED_ID);

        Assert.assertEquals(GALAXY_EXPECTED_NAME, shouldBeCorrectGalaxy.getName());
    }

    @Test
    public void shouldReturnNull() {
        when(galaxyRepository.findById(GALAXY_EXPECTED_ID)).thenReturn(Optional.empty());

        GalaxyDTO shouldBeNull = galaxyService.getGalaxyById(GALAXY_EXPECTED_ID);

        Assert.assertEquals(null, shouldBeNull);
    }

    @Test
    public void shouldReturnMultipleGalaxies() {
        int expectedSize = 2;

        List<Galaxy> galaxies = new ArrayList<>();
        galaxies.add(createTestGalaxyObject());
        galaxies.add(createTestGalaxyObject());

        when(galaxyRepository.findAll()).thenReturn(galaxies);

        List<GalaxyDTO> allGalaxies = galaxyService.getAllGalaxies();

        Assert.assertEquals(expectedSize, allGalaxies.size());
        Assert.assertEquals(GALAXY_EXPECTED_NAME, allGalaxies.get(0).getName());
        Assert.assertEquals(GALAXY_EXPECTED_NAME, allGalaxies.get(1).getName());
    }

    @Test
    public void deleteGalaxyFoundById() {
        Galaxy expectedObject = createTestGalaxyObject();
        when(galaxyRepository.existsById(GALAXY_EXPECTED_ID)).thenReturn(true);

        Boolean shouldBeTrue = galaxyService.deleteGalaxy(GALAXY_EXPECTED_ID);

        Assert.assertEquals(Boolean.TRUE, shouldBeTrue);
    }

    @Test
    public void deleteGalaxyNotFoundById() {
        when(galaxyRepository.existsById(GALAXY_EXPECTED_ID)).thenReturn(false);

        Boolean shouldBeFalse = galaxyService.deleteGalaxy(GALAXY_EXPECTED_ID);

        Assert.assertEquals(Boolean.FALSE, shouldBeFalse);
    }

    private Galaxy createTestGalaxyObject() {
        Galaxy galaxy = new Galaxy();
        galaxy.setName(GALAXY_EXPECTED_NAME);
        galaxy.setId(GALAXY_EXPECTED_ID);
        return galaxy;
    }
}
