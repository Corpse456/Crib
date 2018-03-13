package sort;

//Быстрая сортировка
public class Fast
{

	private static int[] array = new int[30000];

	public static void main(String[] args)
	{

		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int) (Math.random() * array.length);
		}

		print();

		long time = System.currentTimeMillis();
		sort(0, array.length - 1);
		long time2 = System.currentTimeMillis();

		print();

		System.out.println("Time - " + (time2 - time) / 1000f);

		time = System.currentTimeMillis();
		sort(0, array.length - 1);
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
	}

	private static void sort(int start, int end)
	{
		int left = start, right = end;
		int support = array[(left + right) / 2];

		while (right >= left)
		{
			while (array[left] < support)
			{
				left++;
			}

			while (array[right] > support)
			{
				right--;
			}

			if (right >= left)
			{
				swap(right--, left++);
			}
		}
		if (start < right)
		{
			sort(start, right);
		}
		if (left < end)
		{
			sort(left, end);
		}
	}

	private static void print()
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

	private static void swap(int i, int j)
	{
		int change = array[i];
		array[i] = array[j];
		array[j] = change;
	}
}