package com.sapient.Airport_Application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AirportFrequency {

    @Id
    private Long  id;
    private Long airport_ref;
    private String airport_ident;
    private String type;
    private String description;
    private double frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAirport_ref() {
        return airport_ref;
    }

    public void setAirport_ref(Long airport_ref) {
        this.airport_ref = airport_ref;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public void setAirport_ident(String airport_ident) {
        this.airport_ident = airport_ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "AirportFrequency{" +
                "id=" + id +
                ", airport_ref=" + airport_ref +
                ", airport_ident='" + airport_ident + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
