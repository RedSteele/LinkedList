class Main{
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		a.buildOneTwoThree();
		a.print();
		System.out.println(a.getNth(2));
		a.sortedInsert(2);
		a.print();
	}
}

