package hw9.countries.dto;

import hw9.countries.dto.subentity.Translations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CountryDto {
	private String name;
	private String capital;
	private List<String> altSpellings;
	private String relevance;
	private String region;
	private String subregion;
	private Translations translations;
	private Long population;
	private List<Float> latlng;
	private String demonym;
	private Long area;
	private Float gini;
	private List<String> timezones;
	private List<String> callingCodes;
	private List<String> topLevelDomain;
	private List<String> currencies;
	private List<String> languages;
}
