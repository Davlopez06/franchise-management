package com.accenture.franchisemanagement.infrastructure.adapters.inbound;

import com.accenture.franchisemanagement.domain.models.Product;
import com.accenture.franchisemanagement.infrastructure.adapters.outbound.ProductRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @PostMapping
    public Mono<Product> createProduct(@Valid @RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/top-stock/franchise/{franchiseId}")
    public Flux<Product> getTopStockByFranchise(@PathVariable Long franchiseId) {
        return repository.findTopStockProductsByFranchise(franchiseId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PatchMapping("/{id}/stock")
    public Mono<Product> updateStock(@PathVariable Long id, @RequestParam int newStock) {
        return repository.findById(id)
                .flatMap(product -> {
                    product.setStock(newStock);
                    return repository.save(product);
                });
    }

    @PatchMapping("/{id}/name")
    public Mono<Product> updateName(@PathVariable Long id, @RequestParam String newName) {
        return repository.findById(id)
                .flatMap(p -> {
                    p.setName(newName);
                    return repository.save(p);
                });
    }
}