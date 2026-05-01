package com.accenture.franchisemanagement.infrastructure.adapters.outbound;

import com.accenture.franchisemanagement.domain.models.Franchise;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends ReactiveCrudRepository<Franchise, Long> {
}