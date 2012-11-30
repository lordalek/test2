package animations;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class AbstractDrawingPanel extends JPanel implements Runnable{
	public void paintLine(GrahpicalNode topNode, GrahpicalNode bottomNode, Graphics2D g2) {
		g2.drawLine((int)bottomNode.getTopPoint().getX(), (int)bottomNode.getTopPoint().getY(), (int) topNode.getBottomPoint().getX(), (int) topNode.getBottomPoint().getY());
	} 
	
	public void removeLine(GrahpicalNode topNode, GrahpicalNode bottomNode, Graphics2D g2, int x, int y){
		g2.drawLine((int)bottomNode.getTopPoint().getX()-x, (int)bottomNode.getTopPoint().getY()-y, (int) topNode.getBottomPoint().getX(), (int) topNode.getBottomPoint().getY());
	}
	
	public void paintNewLine(int x, int y, GrahpicalNode startNode, Graphics2D g2){
		g2.drawLine( (int) startNode.getBottomPoint().getX(), (int) startNode.getBottomPoint().getY(), (int) startNode.getBottomPoint().getX() + x, (int) startNode.getBottomPoint().getY() + y);
	}

	public void paintNode(GrahpicalNode BNC, Graphics2D g2){
		g2.draw(BNC.getShape());
		g2.drawString(BNC.toString(), (int) BNC.getValuePosition().getX(), (int) BNC.getValuePosition().getY());
	}
	
	public void paintNodeWithColor(GrahpicalNode BNC, Graphics2D g2, Color color){
		g2.setColor(color);
		g2.draw(BNC.getShape());
		g2.drawString(BNC.toString(), (int) BNC.getValuePosition().getX(), (int) BNC.getValuePosition().getY());
		g2.setColor(Color.BLACK);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
