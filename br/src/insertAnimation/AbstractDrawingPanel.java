package insertAnimation;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class AbstractDrawingPanel extends JPanel implements Runnable{

	public void paintLine(GraphicalNode topNode, GraphicalNode bottomNode, Graphics2D g2) {
		g2.drawLine((int)bottomNode.getTopPoint().getX(), (int)bottomNode.getTopPoint().getY(), (int) topNode.getBottomPoint().getX(), (int) topNode.getBottomPoint().getY());
	}   

	public void paintNode(GraphicalNode nodeToBeDrawn, Graphics2D g2){
		g2.draw(nodeToBeDrawn.getShape());
		g2.drawString(nodeToBeDrawn.toString(), (int) nodeToBeDrawn.getValuePosition().getX(), (int) nodeToBeDrawn.getValuePosition().getY());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
