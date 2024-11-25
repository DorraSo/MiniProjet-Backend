package com.dorra.films;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dorra.films.entities.Film;
import com.dorra.films.entities.Producteur;
import com.dorra.films.repos.FilmRepository;

@SpringBootTest
class FilmsApplicationTests {

	@Autowired
	private FilmRepository filmRepository;
	@Test
	public void testCreateFilm() {
	Film fil = new Film("Titanic ",LocalDate.of(1997, 12, 19),"action");
	filmRepository.save(fil);
	}

	
	@Test
	public void testFindFilm()
	{
		Film f = filmRepository.findById(1L).get();
	System.out.println(f);
	}
	
	@Test
	public void testUpdateProduit()
	{
	Film f = filmRepository.findById(1L).get();
	f.setGenreFil("Suspence");
	filmRepository.save(f);
	}
	
	@Test
	public void testDeleteFilm()
	{
	filmRepository.deleteById(1L);;
	}

	@Test
	public void testListerAllFilms()
	{
	List<Film> films   = filmRepository.findAll();
	for (Film f : films)
	{
	System.out.println(f);
	}
	
	}

	
	
	@Test
	public void testFindFilmByNom()
	{
		List<Film>  fils = filmRepository.findByNomFilm("The Tourist ");
		for (Film f : fils)
		{
		System.out.println(f);
		}
	}
	
	
	@Test
	public void testFindFilmByNomContains ()
	{
	List<Film> fils=filmRepository.findByNomFilmContains("a");
	for (Film f : fils)
	{
	System.out.println(f);
	}
	
	}
	
	
	@Test
	public void testfindByNomDateSor()
	{
		List<Film> fils=filmRepository.findByNomDateSor("After ",LocalDate.of(1997, 10, 19));
		for (Film f : fils)
		{
		System.out.println(f);
		}
		
	}

	
	
	@Test
	public void testfindByProducteur()
	{
	Producteur produc = new Producteur();
	produc.setIdProduc(3L); 
	List<Film> producs = filmRepository.findByProducteur(produc);
	for (Film f : producs)
	{
	System.out.println(f);
	}
	}
	
	
	
	@Test
	public void findByProducteurIdProdu()
	{
	List<Film> producs =filmRepository.findByProducteurIdProduc(4L);
	for (Film f: producs)
	{
	System.out.println(f);
	}
	 }
	
	
	
	@Test
	public void testfindByOrderBynomFilmAsc()
	{
	List<Film> producs =filmRepository.findByOrderByNomFilmAsc();
	for (Film f : producs)
	{
	System.out.println(f);
	}
	}
	
	
	@Test
	public void testTrierFilmsNomsDateSortie() {
	    List<Film> producs = filmRepository.trierFilmsNomsDateSortie();
	    for (Film f : producs) {
	        System.out.println(f);
	    }
	}

	
	
	
}
