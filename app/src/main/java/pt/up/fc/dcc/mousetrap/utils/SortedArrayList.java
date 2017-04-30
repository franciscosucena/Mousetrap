package pt.up.fc.dcc.mousetrap.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ArrayList with sorted insertion
 *
 * @author José C. Paiva <up201200272@fc.up.pt>
 */
public class SortedArrayList<T> extends ArrayList<T> {

    @Override
    public boolean add(T t) {
        insertSorted(t);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Use insertSorted() instead");
    }

    @SuppressWarnings("unchecked")
    public void insertSorted(T value) {
        super.add(value);

        Comparable<T> cmp = (Comparable<T>) value;
        for (int i = size() - 1; i > 0 && cmp.compareTo(get(i - 1)) < 0; i--)
            Collections.swap(this, i, i - 1);
    }

    public void insertAllSorted(Collection<? extends T> c) {
        for (T t : c) {
            insertSorted(t);
        }
    }
}
