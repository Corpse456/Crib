package pset1;

public class CreditCard
{
	public static void main(String[] args)
	{
		//system("clear");
		int sumOfDigits = 0;
		//защита от дурака при вводе номера
		System.out.print("Number your credit card: ");
		int[] numberOfCard = GetArrayInt.get();
		if (numberOfCard.length < 13 || numberOfCard.length > 16)
		{
			System.out.println("Wrong number of Card");
		}

		int firstDigit = numberOfCard[0];
		int secondDigit = numberOfCard[1];

		for (int i = numberOfCard.length-1; i >= 0; i--)
		{
			//умножение всех цифр в номере через одну на 2
			if (i % 2 == 0) 
			{
				numberOfCard[i] *= 2;
				//если результат превышает 9, вернуть сумму цифр числа (14=1+4)
				if (numberOfCard[i] > 9)
					numberOfCard[i] -= 9;
			}
			//сумма всех цифр номера с учётом преобразования
			sumOfDigits += numberOfCard[i]; 
		}
		//проверка кратности 10
		if (sumOfDigits % 10 != 0) 
		{
			System.out.println("INVALID");
		}
		//проверка длины и соответствия первых двух цифр
		else 
		{
			System.out.println("Right card number");
			if (numberOfCard.length == 15 && firstDigit == 3 && (secondDigit == 4 || secondDigit == 7))
				System.out.println("AMEX");
			if ((numberOfCard.length == 13 || numberOfCard.length == 16) && firstDigit == 4)
				System.out.println("VISA");
			if (numberOfCard.length == 16 && firstDigit == 5 && (secondDigit == 1 || secondDigit == 2 || secondDigit == 3 || secondDigit == 4 || secondDigit == 5))
				System.out.println("MASTERCARD");
		}
	}
}
