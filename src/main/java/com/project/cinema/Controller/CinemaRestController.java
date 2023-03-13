package com.project.cinema.Controller;

import com.project.cinema.dao.*;
import com.project.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository ;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private VilleRepository villeRepository ;
    @Autowired
    private SalleRepository salleRepository ;
    @Autowired
    private PlaceRepository placeRepository ;
    @Autowired
    private SeanceRepository seanceRepository ;
    @Autowired
    private ProjectionRepository projectionRepository ;
    @Autowired
    private TicketRepository ticketRepository ;

    @GetMapping("/listVilles")
    public List<Ville> villes(){
        return villeRepository.findAll();
    }
    @GetMapping("/listCinemas")
    public List<Cinema> cinemas(){
        return cinemaRepository.findAll();
    }
    @GetMapping("/listSalles")
    public List<Salle> salles(){
        return salleRepository.findAll();
    }

    @GetMapping("/listPlace")
    public List<Place> places(){
        return placeRepository.findAll();
    }

    @GetMapping("/listSeances")
    public List<Seance> seances(){
        return seanceRepository.findAll();
    }

    @GetMapping("/listFilms")
    public List<Film> films(){

        return filmRepository.findAll();
    }

    @GetMapping("/listProjection")
    public List<Projection> projections(){
        return projectionRepository.findAll();
    }

    @GetMapping("/listTickets")
    public List<Ticket> tickets(){
        return ticketRepository.findAll();
    }

}
