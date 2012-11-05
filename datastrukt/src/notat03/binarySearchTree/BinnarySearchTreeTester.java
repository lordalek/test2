package notat03.binarySearchTree;

public class BinnarySearchTreeTester {
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		
		t.insert("H");
		t.insert("D");
		t.insert("J");
		t.insert("B");
		t.insert("F");
		t.insert("I");
		t.insert("K");
		t.insert("A");
		t.insert("C");
		t.insert("E");
		t.insert("G"); 
		
		System.out.println("No of leafs = " + t.getNoOfLeafs());
		
		t.printNodesAt(2 );
	}
}
