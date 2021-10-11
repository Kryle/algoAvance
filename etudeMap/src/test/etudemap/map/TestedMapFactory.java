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
package test.etudemap.map;

import etudemap.map.Map;
import etudemap.map.MapImpl;

/**
 *
 * @author rvenant
 */
public class TestedMapFactory {
    
    public static Map<String, String> createOpenAdressMap(int mapSize){
        return new MapImpl<>(mapSize);
    }
    
    public static Map<String, String> createExtChainMap(int mapSize){
        return new MapImpl<>(mapSize);
    }
    
}
