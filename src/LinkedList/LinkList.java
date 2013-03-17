package LinkedList;

public class LinkList {
	public Node first;

	public void insert(int value) {
		if (first == null) {
			first = new Node(value);
			return;
		}
		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(value);
		temp.next = newNode;
	}

	public int delete(int pos) {
		if (first == null || pos < 0)
			return -1;
		Node temp = first;
		Node prev = null;
		while (pos > 0) {
			if (temp != null) {
				prev = temp;
				temp = temp.next;
			} else {
				return -1;
			}
			pos--;
		}
		prev.next = temp.next;
		return temp.value;
	}

	public void print() {
		Node temp = first;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("");
	}
	public void reversePartialIterative(int gap,Node firstNode)
	{
		boolean firstPass=true;
		
		if(firstNode==null || firstNode.next==null)
			return;
		
		Node prev=null;
		Node temp=prev;
		Node next=firstNode;
		Node prevEndPoint=null;
		Node nextEndPoint=null;
		while(next!=null)
		{
			nextEndPoint=next;
			for(int i=0;i<gap;i++)
			{
				if(next==null)
				{
					break;
				}
				temp=next;
				next=next.next;				
				temp.next=prev;
				prev=temp;
			}
			if(firstPass)
			{
				first=temp;
				firstPass=false;
				prevEndPoint=firstNode;
			}
			else
			{
				prevEndPoint.next=temp;
				prevEndPoint=nextEndPoint;
			}
			
		}
		prevEndPoint.next=temp;
		nextEndPoint.next=null;		
	}
	

	public void reversePartial(int gap,Node tempFirst,Node nextPoint,int level) {
		
		Node temp = null, prev = null;
		Node next = tempFirst;
		
		Node endPoint=tempFirst;
		
		if (next == null)
			return;

		int i = 0;
		while (i < gap) {
			if (next == null) {
				nextPoint.next=temp;
				tempFirst.next=null;
				return;
			}
			temp = next;
			next = next.next;
			temp.next = prev;
			prev = temp;
			i++;
		}
		
		tempFirst=temp;
		if(level==1)
			first=temp;
		
		if(nextPoint!=null)
			nextPoint.next=temp;
		reversePartial(gap,next,endPoint,level+1);
	}

	public void reverseList() {
		Node temp = null, prev = null;
		Node next = first;
		if (first == null)
			return;
		while (next != null) {
			temp = next;
			next = next.next;
			temp.next = prev;
			prev = temp;
		}
		first = temp;
	}
}
