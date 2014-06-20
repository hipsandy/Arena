package com.hipsandy.searchnsort;

import java.util.List;

public class BinarySearcher<T extends Comparable<T>> {


    public T search(List<T> data, T item) {
    	return search(data, item, 0, data.size() - 1);
    }
	

	private T search(List<T> data, T item, int l, int r) {
		if (r > l) {
			return null;
		}
		int m = l + ((r - l) >> 1);
		T mid = data.get(m);
		if (item.compareTo(mid) < 0) {
			return search(data, item, l, m - 1);
		} else if (item.compareTo(mid) > 0) {
			return search(data, item, m + 1, r);
		} else {
			return data.get(m);
		}
	}

}
