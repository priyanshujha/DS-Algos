package Miscellaneous;

public class FindPalindromicsubString {

	public static int findPalindrome(String a)
	{
		int palin_length=0;
		int max_length=0;
		int start=0;
		int end=0;
		if(a.length()==0 || a.length()==1)
			return a.length();
		
		if(a.length()==2)
		{
			if(a.charAt(0)==a.charAt(1))
				return 2;
			else
				return 1;
		}
		for(int center=1;center<(a.length()-1);center++)
		{
			int left=center-1;
			int right=center+1;
			palin_length=1;
			
			if(a.charAt(left)==a.charAt(center))
			{
				palin_length=0;
				right=center;
			}
			while(left>0 && right<a.length())
			{
				if(a.charAt(left)==a.charAt(right))
				{
					left--;
					right++;
					palin_length+=2;
				}
				else
				{
					if(palin_length>max_length)
					{
						max_length=palin_length;
						start=left+1;
						end=right-1;
					}
					break;
				}				
			}			
		}
		
		System.out.println(a.substring(start,end+1));
		return max_length;
		
	}
	public static void main(String[] a)
	{
		String arg="karrakabcddcbapriyanshu";
		System.out.println("Palindrome Length:"+findPalindrome(arg));
	}
}
