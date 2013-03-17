package Miscellaneous;

public class GenerateNumber {

	/**
	 * @param args
	 */
	public static void generate(int n,int number,int level)
	{
		
		for(int i=level;i<10;i++)
		{
			int newNumber= number + (int) (i*Math.pow(10,n-1));			
			if(n>1)
				generate(n-1,newNumber,i+1);			
			else
				System.out.println(newNumber);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		generate(n,0,1);
	}

}
