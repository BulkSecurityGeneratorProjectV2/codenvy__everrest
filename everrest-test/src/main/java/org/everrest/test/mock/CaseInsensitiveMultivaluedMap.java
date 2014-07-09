/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.everrest.test.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author andrew00x */
public class CaseInsensitiveMultivaluedMap<T> extends HashMap<String, List<T>> {

    private static final long serialVersionUID = 6637313979061607685L;

    //override putAll since in java8 in doesn't use method put.
    @Override
    public void putAll(Map<? extends String, ? extends List<T>> m) {
        for (Map.Entry<? extends String, ? extends  List<T>> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(getKey(key));
    }

    /** {@inheritDoc} */
    @Override
    public List<T> get(Object key) {
        return getList(getKey(key));
    }

    /** {@inheritDoc} */
    @Override
    public List<T> put(String key, List<T> value) {
        return super.put(getKey(key), value);
    }

    /** {@inheritDoc} */
    @Override
    public List<T> remove(Object key) {
        return super.remove(getKey(key));
    }

    public T getFirst(String key) {
        List<T> l = getList(key);
        if (l.size() == 0)
            return null;
        return l.get(0);
    }

    private List<T> getList(String key) {
        List<T> l = super.get(getKey(key));
        if (l == null)
            l = new ArrayList<T>();
        put(key, l);
        return l;
    }

    private String getKey(Object key) {
        if (key == null) {
            return null;
        }
        return key.toString().toLowerCase();
    }

}