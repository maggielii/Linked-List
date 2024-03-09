package code;

public class LinkedList {

	private Node first;
	private Node last;
	
	public void push(int data)
	{
		Node newNode  = new Node(data);
		
		if(first == null) //if list is empty
			first = newNode;
		else 
		{
			last.setNext(newNode);
			newNode.setPrev(last);
		}
		last = newNode;
	}//newNode name gets destroyed
	
	public void pop()
	{
		if(last != first)
		{
			last = last.getPrev();
			last.setNext(null);
		}
		else //if only one node 
		{
			first = null;
			last = null;
		}
	}
	
	public void display()
	{
		Node temp = first;
		
		while(temp != null)
		{
			System.out.print( temp.getData() + " ");
			temp = temp.getNext();
		}
			
		System.out.println( );
		
		temp = last;
		
		while(temp != null)
		{
			System.out.print( temp.getData() + " ");
			temp = temp.getPrev();
		}
		
		System.out.println( );
		
	}
	
	public Node find(int target)
	{
		Node temp = first;
		
		while(temp != null)
		{
			if(temp.getData() == target)
			{
				return temp;
			}
			temp = temp.getNext();
		}
		
		return null;
	}
	
	public void pop(int target)
	{
		Node temp = find(target);
		
		if(temp == null)
		{}
		else if(temp == last)
			pop();
		else if(temp == first)
		{
			first.getNext().setPrev(null);
			first = first.getNext();
		}
		else
		{
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
		}
	}
	
	public void swap(int number1, int number2)
	{
		Node node1 = find(number1);
		Node node2 = find(number2);
		
		if(node1 != null && node2 != null && node1 != node2)
		{		
			Node temp = node1.getNext();
			boolean inOrder = false;
			
			while(temp != null)
			{
				if(temp == node2)
				{
					inOrder = true;
					break;
				}
				
				temp = temp.getNext();
			}
			
			if(!inOrder)//swapping node names
			{
				temp = node1;
				node1 = node2;
				node2 = temp;
			}
			
			if(node1 != first && node2 != last && node1.getNext() == node2)//adjacent and not first or last
			{
				Node temp2 = node1.getPrev();
				temp = node2.getNext();
				node1.setNext(node2.getNext());
				node2.setNext(node1);
				node1.getPrev().setNext(node2);
				temp.setPrev(node1);
				node1.setPrev(node2);
				node2.setPrev(temp2);
			}
			else if(node1 == first && node2 == last && node2.getPrev() == node1)//adjacent and first and last
			{ 
				node2.setNext(node1);
				node1.setPrev(node2);
				node2.setPrev(null);
				node1.setNext(null);
				first = node2;
				last = node1;
			}
			else if(node1 == first && node1.getNext() == node2)//adjacent and one is first
			{
				node1.setNext(node2.getNext());
				node2.getNext().setPrev(node1);
				node1.setPrev(node2); 
				node2.setNext(node1);
				node2.setPrev(null); 
				first = node2;
			}
			else if(node2 == last && node2.getPrev() == node1)//adjacent and second is last
			{
				node2.setPrev(node1.getPrev()); 
				node1.getPrev().setNext(node2);
				node1.setPrev(node2); 
				node2.setNext(node1);
				node1.setNext(null);
				last = node1;
			}
			else if(node1 != first && node2 != last && node1.getNext().getNext() == node2)//one away and not first or last
			{
				Node temp2 = node1.getPrev();
				temp = node2.getNext();
				node1.getPrev().setNext(node2);
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node1.setNext(temp);
				temp.setPrev(node1);
				node1.setPrev(node2.getPrev());
				node2.getPrev().setPrev(node2);
				node2.setPrev(temp2);
			}
			else if(node1 == first && node2 == last && node1.getNext().getNext() == node2)//one away and first and last
			{
				node2.setNext(node1.getNext());
				node1.getNext().setNext(node1);
				node1.setPrev(node1.getNext());
				node1.getNext().setPrev(node2);
				node1.setNext(null);
				node2.setPrev(null);
				first = node2;
				last = node1;
			}
			else if(node1 == first && node1.getNext().getNext() == node2)//one away and one is first
			{
				temp = node2.getNext();
				node2.setNext(node1.getNext());
				node1.getNext().setNext(node1);	
				node1.setNext(temp);
				temp.setPrev(node1);
				node1.setPrev(node2.getPrev());
				node2.getPrev().setPrev(node2);
				node2.setPrev(null);
				first = node2;
			}
			else if(node2 == last && node2.getPrev().getPrev() == node1)//one away and second is last
			{
				temp = node1.getPrev();
				node1.getPrev().setNext(node2);
				node2.setNext(node2.getPrev());
				node2.getPrev().setNext(node1);
				node1.setPrev(node1.getNext());
				node1.getNext().setPrev(node2);
				node2.setPrev(temp);
				node1.setNext(null);
				last = node1;
			}
			else if(node1 != first && node2 != last && node1.getNext() != node2 && node1.getNext().getNext() != node2)//two or more away and not first or last
			{
				Node temp2 = node1.getPrev();
				temp = node2.getNext();
				node1.getPrev().setNext(node2);
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node1.setNext(temp);
				
				temp.setPrev(node1);
				node1.setPrev(node2.getPrev());
				node2.getNext().setPrev(node2);
				node2.setPrev(temp2); 
			}
			else if(node1 == first && node2 == last && node1.getNext() != node2 && node1.getNext().getNext() != node2)//two or more away and swap first and last
			{
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node1.getNext().setPrev(node2);
				node1.setPrev(node2.getPrev());
				node1.setNext(null);
				node2.setPrev(null);
				first = node2;
				last = node1;
			}
			else if(node1 == first && node1.getNext() != node2 && node1.getNext().getNext() != node2)//two or more away and one is first
			{
				Node temp2 = node1.getNext();
				temp = node2.getNext();
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node1.setNext(temp);
				temp.setPrev(node1);
				node1.setPrev(node2.getPrev());
				temp2.setPrev(node2);
				node2.setPrev(null);
				first = node2;
			}
			else//two or more away and second is last
			{
				temp = node1.getPrev();
				node1.getPrev().setNext(node2);
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node1.setPrev(node2.getPrev());
				node1.getNext().setPrev(node2);
				node2.setPrev(temp);
				node1.setNext(null);
				last = node1;
			}
		}
	}
	
	public LinkedList() { //first and last default value is null so this isn't needed
		first = null;
		last = null;
	}
	
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	
}
