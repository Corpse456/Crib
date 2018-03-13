package pset1;

public class Chess {

    public static void main(String[] args) {
	// system("clear");
	Letter();

	for (int j = 1; j < 9; j++) {
	    System.out.printf("\n\t\t    ");
	    Cell(j);
	    System.out.printf("\n\t\t%d   ", j); // цифры слева
	    Cell(j);
	    System.out.printf("   %d\n\t\t    ", j); // цифры справа
	    Cell(j);
	}
	Letter();
    }

    private static void Letter() {
	System.out.printf("\n\n");
	System.out.printf("\t\t\t");
	for (int i = 'A'; i <= 'H'; i++) {
	    System.out.printf("%c\t", i);
	}
	System.out.println();
    }

    private static void Cell(int black) {
	if (black % 2 == 1) {
	    for (int k = 0; k < 4; k++) {
		System.out.print("||||||||        ");
	    }
	} else {
	    for (int k = 0; k < 4; k++) {
		System.out.print("        ||||||||");
	    }
	}
    }
}
