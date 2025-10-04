package com.aireya.aireya.web.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
