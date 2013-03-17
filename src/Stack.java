import java.io.*;
public class Stack {
    int top;
    int size;
    int[] stack;
    public Stack(int size)
    {
    	top=-1;
        this.size=size;        
        stack=new int[size];
    }
    public boolean push(int data)
    {
    	if(top==size)
            return false;
        stack[++top]=data;
        return true;
    }
    public int pop()
    {
    	//Assuming -1 as an error
        if(top==-1)
            return -1;
        return stack[top--];
    }
    public int findMinimum()
    {
    	//Assuming -1 as an error
        if(top==-1)
            return -1;
        
        int min=stack[0];
        for(int i=0;i<=top;i++)
        {
 			if(stack[i]<min)
                min=stack[i];
        }
        return min;
    
    }
    
    public static void main(String[] args) {
      Stack theStack = new Stack(10); 
      theStack.push(10);
      theStack.push(20);
      theStack.push(30);
      theStack.push(40);
      theStack.push(50);
      System.out.println(theStack.findMinimum());        
   }
    
}