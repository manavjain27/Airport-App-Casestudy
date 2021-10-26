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
public class NavAid {
    @Id
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
}
