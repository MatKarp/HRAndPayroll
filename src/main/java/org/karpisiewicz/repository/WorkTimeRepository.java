package org.karpisiewicz.repository;

import org.karpisiewicz.entity.WorkTime;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeRepository extends PagingAndSortingRepository<WorkTime, Long>{
     
}
