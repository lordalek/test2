package deleteAnimation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Remove extends JApplet {
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
		private GrahpicalNode node15, node16, node13, node20, node17, node21;
		private RemoveSymbol rs;
		private int iteration, maxIteration = 7, y = 0, j = 0;
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
				g2.drawString("Remove(node16, node15)", 5, 20);
				node15 = new GrahpicalNode("15", 150, 30);
				node13 = new GrahpicalNode("13", 75, 100);
				node20 = new GrahpicalNode("20", 225, 100);
				node21 = new GrahpicalNode("21", 280, 170);
				node17 = new GrahpicalNode("17", 200, 240);
				node16 = new GrahpicalNode("16", 175, 170);
				paintNode(node16, g2);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node16, g2);
				paintLine(node20, node21, g2);
				paintLine(node16, node17, g2);
				j+=3;
				paintRemoveSymbol(200-j, 30, g2);
				if(j >= 50) { iteration++; j = 0; y = 0;}
			}
			
			if(iteration == 1){
				g2.drawString("node16 > node15, passed to the right", 5, 20);
				paintNode(node16, g2);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node16, g2);
				paintLine(node20, node21, g2);
				paintLine(node16, node17, g2);
				j+=3;
				y+=3;
				System.out.println(j +" y: "+ y);
				paintRemoveSymbol(150+j, 30+y, g2);
				if(j >= 75 && y >=70){ iteration++; j = 0; y = 0;}
			}
			
			if(iteration == 2){
				g2.drawString("node16 < node20, passed to the left", 5, 20);
				paintNode(node16, g2);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node16, g2);
				paintLine(node20, node21, g2);
				paintLine(node16, node17, g2);
				if(j < 70) j+=3;
				y+=3;
				paintRemoveSymbol(225-j, 100+y, g2);
				if(j >= 5 && y >= 70){iteration++; j=0; y=0;}
			}
			
			if(iteration == 3){
				g2.drawString("node16 < node20, passed to the left", 5, 20);
				
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node16, g2);
				paintLine(node20, node21, g2);
				
				
				g2.setColor(Color.RED);
				if(j <= 75){j+=3; y+=3;}
				paintNode(node16, g2);
				
				node16 = new GrahpicalNode("16", 175-j, 170+y);
				System.out.println(j + " y: " + y);
				g2.drawLine((int)node16.getTopPoint().getX()-30,(int) node16.getTopPoint().getY(),(int) node16.getTopPoint().getX()+30,(int) node16.getTopPoint().getY()+50);
				g2.drawLine((int)node16.getTopPoint().getX()+30,(int) node16.getTopPoint().getY(),(int) node16.getTopPoint().getX()-30,(int) node16.getTopPoint().getY()+50);
				paintRemoveSymbol(155-j, 170+y, g2);
				if(j >= 75){ iteration++; j = 0; y = 0;}
			}
			
			if(iteration == 4){
				g2.drawString("Reference to node16 is removed", 5, 20);
				paintRemoveSymbol(80, 245, g2);
				node16 = new GrahpicalNode("16", 100, 245);
				g2.setColor(Color.RED);
				paintNode(node16, g2);
				g2.setColor(Color.BLACK);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node21, g2);
				if(j <= 124)j+=4; 
				if(y <= 90)y+=3;
				System.out.println(j + " y: " + y);
				if(y >= 91 && j >= 125){ iteration++; j = 0; y = 0;}
				g2.drawLine((int) node20.getBottomPoint().getX(), (int) node20.getBottomPoint().getY(), (int) node16.getTopPoint().getX()+j, (int) node16.getTopPoint().getY()-y);
				
				
			}
			
			if(iteration == 5){
				g2.drawString("Node17 is set as node20's left child", 5, 20);
				g2.setColor(Color.RED);
				paintNode(node16, g2);
				paintRemoveSymbol(80, 245, g2);
				g2.setColor(Color.BLACK);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node21, g2);
				if(j <= 24) j+=1;
				if(y <= 89) y+=4;
				if(y >= 90 && j >= 24){ iteration++; j = 0; y = 0;}
				System.out.println(j + " y: " +y);
				g2.drawLine((int) node20.getBottomPoint().getX(), (int) node20.getBottomPoint().getY(), (int) node20.getBottomPoint().getX()-j, (int) node20.getBottomPoint().getY()+y);
			}
			
			if(iteration == 6){
				g2.drawString("Node20 returns itself to its root", 5, 20);
				g2.setColor(Color.RED);
				paintNode(node16, g2);
				paintRemoveSymbol(80, 245, g2);
				g2.setColor(Color.BLACK);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node20, node21, g2);
				paintLine(node20, node17, g2);
				if(j <= 74) j+=4;
				if(y <= 69) y+=4;
				g2.drawLine((int) node15.getBottomPoint().getX(), (int) node15.getBottomPoint().getY(), (int) node15.getBottomPoint().getX()+j, (int) ((int) node15.getBottomPoint().getY()+(0.285*y)));
				paintReturnNode(225-j, 100-y, g2, "20");
				if(y >= 70 && j >= 75){ iteration++; j = 0; y = 0;}
				System.out.println(j + " y: " +y);			
			}
			
			if(iteration == 7){
				g2.setColor(Color.RED);
				paintNode(node16, g2);
				paintRemoveSymbol(80, 245, g2);
				g2.setColor(Color.BLACK);
				paintNode(node17, g2);
				paintNode(node21, g2);
				paintNode(node20, g2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintLine(node15, node13, g2);
				paintLine(node15, node20, g2);
				paintLine(node20, node17, g2);
				paintLine(node20, node21, g2);
				j+=3;
				if(j >= 50) { iteration=0; j = 0; y = 0;}
			}
		}

		private void paintRemoveSymbol(int x, int y, Graphics2D g2){
			g2.setFont(new Font("SansSerif", 10, 15));
			rs = new RemoveSymbol(x, y);
			g2.drawString(rs.toString(), rs.getX(), rs.getY());
			g2.setColor(Color.RED);
			g2.draw(rs.getLeftCross());
			g2.draw(rs.getRightCross());
			g2.setColor(Color.BLACK);
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
		
		private class RemoveSymbol {
			private int x, y;
			private String txt = "Node16";
			public RemoveSymbol(int x, int y){
				this.x = x;
				this.y = y;
			}
			
			public String toString(){
				return txt;
			}
			
			public int getX(){
				return x;
			}
			
			public int getY(){
				return y;
			}
			
			public Line2D getLeftCross(){
				return new Line2D.Double(x, y+5, x+50, y-10);
			}
			
			public Line2D getRightCross(){
				return new Line2D.Double(x+50, y+5, x, y-10);
			}
		}
	}
}