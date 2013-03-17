package RandomLinkedList;

public class Node {
	public Node next;
	public Node random;
	public int value;
	public Node(int value)
	{
		this.value=value;
		this.next=null;
	}
	public Node()
	{
		
	}
	public void setRandom(Node random)
	{
		this.random=random;
	}
	
}