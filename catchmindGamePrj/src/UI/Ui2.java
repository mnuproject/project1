package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui2 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	private JButton plBtn1;
	private JLabel plImg1;
	
	private TextField tfIdInput;
	
	public Ui2() {
		uiTool = new UiTool();
		setLayout(null);
		uI2_DesignLayout();
		uI2_listener();
	}	
	
	private void uI2_DesignLayout() {
		plId1 = new JLabel("UI2 라벨생성 예시");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(0, 50, 400, 50);
		
		plId1 = new JLabel("UI2 라벨생성 예시");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(0, 50, 400, 50);
		
		plBtn1 = new JButton("로그인");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(0, 100, 100, 30);
		
		tfIdInput = new TextField();
		tfIdInput.setBounds(50, 300, 100, 30);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/drawBlackPen.png", 50, 100));
		plImg1.setBounds(150, 100, 100, 100);
		
		add(plId1);
		add(plBtn1);
		add(plImg1);
		add(tfIdInput);
	}
	
	private void uI2_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//protocol.add()
				System.out.println(tfIdInput.getText());
			}
		});
	}
}
