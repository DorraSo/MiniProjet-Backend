package com.dorra.films.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dorra.films.entities.Producteur;
import com.dorra.films.repos.ProducteurRepository;

@RestController
@RequestMapping("/api/prod")
@CrossOrigin("*")
public class ProducteurRESTController {
	@Autowired
	ProducteurRepository producteurRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Producteur> getAllProducteurs()
	{
	return producteurRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Producteur getProducteurById(@PathVariable("id") Long id) {
	return producteurRepository.findById(id).get();
	}

}
