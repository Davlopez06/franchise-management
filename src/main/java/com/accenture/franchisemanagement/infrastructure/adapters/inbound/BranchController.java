package com.accenture.franchisemanagement.infrastructure.adapters.inbound;

import com.accenture.franchisemanagement.domain.models.Branch;
import com.accenture.franchisemanagement.infrastructure.adapters.outbound.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchRepository repository;

    @PostMapping
    public Mono<Branch> createBranch(@RequestBody Branch branch) {
        return repository.save(branch);
    }

    @GetMapping("/franchise/{franchiseId}")
    public Flux<Branch> getBranchesByFranchise(@PathVariable Long franchiseId) {
        return repository.findByFranchiseId(franchiseId);
    }

    @PatchMapping("/{id}/name")
    public Mono<Branch> updateName(@PathVariable Long id, @RequestParam String newName) {
        return repository.findById(id)
                .flatMap(b -> {
                    b.setName(newName);
                    return repository.save(b);
                });
    }
}