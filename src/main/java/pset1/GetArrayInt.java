package pset1;

import java.util.Scanner;

public class GetArrayInt {
    public static int[] get() {

	Scanner take = new Scanner(System.in);

	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	take.close();

	char[] arrayChar = input.toCharArray();

	int[] array = new int[arrayChar.length];
	for (int i = 0; i < arrayChar.length; i++) {
	    array[i] = arrayChar[i] - 48;
	}
	return array;
    }

    private static boolean check(String input) {
	if (input.length() < 1) {
	    return false;
	}
	String numbers = "0123456789";

	for (int i = 0; i < input.length(); i++) {
	    boolean exist = false;
	    for (int j = 0; j < numbers.length(); j++) {
		if (numbers.charAt(j) == input.charAt(i)) {
		    exist = true;
		    break;
		}
	    }
	    if (!exist) {
		return false;
	    }
	}
	return true;
    }
}