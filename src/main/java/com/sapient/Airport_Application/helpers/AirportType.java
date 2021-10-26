package com.sapient.Airport_Application.helpers;

public enum AirportType {
    SMALL_AIRPORT,
    LARGE_AIRPORT,
    MEDIUM_AIRPORT,
    BALLOONPORT,
    CLOSED,
    HELIPORT,
    SEAPLANE_BASE;

    public String smallAirport() {
        return SMALL_AIRPORT.name().toLowerCase();
    }

    public String largeAirport() {
        return LARGE_AIRPORT.name().toLowerCase();
    }

    public String mediumAirport() {
        return MEDIUM_AIRPORT.name().toLowerCase();
    }

    public String balloonport() {
        return BALLOONPORT.name().toLowerCase();
    }

    public String closed() {
        return CLOSED.name().toLowerCase();
    }

    public String heliport() {
        return HELIPORT.name().toLowerCase();
    }

    public String seaplaneBase() {
        return SEAPLANE_BASE.name().toLowerCase();
    }

}
