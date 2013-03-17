package LinkedList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;


public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkList l=new LinkList();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);		
		l.insert(60);
		l.insert(70);
		l.insert(80);
		l.insert(90);
		l.insert(100);
		l.insert(110);
		l.insert(120);
		
		l.print();
		//l.reversePartial(3,l.first,null,1);
		l.print();
		l.reversePartialIterative(3,l.first);
		l.print();
	
	}


}
