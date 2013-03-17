package Miscellaneous;

public class StringCombinationNumber {

	public static void generatePermutation(String[] s, String str) {
	
		genPermString("", s,str);

	}

	public static void genPermString(String c,String[] s,String str)
	{
		if(str.length()==0)
		{
			System.out.println(c);
			return;
		}
		int pos=str.charAt(0)-'0';
		
		if(s[pos]!=null)
		{
			for(int i=0;i<s[pos].length();i++)
			{
				genPermString(c+s[pos].charAt(i),s,str.substring(1));
			}
		}
		else
		{
			genPermString(c,s,str.substring(1));
		}		
			
	}

	public static void main(String[] args) {
		String[] s = { null, "vtfrq", "ftk", "wzbg", "rs", null, "fir", "p",
				"lo", "pqrs" };
		String a = "9814";
		generatePermutation(s, a);
	}

}
