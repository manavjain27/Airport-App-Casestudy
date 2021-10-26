package com.sapient.Airport_Application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Runway {
    @Id
    private Long  id;
    private Long airport_ref;
    private String airport_ident;
    private Long length_ft;
    private Long width_ft;
    private int lighted;
    private int closed;

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

    public Long getLength_ft() {
        return length_ft;
    }

    public void setLength_ft(Long length_ft) {
        this.length_ft = length_ft;
    }

    public Long getWidth_ft() {
        return width_ft;
    }

    public void setWidth_ft(Long width_ft) {
        this.width_ft = width_ft;
    }

    public int getLighted() {
        return lighted;
    }

    public void setLighted(int lighted) {
        this.lighted = lighted;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Runway{" +
                "id=" + id +
                ", airport_ref=" + airport_ref +
                ", airport_ident='" + airport_ident + '\'' +
                ", length_ft=" + length_ft +
                ", width_ft=" + width_ft +
                ", lighted=" + lighted +
                ", closed=" + closed +
                '}';
    }
}
