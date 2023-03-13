package com.project.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id ;
    private Date dateProjection ;
    private Double prix ;
    @JsonIgnore
    @ManyToOne
    private Salle salle ;
    @JsonIgnore
    @ManyToOne
    private Film film ;
    @JsonIgnore
    @OneToMany(mappedBy = "projection")
    private Collection<Ticket> tickets ;

    @JsonIgnore
    @ManyToOne
    private Seance seance ;
}
