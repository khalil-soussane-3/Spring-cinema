package com.project.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title ;
    private double duree ;
    private String realisateur ;
    private String description ;
    private String photo ;
    private Date dateSortie ;
    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections ;

}
