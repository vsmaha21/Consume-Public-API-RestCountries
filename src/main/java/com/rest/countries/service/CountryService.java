package com.rest.countries.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.countries.model.Country;

import jakarta.annotation.PostConstruct;

@Service
public class CountryService {

	List<Country> countries;

	@Autowired
	RestTemplate restTemplate;

	@PostConstruct
	public void setAllCountries() {
		String url = "https://restcountries.com/v3.1/all";
		countries = Arrays.asList(restTemplate.getForObject(url, Country[].class));

	}

	public List<String> getAllCountries() {
		// TODO Auto-generated method

		if (countries != null) {
			return countries.stream().map(a -> a.getName().getCommon()).collect(Collectors.toList());
		}
		return null;
	}

	public Country getCountryByName(String name) {
		// TODO Auto-generated method stub
		String url = "https://restcountries.com/v3.1/name/" + name;
		Country[] countries = restTemplate.getForObject(url, Country[].class); // The API returns an array of countries,
																				// even for a single country.

		if (countries != null && countries.length > 0) {
			return countries[0]; // Return the first country in the array
		}
		return null; // In case no country was found
	}

	public List<String> getCountriesByContinent(String continent) {
		// TODO Auto-generated method stub

		String url = "https://restcountries.com/v3.1/region/" + continent;
		Country[] countries = restTemplate.getForObject(url, Country[].class);

		if (countries != null) {
			return Arrays.asList(countries).stream().map(a -> a.getName().getCommon()).collect(Collectors.toList());
		}
		return null;
	}

	public List<String> getSortedCountries(String sortBy) {
		// TODO Auto-generated method stub

		if (countries == null || countries.isEmpty()) {
			return null;
		}

		switch (sortBy.toLowerCase()) {
		case "name":
			return countries.stream().map(c -> c.getName().getCommon()).sorted((c1, c2) -> c1.compareToIgnoreCase(c2))
					.collect(Collectors.toList());
		case "population":
			return countries.stream().sorted((c1, c2) -> Long.compare(c2.getPopulation(), c1.getPopulation()))
					.map(c -> c.getName().getCommon() + " : " + c.getPopulation()).collect(Collectors.toList());
		// country : population in descending order

		case "area":
			return countries.stream().sorted((c1, c2) -> Double.compare(c2.getArea(), c1.getArea()))
					.map(c -> c.getName().getCommon() + " : " + c.getArea()).collect(Collectors.toList());
		default:
			return countries.stream().map(c -> c.getName().getCommon()).collect(Collectors.toList());
		// Return the list without sorting if the parameter is invalid
		}

	}
}
