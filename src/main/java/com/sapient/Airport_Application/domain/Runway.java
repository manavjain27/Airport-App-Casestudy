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
public class Runway {
    @Id
    private Long  id;
    private Long airport_ref;
    private String airport_ident;
    private Long length_ft;
    private Long width_ft;
    private int lighted;
    private int closed;

}
