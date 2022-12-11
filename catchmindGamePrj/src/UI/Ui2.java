package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import server.ClientInfo;
import server.GameServer;

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
		
		plBtn1 = new JButton("로그인");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(590, 350, 110, 30);
		
		tfIdInput = new TextField();
		tfIdInput.setBounds(400, 355, 170, 25);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/catchMindBG.png", 649, 488));
		plImg1.setBounds(225, -150, 900, 900);
		//이쪽도 스케치북같은 뒷배경 넣을 예정
		
		
		add(plBtn1);
		add(tfIdInput);
		add(plImg1);
	}
	
	private void uI2_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.clnt.sendId(tfIdInput.getText());
				uiTool.setUI(Ui2.this, Ui3.getUi3());
				//uiTool.setUI(Ui2.this, new Ui3());
			}
		});
	}
}
