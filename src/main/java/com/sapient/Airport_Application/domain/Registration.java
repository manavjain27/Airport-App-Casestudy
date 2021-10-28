package com.sapient.Airport_Application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Registration {

    @Id
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;
}
