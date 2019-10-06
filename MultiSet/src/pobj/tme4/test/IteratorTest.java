package pobj.tme4.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import pobj.tme4.HashMultiSet;
import pobj.tme4.HashMultiSet.HashMultiSetIterator;

public class IteratorTest {

	@Test
	public void testIterator() {
		HashMultiSet<String> m = new HashMultiSet<>();
		List<String> l = new ArrayList<>();
		m.add("a",3);
		m.add("b");
		m.add("c",2);
		System.out.println(m.getMap());
		HashMultiSet.HashMultiSetIterator mp = (HashMultiSetIterator) m.iterator();
	
		for (String s : m) {
			System.out.println(s);
			l.add(s);
		}
		Collections.sort(l);
		assertEquals(6, l.size());
		assertEquals("a", l.get(0));
		assertEquals("a", l.get(1));
		assertEquals("a", l.get(2));
		assertEquals("b", l.get(3));
		assertEquals("c", l.get(4));
		assertEquals("c", l.get(5));
		
	}

}
