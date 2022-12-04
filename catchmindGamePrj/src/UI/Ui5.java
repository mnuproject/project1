package UI;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class Ui5 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	
	private JButton plBtn1;

	private JLabel plImg1;
	private JLabel plImg2;
	private JLabel plImg3;
	private JLabel plImg4;
	private JLabel plImg5;
	
	
	public Ui5() {
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}	
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("테마선택하기(동물,음식,과일,게임제목)");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(200, 35, 800, 50);
		plId1.setFont(uiTool.ftLarge());
		
		plBtn1 = new JButton("");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(0, 100, 100, 30);
		
		
		plImg2 = new JLabel();
		plImg2.setIcon(uiTool.getImg("img/animal_img.png", 1100, 750));
		plImg2.setBounds(50, 130, 450, 270);
		
		plImg3 = new JLabel();
		plImg3.setIcon(uiTool.getImg("img/food_img.png", 1100, 750));
		plImg3.setBounds(550, 130, 450, 270);
		
		plImg4 = new JLabel();
		plImg4.setIcon(uiTool.getImg("img/fruit_img.png", 1100, 750));
		plImg4.setBounds(50, 430, 450, 270);
		
		plImg5 = new JLabel();
		plImg5.setIcon(uiTool.getImg("img/gamename_img.png", 1100, 750));
		plImg5.setBounds(550, 430, 450, 270);
		
		JPanel plID1 = new JPanel();
		plID1.setBackground(new Color(63, 72, 204));
		plID1.setBounds(0, 80, 1100, 15);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0, 0, 1100, 750);
		
		
		add(plId1);
		
		add(plID1);
		add(plImg2);
		
		add(plImg3);
		add(plImg4);
		add(plImg5);
		
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
