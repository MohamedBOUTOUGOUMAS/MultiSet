package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>, Comparator<T>{
	
	private List<T> list;
	
	public NaiveMultiSet() {
		this.list = new ArrayList<T>();
	}

	public List<T> getList(){
		return this.list;
	}
	
	@Override
	public boolean add(T e){
		this.getList().add(e);
		return true;
	}
	@Override

	public boolean add(T e, int count) {
		for (int i=0;i<count;i++){
			this.add(e);
		}
		return true;
	}

	@Override
	public boolean remove(Object e){
		this.getList().remove(e);
		return true;
	}
	@Override
	public boolean remove(Object e, int count) {
		for (int i=0;i<count;i++){
			this.remove(e);
		}
		return true;
	}

	@Override
	public int count(T o) {
		int cpt = 0;
		for(T e : this.getList())
			if (e.equals(o))
				cpt++;
		return cpt;
	}
	
	@Override
	public void clear() {
		this.getList().clear();
	}
	
	@Override
	public int size() {
		return this.getList().size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.getList().iterator();
	}
	
	@Override
	public List<T> elements() {
		Set<T> s = new HashSet<T>(this.getList());
		List<T> l = new ArrayList<T>();
		l.addAll(s);
		return l;
	}

	@Override
	public int compare(T o1, T o2) {
		if (this.count(o1) > this.count(o2)){
			return -1;
		}
		else if (this.count(o1) < this.count(o2)) {
			return 1;
		}
		else{
			return 0;
		}
			
	}
	
}
