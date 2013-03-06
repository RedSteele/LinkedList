/**
 * Node
 * 		A member of a linked list. Holds an integer values and a link to another node
 */

public class Node{
	
	private int value;
	private Node next;

	/**
	 * Constructors
	 */
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
	}
	public Node(){
		this(0, null);
	}
	public Node(int value){
		this(value, null);
	}

	/**
	 * Getters and Setters
	 */

	public int getValue(){
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node next){
		this.next = next;
	}

}