package map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class AboutMap {

    @SuppressWarnings ("unused")
    public static <C, N> void main (C[] args) {
	Map<C, N> map = new HashMap<>();

// 0. Обращение Map в List
	// лист ключей
	List<C> keyList = new ArrayList<>(map.keySet());
	// лист значений
	List<N> valueList = new ArrayList<>(map.values());
	// лист ключ-значения
	List<Entry<C, N>> entryList = new ArrayList<>(map.entrySet());

// 1. Пройтись по всем значениям в Map
	for (Entry<C, N> entry : map.entrySet()) {
	    // получить ключ
	    C key = entry.getKey();
	    // получить значение
	    N value = entry.getValue();
	}

	Iterator<Entry<C, N>> itr = map.entrySet().iterator();
	while (itr.hasNext()) {
	    Entry<C, N> entry = itr.next();
	    // получить ключ
	    C key = entry.getKey();
	    // получить значение
	    N value = entry.getValue();
	}
	
// 2. Упорядочивание Map по ключам
	List<Entry<C,N>> list = new ArrayList<>(map.entrySet());
	list.sort(new Comparator<Entry<C, N>>() {
	    @Override
	    public int compare (Entry<C, N> e1, Entry<C, N> e2) {
		//return e1.getKey().compareTo(e2.getKey());
		return 0;
	    }
	});
	
	SortedMap<C, N> sortedMap = new TreeMap<>(new Comparator<C>() {
	    @Override
	    public int compare (C c1, C c2) {
		//return c1.compareTo(c2);
		return 0;
	    }
	});
	sortedMap.putAll(map);
	
// 3. Упорядочивание Map по значениям
	List<Entry<C,N>> list2 = new ArrayList<>(map.entrySet());
	list2.sort(new Comparator<Entry<C, N>>() {
	    @Override
	    public int compare (Entry<C, N> e1, Entry<C, N> e2) {
		//return e1.getValue().compareTo(e2.getValue());
		return 0;
	    }
	});
    }
}