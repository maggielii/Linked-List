package code;

public class Node {

	private int data;
	private Node prev;
	private Node next;

	public Node() {
		this.data = 0;
	}
	
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
