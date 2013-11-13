/**
* Program to create a linked list, print it's elements and  
 find the moddle of the linked list

*/
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class linkedList{
	Node head;
	Node last;
	linkedList(){
		head = null;
		last = null;
	}
	void insert(int data){
		Node nod = new Node(data);
		if(head == null){
			head = nod;
		}else{
			last.next = nod; 
		}
		last = nod;
	}
	void printList(){
		Node current = head;
		System.out.println("Elements are");
		while(current!=null){
			System.out.println(current.data);
			current = current.next;
		}


	}
	
	int middle(){
		int count =0;
		Node current = head,mid = null;
		System.out.println("Middle element is");
		while(current != null){
			count++;
			if(count == 1)
				mid = head;
			else if(count%2!=0)
				mid = mid.next;
			current = current.next;
		}
		return mid.data;

	}


public static void main(String [] args){
	linkedList list = new linkedList();
	list.insert(2);
	list.insert(5);
	list.insert(16);
	list.insert(6);
	list.insert(11);
	list.insert(12);
	list.printList();
	int n = list.middle();
	System.out.println(n);

}
}

