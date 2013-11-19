package eu.ehri.geotranslation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class PrintResults {

	public Object printOut(String name,
			HashMap<String, HashMap<String, String>> translations)
			throws IOException {

		String resultFile = name + ".translation";

		File f = new File(resultFile);
		f.createNewFile();

//		FileWriter writer = new FileWriter(f ,true);
		PrintWriter writer = new PrintWriter(f);
		
		for (String s : translations.keySet()) {
			String identifier = s;
			HashMap<String, String> placeNames = translations.get(s);

			writer.write(identifier + "\t");
			
			for (String language : placeNames.keySet()){
				String translatedName = placeNames.get(language);
				writer.write(language + ":");

					writer.write(translatedName);
			
				writer.write("\t");
								
			}
			writer.println();
		}
		writer.close();
		
		
		return null;
	}

}
