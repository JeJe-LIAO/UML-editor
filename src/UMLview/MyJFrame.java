package UMLview;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import bar.TaskBar;
import bar.MenuBar;

public class MyJFrame extends JFrame{
	private Canvas canvas;
	private TaskBar taskBar;
	private MenuBar menuBar;

	public MyJFrame () {
		setSize(630, 650);                       // �]�w�����j�p
		setLocationRelativeTo(null);             // �������m�]�w��ù�����
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		canvas = Canvas.getInstance();;
		taskBar = new TaskBar();
		menuBar = new MenuBar();
		canvas.setLayout(null);

		canvas.add(menuBar);
		taskBar.addBtns(canvas);
		
		setContentPane(canvas);
		setVisible(true);	
		
	}
}
