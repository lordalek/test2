package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarkLeavesAndRoot extends JApplet{
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("MarkLeavesAndRoot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new MarkLeavesAndRoot();
		applet.init();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public void init(){
		JPanel panel = new DrawingPanel();
		getContentPane().add(panel);
	}
	
	private class DrawingPanel extends JPanel implements MouseListener {
		private GraphicNode[] listOfnodes;
		public DrawingPanel() {
			setPreferredSize(new Dimension(450, 300));
			addMouseListener(this);
			fillListOfNodes();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D) g;
			
			for(int i = 0; i <= 7; i++){
			g2.setColor(listOfnodes[i].getColor());
			g2.fill(listOfnodes[i].getShape());
			g2.setColor(Color.BLACK);
			g2.drawString(listOfnodes[i].getStringForShape(), (int) listOfnodes[i].getPositionOfValue().getX(), (int) listOfnodes[i].getPositionOfValue().getY());
			}
			g2.drawLine((int)listOfnodes[0].getBottomPoint().getX(), (int)listOfnodes[0].getBottomPoint().getY(),(int) listOfnodes[1].getTopPoint().getX(),(int) listOfnodes[1].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[1].getBottomPoint().getX(), (int)listOfnodes[1].getBottomPoint().getY(),(int) listOfnodes[2].getTopPoint().getX(),(int) listOfnodes[2].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[1].getBottomPoint().getX(), (int)listOfnodes[1].getBottomPoint().getY(),(int) listOfnodes[3].getTopPoint().getX(),(int) listOfnodes[3].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[0].getBottomPoint().getX(), (int)listOfnodes[0].getBottomPoint().getY(),(int) listOfnodes[4].getTopPoint().getX(),(int) listOfnodes[4].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[4].getBottomPoint().getX(), (int)listOfnodes[4].getBottomPoint().getY(),(int) listOfnodes[5].getTopPoint().getX(),(int) listOfnodes[5].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[4].getBottomPoint().getX(), (int)listOfnodes[4].getBottomPoint().getY(),(int) listOfnodes[7].getTopPoint().getX(),(int) listOfnodes[7].getTopPoint().getY());
			g2.drawLine((int)listOfnodes[5].getBottomPoint().getX(), (int)listOfnodes[5].getBottomPoint().getY(),(int) listOfnodes[6].getTopPoint().getX(),(int) listOfnodes[6].getTopPoint().getY());
			
			
			
			
		}
		
		private void fillListOfNodes(){
			listOfnodes = new GraphicNode[8];
			listOfnodes[0] = new GraphicNode(10, 175, 0);
			listOfnodes[1] = new GraphicNode(5, 75, 75);
			listOfnodes[2] = new GraphicNode(3, 0, 150);
			listOfnodes[3] = new GraphicNode(7, 100, 150);
			listOfnodes[4] = new GraphicNode(75, 275, 75);
			listOfnodes[5] = new GraphicNode(50, 200, 150);
			listOfnodes[6] = new GraphicNode(60, 250, 225);
			listOfnodes[7] = new GraphicNode(100, 325, 150);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			listOfnodes[2].changeColor();
			listOfnodes[3].changeColor();
			listOfnodes[6].changeColor();
			listOfnodes[7].changeColor();
			listOfnodes[0].changeColor("root");
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}


