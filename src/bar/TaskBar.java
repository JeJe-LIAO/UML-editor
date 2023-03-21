package bar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import UMLview.Canvas;
import mode.AssociationLineMode;
import mode.ClassMode;
import mode.CompositionLineMode;
import mode.GeneralizationLineMode;
import mode.Mode;
import mode.SelectMode;
import mode.UsecaseMode;


public class TaskBar {
	public JButton selectedBtn = null;
	private ArrayList<JButton> btns;
	private Canvas canvas;
	
	public ArrayList<JButton> getBtns(){
		return btns;
	}

	public TaskBar() {
		canvas = Canvas.getInstance();
		btns = new ArrayList<JButton>(6);
										//posX,posY,height,width
		BtnSelect btnSelect = new BtnSelect(0,20,100,100);
		btns.add(btnSelect);
		BtnAssociationLine btnAssociLine = new BtnAssociationLine(0,120,100,100);
		btns.add(btnAssociLine);
		BtnGeneralizationLine btnGeneLine = new BtnGeneralizationLine(0,220,100,100);
		btns.add(btnGeneLine);
		BtnCompositionLine btnCompLine = new BtnCompositionLine(0,320,100,100);
		btns.add(btnCompLine);
		BtnClass btnClass = new BtnClass(0,420,100,100);
		btns.add(btnClass);
		BtnUseCase useCase = new BtnUseCase(0,520,100,100);
		btns.add(useCase);
	}
	public void addBtns(Canvas canvas) {
		for(JButton b:btns) {
			canvas.add(b);
		}
	}
	public class BtnSelect extends JButton {
		private Mode mode = new SelectMode();
		public BtnSelect(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("select");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
			}
		}
	}
	public class BtnAssociationLine extends JButton{
		private Mode mode = new AssociationLineMode();
		public BtnAssociationLine(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("association line");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
			}
		}
	}
	public class BtnGeneralizationLine extends JButton{
		private Mode mode = new GeneralizationLineMode();
		public BtnGeneralizationLine(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("generalizationLine line");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
			}
		}
	}
	public class BtnCompositionLine extends JButton{
		private Mode mode = new CompositionLineMode();
		public BtnCompositionLine(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("composition line");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
			}
		}
	}
	public class BtnClass extends JButton{
		private Mode mode = new ClassMode();
		public BtnClass(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("class");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
				
			}
		}
	}
	public class BtnUseCase extends JButton {
		private Mode mode = new UsecaseMode();
		public BtnUseCase(int posX, int posY, int height, int width) {
			setBounds(posX,posY,height,width);
			setText("use case");
			setBackground(Color.white);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(Color.white);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(Color.black);
				canvas.setCurrMode(mode);
			}
		}
	}
}
