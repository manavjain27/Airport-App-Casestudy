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
public class AirportFrequency {

    @Id
    private Long  id;
    private Long airport_ref;
    private String airport_ident;
    private String type;
    private String description;
    private double frequency;
}
