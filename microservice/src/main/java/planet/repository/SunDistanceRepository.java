package planet.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import planet.entity.SunDistance;

public interface SunDistanceRepository extends PagingAndSortingRepository<SunDistance, Integer> {

}