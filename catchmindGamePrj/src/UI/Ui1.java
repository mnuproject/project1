package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gameSound.GameSound;

public class Ui1 extends JPanel{
	private GameSound sound;
	private UiTool uiTool;
	private JLabel plId1; //text
	private JButton plBtn1; //button
	private JButton plBtn2; //button
	private JLabel plImg1; //img
	
	public Ui1() {
		sound = new GameSound("bgm/bg1.wav");
		
		uiTool = new UiTool();
		setLayout(null);
		uI1_DesignLayout();
		uI1_listener();
	}
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("캐치 마인드");
		plId1.setBackground(new Color(255, 255, 255));
		plId1.setBounds(90, 180, 900, 130);
		plId1.setHorizontalAlignment(JLabel.CENTER);
		plId1.setFont(new Font("맑은고딕", Font.BOLD, 50));
				
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/catchMindBG.png", 1100, 710));
		plImg1.setBounds(-20, 0, 1100, 710);
		//뒷배경 넣을 예정 ex)스케치북
		
		plBtn1 = new JButton("GAME START");
		plBtn1.setBackground(Color.CYAN);
		plBtn1.setBounds(90, 400, 900, 100);
		plBtn1.setFont(new Font("맑은고딕", Font.BOLD, 80));
		
		plBtn2 = new JButton("GAME EXIT");
		plBtn2.setBackground(Color.ORANGE);
		plBtn2.setBounds(90, 510, 900, 100);
		plBtn2.setFont(new Font("맑은고딕", Font.BOLD, 80));

		//add(plId1);
		add(plBtn1);
		add(plBtn2);
		add(plImg1);
				
	}
	
	private void uI1_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.playEffect("bgm/effect_turn.wav");
				sound.stopBg();
				uiTool.setUI(Ui1.this, new Ui2());
			}
		});
	
	
	plBtn2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			sound.playEffect("bgm/effect_ring.wav");
			sound.stopBg();
			System.exit(0);
		}
	});
	}
}
