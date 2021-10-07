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

/**
 * An entry of a Map, representing a pair of a key and a value.
 * @author rvenant
 */
public interface MapEntry<K, V> {
    /**
     * Get the key in the entry
     * @return the key
     */
    K getKey();
    
    /**
     * Get the value in the entry
     * @return the value
     */
    V getValue();
}
