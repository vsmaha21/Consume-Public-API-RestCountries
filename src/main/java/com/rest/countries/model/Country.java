package com.rest.countries.model;

import java.util.List;
import java.util.Map;

public class Country {

	private Name name; // Represents name information (common and official)
	private List<String> capital; // Capital city or cities
	private List<String> continents; // Continent(s) of the country
	private double area; // Area of the country
	private Long population; // Population of the country
	private Map<String, Currency> currencies; // Currencies of the country
	private Map<String, String> languages; // Languages spoken in the country
	private List<String> timezones;

	// Getters and Setters

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public List<String> getCapital() {
		return capital;
	}

	public void setCapital(List<String> capital) {
		this.capital = capital;
	}

	public List<String> getContinents() {
		return continents;
	}

	public void setContinents(List<String> continents) {
		this.continents = continents;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Map<String, Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, Currency> currencies) {
		this.currencies = currencies;
	}

	public Map<String, String> getLanguages() {
		return languages;
	}

	public void setLanguages(Map<String, String> languages) {
		this.languages = languages;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

}
