package com.sapient.Airport_Application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @NotNull
    private String email;
    @NotNull
    private String password;
}

