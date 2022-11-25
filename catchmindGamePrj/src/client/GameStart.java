// 최종본
package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.*;

import res.Word;

public class GameStart extends JFrame {
	// 필수 태그
	private static final String TAG = "GameStart :";
	// 클라이언트가 입력한 아이디 값을 클라이언트도 알도록 전역 변수로 설정.
	private String IDString;

	// 턴이 변화할 때 마다 제시어를 순차적으로 선택하는 변수.
	public int selectProblem = 0;

	private ImageIcon icGameStart;

	private ImageIcon iconBlackPen;
	private ImageIcon iconRedPen;
	private ImageIcon iconOrangePen;
	private ImageIcon iconYellowPen;
	private ImageIcon iconGreenPen;
	private ImageIcon iconBluePen;
	private ImageIcon iconIndigoPen;
	private ImageIcon iconPurplePen;

	// 통신
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;

	// 이미지 패널
	private UI.MyPanel plMain; // 초기 메인 화면 이미지

	// plMain에 포함됨
	private JButton btnStart; // 아이디 입력 전 게임시작 버튼

	// btnStart을 누르면 plId이 나타남
	private JPanel plId; // 아이디 입력 패널
	private JPanel plSub; // 아이디 입력 패널

	// plId에 포함됨
	private JLabel laId; // '아이디를 입력하세요'라벨
	private TextField tfIdInput; // 아이디 입력
	private JButton btnId; // 아이디 입력 버튼

	// btnStart을 누르면 plDrawRoom로 바뀜
	private JPanel plDrawRoom; // 그리기방 패널(화면 전체)

	// plDrawRoom에 포함됨

	// plTop과 plMplId
	private JPanel plTopMpId;

	// 위쪽 방 이름 , 제시어, 넘기기 버튼
	private JPanel plTop;

	// plTop에 포함됨
	private JLabel laQuizTitle; // '제시어 : ' 라벨
	private JLabel laQuiz; // 제시어 변수 라벨
	private JButton btnSkip; // 넘기기 버튼

	// 왼쪽을 포함한 중간 그림판
	private JPanel plMplId; // 그림판

	// plMplId에 포함됨
	private MyPanel1 plDraw; // 그림판 이미지

	// 아래쪽 팔레트
	private JPanel plBottom; // 팔레트

	private MyButton1 btnDelete; // 지우개 이미지

	// plBottom에 포함됨
	private MyPanel2 plPalette; // 크레파스 이미지

	private JButton btnBlackDrawPen;
	private JButton btnRedDrawPen;
	private JButton btnOrangeDrawPen;
	private JButton btnYellowDrawPen;
	private JButton btnGreenDrawPen;
	private JButton btnBlueDrawPen;
	private JButton btnIndigoDrawPen;
	private JButton btnPurpleDrawPen;

	private MyButton btnEraser; // 지우개 이미지

	// 오른쪽 유저목록, 채팅, 준비완료, 나가기 버튼
	private JPanel plEast;

	// plEast에 포함됨
	private JTextArea taUserList; // 유저 목록 라벨

	// plEast에 포함된 채팅 패널
	private JPanel plChat; // 채팅창, 채팅 입력란

	// plChat에 포함됨
	private TextField tfChat; // 채팅 입력
	public static JTextArea taChat; // 채팅 로그
	private JScrollPane scrChat;

	// 준비완료, 나가기 버튼 패널
	private JPanel btnPanel; // 채팅창, 채팅 입력란

	// btnPanel에 포함됨
	private JButton btnReady; // 준비 완료 버튼
	private JButton btnExit; // 나가기 버튼

	// 폰트 크기 설정
	private Font ftSmall; // 16px크기 폰트
	private Font ftMedium; // 24px크기 폰트
	private Font ftLarge; // 36px크기 폰트

	// 이미지 매서드
	private ImageIcon ImageSetSize(ImageIcon icon, int width, int heigth) {
		Image xImage = icon.getImage();
		Image yImage = xImage.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
		ImageIcon xyImage = new ImageIcon(yImage);
		return xyImage;
	}

	class MyPanel1 extends JPanel {
		private ImageIcon icon = new ImageIcon("img/draw.png");
		private Image imgMain = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgMain, 0, 0, getWidth(), getHeight(), null);
		}
	};

	class MyPanel2 extends JPanel {
		private ImageIcon icon = new ImageIcon("img/drawColor.png");
		private Image imgMain = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgMain, 0, 0, getWidth(), getHeight(), null);
		}
	};

	class MyButton extends JButton {
		private ImageIcon icon = new ImageIcon("img/drawEraser.png");
		private Image imgMain = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgMain, 0, 0, getWidth(), getHeight(), null);
			setBorderPainted(false); // 버튼 테두리 제거
		}
	};

	class MyButton1 extends JButton {
		private ImageIcon icon = new ImageIcon("img/allDelete.png");
		private Image imgMain = icon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgMain, 0, 0, getWidth(), getHeight(), null);
			setBorderPainted(false); // 버튼 테두리 제거
		}
	};

	public GameStart() {
		init();
		setting();
		batch();
		listener();
		setVisible(true);
	}

	private void init() {
		// 이미지 패널
		plMain = new UI.MyPanel(); // 초기 메인 화면 이미지
		plTopMpId = new MyPanel1(); // plMplId - 그림판 이미지
		plPalette = new MyPanel2(); // plBottom - 크레파스 이미지
		btnEraser = new MyButton(); // plBottom - 지우개 이미지
		btnDelete = new MyButton1(); // plBottom - 휴지통 이미지

		// 패널
		plId = new JPanel(); // plMain - 초기 아이디 입력 패널
		plSub = new JPanel(); // plMain - 초기 아이디 입력 패널
		plDrawRoom = new JPanel(); // 아이디를 입력하고 버튼을 누르면 나오는 패널, 게임화면 전체

		// plDrawRoom
		plTop = new JPanel();
		plMplId = new JPanel();
		plBottom = new JPanel();
		plEast = new JPanel();
		btnPanel = new JPanel();

		// plEast
		plChat = new JPanel();

		// 이미지
		icGameStart = new ImageIcon("img/gameStart.png"); // 게임시작 버튼 이미지

		iconBlackPen = new ImageIcon("img/drawBlackPen.png");
		iconRedPen = new ImageIcon("img/drawRedPen.png");
		iconOrangePen = new ImageIcon("img/drawOrangePen.png");
		iconYellowPen = new ImageIcon("img/drawYellowPen.png");
		iconGreenPen = new ImageIcon("img/drawGreenPen.png");
		iconBluePen = new ImageIcon("img/drawBluePen.png");
		iconIndigoPen = new ImageIcon("img/drawIndigoPen.png");
		iconPurplePen = new ImageIcon("img/drawPurplePen.png");

		// 버튼
		btnStart = new JButton(icGameStart); // plMain
		btnId = new JButton(icGameStart); // plMain
		btnSkip = new JButton("넘기기"); // plTop
		btnReady = new JButton("준비"); // plEast
		btnExit = new JButton("나가기"); // plEast

		btnBlackDrawPen = new JButton(iconBlackPen);
		btnRedDrawPen = new JButton(iconRedPen);
		btnOrangeDrawPen = new JButton(iconOrangePen);
		btnYellowDrawPen = new JButton(iconYellowPen);
		btnGreenDrawPen = new JButton(iconGreenPen);
		btnBlueDrawPen = new JButton(iconBluePen);
		btnIndigoDrawPen = new JButton(iconIndigoPen);
		btnPurpleDrawPen = new JButton(iconPurplePen);

		// 라벨
		laId = new JLabel("아이디"); // plMain
		laQuizTitle = new JLabel("제시어");
		laQuiz = new JLabel("변수"); // plTop

		// 텍스트 입력란
		tfIdInput = new TextField(); // plMain
		tfChat = new TextField(); // plEast

		// 텍스트 영역
		taChat = new JTextArea(); // plEast
		taUserList = new JTextArea();
		// 폰트
		ftSmall = new Font("맑은고딕", Font.PLAIN, 16);
		ftMedium = new Font("맑은고딕", Font.PLAIN, 24);
		ftLarge = new Font("맑은고딕", Font.PLAIN, 36);

		// 스크롤 바
		scrChat = new JScrollPane(taChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 드로우 캔버스
		res.res.imgBuff = new BufferedImage(750, 450, BufferedImage.TYPE_INT_ARGB);
		res.res.drawLabel = new JLabel(new ImageIcon(res.res.imgBuff));
		res.res.drawPanel = new JPanel();
		res.res.brush = new Brush();
	}

	private void setting() {
		setTitle("캐치마인드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		// plMain
		setContentPane(plMain);
		plMain.setLayout(null);
		btnStart.setBounds(300, 360, 180, 110); // btnStart 위치, 크기 조정 (x, y, width, height)
		btnStart.setBorderPainted(false); // 버튼 테두리 제거

		icGameStart = ImageSetSize(icGameStart, 180, 110); // 게임 시작 버튼 이미지
		// plId
		plId.setLayout(null);
		plId.setVisible(false); // 비활성화
		plId.setBackground(new Color(242, 242, 242));
		plId.setBounds(180, 200, 420, 300); // plId 위치, 크기 조정 (x, y, width, height) 좌표는 plMain 기준

		plSub.setLayout(null);
		plSub.setVisible(false); // 비활성화
		plSub.setBorder(new LineBorder(new Color(87, 87, 87), 3, true));
		plSub.setBounds(90, 50, 246, 36); // plId 위치, 크기 조정 (x, y, width, height) 좌표는 plMain 기준

		laId.setBounds(0, 2, 62, 32); // laId 위치, 크기 조정 (x, y, width, height) 좌표는 plId 기준
		laId.setBorder(new LineBorder(new Color(87, 87, 87), 2, true));
		laId.setFont(ftSmall);
		laId.setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬

		tfIdInput.setBounds(63, 3, 180, 30); // tfIdInput 위치, 크기 조정 (x, y, width, height) 좌표는 plId 기준
		tfIdInput.setBackground(new Color(242, 242, 242, 255));
		tfIdInput.setFont(ftMedium);

		btnId.setBounds(120, 150, 180, 110); // btnId 위치, 크기 조정 (x, y, width, height) 좌표는 plId 기준
		btnId.setBorderPainted(false); // 버튼 테두리 제거

		// plDrawRoom
		plDrawRoom.setLayout(null);
		plDrawRoom.setVisible(false); // 비활성화
		plDrawRoom.setBounds(70, 120, 1005, 660);// plDrawRoom 위치, 크기 조정 좌표는 plMain 기준

		// plDrawRoom - plTopMpId
		plTopMpId.setLayout(null);
		plTopMpId.setBackground(new Color(255, 255, 255, 255));
		plTopMpId.setBounds(0, 0, 750, 530);

		// plDrawRoom - plTop
		plTop.setLayout(null);
		plTop.setBackground(new Color(255, 255, 255, 0));
		plTop.setBounds(0, 0, 750, 80); // plTop 위치, 크기 조정 좌표는 plDrawRoom 기준

		// plDrawRoom - plMplId
		plMplId.setLayout(null);
		plMplId.setBackground(new Color(255, 255, 255, 255));
		plMplId.setBounds(0, 110, 750, 450); // plMplId 위치, 크기 조정 좌표는 plDrawRoom 기준

		// plDrawRoom - plBottom
		plBottom.setLayout(null);
		plBottom.setBackground(new Color(242, 242, 242, 255));
		plBottom.setBounds(0, 530, 700, 130); // plBottom 위치, 크기 조정 좌표는 plDrawRoom 기준

		iconBlackPen = ImageSetSize(iconBlackPen, 65, 130);
		iconRedPen = ImageSetSize(iconRedPen, 65, 130);
		iconOrangePen = ImageSetSize(iconOrangePen, 65, 130);
		iconYellowPen = ImageSetSize(iconYellowPen, 65, 130);
		iconGreenPen = ImageSetSize(iconGreenPen, 65, 130);
		iconBluePen = ImageSetSize(iconBluePen, 65, 130);
		iconIndigoPen = ImageSetSize(iconIndigoPen, 65, 130);
		iconPurplePen = ImageSetSize(iconPurplePen, 65, 130);

		btnBlackDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnBlackDrawPen.setBounds(0, 0, 65, 130);
		btnBlackDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnRedDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnRedDrawPen.setBounds(65, 0, 65, 130);
		btnRedDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnOrangeDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnOrangeDrawPen.setBounds(130, 0, 65, 130);
		btnOrangeDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnYellowDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnYellowDrawPen.setBounds(195, 0, 65, 130);
		btnYellowDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnGreenDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnGreenDrawPen.setBounds(260, 0, 65, 130);
		btnGreenDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnBlueDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnBlueDrawPen.setBounds(325, 0, 65, 130);
		btnBlueDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnIndigoDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnIndigoDrawPen.setBounds(390, 0, 65, 130);
		btnIndigoDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		btnPurpleDrawPen.setBackground(new Color(242, 242, 242, 255));
		btnPurpleDrawPen.setBounds(455, 0, 65, 130);
		btnPurpleDrawPen.setBorderPainted(false); // 버튼 테두리 제거

		// plDrawRoom - plEast
		plEast.setLayout(null);
		plEast.setBounds(750, 0, 255, 530); // plEast 위치, 크기 조정 좌표는 plDrawRoom 기준

		// plDrawRoom - plChat
		plChat.setLayout(null);

		// plDrawRoom - btnPanel
		btnPanel.setLayout(null);
		btnPanel.setBackground(new Color(242, 242, 242, 255));
		btnPanel.setBounds(700, 530, 405, 130);

		// plTop

		// plMplId
//		plDraw.setBackground(new Color(242, 242, 242, 255));
//		plDraw.setBounds(0, 0, 750, 420); // plDraw 위치, 크기 조정 좌표는 plMplId 기준

		// plBottom
		plPalette.setLayout(null);
		plPalette.setBackground(new Color(242, 242, 242, 255));
		plPalette.setBounds(0, 0, 520, 130); // plPalette 위치, 크기 조정 좌표는 plBottom 기준

		btnEraser.setBackground(new Color(242, 242, 242, 255));
		btnEraser.setBounds(520, 0, 80, 130); // btnEraser 위치, 크기 조정 좌표는 plBottom 기준

		btnDelete.setBackground(new Color(242, 242, 242, 255));
		btnDelete.setBounds(600, 0, 100, 130); // btnEraser 위치, 크기 조정 좌표는 plBottom 기준

		// plEast
		taUserList.setBounds(0, 0, 255, 150); // taUserList 위치, 크기 조정 좌표는 plEast 기준
		taUserList.setFont(ftMedium);
		taUserList.setBackground(new Color(242, 242, 242, 255));
		taUserList.setLineWrap(true);

		plChat.setBackground(Color.WHITE);
		plChat.setBounds(0, 150, 255, 385); // plChat 위치, 크기 조정 좌표는 plEast 기준

		// plEast - plChat
		tfChat.setBackground(Color.WHITE);
		tfChat.setBounds(0, 350, 255, 30); // tfChat 위치, 크기 조정 좌표는 plEast 기준
		tfChat.setFont(ftMedium);
		tfChat.setBackground(new Color(242, 242, 242, 255));
		tfChat.setColumns(30);

		scrChat.setBounds(0, 0, 255, 350); // taChat 위치, 크기 조정 좌표는 plEast 기준
		scrChat.setFocusable(false);

		taChat.setLineWrap(true);
		taChat.setBackground(new Color(242, 242, 242, 255));

		// btnPanel
		laQuizTitle.setVisible(true);
		laQuizTitle.setBounds(0, 2, 155, 65); // laQuiz 위치, 크기 조정 좌표는 plTop 기준
		laQuizTitle.setFont(ftMedium);
		laQuizTitle.setBackground(new Color(242, 242, 242, 255));
		laQuizTitle.setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬

		laQuiz.setVisible(false);
		laQuiz.setBounds(0, 67, 155, 65); // laQuiz 위치, 크기 조정 좌표는 plTop 기준
		laQuiz.setFont(ftMedium);
		laQuiz.setBackground(new Color(242, 242, 242, 255));
		laQuiz.setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬

		btnReady.setBounds(150, 2, 155, 65); // btnReady 위치, 크기 조정 좌표는 plEast 기준
		btnReady.setFont(ftMedium);
		btnReady.setBackground(new Color(242, 242, 242, 255));
		btnReady.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));

		btnSkip.setVisible(false);
		btnSkip.setBounds(150, 2, 155, 65); // btnSkip 위치, 크기 조정 좌표는 plTop 기준
		btnSkip.setFont(ftMedium);
		btnSkip.setBackground(new Color(242, 242, 242, 255));
		btnSkip.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));

		btnExit.setBounds(150, 62, 155, 65); // btnExit 위치, 크기 조정 좌표는 plEast 기준
		btnExit.setFont(ftMedium);
		btnExit.setBackground(new Color(242, 242, 242, 255));
		btnExit.setBorder(new LineBorder(new Color(87, 87, 87), 5, true));

		// 드로우 캔버스
		res.res.drawLabel.setBounds(0, 0, 750, 450);
		res.res.drawLabel.setBackground(new Color(255, 255, 255, 0));
		res.res.brush.setBounds(0, 0, 750, 450);

		setSize(800, 640);
	}

	private void batch() {
		plMain.add(btnStart);
		plMain.add(plId);
		plMain.add(plDrawRoom);
		btnStart.setIcon(icGameStart);

		plId.add(plSub);
		plSub.add(laId);
		plSub.add(tfIdInput);
		plId.add(btnId);
		btnId.setIcon(icGameStart);

		plDrawRoom.add(plTopMpId);

		plTopMpId.add(plTop);
		plTopMpId.add(plMplId);

		plDrawRoom.add(plBottom);
		plDrawRoom.add(plEast);
		plDrawRoom.add(btnPanel);

//		plMplId.add(plDraw);

		plBottom.add(plPalette);
		plBottom.add(btnEraser);
		plBottom.add(btnDelete);

		plPalette.add(btnBlackDrawPen);
		plPalette.add(btnRedDrawPen);
		plPalette.add(btnOrangeDrawPen);
		plPalette.add(btnYellowDrawPen);
		plPalette.add(btnGreenDrawPen);
		plPalette.add(btnBlueDrawPen);
		plPalette.add(btnIndigoDrawPen);
		plPalette.add(btnPurpleDrawPen);

		plEast.add(plChat);
		plEast.add(taUserList);

		plChat.add(scrChat);
		plChat.add(tfChat);

		btnPanel.add(laQuiz);
		btnPanel.add(laQuizTitle);
		btnPanel.add(btnReady);
		btnPanel.add(btnSkip);
		btnPanel.add(btnExit);

		// 드로우
		plMplId.add(res.res.drawLabel);
		plMplId.add(res.res.brush);

	}

	private void listener() {
		// Enter 입력시 채팅 메세지가 보내지는 이벤트.
		tfChat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendChat();
			}
		});

		// 이 이벤트로 plId이 활성화 되어서 아이디를 입력할 수 있음.
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btnStart = (JButton) e.getSource();
				plId.setVisible(true); // plId 활성화
				plSub.setVisible(true); // plId 활성화
				btnStart.setVisible(false); // btnStart 비활성화
			}
		});

		// 이 이벤트로 plDrawRoom이 활성화 되어서 그리기방에 입장함.
		btnId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JButton btnId = (JButton)e.getSource();
				connectServer(); // 서버와 연결
				sendInsertId();
			}
		});

		// 나가기 버튼 이벤트.
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendExit();
				System.exit(0);
			}
		});

		// 준비 버튼 이벤트.
		btnReady.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendReady();
			}
		});

		// 넘기기 버튼 이벤트.
		btnSkip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendSkip();
			}
		});
		// 마우스를 눌렀을때 그리는 이벤트

		res.res.drawLabel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (res.res.drawPPAP == true) {
					System.out.println("ppap true 실행 됨");
					res.res.sendDraw = "DRAW&" + e.getX() + "," + e.getY();
					res.brush.xx = e.getX();
					res.res.brush.yy = e.getY();
					res.res.brush.repaint();
					res.res.brush.printAll(res.res.imgBuff.getGraphics());
					writer.println(res.res.sendDraw);
				} else {
					System.out.println("ppap false 실행 됨");
				}
			}
		});

		// 검은색 펜 이벤트
		btnBlackDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Black";
				res.res.brush.setColor(Color.BLACK);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 빨간색 펜 이벤트
		btnRedDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Red";
				res.res.brush.setColor(Color.RED);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 오렌지색 펜 이벤트
		btnOrangeDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Orange";
				res.res.brush.setColor(Color.ORANGE);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 노란색 펜 이벤트
		btnYellowDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Yellow";
				res.res.brush.setColor(Color.YELLOW);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 초록색 펜 이벤트
		btnGreenDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Green";
				res.res.brush.setColor(Color.GREEN);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 하늘색 펜 이벤트
		btnBlueDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Blue";
				res.res.brush.setColor(Color.CYAN);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 파란색 펜 이벤트
		btnIndigoDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Indigo";
				res.res.brush.setColor(Color.BLUE);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 핑크색 펜 이벤트
		btnPurpleDrawPen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "Purple";
				res.res.brush.setColor(Color.PINK);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 지우개(흰색) 이벤트
		btnEraser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				res.res.sendColor = "COLOR&" + "White";
				res.res.brush.setColor(Color.WHITE);
				writer.println(res.res.sendColor);
				System.out.println("색 변경 : " + res.res.sendColor);
			}
		});
		// 드로우 캔버스 초기화 이벤트
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete 버튼 눌러짐");
				res.res.sendColor = "COLOR&" + "Delete";
				writer.println(res.res.sendColor);
				res.res.brush.setClearC(false);
				cleanDraw();
				System.out.println("드로우 캔버스 초기화");
			}
		});
	}

	// 접속 시 서버 연결 메서드.
	private void connectServer() {
		try {
			socket = new Socket("localhost", 3000);
			ReaderThread rt = new ReaderThread();
			rt.start();
		} catch (Exception e) {
			System.out.println(TAG + "서버 연결 실패");
		}
	}

	// EXIT 프로토콜 메서드.
	private void sendExit() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("EXIT&" + IDString);
		} catch (Exception e) {
			System.out.println(TAG + "Exit Msg writer fail...");
		}
	}

	// SKIP 프로토콜 메서드.
	private void sendSkip() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("SKIP&");
		} catch (Exception e) {
			System.out.println(TAG + "Skip Msg writer fail...");
		}
	}

	// READY 프로토콜 메서드.
	private void sendReady() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("READY&");
		} catch (Exception e) {
			System.out.println(TAG + "Ready Msg send fail...");
		}

	}

	// CHAT 프로토콜 메서드.
	private void sendChat() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			String chatString = tfChat.getText();
			writer.println("CHAT&" + chatString);
			tfChat.setText("");
		} catch (Exception e) {
			System.out.println(TAG + "채팅 메세지 요청 실패");
		}
	}

	// ID 프로토콜 메서드
	private void sendInsertId() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			IDString = tfIdInput.getText();
			if ((IDString.equals(""))) { // NULL값 입력시
				IDString = "emptyID";
				writer.println("ID&" + IDString);
				plId.setVisible(false); // plId 비활성화
				plSub.setVisible(false); // plId 활성화
				plDrawRoom.setVisible(true); // plDrawRoom 활성화
				setSize(1152, 864);
			} else { // 아이디 값 입력시.
				writer.println("ID&" + IDString);
				tfIdInput.setText("");
				plId.setVisible(false); // plId 비활성화
				plSub.setVisible(false); // plId 활성화
				plDrawRoom.setVisible(true); // plDrawRoom 활성화
				setSize(1152, 864);
			}

		} catch (IOException e) {
			System.out.println(TAG + "준비 메세지 요청 실패");
		}
	}

	// 드로우 캔버스 초기화 메서드
	private void cleanDraw() {
		res.res.brush.setClearC(false);
		res.res.brush.repaint();
		res.res.brush.printAll(res.res.imgBuff.getGraphics());
	}

	public static void main(String[] args) {
		new GameStart();
	}
}