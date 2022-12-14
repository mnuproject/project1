package UI;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import gameSound.GameSound;
//음악넣기, UI5 >> 버튼에다가 이미지 넣기, UI6번으로 넘기기. , 이미지 첨부해주기.
public class Ui5 extends JPanel{
	public static Ui5 ui5;

	private ImageIcon img1;
	private ImageIcon img2;
	private ImageIcon img3;
	private ImageIcon img4;
	
	private UiTool uiTool;
	private GameSound soundEffect;
	
	private JLabel plId1;
	private JLabel plId2;
	private JLabel plId3;
	private JLabel plId4;
	private JLabel plId5;
	
	private JButton plBtn1;
	private JButton plBtn2;
	private JButton plBtn3;
	private JButton plBtn4;

	private JLabel plImg1;
	
	private Ui5() {
		uiTool = new UiTool();
		soundEffect = new GameSound(null);
		setLayout(null);
		uI1_DesignLayout();
		uI5_listener();
		
	}	

	public static Ui5 getUi5() {
		if (ui5 == null) {
			ui5 = new Ui5();
		}
		return ui5;
	}
	
	private void uI1_DesignLayout() {
		plId1 = new JLabel("테마선택하기(동물,음식,과일,게임제목)");
		plId1.setBackground(new Color(0, 0, 255));
		plId1.setBounds(200, 30, 800, 50);
		plId1.setFont(uiTool.ftLarge());
		
		img1 = uiTool.getImg("img/animal_img.png", 900, 900);
		img2 = uiTool.getImg("img/food_img.png", 600, 500);
		img3 = uiTool.getImg("img/fruit_img.png", 800, 640);
		img4 = uiTool.getImg("img/gamename_img.png", 800, 530);
		
		plId2 = new JLabel("동물");
		plId2.setBounds(190, 50, 300, 200);
		plId2.setFont(uiTool.ftMedium());
		
		plId3 = new JLabel("음식");
		plId3.setBounds(190, 50, 300, 200);
		plId3.setFont(uiTool.ftMedium());
		
		plId4 = new JLabel("과일");
		plId4.setBounds(190, 50, 300, 200);
		plId4.setFont(uiTool.ftMedium());
		
		plId5 = new JLabel("게임제목");
		plId5.setBounds(30, 55, 300, 200);
		plId5.setFont(uiTool.ftMedium());
		
		plBtn1 = new JButton(img1);
		plBtn1.setBounds(50, 130, 450, 270);
		plBtn1.setRolloverIcon(img1);
		
		plBtn2 = new JButton(img2);
		plBtn2.setBounds(550, 130, 450, 270);
		plBtn2.setRolloverIcon(img2);
		
		plBtn3 = new JButton(img3);
		plBtn3.setBounds(50, 430, 450, 270);
		plBtn3.setRolloverIcon(img3);
		
		plBtn4 = new JButton(img4);
		plBtn4.setBounds(550, 430, 450, 270);
		plBtn4.setRolloverIcon(img4);
		
		/*
		plBtn1 = new JButton(new ImageIcon("img/darwBlackPen.png"));
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(180,50 , 500, 300);
		*/

		
		JPanel plID1 = new JPanel();
		plID1.setBackground(new Color(63, 72, 204));
		plID1.setBounds(0, 80, 1100, 15);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0, 0, 1100, 750);
		
		add(plBtn1);
		add(plBtn2);
		add(plBtn3);
		add(plBtn4);
		
		add(plId1);
		
		add(plID1);
		
		add(plImg1);
		
	}
	
	private void uI5_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui5.getUi5(), Ui6.getUi6());
				Ui6.playTurn.setText("주제: 동물");
			}
			
		});
		plBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui5.getUi5(), Ui6.getUi6());
				Ui6.playTurn.setText("주제: 음식");
			}
			
		});
		plBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui5.getUi5(), Ui6.getUi6());
				Ui6.playTurn.setText("주제: 과일");
			}
			
		});
		plBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui5.getUi5(), Ui6.getUi6());
				Ui6.playTurn.setText("주제: 게임제목");
			}
			
		});
		
		
	}
}
