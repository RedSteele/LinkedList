/**
 * Linked List
 */
import java.util.*;

class LinkedList {
	private Node head;

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
	public void setHead(Node head){
		this.head = head;
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
	public int getLength() {
		int length = 0;
		Node next = head;
		while(next.getNext()!=null) {
			next = next.getNext();
			length++;
		}
		return length;
	}
	/**
	 * [length description]
	 * @return [description]
	 */
	public int length() {
		int length = 0;
		Node next = head;
		while(next.getNext()!=null) {
			next = next.getNext();
			length++;
		}
		return length;
	}
	/**
	 * [empty description]
	 */
	public void empty(){
		head = new Node();
	}
	/**
	 * [buildOneTwoThree description]
	 */
	public void buildOneTwoThree(){
		empty();
		push(3);
		push(2);
		push(1);

	}
	/**
	 * [count description]
	 * @param  a [description]
	 * @return   [description]
	 */
	public int count(int a) {
	 	int count = 0;
	 	Node next = head;
	 	while(next.getNext()!= null) {
	 		next = next.getNext();
	 		if(next.getValue() == a) count++;
	 	}
	 	return count;
	 }
	/**
	 * [print description]
	 */
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
	/**
	 * [getNth description]
	 * @param  index [description]
	 * @return       [description]
	 */
	public int getNth(int index){
		if (index>getLength()){
			return -1;
		}
		Node next = head.getNext();
		for (int i=0; i!=index; i++) {
			next = next.getNext();	
		}
		return next.getValue();
	}
	/**
	 * [pop description]
	 * @return [description]
	 */
	public int pop(){
		Node first = head.getNext();
	 	Node next = first.getNext();
	 	first.setNext(null);
	 	head.setNext(next);
	 	return first.getValue();
	}
	/**
	 * [linearSearch description]
	 * @param  n [description]
	 * @return   [description]
	 */
	public int linearSearch(int n){
		int index = 0;
		Node next = head;
		boolean found = false;
		while(next.getNext()!=null&&!found){
			next = next.getNext();
			if(next.getValue() == n){
				return index;
			} 
			index++;
		}
	 	return -1;
	}
	/**
	 * [insertNth description]
	 * @param n     [description]
	 * @param value [description]
	 */
	public void insertNth(int n, int value) {
		int index = 0;
	 	Node next = head;
	 	Node current = head;
	 	if(n == 0) {
	 		push(value);
	 	}
	 	while(next.getNext()!= null&&index!=n) {
	 		next = next.getNext();
	 		index++;
	 		if(index == n) {
	 			current = next.getNext();
	 			next.setNext(new Node(value, current));
	 		}
	 	}
	 }
	 /**
	  * [sortedInsert description]
	  * @param value [description]
	  */
	public void sortedInsert(int value){
		Node current = head.getNext();
		int index = 0;
		while(index<getLength() && current.getValue()<value){
			index++;
			if(current.getNext() != null){
				current = current.getNext();
			}
		}
		insertNth(index, value);
	}
	/**
	 * [insertSort description]
	 */
	public void insertSort(){
		int[] values = new int[length()];
		Node now = head;
		for(int i = 0; i<length(); i++){
			now = now.getNext();
			values[i] = now.getValue();
		}
		empty();
		for(int i = 0; i<values.length; i++){
			sortedInsert(values[i]);
		}
	}
	/**
	 * [append description]
	 * @param as [description]
	 */
	public void append(LinkedList list) {
		Node next = head;
		while(next.getNext()!=null) {
			next = next.getNext();
		}
		next.setNext(list.getHead().getNext());
	}
	/**
	 * 
	 */
	public LinkedList[] frontBackSplit(){
		int halfLength = length()/2;
		LinkedList first = new LinkedList();
		LinkedList second = new LinkedList();
		LinkedList[] halves = {first, second};
		Node now = head;
		int[] values = new int[length()];
		for(int i = 0; i<length(); i++){
			now = now.getNext();
			values[i] = now.getValue();
		}
		for(int i = halfLength-1; i>=0; i--){
			first.push(values[i]);
		}
		for(int i = length() - 1; i>=halfLength; i--){
			second.push(values[i]);
		}
		return halves;
	}
	/**
	 * [removeDuplicates description]
	 */
	public void removeDuplicates(){
		if(length() == 0){
			return;
		}
		Node now = head.getNext();
		Node next = now.getNext();
		for(int i = 1; i < length(); i++){
			while(now != null && next != null && now.getValue() == next.getValue()){
				now.setNext(next.getNext());
				next = now.getNext();
			}
			if(now != null){
				now = now.getNext();
			}
			if(now != null && now.getNext() != null){	
				next = now.getNext();
			}	
		}	
	}

	/**
	 * NOW FOR THE FUN STUFF MADAFACKERS!!!
	 */
	private void insert(int value, Node next) {
		next.setNext(new Node(value, next.getNext()));
	}

	public static LinkedList sortedMerge(LinkedList a, LinkedList b){
		LinkedList sorted = new LinkedList();

		Node aNext = a.getHead().getNext();
		Node bNext = b.getHead().getNext();
		Node sortedNow = sorted.getHead();
		boolean run = true;

		while(run==true){
			if(aNext != null || bNext != null){			
				if(aNext.getValue()>=bNext.getValue()){
					sortedNow.setNext(aNext);
					aNext = aNext.getNext();
					sortedNow = sortedNow.getNext();
				}else{
					sortedNow.setNext(bNext);
					bNext = bNext.getNext();
					sortedNow = sortedNow.getNext();
				}
			}	
			if(aNext == null || bNext == null){
				run = false;
			}
		}
		return sorted;
	}
	



}