package com.sapient.Airport_Application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NavAid {
    @Id
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
