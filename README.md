# RestCountries API Spring Boot Project

This project is a Spring Boot application that consumes the RestCountries API to fetch information about countries. It provides endpoints to sort countries by name, population, and area, and allows fetching countries based on their continent.

## Features
- Fetch a list of all countries.
- Sort countries by name, population, or area.
- Retrieve countries by their continent (e.g., Africa, Asia, etc.).
- Return country information including name, capital, continent, area, population, currency, and languages.

## Technologies Used
- **Spring Boot**: Framework for building the REST API.
- **RestTemplate**: For making HTTP requests to external APIs (RestCountries API).
- **Java 17+**: The programming language for implementing the Spring Boot app.
- **Maven**: Build automation tool.
- **Spring Web**: For creating RESTful web services.

## API Endpoints
- **Get All Countries** -> http://localhost:8080/countries
- **Get Country by Name** -> http://localhost:8080/countries/india
- **Get Countries by Continent** -> http://localhost:8080/countries/continent/{continent}

Replace {continent} with a valid continent name (e.g., Africa, Asia, Europe).

- **Get Sorted Countries** -> http://localhost:8080/countries/sorted?sortBy=area

This endpoint allows you to get a sorted list of countries based on name, population, or area.

