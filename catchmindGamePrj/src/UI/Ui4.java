package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui4 extends JPanel{
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtn2;
	private JButton plBtn3;
	private JButton plBtn4;
	private JButton plBtn5;
	private JButton plBtn6;
	private JLabel plImg1;
	public static TextArea ta1 = new TextArea("text area");	
	TextField tf1 = new TextField("text field");
	
	
	public Ui4() {
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}	
	
	private void uI1_DesignLayout() {
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/item1.jpg", 235, 247));
		plImg1.setBounds(805,20,235,247);
		
		plBtn1 = new JButton("1번 주제");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(50, 40, 312, 183);
		
		plBtn2 = new JButton("2번 주제");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(50, 263, 312, 183);
		
		plBtn3 = new JButton("3번 주제");
		plBtn3.setBackground(new Color(255, 255, 255));
		plBtn3.setBounds(50, 497, 312, 183);
		
		plBtn4 = new JButton("O");
		plBtn4.setBackground(new Color(255, 255, 255));
		plBtn4.setBounds(997, 497, 43, 20);
		
		plBtn5 = new JButton("준비");
		plBtn5.setBackground(new Color(255, 255, 255));
		plBtn5.setBounds(805, 537, 235, 20);
		
		plBtn6 = new JButton("시작");
		plBtn6.setBackground(new Color(255, 255, 255));
		plBtn6.setBounds(805, 577, 235, 20);
		
		tf1.setBounds(805, 497, 172, 20);
		
		ta1.setBounds(805, 267, 235, 200);
		
		add(plImg1);
		add(plBtn1);
		add(plBtn2);
		add(plBtn3);
		add(plBtn4);
		add(plBtn5);
		add(plBtn6);
		add(tf1);
		add(ta1);
	}
	
	private void uI1_listener() {
		plBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭");
				ta1.setText(ta1.getText() + "\n" + tf1.getText());
			}
		});
		
		tf1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10 && tf1.getText().length() > 0) {
					MainFrame.clnt.sendChat(tf1.getText());
					//taChat.setText(taChat.getText()+"\n"+sendChat.getText());
					tf1.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		plBtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui4.this, new Ui5());
			}
		});
	
	}
}
