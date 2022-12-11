package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gameSound.GameSound;


public class Ui2 extends JPanel{
	private GameSound sound;
	private UiTool uiTool;
	private JLabel plId1;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	
	private TextField tfIdInput;
	
	public Ui2() {
		sound = new GameSound("bgm/캐치마인드-로비.wav");
		
		uiTool = new UiTool();
		setLayout(null);
		uI2_DesignLayout();
		uI2_listener();
	}	
	
	private void uI2_DesignLayout() {
		plId1 = new JLabel("아이디를 입력해주세요");
		plId1.setBackground(new Color(0, 0, 255));
		plId1.setBounds(130, 180, 800, 130);
		plId1.setHorizontalAlignment(JLabel.CENTER);
		plId1.setFont(new Font("맑은고딕", Font.BOLD, 80));

		
		plBtn1 = new JButton("로그인");
		plBtn1.setBackground(Color.ORANGE);
		plBtn1.setBounds(590, 400, 110, 30);
		
		tfIdInput = new TextField();
		tfIdInput.setBounds(380, 400, 200, 40);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/catchMindBanner.png", 1100, 710));
		plImg1.setBounds(-20, 0, 1100, 710);
		//이쪽도 스케치북같은 뒷배경 넣을 예정
		
		plBtn2 = new JButton("아이디를 입력해주세요");
		plBtn2.setBackground(Color.CYAN);
		plBtn2.setBounds(90, 230, 900, 130);
		plBtn2.setFont(new Font("맑은고딕", Font.BOLD, 80));
		plBtn2.setForeground(Color.BLACK);
		plBtn2.setBorderPainted(false);//Border 태두리제거
		plBtn2.setContentAreaFilled(false);//영역채우기제거
		plBtn2.setFocusPainted(false);//마우스 올릴때 테두리제거
	    plBtn2.setOpaque(false);//투명하게 
	    //이쪽도 후에 글씨 색이랑 위치 등 가독성 좋게 변경 예정
				
		//add(plId1);
		add(plBtn1);
		add(plBtn2);
		add(tfIdInput);
		add(plImg1);
	}
	
	private void uI2_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sound.playEffect("bgm/effect_gamestart.wav");
				sound.stopBg();
				MainFrame.clnt.sendId(tfIdInput.getText());
				uiTool.setUI(Ui2.this, Ui3.getUi3());
				//uiTool.setUI(Ui2.this, new Ui3());
			}
		});
	}
}
