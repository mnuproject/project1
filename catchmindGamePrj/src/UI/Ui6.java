package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.*;
import item.*;
import server.ClientInfo;
import server.GameServer;
import gameSound.GameSound;

public class Ui6 extends JPanel{
	private UiTool uiTool;
	private GameSound soundEffect;
	
	//Title
	public static JLabel playTitle;
	public static JLabel playTurn;
	
	//profile
	public static JPanel IdProfile1;
	public static JLabel idProfileID1;
	public static JLabel idProfileScore1;
	public static JLabel idProfileReady1;
	
	public static JPanel IdProfile2;
	public static JLabel idProfileID2;
	public static JLabel idProfileScore2;
	public static JLabel idProfileReady2;
	
	public static JPanel IdProfile3;
	public static JLabel idProfileID3;
	public static JLabel idProfileScore3;
	public static JLabel idProfileReady3;
	
	public static JPanel IdProfile4;
	public static JLabel idProfileID4;
	public static JLabel idProfileScore4;
	public static JLabel idProfileReady4;
	
	//time
	public static JProgressBar timeProgress;
	public static int timeValue = 100;
	
	//screen
	private Screen screen;
	
	//draw
	public static JPanel colorPallet;
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
	private JButton btnItem1;
	private JLabel nItemTx1;
	private int numItem1 = 0;
	
	public static JButton btnItem2;
	public static JLabel nItemTx2;
	private int numItem2 = 0;
	
	public static JButton btnItem3;
	public static JLabel nItemTx3;
	private int numItem3 = 0;
	
	public static JButton btnItem4;
	public static JLabel nItemTx4;
	private int numItem4 = 0;
	
	//ready
	public static JButton btnReady;
	public static JButton btnFin;
	
	public Ui6() {
		uiTool = new UiTool();
		soundEffect = new GameSound(null);
		
		setLayout(null);
		setBackground(new Color(239, 228, 176));
		uI6_DesignLayout();
		uI6_listener();
		MainFrame.clnt.send_IdTotalList();
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
		playTurn = new JLabel("주제: 동물");
		playTurn.setFont(uiTool.ftSmall());
		playTurn.setBounds(0, 60, 190, 30);
		titlePanel.add(playTitle);
		titlePanel.add(playTurn);
		
		//profile1
		IdProfile1 = new JPanel();
		IdProfile1.setLayout(null);
		IdProfile1.setBackground(new Color(55, 227, 153));
		IdProfile1.setBounds(0, 155, 190, 130);
		idProfileID1 = new JLabel("서버오류");
		idProfileID1.setFont(uiTool.ftSmall());
		idProfileID1.setBounds(0, 0, 100, 30);
		idProfileScore1 = new JLabel("실행 후 접속");
		idProfileScore1.setFont(uiTool.ftSmall());
		idProfileScore1.setBounds(0, 50, 100, 30);
		idProfileReady1 = new JLabel("준비됨");
		idProfileReady1.setBounds(150, 50, 100, 30);
		idProfileReady1.setVisible(false);
		IdProfile1.add(idProfileReady1);
		IdProfile1.add(idProfileID1);
		IdProfile1.add(idProfileScore1);
		
		//profile2
		IdProfile2 = new JPanel();
		IdProfile2.setLayout(null);
		IdProfile2.setBounds(0, 290, 190, 130);
		idProfileID2 = new JLabel();
		idProfileID2.setFont(uiTool.ftSmall());
		idProfileID2.setBounds(0, 0, 100, 30);
		IdProfile2.add(idProfileID2);
		idProfileScore2 = new JLabel();
		idProfileScore2.setFont(uiTool.ftSmall());
		idProfileScore2.setBounds(0, 50, 100, 30);
		idProfileReady2 = new JLabel("준비됨");
		idProfileReady2.setBounds(150, 50, 100, 30);
		idProfileReady2.setVisible(false);
		IdProfile2.add(idProfileReady2);
		IdProfile2.add(idProfileID2);
		IdProfile2.add(idProfileScore2);
	
		//profile3
		IdProfile3 = new JPanel();
		IdProfile3.setLayout(null);
		IdProfile3.setBounds(0, 425, 190, 130);
		idProfileID3 = new JLabel();
		idProfileID3.setFont(uiTool.ftSmall());
		idProfileID3.setBounds(0, 0, 100, 30);
		idProfileScore3 = new JLabel();
		idProfileScore3.setFont(uiTool.ftSmall());
		idProfileScore3.setBounds(0, 50, 100, 30);
		idProfileReady3 = new JLabel("준비됨");
		idProfileReady3.setBounds(150, 50, 100, 30);
		idProfileReady3.setVisible(false);
		IdProfile3.add(idProfileReady3);
		IdProfile3.add(idProfileID3);
		IdProfile3.add(idProfileScore3);
		
		//profile4
		IdProfile4 = new JPanel();
		IdProfile4.setLayout(null);
		IdProfile4.setBounds(0, 560, 190, 130);
		idProfileID4 = new JLabel();
		idProfileID4.setFont(uiTool.ftSmall());
		idProfileID4.setBounds(0, 0, 100, 30);
		idProfileScore4 = new JLabel();
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
		btnItem1.setToolTipText("초성힌트");
		chatPanel.add(btnItem1);
		
		nItemTx1 = new JLabel("0");
		nItemTx1.setBounds(40, 540, 60, 50);
		nItemTx1.setFont(uiTool.ftSmall());
		nItemTx1.setText(String.valueOf(numItem1));
		chatPanel.add(nItemTx1);
		
		btnItem2 = new JButton();
		btnItem2.setIcon(uiTool.getImg("img/item2.png", 50, 50));
		btnItem2.setBounds(60, 500, 50, 50);
		btnItem2.setBackground(new Color(150, 150, 50));
		btnItem2.setBorderPainted(false);
		btnItem2.setToolTipText("글자힌트");
		chatPanel.add(btnItem2);
		
		nItemTx2 = new JLabel("0");
		nItemTx2.setBounds(95, 540, 50, 50);
		nItemTx2.setFont(uiTool.ftSmall());
		nItemTx2.setText(String.valueOf(numItem2));
		chatPanel.add(nItemTx2);
		
		btnItem3 = new JButton();
		btnItem3.setIcon(uiTool.getImg("img/item3.png", 50, 50));
		btnItem3.setBounds(115, 500, 50, 50);
		btnItem3.setBackground(new Color(150, 50, 176));
		btnItem3.setBorderPainted(false);
		btnItem3.setToolTipText("먹물");
		chatPanel.add(btnItem3);
		
		nItemTx3 = new JLabel("0");
		nItemTx3.setBounds(150, 540, 50, 50);
		nItemTx3.setFont(uiTool.ftSmall());
		nItemTx3.setText(String.valueOf(numItem3));
		chatPanel.add(nItemTx3);
		
		btnItem4 = new JButton();
		btnItem4.setIcon(uiTool.getImg("img/item4.png", 50, 50));
		btnItem4.setBounds(170, 500, 50, 50);
		btnItem4.setBackground(new Color(150, 150, 210));
		btnItem4.setBorderPainted(false);
		btnItem4.setToolTipText("먹물방어");
		chatPanel.add(btnItem4);
		
		nItemTx4 = new JLabel();
		nItemTx4.setBounds(205, 540, 50, 50);
		nItemTx4.setFont(uiTool.ftSmall());
		nItemTx4.setText(String.valueOf(numItem4));
		chatPanel.add(nItemTx4);
		
		btnReady = new JButton("준비");
		btnReady.setFont(uiTool.ftMedium());
		btnReady.setBounds(20, 600, 180, 80);
		btnReady.setBackground(new Color(220, 220, 220));
		btnReady.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));
		chatPanel.add(btnReady);
		add(chatPanel);
		
		btnFin = new JButton("종료");
		btnFin.setFont(uiTool.ftMedium());
		btnFin.setBounds(20, 600, 180, 80);
		btnFin.setBackground(new Color(220, 220, 220));
		btnFin.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));
		btnFin.setVisible(false);
		chatPanel.add(btnFin);
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
				Ui6.scrChat.getVerticalScrollBar().setValue(Ui6.scrChat.getVerticalScrollBar().getMaximum());
				if (e.getKeyCode() == 10 && sendChat.getText().length() > 0) {
					MainFrame.clnt.sendChat(sendChat.getText());
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
				MainFrame.clnt.sendItem2();
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
				soundEffect.playEffect("bgm/effect_ring.wav");
				MainFrame.clnt.sendReady();
				MainFrame.clnt.send_IdTotalList();
				if (Client.isReady) {
					btnReady.setText("준비됨");
					btnReady.setBackground(new Color(230, 197, 230));
				}
				else {
					btnReady.setText("준비");
					btnReady.setBackground(new Color(220, 220, 220));
				}
			}
		});	
		
		btnFin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uiTool.setUI(Ui6.this, new Ui7());
			}
		});	
	}
}
