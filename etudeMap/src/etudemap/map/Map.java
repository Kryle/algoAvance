/*
 * Copyright (C) 2019 rvenant.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package etudemap.map;

import etudemap.map.exceptions.CompleteTableException;
import etudemap.map.exceptions.NullKeyException;
import java.util.Iterator;

/**
 * Basic Interface of a Map.
 *
 * @author rvenant
 * @param <K> type of key
 * @param <V> type of value
 */
public interface Map<K, V> {

    /**
     * Put an entry (a pair key-value) in the table. 
     * If the key already exists, overrides its associated value.
     *
     * @param key the key
     * @param value the value
     * @throws NullKeyException if the key is null
     * @throws CompleteTableException if table is complete
     */
    void put(K key, V value) throws NullKeyException, CompleteTableException;

    /**
     * Remove an entry (a pair key-value) from the table. 
     * Does nothing if the key does not exist.
     *
     * @param key the key
     * @return the associated removed value, or null if the key does not exist
     * @throws NullKeyException if the key is null
     */
    V remove(K key) throws NullKeyException;

    /**
     * Retrieve a value associated to a key
     *
     * @param key the key
     * @return the associated value, or null if the key does not exist
     * @throws NullKeyException if the key is null
     */
    V get(K key) throws NullKeyException;

    /**
     * Test if a key exists in the table
     *
     * @param key the key
     * @return True if the key exists, else otherwise
     * @throws NullKeyException if the key is null
     */
    boolean contains(K key) throws NullKeyException;

    /**
     * Get the number of entries in the map (= the number of keys = the number
     * of values)
     *
     * @return the size of the map
     */
    int size();
    
    /**
     * Get an iterator over the map.
     * This iterator implements the remove() method.
     * @return a new iterator
     */
    Iterator<MapEntry<K, V>> iterator();
}
