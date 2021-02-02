package hw9.countries.service;

import hw9.countries.dto.CountryDto;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;

public class RestCountriesAssertions {

	private CountryDto[] counties;

	public RestCountriesAssertions(CountryDto[] response) {
		this.counties = response;
	}

	public RestCountriesAssertions verifyCountry(String countryName) {
		assertEquals(counties.length, 1, "Incorrect list of countries size");
		assertEquals(counties[0].getName(), countryName, "Incorrect county name");
		return this;
	}

	public void verifyCountries(String... countryName) {
		assertEquals(
				stream(counties).map(CountryDto::getName).collect(toList()).toArray(new String[]{}),
				countryName,
				"Incorrect list of countries");
	}

	public RestCountriesAssertions verifyDataEqual(CountryDto[] res){
		assertEquals(counties, res);

		return this;
	}
}
