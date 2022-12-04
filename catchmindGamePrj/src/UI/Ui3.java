package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui3 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	
	private JButton plBtn1;
	private JButton plBtn2; 
	private JButton plBtn3;
	private JButton plBtn4;
	private JButton plBtn5;
	private JButton plBtn6;
	private JButton plBtn7;
	private JButton plBtn8;
	
	private JLabel plImg1;
	private JLabel plImg2;
	
	public Ui3() {
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}	
	
	private void uI1_DesignLayout() {
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0,0,1100,750);
		
		plBtn1 = new JButton("방만들기");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(180,50 , 100, 30);
		
		plBtn3 = new JButton("그림연습");
		plBtn3.setBackground(new Color(255, 255, 255));
		plBtn3.setBounds(350,50 , 100, 30);
		
		plImg2 = new JLabel();
		plImg2.setIcon(uiTool.getImg("img/catchimg.png",75,48));
		plImg2.setBounds(500,0,300,100);
		
		plBtn2 = new JButton("설정");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(620,50 , 100, 30);
		
		plBtn4 = new JButton("종료하기");
		plBtn4.setBackground(new Color(255, 255, 255));
		plBtn4.setBounds(800,50 , 100, 30);
		
		//라인 그은것.
		JPanel plId1 = new JPanel();
		plId1.setBackground(new Color(63, 72, 204));
		plId1.setBounds(0, 80, 1100, 15);
		
		plBtn5 = new JButton("1번방");
		plBtn5.setBackground(new Color(255, 255, 255));
		plBtn5.setBounds(90,130,900,130);
		
		plBtn6 = new JButton("2번방");
		plBtn6.setBackground(new Color(255, 255, 255));
		plBtn6.setBounds(90,260, 900,130);
		
		plBtn7 = new JButton("3번방");
		plBtn7.setBackground(new Color(255, 255, 255));
		plBtn7.setBounds(90,390, 900,130);
		
		plBtn8 = new JButton("4번방");
		plBtn8.setBackground(new Color(255, 255, 255));
		plBtn8.setBounds(90,520, 900,130);
		
		add(plBtn1);
		add(plBtn2);
		add(plImg2);
		add(plBtn3);
		add(plBtn4);
		
		add(plId1);
		
		add(plBtn5);
		add(plBtn6);
		add(plBtn7);
		add(plBtn8);
		
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
