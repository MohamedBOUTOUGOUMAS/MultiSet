package pobj.tme4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pobj.util.Chrono;

public class WordCount {

	public static void wordcount(HashMultiSet<String> ms){
		try {
			//String file = "src/fichier.txt";
			String file = "data/WarAndPeace.txt";
			BufferedReader br;
			br = new	BufferedReader(new FileReader(file));
			String line;
			try {
				while((line = br.readLine())!= null) {
					for(String word : line.split("\\P{L}+")) {
						if(word.equals(""))	continue; // ignore les mots vides
						ms.add(word);
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Fin de construction de notre HashMultiset ms (chargement du fichier)
	}
	
	public static void wordcount(NaiveMultiSet<String> ms){
		try {
			//String file = "src/fichier.txt";
			String file = "data/WarAndPeace.txt";
			BufferedReader br;
			br = new	BufferedReader(new FileReader(file));
			String line;
			try {
				while((line = br.readLine())!= null) {
					for(String word : line.split("\\P{L}+")) {
						if(word.equals(""))	continue; // ignore les mots vides
						ms.add(word);
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Fin de construction de notre HashMultiset ms (chargement du fichier)
	}
	
	public static void main(String argv[]){
		Chrono chrono1 = new Chrono();
		HashMultiSet<String> m = new HashMultiSet<>();
		WordCount.wordcount(m);
		List<String> ls= m.elements();
		ls.sort(m);
		chrono1.stop();
		//System.out.println(chrono1);
		for (int i=0; i<10; i++)
			System.out.println(ls.get(i));
		Chrono chrono2 = new Chrono();
		
		
		NaiveMultiSet<String> m1 = new NaiveMultiSet<>();
		WordCount.wordcount(m1);
		List<String> ls1= m1.elements();
		ls1.sort(m1);
		chrono2.stop();
		for (int i=0; i<10; i++)
			System.out.println(ls1.get(i));
		System.out.println("-----------> FIN");
	}
	
}

