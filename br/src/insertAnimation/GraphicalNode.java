package insertAnimation;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

//Basic node stored in unbalanced binary search trees
//Note that this class is not accessible outside
//of this package.

class GraphicalNode {
	private Point2D bottomPoint, topPoint, valuePosition;
	private Ellipse2D shape;
	private int sizeOfNode = 50;
	// Constructors
	public GraphicalNode(Comparable theElement, int posX, int posY) {
		element = theElement;
		left = right = null;
		bottomPoint = new Point2D.Double(posX+25, posY+50);
		topPoint = new Point2D.Double(posX+25, posY);
		valuePosition = new Point2D.Double(posX+15, posY+30);
		shape = new Ellipse2D.Double(posX, posY, sizeOfNode, sizeOfNode);
	}

	public Point2D getValuePosition() {
		return valuePosition;
	}
	
	public String toString(){
		return (String) element;
	}

	public Ellipse2D getShape(){
		return shape;
	}

	public Point2D getBottomPoint() {
		return bottomPoint;
	}

	public Point2D getTopPoint() {
		return topPoint;
	}

	// Friendly data; accessible by other package routines
	Comparable element; // The data in the node
	GraphicalNode left; // Left child
	GraphicalNode right; // Right child
}