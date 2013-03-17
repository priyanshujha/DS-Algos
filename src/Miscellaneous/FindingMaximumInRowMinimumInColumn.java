package Miscellaneous;

public class FindingMaximumInRowMinimumInColumn {

	/**
	 * @param args
	 */
	public static void find(int[][]a,int row,int col)
	{
		int[] rowMax=new int[row];
		int[] colMin=new int[col];
		
		for(int i=0;i<row;i++)
			rowMax[i]=a[i][0];
		for(int j=0;j<row;j++)
			colMin[j]=a[0][j];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(rowMax[i]<a[i][j])
					rowMax[i]=a[i][j];
				
				if(colMin[j]>a[i][j])
					colMin[j]=a[i][j];
			}			
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(rowMax[i]==colMin[j])
				{
					System.out.println(rowMax[i]);
					return;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{1,2,3},{4,5,6},{7,8,9}};
		find(grid,3,3);
	}

}
