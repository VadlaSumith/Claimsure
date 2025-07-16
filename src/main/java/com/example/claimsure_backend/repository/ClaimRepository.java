package com.example.claimsure_backend.repository;

import com.example.claimsure_backend.model.Claim;
import com.example.claimsure_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findBySubmittedBy(User user);
    List<Claim> findByStatus(String status);
}
