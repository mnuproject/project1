package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.*;
import item.*;
import gameSound.GameSound;

public class Ui6 extends JPanel{
	private UiTool uiTool;
	private GameSound soundEffect;
	
	//Title
	public static JLabel playTitle;
	public static JLabel playTurn;
	
	//profile
	public static JLabel idProfileID1;
	public static JLabel idProfileScore1;
	public static JLabel idProfileReady1;
	public static JLabel idProfileID2;
	public static JLabel idProfileScore2;
	public static JLabel idProfileReady2;
	public static JLabel idProfileID3;
	public static JLabel idProfileScore3;
	public static JLabel idProfileReady3;
	public static JLabel idProfileID4;
	public static JLabel idProfileScore4;
	public static JLabel idProfileReady4;
	
	//time
	public static JProgressBar timeProgress;
	public static int timeValue = 30;
	
	//screen
	private Screen screen;
	
	//draw
	private JPanel colorPallet;
	private JButton btnBlackDrawPen;
	private JButton btnRedDrawPen;
	private JButton btnOrangeDrawPen;
	private JButton btnYellowDrawPen;
	private JButton btnGreenDrawPen;
	private JButton btnBlueDrawPen;
	private JButton btnIndigoDrawPen;
	private JButton btnPurpleDrawPen;
	private JButton btnEraser;
	private JButton btnAllDelete;
	
	//chat
	public static JScrollPane scrChat;
	public static JTextArea taChat;
	public static JTextField sendChat;
	public static JButton btnSendChat;
	
	//item
	public static JButton btnItem1;
	public static JLabel numItem1;
	public static JButton btnItem2;
	public static JLabel numItem2;
	public static JButton btnItem3;
	public static JLabel numItem3;
	public static JButton btnItem4;
	public static JLabel numItem4;
	
	//ready
	public static JButton btnReady;

	
	public Ui6() {
		uiTool = new UiTool();
		soundEffect = new GameSound("bgm/bg1.wav");

		setLayout(null);
		setBackground(new Color(239, 228, 176));
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
		playTitle = new JLabel("캐치마인드");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(0, 15, 190, 30);
		playTurn = new JLabel("턴 2 / 8");
		playTurn.setFont(uiTool.ftSmall());
		playTurn.setBounds(0, 60, 100, 30);
		titlePanel.add(playTitle);
		titlePanel.add(playTurn);
				
		//profile1
		JPanel IdProfile1 = new JPanel();
		IdProfile1.setLayout(null);
		IdProfile1.setBackground(new Color(93, 242, 250));
		IdProfile1.setBounds(0, 155, 190, 130);
		idProfileID1 = new JLabel("아이디: A");
		idProfileID1.setFont(uiTool.ftSmall());
		idProfileID1.setBounds(0, 0, 100, 30);
		idProfileScore1 = new JLabel("점수: 0");
		idProfileScore1.setFont(uiTool.ftSmall());
		idProfileScore1.setBounds(0, 50, 100, 30);
		idProfileReady1 = new JLabel("준비됨");
		idProfileReady1.setBounds(150, 50, 100, 30);
		idProfileReady1.setVisible(false);
		IdProfile1.add(idProfileReady1);
		IdProfile1.add(idProfileID1);
		IdProfile1.add(idProfileScore1);
		
		//profile2
		JPanel IdProfile2 = new JPanel();
		IdProfile2.setLayout(null);
		IdProfile2.setBackground(new Color(110, 250, 50));
		IdProfile2.setBounds(0, 290, 190, 130);
		idProfileID2 = new JLabel("아이디: B");
		idProfileID2.setFont(uiTool.ftSmall());
		idProfileID2.setBounds(0, 0, 100, 30);
		IdProfile2.add(idProfileID2);
		idProfileScore2 = new JLabel("점수: 0");
		idProfileScore2.setFont(uiTool.ftSmall());
		idProfileScore2.setBounds(0, 50, 100, 30);
		idProfileReady2 = new JLabel("준비됨");
		idProfileReady2.setBounds(150, 50, 100, 30);
		idProfileReady2.setVisible(false);
		IdProfile2.add(idProfileReady2);
		IdProfile2.add(idProfileID2);
		IdProfile2.add(idProfileScore2);
	
		//profile3
		JPanel IdProfile3 = new JPanel();
		IdProfile3.setLayout(null);
		IdProfile3.setBackground(new Color(250, 160, 40));
		IdProfile3.setBounds(0, 425, 190, 130);
		idProfileID3 = new JLabel("아이디: C");
		idProfileID3.setFont(uiTool.ftSmall());
		idProfileID3.setBounds(0, 0, 100, 30);
		idProfileScore3 = new JLabel("점수: 0");
		idProfileScore3.setFont(uiTool.ftSmall());
		idProfileScore3.setBounds(0, 50, 100, 30);
		idProfileReady3 = new JLabel("준비됨");
		idProfileReady3.setBounds(150, 50, 100, 30);
		idProfileReady3.setVisible(false);
		IdProfile3.add(idProfileReady3);
		IdProfile3.add(idProfileID3);
		IdProfile3.add(idProfileScore3);
		
		//profile4
		JPanel IdProfile4 = new JPanel();
		IdProfile4.setLayout(null);
		IdProfile4.setBackground(new Color(250, 250, 40));
		IdProfile4.setBounds(0, 560, 190, 130);
		idProfileID4 = new JLabel("아이디: D");
		idProfileID4.setFont(uiTool.ftSmall());
		idProfileID4.setBounds(0, 0, 100, 30);
		idProfileScore4 = new JLabel("점수: 0");
		idProfileScore4.setFont(uiTool.ftSmall());
		idProfileScore4.setBounds(0, 50, 100, 30);
		idProfileReady4 = new JLabel("준비됨");
		idProfileReady4.setBounds(150, 50, 100, 30);
		idProfileReady4.setVisible(false);
		IdProfile4.add(idProfileReady4);
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
		chatPanel.setBounds(855, 0, 230, 750);
		
		taChat = new JTextArea();
		taChat.setEditable(false);
		scrChat = new JScrollPane(taChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrChat.setBounds(0, 0, 230, 450);
		chatPanel.add(scrChat);
		
		sendChat = new JTextField();
		sendChat.setBounds(0, 450, 195, 30);
		chatPanel.add(sendChat);
		
		btnSendChat = new JButton();
		btnSendChat.setBounds(195, 450, 30, 30);
		btnSendChat.setBackground(new Color(239, 228, 176));
		btnSendChat.setIcon(uiTool.getImg("img/sendMessage.png", 40, 40));
		btnSendChat.setBorderPainted(false);
		chatPanel.add(btnSendChat);
		
		//item		
		btnItem1 = new JButton();
		btnItem1.setIcon(uiTool.getImg("img/item1.png", 50, 50));
		btnItem1.setBounds(5, 500, 50, 50);
		btnItem1.setBackground(new Color(250, 160, 40));
		btnItem1.setBorderPainted(false);
		chatPanel.add(btnItem1);
		
		numItem1 = new JLabel("0");
		numItem1.setBounds(40, 540, 50, 50);
		numItem1.setFont(uiTool.ftSmall());
		chatPanel.add(numItem1);
		
		btnItem2 = new JButton();
		btnItem2.setIcon(uiTool.getImg("img/item2.png", 50, 50));
		btnItem2.setBounds(60, 500, 50, 50);
		btnItem2.setBackground(new Color(150, 150, 50));
		btnItem2.setBorderPainted(false);
		chatPanel.add(btnItem2);
		
		numItem2 = new JLabel("0");
		numItem2.setBounds(95, 540, 50, 50);
		numItem2.setFont(uiTool.ftSmall());
		chatPanel.add(numItem2);
		
		btnItem3 = new JButton();
		btnItem3.setIcon(uiTool.getImg("img/item3.png", 50, 50));
		btnItem3.setBounds(115, 500, 50, 50);
		btnItem3.setBackground(new Color(150, 50, 176));
		btnItem3.setBorderPainted(false);
		chatPanel.add(btnItem3);
		
		numItem3 = new JLabel("0");
		numItem3.setBounds(150, 540, 50, 50);
		numItem3.setFont(uiTool.ftSmall());
		chatPanel.add(numItem3);
		
		btnItem4 = new JButton();
		btnItem4.setIcon(uiTool.getImg("img/item4.png", 50, 50));
		btnItem4.setBounds(170, 500, 50, 50);
		btnItem4.setBackground(new Color(150, 150, 210));
		btnItem4.setBorderPainted(false);
		chatPanel.add(btnItem4);
		
		numItem4 = new JLabel("0");
		numItem4.setBounds(205, 540, 50, 50);
		numItem4.setFont(uiTool.ftSmall());
		chatPanel.add(numItem4);
		
		btnReady = new JButton("준비");
		btnReady.setFont(uiTool.ftMedium());
		btnReady.setBounds(20, 600, 180, 80);
		btnReady.setBackground(new Color(220, 220, 220));
		btnReady.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));
		chatPanel.add(btnReady);
		add(chatPanel);
		
		//time
		timeProgress = new JProgressBar();
		timeProgress.setValue(timeValue);
		timeProgress.setBounds(200, 0, 650, 30);
		add(timeProgress);
		
		//drawPen
		colorPallet = new JPanel();
		colorPallet.setLayout(null);
		colorPallet.setBounds(190, 570, 690, 140);
		colorPallet.setBackground(new Color(239, 228, 176));

		btnBlackDrawPen = new JButton();
		btnBlackDrawPen.setIcon(uiTool.getImg("img/drawBlackPen.png", 60, 140));
		btnBlackDrawPen.setBounds(0, 0, 60, 140);
		btnBlackDrawPen.setBackground(new Color(239, 228, 176));
		btnBlackDrawPen.setBorderPainted(false);
		colorPallet.add(btnBlackDrawPen);
		
		btnRedDrawPen = new JButton();
		btnRedDrawPen.setIcon(uiTool.getImg("img/drawRedPen.png", 60, 140));
		btnRedDrawPen.setBounds(60, 0, 60, 140);
		btnRedDrawPen.setBackground(new Color(239, 228, 176));
		btnRedDrawPen.setBorderPainted(false);
		colorPallet.add(btnRedDrawPen);
		
		btnOrangeDrawPen = new JButton();
		btnOrangeDrawPen.setIcon(uiTool.getImg("img/drawOrangePen.png", 60, 140));
		btnOrangeDrawPen.setBounds(120, 0, 60, 140);
		btnOrangeDrawPen.setBackground(new Color(239, 228, 176));
		btnOrangeDrawPen.setBorderPainted(false);
		colorPallet.add(btnOrangeDrawPen);
		
		btnYellowDrawPen = new JButton();
		btnYellowDrawPen.setIcon(uiTool.getImg("img/drawYellowPen.png", 60, 140));
		btnYellowDrawPen.setBounds(180, 0, 60, 140);
		btnYellowDrawPen.setBackground(new Color(239, 228, 176));
		btnYellowDrawPen.setBorderPainted(false);
		colorPallet.add(btnYellowDrawPen);
		
		btnGreenDrawPen = new JButton();
		btnGreenDrawPen.setIcon(uiTool.getImg("img/drawGreenPen.png", 60, 140));
		btnGreenDrawPen.setBounds(240, 0, 60, 140);
		btnGreenDrawPen.setBackground(new Color(239, 228, 176));
		btnGreenDrawPen.setBorderPainted(false);
		colorPallet.add(btnGreenDrawPen);
		
		btnBlueDrawPen = new JButton();
		btnBlueDrawPen.setIcon(uiTool.getImg("img/drawBluePen.png", 60, 140));
		btnBlueDrawPen.setBounds(300, 0, 60, 140);
		btnBlueDrawPen.setBackground(new Color(239, 228, 176));
		btnBlueDrawPen.setBorderPainted(false);
		colorPallet.add(btnBlueDrawPen);
		
		btnIndigoDrawPen = new JButton();
		btnIndigoDrawPen.setIcon(uiTool.getImg("img/drawIndigoPen.png", 60, 140));
		btnIndigoDrawPen.setBounds(360, 0, 60, 140);
		btnIndigoDrawPen.setBackground(new Color(239, 228, 176));
		btnIndigoDrawPen.setBorderPainted(false);
		colorPallet.add(btnIndigoDrawPen);
		
		btnPurpleDrawPen = new JButton();
		btnPurpleDrawPen.setIcon(uiTool.getImg("img/drawPurplePen.png", 60, 140));
		btnPurpleDrawPen.setBounds(420, 0, 60, 140);
		btnPurpleDrawPen.setBackground(new Color(239, 228, 176));
		btnPurpleDrawPen.setBorderPainted(false);
		colorPallet.add(btnPurpleDrawPen);
		
		btnEraser = new JButton();
		btnEraser.setIcon(uiTool.getImg("img/drawEraser.png", 80, 120));
		btnEraser.setBounds(480, 10, 80, 120);
		btnEraser.setBackground(new Color(239, 228, 176));
		btnEraser.setBorderPainted(false);
		colorPallet.add(btnEraser);

		btnAllDelete = new JButton();
		btnAllDelete.setIcon(uiTool.getImg("img/allDelete.png", 90, 120));
		btnAllDelete.setBounds(560, 10, 90, 120);
		btnAllDelete.setBackground(new Color(239, 228, 176));
		btnAllDelete.setBorderPainted(false);
		colorPallet.add(btnAllDelete);
		
		add(colorPallet);
		
		//screen
		screen = Screen.getScreen();
		screen.setBounds(200, 40, 650, 520);
		screen.setBackground(new Color(0xffffff));
		screen.setColor(Color.BLACK);
		add(screen);
	}
	
	private void uI6_listener() {
		btnBlackDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"black pen");
				screen.setColor(Color.BLACK);
			}
		});

		btnRedDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"red pen");
				screen.setColor(Color.RED);
			}
		});

		btnOrangeDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"orange pen");
				screen.setColor(Color.ORANGE);
			}
		});
		
		btnYellowDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"yellow pen");
				screen.setColor(Color.YELLOW);
			}
		});
		
		btnGreenDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"green pen");
				screen.setColor(Color.GREEN);
			}
		});
		
		btnBlueDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"cyan pen");
				screen.setColor(Color.CYAN);
			}
		});
		
		btnIndigoDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"blue pen");
				screen.setColor(Color.BLUE);
			}
		});
		
		btnPurpleDrawPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"purple pen");
				screen.setColor(Color.MAGENTA);
			}
		});
		
		btnEraser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"eraser pen");
				MainFrame.clnt.sendColor("Eraser");
				screen.setEraser();
			}
		});
		
		btnAllDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taChat.setText(taChat.getText()+"\n"+"all delete pen");
				MainFrame.clnt.sendColor("Delete");
				screen.setClear();
			}
		});
		
		btnSendChat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sendChat.getText().length() > 0) {
					MainFrame.clnt.sendChat(sendChat.getText());
					//taChat.setText(taChat.getText()+"\n"+sendChat.getText());
					sendChat.setText("");					
				}
			}
		});		
		
		sendChat.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10 && sendChat.getText().length() > 0) {
					MainFrame.clnt.sendChat(sendChat.getText());
					//taChat.setText(taChat.getText()+"\n"+sendChat.getText());
					sendChat.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.clnt.sendItem1();
			}
		});	
		
		btnItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.clnt.sendItem2();
			}
		});	
		
		btnItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.clnt.sendItem3();
			}
		});	
		
		btnItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.clnt.sendItem4();
			}
		});	
		
		btnReady.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				Client.isReady = !Client.isReady;
				if (Client.isReady) {
					MainFrame.clnt.sendReady();
					taChat.setText(taChat.getText()+"\n"+"ready");
					idProfileReady1.setVisible(true);
					idProfileReady2.setVisible(true);
					idProfileReady3.setVisible(true);
					idProfileReady4.setVisible(true);
					btnReady.setBackground(new Color(239, 141, 228));
					soundEffect.playEffect("bgm/effect_ring.wav");
					btnReady.setText("준비됨");
				}
				else if (!Client.isReady) {
					MainFrame.clnt.sendPrepare();
					soundEffect.stop();
					idProfileReady1.setVisible(false);
					idProfileReady2.setVisible(false);
					idProfileReady3.setVisible(false);
					idProfileReady4.setVisible(false);
					btnReady.setBackground(new Color(220, 220, 220));
					btnReady.setText("준비");
				}
			}
		});	
	}
}