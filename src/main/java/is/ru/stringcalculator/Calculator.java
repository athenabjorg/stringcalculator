package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			
			if(text.contains(",") | text.contains("\n"))
			{
				String numbers[] = text.split(",|\n");
				if(text.contains("-"))
				{
					throwExceptionOnNegatives(numbers);
				}

				return sum(numbers);
			}
			return 1;
		}
		
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String [] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += toInt(number);
		}
		return total;
	}

	private static void throwExceptionOnNegatives(String [] numbers)
	{
		String message = "Negatives not allowed: ";
		boolean firstNegative = true;
		for(String number : numbers)
		{
			if(number.contains("-"))
			{
				if(firstNegative)
				{
					message = message + number;
					firstNegative = false;
				}
				else
				{
					message = message + "," + number; 
				}
				
			}
		}
		throw new IllegalArgumentException(message);
	}
}