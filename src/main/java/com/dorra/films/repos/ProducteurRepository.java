package com.dorra.films.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dorra.films.entities.Producteur;

@RepositoryRestResource(path = "prod")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface ProducteurRepository extends JpaRepository<Producteur, Long>{

}
