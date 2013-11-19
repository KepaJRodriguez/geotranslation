package eu.ehri.geotranslation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadFile {

	public HashMap<String, String> loadFile (String filename){

			
		String currentLine;
		BufferedReader br = null;
		List<String> linesOfFile = new ArrayList<String>();
		HashMap<String,String> vocEntries = new HashMap<String,String>();
		
		try {
			br = new BufferedReader(new FileReader(filename));

			while ((currentLine = br.readLine()) != null) {
				linesOfFile.add(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < linesOfFile.size(); i++){
			String splittedLine[] = linesOfFile.get(i).split("\t");
			vocEntries.put(splittedLine[0], splittedLine[1]);
		}
		
		return vocEntries;
	}
	
}
