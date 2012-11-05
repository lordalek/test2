package br;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class InsertAnimation extends JApplet{
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Insert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new InsertAnimation();
		applet.init();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setVisible(true);
	}

	public void init(){
		InsertPanel panel = new InsertPanel();
		getContentPane().add(panel);
	}

	private class InsertPanel extends JPanel{
		private Thread thread;
		private int step, maxSteps = 6;
		private BinaryNodeComparable[] nodes;
		JButton button;
		
		public InsertPanel(){
			this.setLayout(new BorderLayout());
			button = new JButton("Next");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(step <= maxSteps) step++;
					else step = 1;
					repaint();
				}
			});
			step = 1;
			nodes = new BinaryNodeComparable[6];
			this.add(button, BorderLayout.SOUTH);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.clearRect(0, 0, getWidth(), getHeight());
			if(step==1) setUpThePlayBoard(g2);
			if(step==2) initialInsert(g2);
			if(step==3) scndInsert(g2);
			if(step==4) thrdInsert(g2);
			if(step==5) frthInsert(g2);
			if(step==6) ffhInsert(g2);
		}

		private void setUpThePlayBoard(Graphics2D g2) {
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("We create an empty Tree", 30, 40);
			g2.drawString("new BinarySearchTree() {root = null}", 30, 60);
			g2.drawRect(350, 75, 350, 200);
			g2.drawRect(200, 155, 350, 200);
			g2.drawRect(400, 110, 350, 200);
			g2.drawRect(100, 190, 350, 200);
			g2.drawString("empty symbol of a tree, the rectangles", 350, 250);

		}

		private void initialInsert(Graphics2D g2){
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("Since root equals null, the first node is simply put as the root node.", 30, 40);
			g2.drawString("if(root == null) root = new BinaryNode(\"Node1\").", 30, 60);
			nodes[0] = new BinaryNodeComparable("node 1", 350, 75);
			printNodes(g2, 0);
		}

		private void scndInsert(Graphics2D g2){
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("It is when one inserts the second node that recursion kicks in.", 10, 40);
			g2.drawString("The method first checks wether the new node is smaller that the root's left child.", 10, 60);
			g2.drawString("Since the Node 1's left child is null,", 10, 80);
			g2.drawString("the algorithm will just simply insert the new node there.", 10, 100); 
			nodes[1] = new BinaryNodeComparable("node 2", 275, 150);
			printNodes(g2, 1);
//			g2.drawString("If one examines the source code for the insert method, one can percieve that .", 10, 80);
		
		}
		
		private void thrdInsert(Graphics2D g2){
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("Inserting the second node follows the same logic, given that the new node is smaller than node 2.", 10, 40);
			g2.drawString("Let is imagine that node 3 is larger than node 1, and therefor node 3 is inserted into node 1's right child", 10, 60);
			nodes[2] = new BinaryNodeComparable("node 3", 425, 150);
			printNodes(g2, 2);
		}
		
		private void frthInsert(Graphics2D g2){
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("This tree will balance itself out naturaly due to the recursive compare-checks.", 10, 40);
			g2.drawString("Let us assign some values to the nodes and consder inserting a new node", 10, 60);
			nodes[0] = new BinaryNodeComparable("10", 350, 75);
			nodes[1] = new BinaryNodeComparable("5", 275, 150);
			nodes[2] = new BinaryNodeComparable("13", 425, 150);
			printNodes(g2, 2);
		}
		
		private void ffhInsert(Graphics2D g2){
			g2.drawString("Step #"+step, 10, 20);
			g2.drawString("Let us give our new node the value \" 7 \"", 10, 40);
			g2.drawString("Looking at how the insert algorithm implements recursion, it first checks if our new node is to be passed to the root's left- or right child", 10, 60);
			nodes[3] = new BinaryNodeComparable("7", 350, 250);
			printNodes(g2, 3);
		}
		
		private void printNodes(Graphics2D g2, int node){
			for(int i = 0; i <= node; i++){
			g2.draw(nodes[i].getShape());
			g2.drawString(nodes[i].toString(), (int) nodes[i].getValuePosition().getX(), (int) nodes[i].getValuePosition().getY());
			if(i == 1) g2.drawLine((int) nodes[i-1].getBottomPoint().getX(), (int) nodes[i-1].getBottomPoint().getY(), (int) nodes[i].getTopPoint().getX(), (int) nodes[i].getTopPoint().getY());
			if(i == 2) g2.drawLine((int) nodes[i-2].getBottomPoint().getX(), (int) nodes[i-2].getBottomPoint().getY(), (int) nodes[i].getTopPoint().getX(), (int) nodes[i].getTopPoint().getY());
			}
		}
			
//		public void start() {
//			
//			if (thread == null) {
//				thread = new Thread(this);
//				thread.start();
//			}
//		}

		public void stop() {
			thread = null;
		}

		public void run() {
			while (thread != null) {
				try{

					if(step > maxSteps) step = 1;
					Thread.sleep(3000);
					step++;

				} catch (InterruptedException e) {
				}
				repaint();
			}
			thread = null;
		}
	}
}
