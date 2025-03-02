package com.rest.countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.countries.model.Country;
import com.rest.countries.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public List<String> getCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping("/countries/{name}")
	public Country getCountryByName(@PathVariable String name) {
		return countryService.getCountryByName(name);
	}

	// Endpoint to get countries by continent (region)
	@GetMapping("/countries/continent/{continent}")
	public List<String> getCountriesByContinent(@PathVariable String continent) {
		return countryService.getCountriesByContinent(continent);
	}

	// Endpoint to get all countries sorted by name, population, or area
	@GetMapping("/countries/sorted")
	public List<String> getSortedCountries(@RequestParam(name = "sortBy", defaultValue = "name") String sortBy) {
		return countryService.getSortedCountries(sortBy);
	}
}
