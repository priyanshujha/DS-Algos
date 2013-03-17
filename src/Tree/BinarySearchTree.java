package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree(int data) {
		root = new Node(data);
	}

	public Node insert(Node node, int value) {
		if (node == null)
			return new Node(value);

		if (value == node.value)
			return node;
		else {
			if (value < node.value)
				node.leftChild = insert(node.leftChild, value);
			else
				node.rightChild = insert(node.rightChild, value);
		}
		return node;
	}

	public void printInOrderRecursive(Node node) {
		if (node == null)
			return;

		printInOrderRecursive(node.leftChild);
		System.out.print(node.value + "\t");
		printInOrderRecursive(node.rightChild);

	}

	public void printPreOrderRecursive(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + "\t");
		printPreOrderRecursive(node.leftChild);
		printPreOrderRecursive(node.rightChild);

	}

	public void printPostOrderRecursive(Node node) {
		if (node == null)
			return;

		printPostOrderRecursive(node.leftChild);
		printPostOrderRecursive(node.rightChild);
		System.out.print(node.value + "\t");
	}

	public LinkedList<Node> printInOrder(Node node) {
		Stack<Node> treeStack = new Stack<Node>();
		LinkedList<Node> inOrderList = new LinkedList<Node>();

		if (node == null)
			return inOrderList;

		while (true) {

			while (node != null) {
				treeStack.push(node);
				node = node.leftChild;
			}
			if (treeStack.isEmpty())
				break;
			node = treeStack.pop();
			inOrderList.add(node);
			node = node.rightChild;
		}
		return inOrderList;
	}

	public LinkedList<Node> printPreOrder(Node node) {
		Stack<Node> treeStack = new Stack<Node>();
		LinkedList<Node> inOrderList = new LinkedList<Node>();

		if (node == null)
			return inOrderList;

		while (true) {
			while (node != null) {
				treeStack.push(node);
				inOrderList.add(node);
				node = node.leftChild;
			}
			if (treeStack.isEmpty())
				break;
			node = treeStack.pop();
			node = node.rightChild;
		}
		return inOrderList;
	}

	public Node createLinkList(Node node, Node node2) {
		if (node == null)
			return null;

		node2 = node;
		node2.leftChild = createLinkList(node.leftChild, node2);
		while (node2.leftChild != null)
			node2 = node2.leftChild;

		node2.leftChild = createLinkList(node.rightChild, node2);
		return node;
	}

	public void levelOrderTraversal(Node node) {

	}

	int maxDepthIterative(Node root) {

		if (root == null)
			return 0;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		int maxDepth = 0;
		Node prev = null;

		while (!s.empty()) {

			Node curr = s.peek();
			if (prev == null || prev.leftChild == curr
					|| prev.rightChild == curr) {
				if (curr.leftChild != null)
					s.push(curr.leftChild);
				else if (curr.rightChild != null)
					s.push(curr.rightChild);
			} else if (curr.leftChild == prev) {
				if (curr.rightChild != null)
					s.push(curr.rightChild);
			} else {
				s.pop();
			}
			prev = curr;
			if (s.size() > maxDepth)
				maxDepth = s.size();
		}
		return maxDepth;
	}

	public static LinkedList<Node> postOrderTraversal(Node node) {
		Stack<Node> stack = new Stack<Node>();
		LinkedList<Node> postOrderList = new LinkedList<Node>();

		Node root = node;
		while (true) {

			if (root != null) {

				if (postOrderList.contains(root)) {
					postOrderList.add(stack.pop());
					root = null;
				} else {
					stack.push(root);
					root = root.leftChild;
				}

			} else {

				if (stack.isEmpty()) {
					break;
				} else if (stack.peek().rightChild == null) {
					root = stack.pop();
					postOrderList.add(root);
					if (root == stack.peek().rightChild) {
						postOrderList.add(stack.pop());
					}
				}

				if (!stack.isEmpty()) {
					root = stack.peek().rightChild;
				} else {
					root = null;
				}

			}
		}

		return postOrderList;
	}

	public LinkedList<Node> printBreadthFirst(Node node) {
		LinkedBlockingQueue<NodeLevel> treeQueue = new LinkedBlockingQueue<NodeLevel>();
		LinkedList<Node> bfsTraversal = new LinkedList<Node>();
		treeQueue.add(new NodeLevel(node, 0));
		int level = 0;
		int min_level = 0;
		boolean first = false;
		NodeLevel l = new NodeLevel();
		while (!treeQueue.isEmpty()) {
			l = treeQueue.remove();
			node = l.node;
			bfsTraversal.add(node);
			level = l.level;
			if (node.leftChild != null) {
				treeQueue.add(new NodeLevel(node.leftChild, l.level + 1));
			}
			if (node.rightChild != null) {
				treeQueue.add(new NodeLevel(node.rightChild, l.level + 1));
			}
			if (node.rightChild == null && node.leftChild == null && !first) {
				System.out.println("inside " + level);
				min_level = l.level;
				first = true;
			}
		}
		System.out.println("Difference in height:" + (level - min_level));
		return bfsTraversal;
	}

	public LinkedList<Node> printPostOrder(Node node) {
		Stack<Node> treeStack = new Stack<Node>();
		LinkedList<Node> postOrderList = new LinkedList<Node>();

		if (node == null)
			return postOrderList;
		int i = 0;
		while (i < 10) {
			i++;
			while (node != null) {
				treeStack.push(node);
				System.out.println("Pushed :" + node.value);
				node = node.leftChild;
			}
			if (treeStack.isEmpty())
				break;

			node = treeStack.peek();
			node = node.rightChild;
			if (node != null) {

				if (postOrderList.contains(node)) {
					System.out.println("inside!!");
					postOrderList.add(treeStack.pop());
					node = treeStack.peek();
				} else {
					treeStack.push(node);
					System.out.println("Pushed :" + node.value);
				}
			} else {
				node = treeStack.pop();
				System.out.println("Popped :" + node.value);
				postOrderList.add(node);
				node = treeStack.peek();
				System.out.println("Peeked : " + node.value);
				node = node.rightChild;
			}

		}
		return postOrderList;
	}

	public void findMin(int[][] a, int rows, int cols) {
	
		int min = a[0][0];
		int i = 0, k = 0, j = 0, r = 0;
		
		int[] minOfRows = new int[rows];

		for (i = 0; i < rows; i++)
			minOfRows[i] = 0;
		
		minOfRows[0] = 1;
		
		for (i = 1; i < k; i++) {
			
			min = Integer.MAX_VALUE;
			
			for (j = 0; j < rows; j++) {
				if (minOfRows[j] < cols) {
					if (a[j][minOfRows[j]] < min) {
						min = a[j][minOfRows[j]];
						r = j;
					}
				}
			}
			minOfRows[r]++;
		}
	}

}
