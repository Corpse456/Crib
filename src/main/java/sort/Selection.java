package sort;

//Сортировка выбором
public class Selection {
    private static int[] array = new int[30000];

    public static void main (String[] args) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }

        print();

        long time = System.currentTimeMillis();
        sort();
        long time2 = System.currentTimeMillis();

        print();

        System.out.println("Time - " + (time2 - time) / 1000f);
        time = System.currentTimeMillis();
        sort();
        System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
    }

    private static void sort () {
        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            // если j-ый элемент и так миимальный
            if (min != j) {
                swap(min, j, array);
            }
        }
    }

    private static void print () {
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
