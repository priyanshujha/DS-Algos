package DynamicProgramming;

public class longestSubSequence {

	/**
	 * Longest contiguous subsequence
	 * kadane's algorithm
	 * @author Priyanshu Jha
	 */
	public static void main(String[] args) {
		int[] seq={1,2,3,-1,-5,3,-5,-1,2,0,-4,7,-2,4,5,2,-3};
		int begin=0,begin_temp=0;
		int end=0;
		int max_so_far=seq[0];
		int max_ending_here=seq[0];
		for(int i=1;i<seq.length;i++)
		{
			max_ending_here+=seq[i];
			if(seq[i]>max_ending_here)
			{
				max_ending_here=seq[i];
				begin_temp=i;				
			}
			if(max_ending_here>max_so_far)
			{
				max_so_far=max_ending_here;				
				begin=begin_temp;
				end=i;
			}
				
		}
		System.out.println(max_so_far);
		for(int j=begin;j<=end;j++)
			System.out.print(seq[j]+" ");

	}

}
