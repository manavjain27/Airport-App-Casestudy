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
public class Airport {

    @Id
    private Long  id;
    private String name;
    private String ident;
    private String type;
    private double latitude;
    private double longitude;
    private String countryName;
    private String regionName;
    private String municipality;
    private Long elevation;

}
