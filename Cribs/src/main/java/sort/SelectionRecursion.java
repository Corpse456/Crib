package sort;

//Сортировка выбором
public class SelectionRecursion {
    private final static int MASSLENGTH = 10000;

    public static void main (String[] args) {
        int[] mass = new int[MASSLENGTH];

        for (int i = 0; i < MASSLENGTH; i++) {
            mass[i] = (int) (Math.random() * MASSLENGTH);
        }

        print(mass);

        long time = System.currentTimeMillis();
        sort(0, mass);
        long time2 = System.currentTimeMillis();

        print(mass);
        System.out.println("Time - " + (time2 - time) / 1000f);
    }

    private static void sort (int j, int[] array) {
        int min = j;
        for (int i = j; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        if (min != j) {
            swap(min, j, array);
        }
        if (j != array.length) sort(j + 1, array);
    }

    private static void print (int[] array) {
        int counter = 0;
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + "|");
            counter++;
            if (counter % 25 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void swap (int i, int j, int[] array) {
        int change = array[i];
        array[i] = array[j];
        array[j] = change;
    }
}
