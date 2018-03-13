package sort;
//Сортировка пузыьком
public class BubblesRecursion
{
	private final static int MASSLENGTH = 30000;

	public static void main(String[] args)
	{
		int[] mass = new int[MASSLENGTH];

		for (int i = 0; i < MASSLENGTH; i++)
		{
			mass[i] = (int) (Math.random() * MASSLENGTH);
		}

		print(mass);

		long time = System.currentTimeMillis();
		sort(mass);
		long time2 = System.currentTimeMillis();

		print(mass);

		System.out.println("Time - " + (time2 - time) / 1000f);

		//при повторном запуске сортировка отсортированного массива происходит мнговенно
		time = System.currentTimeMillis();
		sort(mass);
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
	}

	private static void sort(int[] array)
	{
		boolean check = false;
		for (int i = 0; i < array.length - 1; i++)
		{
			if (array[i] > array[i + 1])
			{
				swap(i, i + 1, array);
				check = true;
			}
		}
		//существенно снижает время, если архив почти отсортирован и время равно 0, если полностью
		if (check)
		{
			sort(array);
		}
	}

	private static void print(int[] array)
	{
		int counter = 0;
		for (int k = 0; k < array.length; k++)
		{
			System.out.print(array[k] + "|");
			counter++;
			if (counter % 25 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}

	private static void swap(int i, int j, int[] array)
	{
		int change = array[i];
		array[i] = array[j];
		array[j] = change;
	}
}