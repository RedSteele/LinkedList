/**
 * Linked List
 */

class LinkedList {
	private Node head;
	private int length
	/**
	 * constructors
	 */
	public LinkedList(){
		Node head = Node(p1);
	}
	/**
	 * Getters and Setters
	 */
	public Node getHead(){
		return head;
	}

	public void push(int value){
		Node next = Node(value, head.getNode());
		head.setNode(next);
		length++;
	}

	public int length(){
		return length;
	}
	public void buildOneTwoThree(){
		
	}
}