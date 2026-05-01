package com.accenture.franchisemanagement.infrastructure.adapters.inbound;

import com.accenture.franchisemanagement.domain.models.Franchise;
import com.accenture.franchisemanagement.infrastructure.adapters.outbound.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseRepository repository;

    @GetMapping
    public Flux<Franchise> getAllFranchises() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Franchise> createFranchise(@RequestBody Franchise franchise) {
        return repository.save(franchise);
    }

    @PatchMapping("/{id}/name")
    public Mono<Franchise> updateName(@PathVariable Long id, @RequestParam String newName) {
        return repository.findById(id)
                .flatMap(f -> {
                    f.setName(newName);
                    return repository.save(f);
                });
    }
}