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
public class Place {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int numero ;
    private double longitude , latitude , altitude ;
    @ManyToOne
    private Salle salle;
    @JsonIgnore
    @OneToMany(mappedBy = "place")
    private Collection<Ticket> tickets  ;

}
