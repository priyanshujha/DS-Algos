package Tree;

public class Node {
	public Node rightChild;
	public Node leftChild;
	public int value;

	public Node(int value)
	{
		this.value=value;
		rightChild=null;
		leftChild=null;
	}
}
