package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui3 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	private JButton plBtn1;
	private JLabel plImg1;
	
	public Ui3() {
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}	
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("UI1 라벨생성 예시");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(0, 50, 400, 50);
		
		plBtn1 = new JButton("UI1 버튼생성 예시");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(0, 100, 100, 30);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/drawBlackPen.png", 50, 100));
		plImg1.setBounds(150, 100, 100, 100);
		
		add(plId1);
		add(plBtn1);
		add(plImg1);
	}
	
	private void uI1_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭");
			}
		});
	}
}
