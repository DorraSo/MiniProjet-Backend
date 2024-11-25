package com.dorra.films.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dorra.films.dto.FilmDTO;
import com.dorra.films.entities.Film;
import com.dorra.films.service.FilmService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController {
	
    @Autowired
    FilmService filmService;
    
    // Méthode pour obtenir tous les films
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmDTO> getAllFilms() {
        return filmService.getAllFilms();
    }

    // Méthode pour obtenir un film par ID
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmDTO getFilmById(@PathVariable("id") Long id) {
        return filmService.getFilm(id);
    }

    // Méthode pour créer un film (POST)  ---- l'ajout ne marche paas****
    @RequestMapping(method = RequestMethod.POST)
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO) {
         return filmService.saveFilm(filmDTO);
    }
    
    //-----------l'update ne marche paas****
    @RequestMapping(method = RequestMethod.PUT)
    public FilmDTO updateFilm(@RequestBody FilmDTO filmDTO) {
    return filmService.updateFilm(filmDTO);
    }

    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable("id") Long id)
    {
    	filmService.deleteFilmById(id);
    }

    @RequestMapping(value="/filsproduc/{idProduc}",method = RequestMethod.GET)
    public List<Film> getFilmsByProducId(@PathVariable("idProduc") Long idProduc) {
    return filmService.findByProducteurIdProduc(idProduc);
    }
    
    @RequestMapping(value="/filsByName/{nom}",method = RequestMethod.GET)
    public List<Film> findByNomFilmContains(@PathVariable("nom") String nom) {
    return filmService.findByNomFilmContains(nom);
    }
    

}
