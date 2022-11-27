package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui1 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1; //text
	private JButton plBtn1; //button
	private JLabel plImg1; //img
	
	private JLabel plId2;
	private JLabel plImg2;
	
	public Ui1() {
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("UI1 라벨생성 예시");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(350, 50, 400, 50);
		
		plId2 = new JLabel("UI1 라벨");
		plId2.setBackground(new Color(255, 255, 255));
		plId2.setBounds(350, 100, 400, 50);
		
		plBtn1 = new JButton("게임시작");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(0, 100, 100, 30);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/drawBlackPen.png", 50, 100));
		plImg1.setBounds(150, 100, 100, 100);
		
		plImg2 = new JLabel();
		plImg2.setIcon(uiTool.getImg("img/drawBluePen.png", 50, 100));
		plImg2.setBounds(300, 150, 100, 100);
		
		add(plId1);
		add(plId2);
		add(plBtn1);
		add(plImg1);
		add(plImg2);
	}
	
	private void uI1_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
