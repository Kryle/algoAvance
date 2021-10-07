package etudemap.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import etudemap.map.exceptions.CompleteTableException;
import etudemap.map.exceptions.NullKeyException;

public class MapImpl<K, V> implements Map<K, V>{
	
	private static final int DEFAULT_MAP_SIZE = 100;
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
		return null;
	}

	@Override
	public V get(K key) throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) throws NullKeyException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
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
}
