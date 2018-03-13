package sort;

public class SortString {
    private static String[] array = { "alex", "corpse", "anton", "hren", "crest", "system", "cs50", "wallet", "window",
	    "antropomorf", "baton", "comp", "rainbow", "nobody", "board", "bag", "compare", "mouse", "keyboard",
	    "nothing" };

    public static void main(String[] args) {
	sort(array);
	print();
    }

    public static void sort(String[] array) {
	boolean check = false;
	do {
	    check = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (compare(array[i], array[i + 1])) {
		    swap(i, i + 1);
		    check = true;
		}
	    }
	} while (check);
    }

    private static boolean compare(String string, String string2) {
	int minLength = Math.min(string.length(), string2.length());
	for (int i = 0; i < minLength; i++) {
	    if (string.charAt(i) > string2.charAt(i)) {
		return true;
	    } else if (string.charAt(i) == string2.charAt(i)) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }

    private static void swap(int i, int j) {
	String change = array[i];
	array[i] = array[j];
	array[j] = change;
    }

    private static void print() {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    counter++;
	    System.out.print(array[k] + "|");
	    if (counter % 8 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }
}
