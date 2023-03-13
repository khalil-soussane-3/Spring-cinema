package com.project.cinema.service;

import com.project.cinema.dao.*;
import com.project.cinema.entities.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaService implements ICinemaInitService {

    @Autowired
    private VilleRepository villeRepository ;
    @Autowired
    private CinemaRepository cinemaRepository ;
    @Autowired
    private SalleRepository salleRepository ;
    @Autowired
    private PlaceRepository placeRepository ;
    @Autowired
    private SeanceRepository seanceRepository ;
    @Autowired
    private FilmRepository filmRepository ;
    @Autowired
    private ProjectionRepository projectionRepository ;
    @Autowired
    private TicketRepository ticketRepository ;

    @Override
    public void initVilles() {
        Stream.of("casablanca","marrakech","tanger","rabat").forEach(nameville->{
            Ville ville = new Ville();
            ville.setName(nameville);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("megarama","imax","chahrazad","founon","Dawliz").forEach(nameCinema->{
                Cinema cinema = new Cinema();
                cinema.setName(nameCinema);
                cinema.setNombresalles(3 +(int)(Math.random()*7));
                cinema.setVille(v);
                cinemaRepository.save(cinema) ;
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(c->{
            for(int i = 0 ; i< c.getNombresalles();i++){
                Salle salle = new Salle() ;
                salle.setName("Salle"+(i+1));
                salle.setCinema(c);
                salle.setNombrePlace(15+(int)(Math.random()*20));
                salleRepository.save(salle) ;
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for(int i=0;i< salle.getNombrePlace();i++){
                Place place = new Place() ;
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateformat = new SimpleDateFormat("HH:mm") ;
        Stream.of("12:00","15:00","17:00","20:00","22:00").forEach(s->{
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(dateformat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


        });
    }

    @Override
    public void initFilms() {
        double[] duree = new double []{1,1.5,2,3,4,5};
        Stream.of("Game of Thrones","breaking bad","the house of dragons","elChapo","YOU","SpiderMan","Iron Man")
                .forEach(f->{
                    Film film = new Film() ;
                    film.setTitle(f);
                    film.setDuree(duree[new Random().nextInt(duree.length)]);
                    film.setPhoto(f.replaceAll(" ",""));
                    filmRepository.save(film);
                });
    }

    @Override
    public void initProjections() {
        double [] prices = new double[] {30,40,50,60,70,80,90,100} ;
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film ->{
                        seanceRepository.findAll().forEach(seance ->{
                            Projection projection = new Projection();
                            projection.setDateProjection(new Date());
                            projection.setFilm(film);
                            projection.setPrix(prices[new Random().nextInt(prices.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(p ->{
            p.getSalle().getPlaces().forEach(place ->{
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(p.getPrix());
                ticket.setProjection(p);
                ticket.setReserve(false);
                ticketRepository.save(ticket);
            });
        });
    }
}
