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
	private JLabel plImg1; //img
	
	private JLabel plId2;
	private JLabel plImg2;
	
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
		
		plId2 = new JLabel("UI1 라벨");
		plId2.setBackground(new Color(255, 255, 255));
		plId2.setBounds(350, 100, 400, 50);
		
		plBtn1 = new JButton("GAME START");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(90, 400, 900, 130);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/drawBlackPen.png", 50, 100));
		plImg1.setBounds(515, 260, 900, 130);
		//뒷배경 넣을 예정 ex)스케치북

		plImg2 = new JLabel();
		plImg2.setIcon(uiTool.getImg("img/drawBluePen.png", 50, 100));
		plImg2.setBounds(300, 150, 100, 100);
		
		add(plId1);
		add(plBtn1);
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
	}	
}
