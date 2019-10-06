package pobj.tme5.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pobj.tme5.HashMultiSet;
import pobj.tme5.MultiSet;
import pobj.tme5.MultiSetDecorator;

public class HashMultiSetTest2Decorator {
	
	private MultiSet<String> m;
	
	@Before
	public void before() {
		m = new MultiSetDecorator<>(new HashMultiSet<>());
	}
	
	//************************
	@Test 
	public void testAdd1() {
		m.add("a");
		m.add("a",5);
		assertEquals(6, m.count("a"));
	}

	@Test (expected = IllegalArgumentException.class) 
	public void testAdd2() {
		m.add("a");
		m.add("a",-1);
	}
	//********************
	
	@Test
	public void testRemove1(){
		m.add("a",5);
		m.remove("a");
		assertEquals(4, m.count("a"));
	}
	@Test
	public void testRemove2(){
		m.add("a",5);
		m.remove("a", 5);
		assertEquals(0, m.count("a"));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testRemove3(){
		m.add("a",5);
		m.remove("a", -1);
	}
	
	@Test
	public void testSize(){
		assertEquals(0, m.size());
		m.add("a",5);
		m.add("b");
		m.add("c", 4);
		assertEquals(10, m.size());
	}
	@Test
	public void testToString(){
		assertEquals("[]", m.toString());
		m.add("a",5);
		m.add("b",1);
		m.add("c", 3);
		assertEquals("[a:5; b:1; c:3]", m.toString());
		m.remove("c", m.count("c"));
		assertEquals("[a:5; b:1]", m.toString());
	}
	@Test
	public void testClear(){
		m.clear();
		assertEquals(0, m.size());
		m.add("a",5);
		m.add("b",1);
		m.clear();
		assertEquals(0, m.size());
	}
	
	
	@Test
	public void TestAddRemoveComplexe_Q2(){
		m.add("Markers",3);
		m.add("Prop",5);
		m.add("Serv",7);
		m.add("Snipp",11);
		m.add("Console",13);
		m.add("jUnit",17);
		//m.setSize(20); //A enlever juste pour test à Moh
		assertEquals(56, m.size());
		m.remove("Prop",5);
		m.remove("Markers");
		m.remove("jUnit",10);
		assertEquals(40, m.size());
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void TestAddRemoveCount_Q3(){
		m.add("Markers",3);
		m.add("Prop",5);
		m.add("Serv",7);
		m.add("Snipp",11);
		m.remove("Snipp",-1);
		assertEquals(12, m.count("x"));
	}
	
	@Test (expected = AssertionError.class)
	public void TestAddRemoveCount_Q3_bis(){
		m.add("Markers",3);
		m.add("Prop",5);
		m.add("Serv",7);
		m.add("Snipp",11);
		assertEquals(2, m.count("x"));
	}
	
	

}
