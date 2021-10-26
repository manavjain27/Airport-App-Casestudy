package com.sapient.Airport_Application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Country {
    @Id
    private Long id;
    private String code;
    private String name;
    private String continent;

}
