package animations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import br.GraphicNode;



public class LeafPanel extends JPanel implements MouseListener{
	private Graphics2D g2d;
	private GraphicNode[] nodes = new GraphicNode[6];
	private Point2D[] listOverPositionForBoxes;
	private LeafLogic logic;
	private Integer[] numbers;
	private Rectangle2D rectangleButton;
	private boolean runFirstTime = true, gameWon = false;
	private int size;

	public LeafPanel(LeafLogic logic){
		this.logic = logic;
		numbers = logic.getNumbers();
		setUpPositionsForBoxes();
		size = logic.getSize();

		setFocusable(true);
		addMouseListener(this);
	}
	public void paint(Graphics g) {
		super.paintComponents(g);
		g2d = (Graphics2D) g;
		Font font = new Font("Arial", Font.PLAIN, 20);
		g2d.setColor(Color.GREEN);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	
		g2d.setFont(font);

		if(runFirstTime){
			for(int i = 0; i < size; i++) 
			{
				nodes[i] = new GraphicNode(numbers[i], (int) listOverPositionForBoxes[i].getX(), (int) listOverPositionForBoxes[i].getY());
			}
			rectangleButton = new Rectangle2D.Double(630, 65, 60, 60);
			runFirstTime = false;
		}


		// Paints the nodes at their positions
		for(int i = 0; i <= 5; i++) 
		{
			g2d.setColor(nodes[i].getColor());
			g2d.fill(nodes[i].getShape());

			//Paint values	
			g2d.setColor(Color.WHITE);
			g2d.drawString(nodes[i].getStringForShape(),  (int) listOverPositionForBoxes[i].getX()+10, (int) listOverPositionForBoxes[i].getY()+30);
		}
		// Paint lines between nodes
		g2d.setColor(Color.GREEN);
		g2d.drawLine(375, 50, 290, 80);
		g2d.drawLine(275, 125, 350, 150);
		g2d.drawLine(275, 125, 175, 150);
		g2d.drawLine(375, 50, 460, 80);
		g2d.drawLine(480, 115, 550, 150);

		
		//Check-Button
		g2d.setColor(Color.YELLOW);
		g2d.fill(rectangleButton);
		g2d.setColor(Color.BLACK);
		g2d.drawString("OK", 650, 100);

		if(gameWon){
			Font font2 = new Font("Arial", Font.PLAIN, 70);
			g2d.setFont(font2);
			g2d.setColor(Color.MAGENTA);
			g2d.drawString("YOU'VE WON", 150, 150);
			g2d.setFont(font);
		}
	}


	public void setUpPositionsForBoxes(){
		System.out.println("setUpPositionsForBoxes");
		listOverPositionForBoxes = new Point2D[6];
		listOverPositionForBoxes[0] = new Point2D.Double(350, 0);
		listOverPositionForBoxes[1] = new Point2D.Double(250, 75);
		listOverPositionForBoxes[2] = new Point2D.Double(150, 150);
		listOverPositionForBoxes[3] = new Point2D.Double(323, 150);
		listOverPositionForBoxes[4] = new Point2D.Double(450, 75);
		listOverPositionForBoxes[5] = new Point2D.Double(525, 150);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + e.getY());
		for(int i = 0; i < size; i++){
			nodes[i].checkIfPointIsInsideNode(e.getPoint());
		}


		if(rectangleButton.contains(e.getPoint())){
			if(logic.checkIfLeavesAreMarked(nodes)) gameWon = true; setFocusable(false);
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}

