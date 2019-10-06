package pobj.tme5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser {

	
	
	
	
	@SuppressWarnings({ "resource" })
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat{
		MultiSet<String> ms = new HashMultiSet<String>();
		String file = fileName;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!= null) {
				String [] word = line.split(":");
				if(word.length != 2){
					throw new InvalidMultiSetFormat("Présence de plusieures occurences de \":\"");
				}
				if(Integer.decode(word[1]) != null){
					ms.add(word[0], Integer.decode(word[1]));
				}
			}
			br.close();
		} catch (IOException e) {
			throw new InvalidMultiSetFormat("Fichier inexistant",e);
		} catch(NumberFormatException e){
			throw new InvalidMultiSetFormat("La fréquence du mot n'est pas une valeur enitère", e);
		}
		return ms;
	}
}
