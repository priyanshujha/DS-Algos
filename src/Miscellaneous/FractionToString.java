package Miscellaneous;

public class FractionToString {
	
	public static int findGCD(int num,int den)
	{
		while(true)
		{
			int rem=den%num;
			if(rem==0)
				return num;
			den=num;
			num=rem;
		}
	}
	public static void main(String[] args)
	{
		double a=0.5;
		int numerator=(int)(a*32);
		int denominator=32;
		int gcd=findGCD(numerator,denominator);
		numerator/=gcd;
		denominator/=gcd;
		System.out.println(numerator+"/"+denominator);
		
	}
}
