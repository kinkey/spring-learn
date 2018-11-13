package planet.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import planet.entity.Planet;

public interface PlanetRepository extends PagingAndSortingRepository<Planet, Integer> {

}