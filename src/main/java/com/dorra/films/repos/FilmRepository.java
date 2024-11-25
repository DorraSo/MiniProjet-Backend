package com.dorra.films.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dorra.films.entities.Film;
import com.dorra.films.entities.Producteur;

@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> {
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom); 
	
	/*@Query("select f from Film f where f.nomFilm like %?1 and f.dateSortie > ?2")
	List<Film> findByNomDateSor (String nom, LocalDate dateSor);*/
	
	
	@Query("SELECT f FROM Film f WHERE f.nomFilm LIKE %:nom AND f.dateSortie > :dateSortie")
	List<Film> findByNomDateSor(@Param("nom") String nom, @Param("dateSortie") LocalDate dateSortie);

	
	@Query("select f from Film f where f.producteur = ?1")
	List<Film> findByProducteur (Producteur producteur);
	
	List<Film> findByProducteurIdProduc(Long id);

	
	List<Film> findByOrderByNomFilmAsc();
	 
	@Query("select f from Film f order by f.nomFilm ASC, f.dateSortie DESC")
	List<Film> trierFilmsNomsDateSortie();
}
