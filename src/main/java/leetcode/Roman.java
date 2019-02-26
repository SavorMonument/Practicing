package leetcode;

public class Roman
{

	enum Symbols
	{
		I(1),
		IV(4),
		V(5),
		IX(9),
		X(10),
		XL(40),
		L(50),
		XC(90),
		C(100),
		CD(400),
		D(500),
		CM(900),
		M(1000);

		int nr;

		Symbols(int nr)
		{
			this.nr = nr;
		}
	}

	public String intToRoman(int num)
	{
		StringBuilder romanNumber = new StringBuilder();

		Symbols[] symbols = Symbols.values();
		int index = symbols.length - 1;

		while (num > 0)
		{
			Symbols currentSymbol = symbols[index];
			while(num / currentSymbol.nr > 0)
			{
				romanNumber.append(currentSymbol);
				num -= currentSymbol.nr;
			}
			index--;
		}

		return romanNumber.toString();
	}
}
