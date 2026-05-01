package com.accenture.franchisemanagement.infrastructure.adapters.outbound;

import com.accenture.franchisemanagement.domain.models.Branch;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BranchRepository extends ReactiveCrudRepository<Branch, Long> {
    Flux<Branch> findByFranchiseId(Long franchiseId);
}