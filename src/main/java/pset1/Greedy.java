//Программа подсчёта сдачи
package pset1;

public class Greedy {

    public static void main (String[] args) {
        int sum, quarter;

        System.out.println("O hai! How much change is owed?");
        double sumFirst = GetDouble.get();

        while (sumFirst <= 0 || sumFirst > 10000000) {
            System.out.println("Incorrect input, please try again");
            sumFirst = GetDouble.get();
        }
        sumFirst *= 100;
        sumFirst -= sumFirst % 1;
        sum = (int) sumFirst;
        if (sum % 25 == 0) System.out.println(sum / 25);
        else {
            quarter = sum / 25;
            sum %= 25;
            if (sum % 10 == 0) System.out.println(quarter + sum / 10);
            else {
                quarter += sum / 10;
                sum %= 10;
                if (sum % 5 == 0) System.out.println(quarter + sum / 5);
                else System.out.println(quarter + sum / 5 + sum % 5 / 1);
            }
        }
    }
}
