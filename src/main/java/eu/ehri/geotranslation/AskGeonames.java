package eu.ehri.geotranslation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

public class AskGeonames {

	public HashMap<String, HashMap<String, String>> askGeonames(
			HashMap<String, String> entries) throws Exception {

		HashMap<String, HashMap<String, String>> translations = 
				new HashMap<String, HashMap<String, String>>();

		WebService.setUserName("demo"); // add your Geocodes username here
		
		/*
		 * List of selected languages A list of languages relevant for the EHRI
		 * project Code used by Geonames: ISO-639-1 language code
		 */
		List<String> languages = new ArrayList<String>();
		// languages.add("EN"); // English Original language of the query
		languages.add("DE"); // German
		languages.add("RU"); // Russian
	/*	languages.add("IT"); // Italian
		languages.add("FR"); // French */
		languages.add("PL"); // Polish
/*		languages.add("NL"); // Dutch
		languages.add("CS"); // Czech */
		languages.add("EL"); // Greek
		languages.add("UK"); // Ukrainian
		/*languages.add("HU"); // Hungarian
		languages.add("HR"); // Croatian
		languages.add("SR"); // Serbian
		languages.add("BG"); // Bulgarian
		languages.add("BE"); // Belarussian */
		//languages.add("HE"); // Hebrew
		//languages.add("NO"); // Norwegian
		//languages.add("LT"); // Lituanian
		
		for (String s : entries.keySet()) {

			String identifier = s;
			String placeName = entries.get(s);

			/*
			 * Search whether the query string matchs with an entry of the
			 * Geonames Database
			 */
			ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
			searchCriteria.setNameEquals(placeName);
			//List<String> resultList = new ArrayList<String>();

			//HashMap<String, List<String>> languageResultList = 
			//		new HashMap<String, String>>();
			HashMap<String, String> languageResults = 
					new HashMap<String, String>();
			languageResults.put("EN", placeName);
			
			for (int i = 0; i < languages.size(); i++) {

				List<String> resultList = new ArrayList<String>();



				searchCriteria.setLanguage(languages.get(i));
				searchCriteria.getName();
				searchCriteria.setMaxRows(1);
				ToponymSearchResult searchResult = WebService
						.search(searchCriteria);
				searchResult.setStyle(Style.FULL);
				for (Toponym toponym : searchResult.getToponyms()) {
					resultList.add(toponym.getName().toString());
					if (!toponym.getName().toString().equals(placeName)){
					languageResults.put(languages.get(i), toponym.getName().toString());
				}	
				}


				translations.put(identifier, languageResults);

			}
			//resultList.clear();
		}

		return translations;
	}

}
