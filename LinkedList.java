/**
 * Linked List
 */
import java.util.*;

class LinkedList {
	private Node head;
	private int length;

	/**
	 * constructors
	 */
	public LinkedList(){
		head = new Node();
	}
	/**
	 * Getters and Setters
	 */
	public Node getHead(){
		return head;
	}

	/**
	 * push [Given an int, add a new node at the head of the list with this value.]
	 * @param value [int to be placed in the node value]
	 */
	public void push(int value){
		Node next = new Node(value, head.getNext());
		head.setNext(next);
	}

	/**
	 * length [Return the number of nodes in the linked list.]
	 * @return [returns the length of the linked list]
	 */
	public int length(){
		int length = 0;
		Node next = head;
		while(next.getNext()!=null){
			next = next.getNext();
			length++;
		}
		return length;
	}

	public void empty(){
		head = new Node();
		length = 0;
	}

	public void buildOneTwoThree(){
		empty();
		push(3);
		push(2);
		push(1);

	}

	public void print(){
		if (head == null || head.getNext() == null) {
			System.out.println("List is empty");
			return;
		}

		Node current = head.getNext();
		while(current != null){
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
	}

	public int getNth(int index){
		if (index>length()){
			return -1;
		}
		Node next = head;
		for (int i=0; i!=index; i++) {
			next = next.getNext();	
		}
		return next.getValue();
	}

	public int pop(){
		Node first = head.getNext();
	 	Node next = first.getNext();
	 	first.setNext(null);
	 	head.setNext(next);
	 	return first.getValue();
	 }

	 public int linearSearch(int n) {
	 	int index = 0;
	 	Node next = head;
	 	boolean found = false;
	 	while(next.getNext()!=null&&!found) {
	 		next = next.getNext();
	 		if(next.getValue() == n) return index;
	 		index++;
	 	}
	 	return 0;
	 }

	 public void insertNth(int n, int value) {
	 	int index = 0;
	 	Node next = head;
	 	Node current = head;
	 	while(next.getNext()!= null&&index!=n) {
	 		current = next;
	 		next = next.getNext();
	 		index++;
	 		if(index==n) {
	 			current = next;
	 			next = next.getNext();
	 			current.setNext(new Node(value, next));
	 		}
	 	}
	 	if(index == n) {
	 		head.setNext(new Node(value, head.getNext()));
	 	}
	 }

	 public void sortedInsert(int value){
		Node current = head.getNext();
		int index = 0;
		boolean run = true;
		while(run && current.getValue()<value){
			index++;
			if(current.getNext() != null){
				current = current.getNext();
			}else{
				run = false;;
			}	
		}
		insertNth(value, index);
	}
	 
}