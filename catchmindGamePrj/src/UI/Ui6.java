package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui6 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	private JButton plBtn1;
	private JLabel plImg1;
	
	public Ui6() {
		uiTool = new UiTool();
		setLayout(null);
		uI6_DesignLayout();
		uI6_listener();
	}	
	
	private void uI6_DesignLayout() {
		//IdProfile
		JPanel IdProfile = new JPanel();
		IdProfile.setLayout(null);
		IdProfile.setBackground(new Color(239, 228, 176));
		IdProfile.setBounds(0, 0, 190, 750);
		
		//title
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(239, 141, 228));
		titlePanel.setBounds(0, 20, 190, 130);
		JLabel playTitle = new JLabel("캐치마인드");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(0, 15, 190, 30);
		JLabel playTurn = new JLabel("턴 2/8");
		playTurn.setFont(uiTool.ftSmall());
		playTurn.setBounds(0, 60, 100, 30);
		titlePanel.add(playTitle);
		titlePanel.add(playTurn);
				
		//profile1
		JPanel IdProfile1 = new JPanel();
		IdProfile1.setLayout(null);
		IdProfile1.setBackground(new Color(93, 242, 250));
		IdProfile1.setBounds(0, 155, 190, 130);
		JLabel idProfileID1 = new JLabel("아이디: A");
		idProfileID1.setFont(uiTool.ftSmall());
		idProfileID1.setBounds(0, 0, 100, 30);
		JLabel idProfileScore1 = new JLabel("점수: 0");
		idProfileScore1.setFont(uiTool.ftSmall());
		idProfileScore1.setBounds(0, 50, 100, 30);
		IdProfile1.add(idProfileID1);
		IdProfile1.add(idProfileScore1);
		
		//profile2
		JPanel IdProfile2 = new JPanel();
		IdProfile2.setLayout(null);
		IdProfile2.setBackground(new Color(110, 250, 50));
		IdProfile2.setBounds(0, 290, 190, 130);
		JLabel idProfileID2 = new JLabel("아이디: B");
		idProfileID2.setFont(uiTool.ftSmall());
		idProfileID2.setBounds(0, 0, 100, 30);
		IdProfile2.add(idProfileID2);
		JLabel idProfileScore2 = new JLabel("점수: 0");
		idProfileScore2.setFont(uiTool.ftSmall());
		idProfileScore2.setBounds(0, 50, 100, 30);
		IdProfile2.add(idProfileID2);
		IdProfile2.add(idProfileScore2);
	
		//profile3
		JPanel IdProfile3 = new JPanel();
		IdProfile3.setLayout(null);
		IdProfile3.setBackground(new Color(250, 160, 40));
		IdProfile3.setBounds(0, 425, 190, 130);
		JLabel idProfileID3 = new JLabel("아이디: C");
		idProfileID3.setFont(uiTool.ftSmall());
		idProfileID3.setBounds(0, 0, 100, 30);
		JLabel idProfileScore3 = new JLabel("점수: 0");
		idProfileScore3.setFont(uiTool.ftSmall());
		idProfileScore3.setBounds(0, 50, 100, 30);
		IdProfile3.add(idProfileID3);
		IdProfile3.add(idProfileScore3);
		
		//profile4
		JPanel IdProfile4 = new JPanel();
		IdProfile4.setLayout(null);
		IdProfile4.setBackground(new Color(250, 250, 40));
		IdProfile4.setBounds(0, 560, 190, 130);
		JLabel idProfileID4 = new JLabel("아이디: D");
		idProfileID4.setFont(uiTool.ftSmall());
		idProfileID4.setBounds(0, 0, 100, 30);
		JLabel idProfileScore4 = new JLabel("점수: 0");
		idProfileScore4.setFont(uiTool.ftSmall());
		idProfileScore4.setBounds(0, 50, 100, 30);
		IdProfile4.add(idProfileID4);
		IdProfile4.add(idProfileScore4);
		
		IdProfile.add(titlePanel);
		IdProfile.add(IdProfile1);
		IdProfile.add(IdProfile2);
		IdProfile.add(IdProfile3);
		IdProfile.add(IdProfile4);
		add(IdProfile);
		
		
		// chat
		JPanel chatPanel = new JPanel();
		chatPanel.setLayout(null);
		chatPanel.setBackground(new Color(239, 228, 176));
		chatPanel.setBounds(900, 0, 190, 750);
		
		JTextArea taChat = new JTextArea();
		
		JScrollPane scrChat = new JScrollPane(taChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrChat.setBounds(0, 0, 190, 600);
		chatPanel.add(scrChat);
		
		taChat.setText("**----------**");
		add(chatPanel);
		
		//time
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(30);
		progressBar.setBounds(200, 0, 600, 30);
		add(progressBar);
		
		//drawPen
		JButton btnBlackDrawPen = new JButton();
		JButton btnRedDrawPen = new JButton();
		JButton btnOrangeDrawPen = new JButton();
		JButton btnYellowDrawPen = new JButton();
		JButton btnGreenDrawPen = new JButton();
		JButton btnBlueDrawPen = new JButton();
		JButton btnIndigoDrawPen = new JButton();
		JButton btnPurpleDrawPen = new JButton();
		
		JLabel crayon = new JLabel();
		crayon.setIcon(uiTool.getImg("img/drawColor.png", 600, 150));
		crayon.setBounds(190, 550, 600, 150);
		add(crayon);
		
		//screen
		
	}
	
	private void uI6_listener() {
		
	}
}
