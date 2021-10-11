package etudemap.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import etudemap.map.exceptions.CompleteTableException;
import etudemap.map.exceptions.NullKeyException;

public class MapImpl<K, V> implements Map<K, V>{
	
	private static final int DEFAULT_MAP_SIZE = 100;
	private int nbEntries = 0;
	private List<MapEntryImpl<K, V>>[] tab;
	
	public MapImpl(){
		this.tab = new List[DEFAULT_MAP_SIZE];
	}
	
	public MapImpl(int mapSize){
		this.tab = new List[mapSize];
	}


	@Override
	public void put(K key, V value) throws NullKeyException, CompleteTableException {
		
		final int idx = computeIndixFromKey(key);
		
		// si pas encore de liste dans le tableau à idx, en créé une
		if(this.tab[idx] == null) {
			this.tab[idx] = new LinkedList<>();
		} else {
			for(MapEntryImpl<K, V> entry : this.tab[idx]) {
				if(entry.getKey() == key) {
					entry.value = value;
					return;
				}
			}
		}
		this.tab[idx].add(new MapEntryImpl<>(key, value));
		this.nbEntries++;
	}

	private int computeIndixFromKey(K key) throws NullKeyException {
		// calcul de l'indice du tab. correspondant à la clé
				if(key == null) {
					throw new NullKeyException();
				}
		return key.hashCode() % this.tab.length;
	}
	
	@Override
	public V remove(K key) throws NullKeyException {
		
		final int idx = computeIndixFromKey(key);
		
		if(this.tab[idx] == null) {
			return null;
		}
		
		final Iterator<MapEntryImpl<K, V>> it = 
				this.tab[idx].iterator();
		while(it.hasNext()) {
			MapEntryImpl<K, V> entry = it.next();
			if(entry.key.equals(key)) {
				it.remove();
				this.nbEntries--;
				return entry.value;
			}
		}
		return null;
	}

	@Override
	public V get(K key) throws NullKeyException {
		
		final int idx = computeIndixFromKey(key);
		if(this.tab[idx] == null) {
			return null;
		}
		for(MapEntryImpl<K, V> entry : this.tab[idx]) {
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) throws NullKeyException {

		final int idx = computeIndixFromKey(key);
		if(this.tab[idx] == null) {
			return false;
		}
		for(MapEntryImpl<K, V> entry : this.tab[idx]) {
			if(entry.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return nbEntries;
	}

	@Override
	public Iterator iterator() {
		return new MapImplIterator();
	}

	public static class MapEntryImpl<K, V> implements MapEntry<K, V>{

		private K key;
		private V value;
		
		public MapEntryImpl(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
		
	}
	
	public class MapImplIterator implements Iterator<MapEntry<K, V>> {
		private int idxTab;
		private Iterator<MapEntryImpl<K ,V>> itCurrentList;
		private Iterator<MapEntryImpl<K ,V>> itFuturList;
		
		public MapImplIterator() {
			this.computeFuturListIterator();
				//itFuturList contient l'itérateur de la première liste
				if(this.itFuturList != null) {
					this.itCurrentList = this.itFuturList;
					this.computeFuturListIterator();
				}
		}
		
		@Override
		public boolean hasNext() {
			return (this.itCurrentList != null && this.itCurrentList.hasNext()) || this.itFuturList != null;
		}
		
		private void computeFuturListIterator() {
			do {
				this.idxTab++;
			}while( this.idxTab < tab.length && (tab[this.idxTab] == null || tab[this.idxTab].isEmpty()));
			if(this.idxTab < tab.length) {
				this.itFuturList = tab[this.idxTab].iterator();
			} else {
				this.itFuturList = null;
			}
		}

		@Override
		public MapEntry<K, V> next() {
			if(this.itCurrentList == null) {
				throw new NoSuchElementException();
			}
			if(this.itCurrentList.hasNext()) {
				return this.itCurrentList.next();
			}
			if(this.itFuturList == null) {
				throw new NoSuchElementException();
			}
			this.itCurrentList = this.itFuturList;
			this.computeFuturListIterator();
			return this.itCurrentList.next();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}
		
		
		
	}
	
}
