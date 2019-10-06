package pobj.tme5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface MultiSet<T> extends Collection<T> { // ’interface Collection<T> étend en fait l’interface Java java.lang.Iterable<T>
	public boolean add(T e);
	public boolean add(T e, int count);
	public boolean remove(Object e);
	public boolean remove(Object e, int count);
	public int count(T o);
	public void clear();	
	public int size();
	public Iterator<T> iterator();
	public List<T> elements();
	//public void setSize(int s);//A enlever juste pour test à Moh
}
