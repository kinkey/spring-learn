package planet.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import planet.entity.PlanetAttribute;

public interface PlanetAttributeRepository extends PagingAndSortingRepository<PlanetAttribute, Integer> {

}