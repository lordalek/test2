package animations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RemoveMin extends JApplet {
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Insert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new RemoveMin();
		applet.init();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setVisible(true);
	}

	public void init(){
		getContentPane().add(new DrawingPanel());
	}

	private class DrawingPanel extends AbstractDrawingPanel{
		private Thread thread;
		private JButton button, stopButton, playButton;
		private GrahpicalNode node15, node19, node10, node5, node13;
		private FindMinSymbol symbol;
		private int iteration, maxIteration = 10, i = 0, y = 0, j = 0, y2 = 0, y3 = 0, K = 0;
		public DrawingPanel(){
			this.setLayout(new BorderLayout());
			button = new JButton("Next");
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(iteration <maxIteration) iteration++;
					else if(iteration >= maxIteration) iteration = 0;
					start(); 
					System.out.println(iteration);
					repaint();
				}
			});

			playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					start();

				}
			});

			stopButton = new JButton("Pause");
			stopButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					stop();

				}
			});
			JPanel southButtonPanel = new JPanel();
			southButtonPanel.setLayout(new FlowLayout());
			southButtonPanel.add(stopButton);
			southButtonPanel.add(playButton);
			southButtonPanel.add(button);
			this.add(southButtonPanel, BorderLayout.SOUTH);
			iteration = 0;
		}




		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.clearRect(0, 0, getWidth(), getHeight());
			if(iteration == 0){
				K++;
				if(K >=10) iteration++;  j = i = y = y2 = 0;
				node19 = new GrahpicalNode("19", 250, 100);
				node15 = new GrahpicalNode("15", 180, 30);
				node10 = new GrahpicalNode("10", 90, 100);
				node5  = new GrahpicalNode("5", 20, 170);
				node13 = new GrahpicalNode("13", 160, 170);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);


			}

			if(iteration == 1){
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				i+=5;
				symbol = new FindMinSymbol(5+i, 25, "root");
				paintSymbol(symbol, g2);
				if(i >= 150) iteration++;
			}

			if(iteration == 2) {
				g2.drawString("Checks if the root has a left node and", 5, 15);
				g2.drawString("passes the method the the", 5, 30);
				g2.drawString("root's left child recursively", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				symbol = new FindMinSymbol(150, 30, "root");
				paintSymbol(symbol, g2);
				g2.setColor(Color.YELLOW);

				if(j <= 84)j+=5; 
				if(y <= 69)y+=4;
				g2.fill(new Rectangle2D.Double(node15.getBottomPoint().getX()-15-j, node15.getBottomPoint().getY()+0.285*y, 30, 30));
				g2.setColor(Color.BLACK);
				if(j >= 85 && y  >=70) iteration++; i = 0;
			}

			if(iteration == 3){
				g2.drawString("Checks if the root has a left node and", 5, 15);
				g2.drawString("passes the method the the", 5, 30);
				g2.drawString("root's left child recursively", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				paintSymbol(symbol, g2);
				g2.setColor(Color.GREEN);
				if(y2 <= 69)y2+=4;
				if(i <= 84)i+=5; 

				g2.fill(new Rectangle2D.Double(node10.getTopPoint().getX()-15+i, node10.getTopPoint().getY()-0.285*y2, 30, 30));
				g2.setColor(Color.BLACK);
				if(i >= 85 && y2  >=70) iteration++; j = 0; y = 0;
			}

			if(iteration == 4) {

				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				if(y <= 69)y+=4;
				if(j <= 114)j+=5; 
				symbol = new FindMinSymbol(150-j, (int)( 25+y), "root");
				paintSymbol(symbol, g2);
				if(j >= 115 && y  >=70) iteration++; i = 0; y2 = 0;

			}

			if(iteration == 5) {
				g2.drawString("Checks if node 10 has a left node and", 5, 15);
				g2.drawString("passes the method the the", 5, 30);
				g2.drawString("root's left child recursively", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				if(y2 <= 69)y2+=4;
				if(i <= 74)i+=5; 
				symbol = new FindMinSymbol(20+i/4, 95, "10");
				g2.setColor(Color.YELLOW);
				g2.fill(new Rectangle2D.Double(node10.getBottomPoint().getX()-15-i, node10.getBottomPoint().getY()+0.285*y2, 30, 30));
				g2.setColor(Color.BLACK);
				paintSymbol(symbol, g2);
				if(i >= 75 && y2  >=70) iteration++; j = 0; y = 0;
			}

			if(iteration == 6){
				g2.drawString("Checks if node 10 has a left node and", 5, 15);
				g2.drawString("passes the method the the", 5, 30);
				g2.drawString("root's left child recursively", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				paintSymbol(symbol, g2);
				g2.setColor(Color.GREEN);
				if(y <= 69)y+=4;
				if(j <= 84)j+=5; 				
				g2.fill(new Rectangle2D.Double(node5.getTopPoint().getX()-15+j, node5.getTopPoint().getY()-0.285*y, 30, 30));
				g2.setColor(Color.BLACK);
				if(j >= 85 && y  >=70) iteration++; i = 0; y2 = 0;
			}
			if(iteration == 7) {

				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				if(y2 <= 69)y2+=4;
				if(i <= 10)i+=3; 
				symbol = new FindMinSymbol(20-i, (int)( 115+y2), "10");
				paintSymbol(symbol, g2);
				if(i >= 11 && y2  >=70) iteration++; j = 0; y = 0;
			}

			if(iteration == 8) {
				g2.drawString("Checks if node 5 has a left node and", 5, 15);
				g2.drawString("passes the method the the", 5, 30);
				g2.drawString("root's left child recursively", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				if(y <= 30)y+=2;
				if(j <= 20)j+=1; 
				y3++;
				symbol = new FindMinSymbol(50, 190, "5");
				g2.setColor(Color.YELLOW);
				g2.fill(new Rectangle2D.Double(node5.getBottomPoint().getX()-15, node5.getBottomPoint().getY()+y, 30, 30));
				g2.setColor(Color.BLACK);
				paintSymbol(symbol, g2);
				System.out.println("x: " + (node5.getBottomPoint().getX()-15-j) +" Y: " +( node5.getBottomPoint().getY()+0.285*y));
				if(j >= 21 && y  >=31 && y3 >= 30) iteration++; i = 0; y2 = 0;
			}
			if(iteration == 9){
				g2.drawString("Since node 5 does not have a left", 5, 15);
				g2.drawString("node, node 5 itself is removed from", 5, 30);
				g2.drawString("node 10's left node reference.", 5, 45);
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintNode(node5, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node10, node5, g2);
				paintSymbol(symbol, g2);
				g2.setColor(Color.RED);
				if(y2 <= 30)y2+=2;
				if(i <= 20)i+=1; 
				g2.fill(new Rectangle2D.Double(9, 230 - y2 , 30, 30));
				g2.setColor(Color.BLACK);
				if(i >= 21 && y2  >=31) iteration++; j = 0; y = 0;
			}
			
			if(iteration == 10) {
				paintNode(node19, g2);
				paintNode(node15, g2);
				paintNode(node13, g2);
				paintNode(node10, g2);
				paintLine(node15, node19, g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				if(j <= 89) j+=5;
				if(y <= 69) y+=4;
				if(y >= 70 && j >= 150) iteration++;
				paintReturnNode(90+j,  (int)( 100 -y), g2, "10");
			}
		} 

		private void paintSymbol(FindMinSymbol symbol, Graphics2D g2){
			g2.draw(symbol.getShape());
			g2.drawString(symbol.getNode(), symbol.getNodeX(), symbol.getNodeY());
		}
		
		private void paintReturnNode(int x, int y, Graphics2D g2, String value){
			g2.setColor(Color.RED);
			g2.draw(new Ellipse2D.Double(x, y, 50, 50));
			g2.drawString(value, x+15, y+30);
			g2.setColor(Color.BLACK);
		}
			
		public void stop() {
			if(thread != null) thread = null;
		}

		public void start() {

			if (thread == null) {
				thread = new Thread(this);
				thread.start();
			}
		}

		@Override
		public void run() {
			while (thread != null) {
				System.out.println(iteration);
				try{
					Thread.sleep(100);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}

		private class FindMinSymbol {
			private int x, y;
			private Rectangle2D shape;
			private String node;
			public FindMinSymbol(int x, int y, String node){
				this.x = x;
				this.y = y;
				this.node = node;
				shape = new Rectangle2D.Double(x, y, 90, 25);
			}
			public Rectangle2D getShape(){
				return shape;
			}
			public String getNode(){
				return "findMin( " + node + " )";
			}

			public int getNodeX(){
				return x+5;
			}

			public int getNodeY(){
				return y+15;
			}
		}

	}
}