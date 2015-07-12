package org.karpisiewicz.repository;

import org.karpisiewicz.entity.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends PagingAndSortingRepository<Contract, Long>{
     
}
