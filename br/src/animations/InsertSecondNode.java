package animations;

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

public class InsertSecondNode extends JApplet {
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Insert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new InsertSecondNode();
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
		private int iteration, maxIteration = 11, i = 0, y = 0, j = 0, y2 = 0, y3 = 0, k = 0;
		private GrahpicalNode node15, node10, nullNodeLeft, nullNodeRight, tierTwoNullNodeRight, tierTwoNullNodeLeft, returnNode, node13, tierThreeNullNodeRight, tierThreeNullNodeLeft;
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
				k++;
				if(k >=10) iteration++; j = i = y = y2 = 0;
				node15 = new GrahpicalNode("15", 140, 30);
				nullNodeLeft = new GrahpicalNode("null", 70, 100);
				nullNodeRight = new GrahpicalNode("null", 210, 100);
				paintNode(node15, g2);
				paintNode(nullNodeLeft, g2);				
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				paintLine(node15, nullNodeLeft, g2);
			}
			if(iteration == 1){
				if(i <= 129) i+=4;
				if(i >= 130) iteration ++;
				node10 = new GrahpicalNode("10", 10+i, 30);
				paintNode(node10, g2);
				paintNode(node15, g2);
				g2.drawString("public void insert(Comparable 10) { root = insert(10, 15 ); } ", 10, 20);
				g2.drawLine((int) node15.getValuePosition().getX()-30, (int) node15.getValuePosition().getY(), (int) node10.getValuePosition().getX()+30, (int) node10.getValuePosition().getY());
				g2.drawLine((int) node15.getValuePosition().getX()-30, (int) node15.getValuePosition().getY(),(int) node15.getValuePosition().getX()-45, (int) node15.getValuePosition().getY()+15);
				g2.drawLine((int) node15.getValuePosition().getX()-30, (int) node15.getValuePosition().getY(), (int)node15.getValuePosition().getX()-45, (int) node15.getValuePosition().getY()-15);
				paintNode(nullNodeLeft, g2);				
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				paintLine(node15, nullNodeLeft, g2); 
			}

			if(iteration == 2){
				i = 0;
				if(j <= 69) j+=4;
				if(y <= 69) y+=4;
				if(y >= 69 && j >= 69) iteration++;
				g2.drawString("15.compareTo(10) < 0, passes the node to the left" , 10, 20);
				node10 = new  GrahpicalNode("10", 140-j, 30+y);
				paintNode(node15, g2);

				//Pointer
				g2.drawLine((int) nullNodeLeft.getTopPoint().getX(), (int) nullNodeLeft.getTopPoint().getY(), (int) node15.getValuePosition().getX(), (int) node15.getValuePosition().getY());
				g2.drawLine((int) nullNodeLeft.getTopPoint().getX(), (int) nullNodeLeft.getTopPoint().getY(),(int) nullNodeLeft.getTopPoint().getX(), (int) nullNodeLeft.getTopPoint().getY()-15);
				g2.drawLine((int) nullNodeLeft.getTopPoint().getX(), (int) nullNodeLeft.getTopPoint().getY(), (int) nullNodeLeft.getTopPoint().getX()+15, (int) nullNodeLeft.getTopPoint().getY()+5);

				paintNode(node10, g2);
				paintNode(nullNodeLeft, g2);				
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				paintLine(node15, nullNodeLeft, g2);
			}

			if(iteration == 3){
				g2.drawString("Removes node 15's reference to its left null node" , 10, 20);
				g2.drawString("and generates its" , 10, 40);
				g2.drawString("own subtree." , 10, 60);
				paintNode(node15, g2);
				node10 = new  GrahpicalNode("10", 70, 100);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				if(i <= 69) i+=4;
				if(y2 <= 69) y2+=4;
				if(y2 >= 69 && i >= 69) iteration++; y = 0; j = 0;
				tierTwoNullNodeRight = new GrahpicalNode("null", 70+i, 100+y2);
				tierTwoNullNodeLeft = new GrahpicalNode("null", 70-i, 100+y2);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
			}

			if(iteration == 4){
				tierTwoNullNodeRight = new GrahpicalNode("null", 140, 170);
				tierTwoNullNodeLeft = new GrahpicalNode("null", 0, 170);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				g2.drawString("Node 10 now returns itself as node 15's left child." , 10, 20);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				g2.setColor(Color.RED);
				if(j <= 69) j+=4;
				if(y <= 69) y+=4;
				if(y >= 70 && j >= 70) iteration++; i = 0; y2 = 0;
				returnNode = new GrahpicalNode("10", 70+j, (int) (100-y));
				paintNode(returnNode, g2);
				g2.setColor(Color.BLACK);
			}

			if(iteration == 5){
				g2.drawString("Node 10 now returns itself as node 15's left child." , 10, 20);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				g2.setColor(Color.RED);
				if(i <= 69) i+=4;
				if(y2 <= 20) y2+=4;
				if(i >= 70 && y2 >= 20) iteration++; j = 0;
				g2.drawLine((int) node15.getBottomPoint().getX(), (int) node15.getBottomPoint().getY(), (int) node15.getBottomPoint().getX()-i, (int) node15.getBottomPoint().getY()+y2);
				g2.setColor(Color.BLACK);
			}

			if(iteration == 6){
				g2.drawString("public void insert(Comparable 13) { root = insert(13, 15 ); } ", 10, 20);
				if(j <= 128) j+=4;
				if(j >= 130) iteration++; i = 0; y = 0;
				node13  = new GrahpicalNode("13", 270-j, 30);
				paintNode(node13, g2);

				//Pointer
				g2.drawLine((int) node15.getValuePosition().getX()+30, (int) node15.getValuePosition().getY(),
						(int) node13.getValuePosition().getX()-10, (int) node13.getValuePosition().getY());
				g2.drawLine((int) node15.getValuePosition().getX()+30, (int) node15.getValuePosition().getY(),
						(int) node15.getValuePosition().getX()+45, (int) node15.getValuePosition().getY()-15);
				g2.drawLine((int) node15.getValuePosition().getX()+30, (int) node15.getValuePosition().getY(),
						(int)node15.getValuePosition().getX()+45, (int) node15.getValuePosition().getY()+15);

				paintNode(node15, g2);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				paintLine(node15, node10, g2);
			}

			if(iteration == 7){
				if(i <= 69) i+=2;
				if(y <= 69) y+=2;
				if(y >= 69 && i >= 69) iteration++; j = 0; y2 = 0;
				g2.drawString("15.compareTo(13) < 0, passes the node to the left" , 10, 20);
				node13 = new  GrahpicalNode("13", 140-i, 30+y);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeRight, g2);				
				paintLine(node10, tierTwoNullNodeRight, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
			}

			if(iteration == 8){
				if(j <= 69) j+=2;
				if(y2 <= 69) y2+=2;
				if(y2 >= 69 && j >= 69) iteration++; i = 0; y = 0;
				g2.drawString("10.compareTo(13) > 0, passes the node to the right" , 10, 20);
				node13 = new  GrahpicalNode("13", 70+j, 100+y2);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
			}

			if(iteration == 9){
				g2.drawString("Removes node 10's reference to its left null node" , 10, 20);
				g2.drawString("and generates its" , 10, 40);
				g2.drawString("own subtree." , 10, 60);
				node13 = new  GrahpicalNode("13", 140, 170);
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				if(i <= 69) i+=2;
				if(y <= 69) y+=2;
				if(y >= 69 && i >= 69) iteration++; j = 0; y2 = 0;
				tierThreeNullNodeRight = new GrahpicalNode("null", 140+i, 170+y);
				tierThreeNullNodeLeft = new GrahpicalNode("null", 140-i, 170+y);
				paintNode(tierThreeNullNodeRight, g2);
				paintLine(node13, tierThreeNullNodeRight, g2);
				paintNode(tierThreeNullNodeLeft, g2);
				paintLine(node13, tierThreeNullNodeLeft, g2);
			}

			if(iteration == 10){
				tierThreeNullNodeRight = new GrahpicalNode("null", 210, 240);
				tierThreeNullNodeLeft = new GrahpicalNode("null", 70, 240);
				paintNode(tierThreeNullNodeRight, g2);
				paintLine(node13, tierThreeNullNodeRight, g2);
				paintNode(tierThreeNullNodeLeft, g2);
				paintLine(node13, tierThreeNullNodeLeft, g2);
				node13 = new  GrahpicalNode("13", 140, 170);				
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);				
				if(j <= 69) j+=2;
				if(y2 <= 69) y2+=2;
				if(y2 >= 70 && j >= 70) iteration++; i = 0; y = 0;
				g2.setColor(Color.RED);
				returnNode = new GrahpicalNode("13", 140-j, (int) (170-y2));
				paintNode(returnNode, g2);
				g2.setColor(Color.BLACK);
			}

			if(iteration == 11){
				paintNode(tierThreeNullNodeRight, g2);
				paintLine(node13, tierThreeNullNodeRight, g2);
				paintNode(tierThreeNullNodeLeft, g2);
				paintLine(node13, tierThreeNullNodeLeft, g2);			
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				g2.setColor(Color.RED);
				if(i <= 69) i+=2;
				if(y <= 20) y+=2;
				if(y3 <= 69) y3+=2;
				if(i >= 70 && y >= 20 && y3>=69) iteration++; j = 0; y2 = 0;
				returnNode = new GrahpicalNode("10", 70+i, (int) (100-y3));
				paintNode(returnNode, g2);
				g2.drawLine((int) node10.getBottomPoint().getX(), (int) node10.getBottomPoint().getY(),
						(int) node10.getBottomPoint().getX()+i, (int) node10.getBottomPoint().getY()+y);
				g2.setColor(Color.BLACK);
			}

			if(iteration == 12){
				paintNode(tierThreeNullNodeRight, g2);
				paintLine(node13, tierThreeNullNodeRight, g2);
				paintNode(tierThreeNullNodeLeft, g2);
				paintLine(node13, tierThreeNullNodeLeft, g2);			
				paintNode(node13, g2);
				paintNode(node15, g2);
				paintNode(tierTwoNullNodeLeft, g2);
				paintLine(node10, tierTwoNullNodeLeft, g2);
				paintNode(node10, g2);
				paintNode(nullNodeRight, g2);
				paintLine(node15, nullNodeRight, g2);
				g2.setColor(Color.RED);
				if(j <= 69) j+=2;
				if(y2 <= 20) y2+=2;
				g2.drawLine((int) node15.getBottomPoint().getX(), (int) node15.getBottomPoint().getY(),
						(int) node15.getBottomPoint().getX()-j, (int) node15.getBottomPoint().getY()+y2);
				paintLine(node10, node13, g2);
				g2.setColor(Color.BLACK);
				if(j >= 70 && y2 >= 20) iteration = 0;
			}
		}
	}
}