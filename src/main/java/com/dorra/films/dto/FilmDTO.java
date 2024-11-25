package com.dorra.films.dto;

import java.time.LocalDate;

import com.dorra.films.entities.Producteur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO {

	/*   public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getGenreFil() {
		return genreFil;
	}
	public void setGenreFil(String genreFil) {
		this.genreFil = genreFil;
	}*/
	/*public Producteur getProducteur() {
		return producteur;
	}
	public void setProducteur(Producteur producteur) {
		this.producteur = producteur;
	}*/
	private Long idFilm;
	    private String nomFilm;
	    private LocalDate dateSortie;
	    private String genreFil;
	    private Producteur producteur;
        private String nomProduc;
		
	    
	    
	    
	    
}
	