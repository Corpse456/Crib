package sort;

//Сортировка слиянием
public class Merge
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
		if (end > start)
		{
			int middle = (start + end) / 2;
			sort(start, middle);
			sort(middle + 1, end);
			merge(start, middle, middle + 1, end);
		}
	}

	private static void merge(int start1, int end1, int start2, int end2)
	{
		int[] temp = new int[end2 - start1 + 1];
		int index1 = start1, index2 = start2, i = 0;

		while (index1 <= end1 && index2 <= end2)
		{
			temp[i++] = (array[index1] < array[index2]) ? array[index1++] : array[index2++];
		}

		while (index1 <= end1)
		{
			temp[i++] = array[index1++];
		}

		while (index2 <= end2)
		{
			temp[i++] = array[index2++];
		}

		for (int j = 0; j < temp.length; j++)
		{
			array[start1 + j] = temp[j];
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
}