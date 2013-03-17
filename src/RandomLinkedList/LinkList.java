package RandomLinkedList;

import java.util.HashMap;

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

	public Node customizedClone(Node h) {

		Node newHdr = null;
		HashMap<Node, Node> nodeHash = new HashMap<Node, Node>();
		Node temp = h;
		Node prev = null;
		while (temp != null) {
			Node newNode = null;
			Node randomNode = null;

			if (!nodeHash.containsKey(temp)) {
				newNode = new Node();
				newNode.value = temp.value;

				nodeHash.put(temp, newNode);

			}

			if (temp.random != null && !nodeHash.containsKey(temp.random)) {
				randomNode = new Node();
				randomNode.value = temp.random.value;
				nodeHash.put(temp.random, randomNode);
			}

			newNode = nodeHash.get(temp);
			randomNode = nodeHash.get(temp.random);
			newNode.random = randomNode;
			if (prev != null) {
				prev.next = newNode;
			} else {
				newHdr = newNode;
			}
			prev = newNode;
			temp = temp.next;
		}
		return newHdr;
	}

		  

	public void print() {
		Node temp = first;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("");
	}

}
