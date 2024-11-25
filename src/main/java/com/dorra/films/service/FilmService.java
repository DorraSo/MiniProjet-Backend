package com.dorra.films.service;

import java.time.LocalDate;
import java.util.List;

import com.dorra.films.dto.FilmDTO;
import com.dorra.films.entities.Film;
import com.dorra.films.entities.Producteur;

public interface FilmService {

	FilmDTO saveFilm(FilmDTO f);
	FilmDTO	getFilm(Long id);
	List<FilmDTO> getAllFilms();
	FilmDTO updateFilm(FilmDTO f);
	
	
	void deleteFilm(Film f);
	 void deleteFilmById(Long id);
	
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);
	List<Film> findByNomDateSor (String nom, LocalDate dateSortie);
	List<Film> findByProducteur (Producteur producteur);
	List<Film> findByProducteurIdProduc(Long id);
	List<Film> findByOrderByNomFilmAsc();
	List<Film> trierFilmsNomsDateSortie();
	FilmDTO convertEntityToDto (Film film);
	Film convertDtoToEntity(FilmDTO filmDto);
}
