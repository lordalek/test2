package animations;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeafExercise extends JApplet{
	public static void main(String s[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Leaf Exercise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JApplet applet = new LeafExercise();
		applet.init();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void init(){
		LeafLogic logic = new LeafLogic();
		JPanel panel = new LeafPanel(logic);
		getContentPane().add(panel);
	}
}
