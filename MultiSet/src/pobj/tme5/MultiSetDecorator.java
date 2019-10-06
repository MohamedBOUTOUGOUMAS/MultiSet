package pobj.tme5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;

public class MultiSetDecorator<T> extends AbstractCollection<T> implements MultiSet<T>{
	private MultiSet<T> decorated;
	
	public MultiSetDecorator(MultiSet<T> ms) {
		this.decorated = ms;
	}
	
	public boolean add(T e) {
		boolean ret = this.decorated.add(e);
		assert isConsistent();//************* assert *****************
		return ret;
	}
	
	public boolean add(T e, int count) {
		return this.decorated.add(e, count);
	}
	
	public boolean remove(Object e) {
		boolean ret = this.decorated.remove(e);
		assert isConsistent();
		return ret;
	}
	
	public boolean remove(Object e, int count) {
		return this.decorated.remove(e, count);
	}
	
	public int count(T o) {
		return this.decorated.count(o);
	}
	
	public void clear() {
		this.decorated.clear();
	}
	
	public int size() {
		return this.decorated.size();
	}
	
	public Iterator<T> iterator(){
		return this.decorated.iterator();
	}
	
	@SuppressWarnings("unused")
	public boolean isConsistent(){
		int size_verif = 0;
		for (T e : this.decorated) {
			size_verif += 1;
		}
		return (this.size() == size_verif);
	}
	
	public List<T> elements(){
		return this.decorated.elements();
	}
	
	public String toString(){
		return this.decorated.toString();
	}
}
