package lists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Iterator {

    public static void main (String[] args) {
	iterator();
    }

    private static void iterator() {
	List<Integer> one = new LinkedList<>();
	
	for (int i = 1; i < 15; i++) {
	    one.add(i);
	}
	
	ListIterator<Integer> it = one.listIterator();
	while (it.hasNext()) {
	    if (it.next() == 10) break;
	}
	it.remove();
	print(one);
	it.next();
	it.next();
	it.remove();
	print(one);
	it.previous();
	it.previous();
	it.remove();
	print(one);
	System.out.println(one.size());
	it.next();
	it.next();
	System.out.println(it.nextIndex());
    }

    private static void print(List<Integer> one) {
	for (Integer i : one) {
	    System.out.print(i + " ");
	}
	System.out.println();
    }
}
