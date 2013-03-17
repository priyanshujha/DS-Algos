package Tree;

import java.util.*;



public class TreeTest {
	
	public static void main(String[] arg)
	{
		
		BinarySearchTree bst=new BinarySearchTree(70);
		
		bst.insert(bst.root,60);				
		bst.insert(bst.root,75);
		bst.insert(bst.root,50);				
		bst.insert(bst.root,62);
		bst.insert(bst.root,61);
		bst.insert(bst.root,64);
		bst.insert(bst.root,63);
		bst.insert(bst.root,85);
		bst.insert(bst.root,95);
		bst.insert(bst.root,89);
		bst.insert(bst.root,90);
		bst.insert(bst.root,87);
		System.out.println("recursive In order :");
		bst.printInOrderRecursive(bst.root);
		System.out.println("\nrecursive Pre Order:");
		bst.printPreOrderRecursive(bst.root);
		System.out.println("\nrecursive Post Order:");
		bst.printPostOrderRecursive(bst.root);
		
		System.out.println("\nIterative In order:");
		LinkedList<Node>inorderList=bst.printInOrder(bst.root);
		
		Iterator<Node> i=inorderList.iterator();
	
		while(i.hasNext())
		{
			System.out.print(i.next().value+"\t");
		}
		
		System.out.println("\nIterative Pre Order:");
		LinkedList<Node>preorderList=bst.printPreOrder(bst.root);
		
		i=preorderList.iterator();
	
		while(i.hasNext())
		{
			System.out.print(i.next().value+"\t");
		}
		System.out.println("\nIterative Post Order:");
		LinkedList<Node>postorderList=bst.postOrderTraversal(bst.root);
		
		i=postorderList.iterator();
	
		while(i.hasNext())
		{
			System.out.print(i.next().value+"\t");
		}
		
		System.out.println("\nBreadth First Traversal:");
		LinkedList<Node>bfsList=bst.printBreadthFirst(bst.root);		
		i=bfsList.iterator();	
		while(i.hasNext())
		{
			System.out.print(i.next().value+"\t");
		}


	}
	
}
