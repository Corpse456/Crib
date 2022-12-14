package sort;

////Сортировка вставкой
public class Insert {

    private static int[] array = new int[30000];

    public static void main (String[] args) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }

        print(array);

        long time = System.currentTimeMillis();
        sort(array);
        long time2 = System.currentTimeMillis();

        print(array);

        System.out.println("Time - " + (time2 - time) / 1000f);

        time = System.currentTimeMillis();
        sort(array);
        System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
    }

    private static void sort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int j = i - 1;
                int buff = array[i];
                while (j >= 0 && buff < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = buff;
            }
        }
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
}
