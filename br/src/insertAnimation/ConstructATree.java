package insertAnimation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConstructATree extends JApplet {
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Insert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new ConstructATree();
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
		private int iteration, maxIteration = 17, y = 0, j = 0;
		private GraphicalNode node1, node5, node8, node10, node13, node15, node30, node60, returnNode1, returnNode2;
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
				j++;
				if(j >=10){iteration++; j=0;y=0;}
				node15 = new GraphicalNode("15", 300, 30);				
				node10 = new GraphicalNode("10", 150, 100);
				node13 = new GraphicalNode("13", 225, 170);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);	
			}
			if(iteration == 1){
				if(j <= 149) j+=4;
				if(j >= 150){iteration++; j=0;y=0;}
				node60 = new GraphicalNode("60", 450-j, 30);
				node5 = new GraphicalNode("5", 150+j, 30);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);				
			}	

			if(iteration == 2){
				if(j <= 149) j+=4;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 150){iteration++; j=0;y=0;}
				node60 = new GraphicalNode("60", 300+j, 30+y);
				node5 = new GraphicalNode("5", 300-j, 30+y);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
			}

			if(iteration == 3){		
				g2.setColor(Color.RED);
				if(j <= 149) j+=4;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 150){iteration++; j=0;y=0;}
				node60 = new GraphicalNode("60", 450, 100);
				returnNode1 = new GraphicalNode("60", 450-j,100-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);
				g2.setColor(Color.BLACK);
				node5 = new GraphicalNode("5", 150-(j/2), 100+y);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
			}

			if(iteration == 4){
				if(j <= 149) j+=4;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 150){iteration++; j=0;y=0;}
				node5 = new GraphicalNode("5", 75, 170);
				g2.setColor(Color.RED);
				returnNode1 = new GraphicalNode("5", 75+(j/2), 170-y);
				paintNode(returnNode1, g2);		
				g2.drawLine((int) node15.getBottomPoint().getX(), (int) node15.getBottomPoint().getY(), (int) node15.getBottomPoint().getX()+j, (int) ((int) node15.getBottomPoint().getY()+(0.285*y)));
				g2.setColor(Color.BLACK);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
			}
			if(iteration == 5){
				if(j <= 149) j+=4;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 150){iteration++; j=0;y=0;}
				returnNode1 = new GraphicalNode("10", 150+j, 100-y);
				g2.setColor(Color.RED);
				g2.drawLine((int) node10.getBottomPoint().getX(), (int) node10.getBottomPoint().getY(), (int) node10.getBottomPoint().getX()-j/2,(int) (node10.getBottomPoint().getY()+y*0.285));
				paintNode(returnNode1, g2);	
				g2.setColor(Color.BLACK);

				node1 = new GraphicalNode("1", 150+j, 30);
				node30 = new GraphicalNode("30", 450-j, 30);			
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node15, node60, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node1, g2);
			}

			if(iteration == 6){
				if(j <= 149) j+=4;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 150){iteration++; j=0;y=0;}
				node1 = new GraphicalNode("1", 300-j, 30+y);
				node30 = new GraphicalNode("30", 300+j, 30+y);
				
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node5, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node1, g2);
			}

			if(iteration == 7){
				if(j <= 74) j+=4;
				if(y <= 69) y+=4;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node1 = new GraphicalNode("1", 150-j, 100+y);
				node30 = new GraphicalNode("30", 450-j, 100+y);
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node5, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node1, g2);
			}

			if(iteration == 8){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node1 = new GraphicalNode("1", 75-j/2, 170+y);
				node30 = new GraphicalNode("30", 375, 170);

				returnNode1 = new GraphicalNode("30", 375+j, 170-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);
				g2.setColor(Color.BLACK);

				g2.drawLine((int) node15.getBottomPoint().getX(), (int) node15.getBottomPoint().getY(), (int)node60.getTopPoint().getX(), (int) ((int) node60.getTopPoint().getY()));				
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node5, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node1, g2);
			}

			if(iteration == 9){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node1 = new GraphicalNode("1", 37, 240);
				node30 = new GraphicalNode("30", 375, 170);

				returnNode1 = new GraphicalNode("60", 450-j*2, 100-y);
				returnNode2 = new GraphicalNode("1", 37+j/2, 240-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);
				paintNode(returnNode2, g2);
				g2.drawLine((int) node60.getBottomPoint().getX(), (int) node60.getBottomPoint().getY(), (int) node60.getBottomPoint().getX()-j,(int) (node60.getBottomPoint().getY()+y*0.285));
				g2.setColor(Color.BLACK);
				
				drawInitialThreeNodes(g2);
				paintLine(node15, node10, g2);
				paintLine(node10, node13, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node5, g2);
				paintNode(node60, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node1, g2);
			}

			if(iteration == 10){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node8 = new GraphicalNode("8", 375-j, 30);
				paintNode(node8, g2);
				returnNode1 = new GraphicalNode("5", 75+j, 170-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);	
				g2.drawLine((int) node5.getBottomPoint().getX(), (int) node5.getBottomPoint().getY(), (int) node5.getBottomPoint().getX()-j/2,(int) (node5.getBottomPoint().getY()+y*0.285));
				g2.setColor(Color.BLACK);
																
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);				
			}

			if(iteration == 11){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node8 = new GraphicalNode("8", 300-j*2, 30+y);
				paintNode(node8, g2);
				returnNode1 = new GraphicalNode("10", 150+j*2, 100-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);	
				g2.setColor(Color.BLACK);
				
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}

			if(iteration == 12){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node8 = new GraphicalNode("8", 150-j, 100+y);
				
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}

			if(iteration == 13){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				node8 = new GraphicalNode("8", 75+j, 170+y);
				
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}

			if(iteration == 14){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75) {iteration++; j=0;y=0;}
				returnNode1 = new GraphicalNode("8", 150-j, 240-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);	
				g2.setColor(Color.BLACK);
				node8 = new GraphicalNode("8", 150, 240);
				
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}

			if(iteration == 15){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75){iteration++; j=0;y=0;}
				returnNode1 = new GraphicalNode("5", 75+j, 170-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);
				g2.drawLine((int) node5.getBottomPoint().getX(), (int) node5.getBottomPoint().getY(), (int) node5.getBottomPoint().getX()+j,(int) (node5.getBottomPoint().getY()+y*0.285));
				g2.setColor(Color.BLACK);
				
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}

			if(iteration == 16){
				if(j <= 74) j+=2;
				if(y <= 69) y+=2;
				if(y >= 70 && j >= 75) {iteration++; j=0;y=0;}
				returnNode1 = new GraphicalNode("10", 150+j*2, 100-y);
				g2.setColor(Color.RED);
				paintNode(returnNode1, g2);
				g2.setColor(Color.BLACK);	
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node5, node8, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}
			
			if(iteration == 17){
				j++;
				if(j >= 20){iteration=0; j=0;y=0;}
				drawInitialThreeNodes(g2);
				paintNode(node1, g2);
				paintNode(node5, g2);
				paintNode(node8, g2);
				paintNode(node30, g2);
				paintNode(node60, g2);
				paintLine(node5, node1, g2);
				paintLine(node5, node8, g2);
				paintLine(node10, node5, g2);
				paintLine(node15, node10, g2);
				paintLine(node15, node60, g2);
				paintLine(node10, node13, g2);
				paintLine(node60, node30, g2);
			}
		}

		private void drawInitialThreeNodes(Graphics2D g2){
			g2.draw(node15.getShape());
			g2.drawString(node15.toString(),(int) node15.getValuePosition().getX(), (int) node15.getValuePosition().getY());
			g2.draw(node10.getShape());
			g2.drawString(node10.toString(),(int) node10.getValuePosition().getX(), (int) node10.getValuePosition().getY());
			g2.draw(node13.getShape());
			g2.drawString(node13.toString(),(int) node13.getValuePosition().getX(), (int) node13.getValuePosition().getY());
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

	}
}