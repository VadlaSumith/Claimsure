package com.example.claimsure_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private String description;

    private Double amount;

    private LocalDate submissionDate;

    private String status;  // PENDING, APPROVED, REJECTED

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User submittedBy;
}
