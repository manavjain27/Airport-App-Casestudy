package com.sapient.Airport_Application.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Airport {

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
