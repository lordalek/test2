package notat03.binarySearchTree;

class BinaryNodeWithSize extends BinaryNode {
    BinaryNodeWithSize( Comparable x ) {
        super( x );
        size = 0;
    }
    
    int size;
}