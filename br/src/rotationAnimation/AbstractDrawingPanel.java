package rotationAnimation;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class AbstractDrawingPanel extends JPanel implements Runnable{
	public void paintLine(GrahpicalNode topNode, GrahpicalNode bottomNode, Graphics2D g2) {
		g2.drawLine((int)bottomNode.getTopPoint().getX(), (int)bottomNode.getTopPoint().getY(), (int) topNode.getBottomPoint().getX(), (int) topNode.getBottomPoint().getY());
	}   

	public void paintNode(GrahpicalNode BNC, Graphics2D g2){
		g2.draw(BNC.getShape());
		g2.drawString(BNC.toString(), (int) BNC.getValuePosition().getX(), (int) BNC.getValuePosition().getY());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
