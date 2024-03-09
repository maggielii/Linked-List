package code;

public class LinkedListTester {

	public static void main(String[] args) {

		LinkedList LL = new LinkedList();
		
		LL.push(1);
		LL.push(2);
		LL.push(3);
		LL.push(4);
		LL.push(5);
		LL.push(6);
		LL.display();
		
		LL.swap(2, 4);
		LL.display();

	}

}
