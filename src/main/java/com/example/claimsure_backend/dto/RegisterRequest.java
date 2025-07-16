package com.example.claimsure_backend.dto;

import com.example.claimsure_backend.model.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Role role;
}
