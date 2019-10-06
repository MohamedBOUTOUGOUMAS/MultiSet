package pobj.tme4.test;

import java.util.List;

import org.junit.Test;

import pobj.tme4.HashMultiSet;
import pobj.tme4.WordCount;

public class WordCountTest {

	@Test
	public void testWordCount() {
		HashMultiSet<String> m = new HashMultiSet<>();
		WordCount.wordcount(m);
		List<String> ls= m.elements();
		ls.sort(m);
		
		for (int i=0; i<10; i++)
			System.out.println(ls.get(i));
	}

}
