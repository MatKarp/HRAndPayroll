package org.karpisiewicz.repository;

import org.karpisiewicz.entity.PartitionWorkTime;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartitionWorkTimeRepository extends PagingAndSortingRepository<PartitionWorkTime, Long>{
     
}
