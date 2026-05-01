package com.accenture.franchisemanagement.infrastructure.adapters.outbound;

import com.accenture.franchisemanagement.domain.models.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    
    @Query("SELECT p.* FROM products p " +
           "JOIN branches b ON p.branch_id = b.id " +
           "WHERE b.franchise_id = :franchiseId " +
           "AND p.stock = (SELECT MAX(p2.stock) FROM products p2 WHERE p2.branch_id = b.id)")
    Flux<Product> findTopStockProductsByFranchise(Long franchiseId);
}