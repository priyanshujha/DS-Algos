package Miscellaneous;
import java.util.HashMap;


public class swapAnagram {

	/**
	 * @param args
	 */
	public static void nonRepeatChangeToAnagram(char[] a,char[] b)
	{
		HashMap<Character,Integer> pos=new HashMap();
		for(int i=0;i<b.length;i++)
		{
			pos.put(b[i],i);
		}
		int len=a.length;
		int position=0;
		boolean swapped=false;
		System.out.println(new String(a));
		do
		{
			swapped=false;
			for(int i=1;i<len;i++)
			{
				if(i!=pos.get(a[i]))
				{
					char temp=a[i];
					a[i]=a[i-1];
					a[i-1]=temp;
					swapped=true;
				}
				
			}
			len=len-1;
		}while(swapped);
		
		System.out.println(new String(a));
		
	}
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			String a="dogs";
			String b="gdos";
			char[] stra=a.toCharArray();
			char[] strb=b.toCharArray();
			nonRepeatChangeToAnagram(stra,strb);
	}

}
