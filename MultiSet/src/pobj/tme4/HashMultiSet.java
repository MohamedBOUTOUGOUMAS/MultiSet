package pobj.tme4;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;



public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>, Comparator<T> {
	private Map<T, Integer> map;
	private int size = 0;
	
	public HashMultiSet(){
		this.map = new HashMap<T, Integer>();
	}
	public HashMultiSet(Collection <T> c){
		this.map = new HashMap<T, Integer>();
		for (T i : c){
			if (this.map.containsKey(i)){
				this.map.put(i, this.map.get(i)+1);
			}
			else{
				this.map.put(i, 1);
			}
			this.size++;
		}
		
	}
	@Override
	public boolean add(T e, int count) {
		for (int i=0;i<count;i++){
			this.add(e);
		}
		return true;
	}

	@Override
	public boolean add(T e) {
		if (this.map.containsKey(e)){
			this.map.put(e, this.map.get(e)+1);
		}
		else{
			this.map.put(e, 1);
		}
		this.size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		if(this.map.containsKey(e)){
			if(this.map.get(e)>1){
				this.map.put((T) e,this.map.get(e)-1);
			}else{
				this.map.remove(e);
			}
		}
		this.size--;
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
		if(this.map.containsKey(o)){
			return map.get(o);
		}else{
			return 0;
		}
	}

	@Override
	public void clear() {
		this.map.clear();
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	
	@SuppressWarnings("hiding")
	public class HashMultiSetIterator<T> implements Iterator<T> {
		private HashMultiSet<T> hms;
		//private Iterator<HashMultiSet<T>> itHms;
		private int size = 0;
		private int occMot = 0;
		private Iterator<Entry<T, Integer>> itMap;
		private Entry<T, Integer> es; //element courant
		//private boolean change = true;
		
		public HashMultiSetIterator(HashMultiSet<T> hms){
			this.hms = hms;
			//this.itHms = (Iterator<HashMultiSet<T>>) hms.iterator();			
			this.itMap = this.hms.map.entrySet().iterator();
			this.es = this.itMap.next();//recupere le 1er EntrySet
		}
		
		
		@Override
		public boolean hasNext() {
			return this.size < this.hms.size;
		}

		@Override
		public T next() {
			if (!this.hasNext()){
				throw new NoSuchElementException();
			}
			if(this.hasNext()) {
				if (this.occMot == es.getValue()) { //recup le nouveau mot
					//this.change = true;
					this.es = this.itMap.next(); // un autre mot
					this.occMot = 1; // une occurence deja
					this.size++;
					return es.getKey();
				}
				if (this.occMot < es.getValue()) { //retourne n occurences du mot
					//this.change = false;
					this.occMot++;
					this.size++;
					return es.getKey();
				}
			}
			return null;
		}

	}// fin classe interne
	
	
	@Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator<T>(this);
	}
	
	public Map<T, Integer> getMap() {
		return map;
	}
	
	@Override
	public List<T> elements() {
		Set<T> s = this.map.keySet();
		List<T> l = new ArrayList<T>();
		l.addAll(s);
		return l;

	}
	@Override
	public int compare(T o1, T o2) {
		if (this.map.get(o1) > this.map.get(o2)){
			return -1;
		}
		else if (this.map.get(o1) < this.map.get(o2)) {
			return 1;
		}
		else{
			return 0;
		}
			
	}
	

}
