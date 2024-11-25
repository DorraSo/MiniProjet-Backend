package com.dorra.films.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@Entity
public class Producteur {

	// pour indiquer le champ de clé primaire.
	@Id
	//permettre à l'ID d'être généré automatiquement.
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduc;
	
	private String nomProduc;
	private LocalDate dateNaissance;
	@JsonIgnore
	@OneToMany(mappedBy = "producteur")
	private List<Film> films;
	
	public Producteur() {
		super();
	}
	public Long getIdProduc() {
		return idProduc;
	}
	public void setIdProduc(Long idProduc) {
		this.idProduc = idProduc;
	}
	public String getNomProduc() {
		return nomProduc;
	}
	public void setNomProduc(String nomProduc) {
		this.nomProduc = nomProduc;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	
	
	
}
