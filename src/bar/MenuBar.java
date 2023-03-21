package bar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UMLview.Canvas;
import bar.TaskBar.BtnSelect.btnListener;
import shape.Shape;

public class MenuBar extends JMenuBar{
	private JMenu menuFile;
	private JMenu menuEdit;
	private ItemGroup itemGroup;
	private ItemUnGroup itemUnGroup;
	private ItemRename itemRenmae;
	private Canvas canvas;
	
	public MenuBar() {
		canvas = Canvas.getInstance();
		setBounds(0,0,620,20);

		JMenu menuFile = new JMenu("File");   
		JMenu menuEdit = new JMenu("Edit");
		ItemGroup itemGroup  = new  ItemGroup("Group");
		ItemUnGroup itemUnGroup  = new  ItemUnGroup("UnGroup");
		ItemRename itemRenmae  = new  ItemRename("change object name");
		menuEdit.add(itemGroup);
		menuEdit.add(itemUnGroup);
		menuEdit.add(itemRenmae);
		add(menuFile);
		add(menuEdit);	
	}
	public class ItemGroup extends JMenuItem {
		public ItemGroup(String name) {
			setText(name);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				canvas.groupShape();
			}
		}
	}
	public class ItemUnGroup extends JMenuItem {
		public ItemUnGroup(String name) {
			setText(name);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				canvas.unGroupShape();
			}
		}
	}
	public class ItemRename extends JMenuItem {
		public ItemRename(String name) {
			setText(name);
			addActionListener(new btnListener());
		}
		class btnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Shape> selectShapes = canvas.getSelectShapes();
				if(selectShapes.size()!=1) {return;}
				ArrayList<Shape> groupItems = selectShapes.get(0).getGroupItem();
				if(groupItems != null) {return;}
				
				JFrame renameJf = new JFrame("rename");          // 建立視窗
		    	renameJf.setSize(400, 300);                       // 設定視窗大小
		    	renameJf.setLocationRelativeTo(null);             // 把視窗位置設定到螢幕中心
		    	//renameJf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    	
		    	JPanel renamePanel = new JPanel();
		    	renamePanel.setLayout(null);
		    	
		    	JTextField inputTextField = new JTextField();
		    	inputTextField.setLocation(100,50);
		    	inputTextField.setSize(200,50);
		    	
		    	JButton btnAccept = new JButton("OK");
		    	btnAccept.setBounds(50,200,80,50);
		    	btnAccept.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String newName = inputTextField.getText();
		            	selectShapes.get(0).setName(newName);
		            	canvas.repaint();
		            	renameJf.dispose();	
		            }
		        });

		        JButton btnCancel = new JButton("Cancel");
		        btnCancel.setBounds(250,200,80,50);
		        btnCancel.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	renameJf.dispose();
		            }
		        });
		    	
		        renamePanel.add(btnAccept);
		        renamePanel.add(btnCancel);
		        renamePanel.add(inputTextField);
		        
		        renameJf.setContentPane(renamePanel);
		    	renameJf.setVisible(true);
				
            	
			}
		}
	}

}
