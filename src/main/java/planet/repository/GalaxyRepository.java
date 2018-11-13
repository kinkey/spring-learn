package planet.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import planet.entity.Galaxy;

public interface GalaxyRepository extends PagingAndSortingRepository<Galaxy, Integer> {

}
