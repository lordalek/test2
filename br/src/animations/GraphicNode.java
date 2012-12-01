package animations;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class GraphicNode {
	private int valueOfNode, sizeOfNode = 50;
	private Ellipse2D shape;
	private Color color;
	private Point2D bottomPoint, topPoint, valuePosition;
	
	public GraphicNode(int valueOfNode, int posX, int posY){
		this.valueOfNode = valueOfNode;
		shape = new Ellipse2D.Double(posX, posY, sizeOfNode, sizeOfNode);
		color = Color.GREEN;
		 left = right = null;
		 bottomPoint = new Point2D.Double(posX+25, posY+50);
		 topPoint = new Point2D.Double(posX+25, posY);
		 valuePosition = new Point2D.Double(posX+20, posY+30);
	}
	
	public Ellipse2D getShape(){
		return shape;
	}
	
	public String getStringForShape(){
		String valueAsString = Integer.toString(valueOfNode);
		return valueAsString;
	}
	
	public Point2D getPositionOfValue(){
		return valuePosition;
	}
	
	public void checkIfPointIsInsideNode(Point point){
		if(shape.contains(point)) {
			System.out.println(shape.contains(point));
			if(color == Color.GREEN)color = Color.BLUE;
			else if(color == Color.BLUE) color = Color.GREEN;
		}
	}
	
	public void changeColor(){
		if(color == Color.GREEN) color = Color.YELLOW;
		else color = Color.GREEN;
	}
	
	public void changeColor(String specialPosition){
		if(color == Color.GREEN) color = Color.RED;
		else color = Color.GREEN;
	}
	
	public Point2D getBottomPoint() {
		return bottomPoint;
	}

	public Point2D getTopPoint() {
		return topPoint;
	}

	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	GraphicNode left; //Left Child
	GraphicNode right; //Right Child
}
