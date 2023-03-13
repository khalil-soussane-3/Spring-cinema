package com.project.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;
    private Double longitude , latitude , altitude ;
    private int nombresalles ;
    @JsonIgnore
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles ;
    @ManyToOne
    private Ville ville ;

}
