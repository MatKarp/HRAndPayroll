package org.karpisiewicz.repository;

import org.karpisiewicz.entity.Day;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends PagingAndSortingRepository<Day, Long>{
     
}
