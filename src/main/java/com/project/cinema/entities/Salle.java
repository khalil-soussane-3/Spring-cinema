package com.project.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salle {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name ;
    private int nombrePlace ;
    @ManyToOne
    private Cinema cinema ;
    @JsonIgnore
    @OneToMany(mappedBy = "salle")
    private Collection<Place> places ;
    @JsonIgnore
    @OneToMany(mappedBy = "salle")
    private Collection<Projection> projections ;
}
