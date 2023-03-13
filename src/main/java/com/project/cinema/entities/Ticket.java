package com.project.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nomClient ;
    private Double prix ;
    @GeneratedValue
    private int codePayement ;
    private boolean reserve ;
    @ManyToOne
    private Place place ;
    @ManyToOne
    private Projection projection ;

}
