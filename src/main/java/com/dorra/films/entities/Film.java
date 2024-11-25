package com.dorra.films.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Film {
  	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idFilm;
	    private String nomFilm;
	    private LocalDate dateSortie;
	    private String genreFil;
	    
	    @ManyToOne
	    @JsonManagedReference
	    private Producteur producteur;
	    
	    
		public Film() {
			super();
		}
		
		
		
		public Film(String nomFilm, LocalDate dateSortie, String genreFil) {
			super();
			this.nomFilm = nomFilm;
			this.dateSortie = dateSortie;
			this.genreFil = genreFil;
		}



		public Long getIdFilm() {
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
		}



		@Override
		public String toString() {
			return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", dateSortie=" + dateSortie + ", genreFil="
					+ genreFil + "]";
		}



		public Producteur getProducteur() {
			return producteur;
		}



		public void setProducteur(Producteur producteur) {
			this.producteur = producteur;
		}
	
	
	
}
