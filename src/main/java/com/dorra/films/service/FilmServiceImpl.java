package com.dorra.films.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.MatchingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorra.films.dto.FilmDTO;
import com.dorra.films.entities.Film;
import com.dorra.films.entities.Producteur;
import com.dorra.films.repos.FilmRepository;
@Service
public class FilmServiceImpl implements FilmService{

	@Autowired
	FilmRepository filmRepository;
	@Autowired	
    ModelMapper modelMapper;
	
	@Override
	public FilmDTO saveFilm(FilmDTO f) {
		return convertEntityToDto(filmRepository.save(convertDtoToEntity(f)));
	}

	@Override
	public FilmDTO updateFilm(FilmDTO f) {
		return convertEntityToDto(filmRepository.save(convertDtoToEntity(f)));
	}

	@Override
	public void deleteFilm(Film f) {
		 filmRepository.delete(f);
		
	}

	@Override
	public void deleteFilmById(Long id) {
		filmRepository.deleteById(id);
		
	}

	@Override
	public FilmDTO getFilm(Long id) {
		return convertEntityToDto( filmRepository.findById(id).get());
	}

	@Override
	public List<FilmDTO> getAllFilms() {
		return filmRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	@Override
	public List<Film> findByNomFilm(String nom) {
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return filmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomDateSor(String nom, LocalDate dateSortie) {
		return filmRepository.findByNomDateSor(nom, dateSortie);
	}

	@Override
	public List<Film> findByProducteur(Producteur producteur) {
		return filmRepository.findByProducteur(producteur);
	}

	@Override
	public List<Film> findByProducteurIdProduc(Long id) {
		return filmRepository.findByProducteurIdProduc(id);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return filmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmsNomsDateSortie() {
		return filmRepository.trierFilmsNomsDateSortie();
	}

	@Override
	public FilmDTO convertEntityToDto(Film film) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		FilmDTO filmDTO = modelMapper.map(film, FilmDTO.class);
		 return filmDTO;
		 
		
		
		
		/*FilmDTO filmDTO = new FilmDTO();
		 filmDTO.setIdFilm(f.getIdFilm());
		 filmDTO.setNomFilm(f.getNomFilm());
		 filmDTO.setDateSortie(f.getDateSortie()); 
		//filmDTO.setProducteur(f.getProducteur()); 

		return filmDTO;*/
		/*return FilmDTO.builder()
	            .idFilm(f.getIdFilm())
	            .nomFilm(f.getNomFilm())
	            .dateSortie(f.getDateSortie())
	            .genreFil(f.getGenreFil())
	            //Pour affichier le nom du producteur :
	            //.nomProduc(f.getProducteur().getNomProduc())
	            .producteur(f.getProducteur())
	            .build();*/


	}

	@Override
	public Film convertDtoToEntity(FilmDTO filmDto) {
		Film film = new Film();
		film = modelMapper.map(filmDto, Film.class);
		return film;
		
		/*Film film = new Film();
		film.setIdFilm(filmDto.getIdFilm());
		film.setNomFilm(filmDto.getNomFilm());
		film.setDateSortie(filmDto.getDateSortie());
		film.setGenreFil(filmDto.getGenreFil());
		film.setProducteur(filmDto.getProducteur()); 
		return film;*/
	}

}
