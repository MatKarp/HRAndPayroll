package org.karpisiewicz.repository;

import org.karpisiewicz.entity.Schedule;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, Long>{
     
}
