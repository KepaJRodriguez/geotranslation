package eu.ehri.geotranslation;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		LoadFile upload = new LoadFile();
		HashMap<String, String> loaded = upload.loadFile(fileName);
		System.out.println("Hello World! " + fileName + " loves you");
		AskGeonames translate = new AskGeonames();
		HashMap<String, HashMap<String, String>> translations = translate
				.askGeonames(loaded);
		PrintResults printer = new PrintResults();
		Object printed = printer.printOut(fileName, translations);
	}
}
