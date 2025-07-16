package com.example.claimsure_backend.controller;

import com.example.claimsure_backend.model.*;
import com.example.claimsure_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimRepository claimRepo;
    private final UserRepository userRepo;

    @PostMapping("/submit")
    public ResponseEntity<?> submitClaim(@RequestBody Claim claim, Authentication auth) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();
        claim.setSubmittedBy(user);
        claim.setSubmissionDate(LocalDate.now());
        claim.setStatus("PENDING");
        return ResponseEntity.ok(claimRepo.save(claim));
    }

    @GetMapping("/user")
    public List<Claim> getMyClaims(Authentication auth) {
        User user = userRepo.findByUsername(auth.getName()).orElseThrow();
        return claimRepo.findBySubmittedBy(user);
    }

    @GetMapping("/pending")
    public List<Claim> getPendingClaims() {
        return claimRepo.findByStatus("PENDING");
    }

    @PostMapping("/review/{id}")
    public ResponseEntity<?> reviewClaim(@PathVariable Long id, @RequestParam String action) {
        Claim claim = claimRepo.findById(id).orElseThrow();
        if (action.equalsIgnoreCase("approve") || action.equalsIgnoreCase("reject")) {
            claim.setStatus(action.toUpperCase());
            return ResponseEntity.ok(claimRepo.save(claim));
        }
        return ResponseEntity.badRequest().body("Invalid action");
    }
}
