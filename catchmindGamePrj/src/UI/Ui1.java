package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gameSound.GameSound;

public class Ui1 extends JPanel{
	public static Ui1 ui1;
	
	private GameSound sound;
	private UiTool uiTool;
	private JLabel plId1; //text
	private JButton plBtn1; //button
	private JButton plBtn2; //button
	private JLabel plImg1; //img
	private JLabel plImg2; //img
	
	private Ui1() {
		sound = new GameSound("bgm/캐치마인드-로비.wav");
		
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}
	
	public static Ui1 getUi1() {
		if (ui1 == null) {
			ui1 = new Ui1();
		}
		return ui1;
	}
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("캐치 마인드");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(90, 180, 900, 130);
		plId1.setHorizontalAlignment(JLabel.CENTER);
		plId1.setFont(new Font("맑은고딕", Font.BOLD, 50));
				
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/catchMindMainTheme.png", 1100, 710));
		plImg1.setBounds(-20, 0, 1100, 710);
		//뒷배경 넣을 예정 ex)스케치북
		
		//plImg2 = new JLabel();
		//plImg2.setIcon(uiTool.getImg("img/catchMindLogo.png", 1100, 710));
		//plImg2.setBounds(-20, 0, 1200, 810);
		
		plBtn1 = new JButton("GAME START");
		plBtn1.setBackground(Color.CYAN);
		plBtn1.setBounds(130, 510, 800, 80);
		plBtn1.setFont(new Font("맑은고딕", Font.BOLD, 80));
		plBtn1.setForeground(Color.BLUE);
		plBtn1.setBorderPainted(false);//Border 태두리제거
		plBtn1.setContentAreaFilled(false);//영역채우기제거
		plBtn1.setFocusPainted(false);//마우스 올릴때 테두리제거
	    plBtn1.setOpaque(false);//투명하게 
		
		plBtn2 = new JButton("GAME EXIT");
		plBtn2.setBackground(Color.ORANGE);
		plBtn2.setBounds(130, 610, 800, 80);
		plBtn2.setFont(new Font("맑은고딕", Font.BOLD, 80));
		plBtn2.setForeground(Color.BLUE);
		plBtn2.setBorderPainted(false);//Border 태두리제거
		plBtn2.setContentAreaFilled(false);//영역채우기제거
		plBtn2.setFocusPainted(false);//마우스 올릴때 테두리제거
	    plBtn2.setOpaque(false);//투명하게 
	    //글씨색깔 가독성 좋게 변경 예정

		//add(plId1);
		add(plBtn1);
		add(plBtn2);
	    //add(plImg2);
		add(plImg1);
	}
	
	private void uI1_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.playEffect("bgm/effect_gamestart.wav");
				sound.stopBg();
				uiTool.setUI(Ui1.this, Ui2.getUi2());
			}
		});
	
	
		plBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.playEffect("bgm/effect_gameover.wav");
				sound.stopBg();
				System.exit(0);
			}
		});
	}	
}
