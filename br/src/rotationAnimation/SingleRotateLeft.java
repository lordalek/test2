package rotationAnimation;

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


public class SingleRotateLeft extends JApplet {
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Insert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new SingleRotateLeft();
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
		Color red = Color.RED, green = Color.GREEN, blue = Color.BLUE;
		
		private JButton button, stopButton, playButton;
		private GrahpicalNode node1, node2, node4, node6, node8, node10, node12, node14, node16;
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
				node1 = new GrahpicalNode("1", 170, 310);
				paintNode(node1, g2);
				node2 = new GrahpicalNode("2", 240, 240);
				paintNode(node2, g2);
				node4 = new GrahpicalNode("4", 310, 170);
				paintNodeWithColor(node4, g2, blue);
				node6 = new GrahpicalNode("6", 355, 240);
				paintNode(node6, g2);
				node8 = new GrahpicalNode("8", 380, 100);
				paintNodeWithColor(node8, g2, red);
				node10 = new GrahpicalNode("10", 425, 170);
				paintNode(node10, g2);
				node12 = new GrahpicalNode("12", 450, 30);
				paintNode(node12, g2);
				paintLine(node2, node1, g2);
				paintLine(node4, node2, g2);
				paintLine(node4, node6, g2);
				paintLine(node8, node4, g2);
				paintLine(node8, node10, g2);
				paintLine(node12, node8, g2);
			}
			if(iteration == 1){
				paintNode(node1, g2);
				paintNode(node2, g2);
				paintNodeWithColor(node4, g2, blue);
				paintNode(node6, g2);
				paintNodeWithColor(node8, g2, red);
				paintNode(node10, g2);
				paintNode(node12, g2);
				paintLine(node2, node1, g2);
				paintLine(node4, node2, g2);
				paintLine(node8, node10, g2);
				paintLine(node12, node8, g2);
				paintLine(node8, node4, g2);
				if(y < 20)y++; 
				if(j < 45)j+=2;
				removeLine(node4, node6, g2, j, y);
				if(y >= 20 && j >= 45){iteration++; y = j = 0;}
			}
			
			if(iteration == 2){
				paintNode(node1, g2);
				paintNode(node2, g2);
				paintNodeWithColor(node4, g2, blue);
				paintNode(node6, g2);
				paintNodeWithColor(node8, g2, red);
				paintNode(node10, g2);
				paintNode(node12, g2);
				paintLine(node2, node1, g2);
				paintLine(node4, node2, g2);
				paintLine(node8, node10, g2);
				paintLine(node12, node8, g2);
				if(j < 70) j+=3;
				if(y < 20) y++;
				removeLine(node8, node4, g2, -j, y);
				if(j >= 70 && y >= 20){iteration++; j = y = 0;}
			}
			if(iteration == 3){
				paintNode(node1, g2);
				paintNode(node2, g2);
				paintNodeWithColor(node4, g2, blue);
				paintNode(node6, g2);
				paintNodeWithColor(node8, g2, red);
				paintNode(node10, g2);
				paintNode(node12, g2);
				paintLine(node2, node1, g2);
				paintLine(node4, node2, g2);
				paintLine(node8, node10, g2);
				paintLine(node12, node8, g2);
				
			}
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