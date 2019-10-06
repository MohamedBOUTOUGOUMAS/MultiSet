package pobj.tme5.test;

import pobj.tme5.InvalidMultiSetFormat;
import pobj.tme5.MultiSet;
import pobj.tme5.MultiSetParser;

public class MultiSetParserTest {

	public static void main(String [] args){
		try{
			MultiSet<String> ms = MultiSetParser.parse("data/Test.txt");
			System.out.println(ms.toString());
		}catch(InvalidMultiSetFormat e){
			System.out.println(e.getMessage());
		}
	}
}
