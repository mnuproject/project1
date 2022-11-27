// 최종본
package client;

import java.awt.*;
import java.awt.TextField;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import UI.MainFrame;
import res.Word;

public class GameStart extends JFrame {
/*	// 필수 태그
	public static final String TAG = "GameStart :";
	// 클라이언트가 입력한 아이디 값을 클라이언트도 알도록 전역 변수로 설정.
	private String IDString;

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
	public static JLabel laQuiz; // 제시어 변수 라벨
	public static JButton btnSkip; // 넘기기 버튼

	// 왼쪽을 포함한 중간 그림판
	private JPanel plMplId; // 그림판

	// plMplId에 포함됨
	private MyPanel1 plDraw; // 그림판 이미지

	// 아래쪽 팔레트
	public static JPanel plBottom; // 팔레트

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
	public static JTextArea taUserList; // 유저 목록 라벨

	// plEast에 포함된 채팅 패널
	public static JPanel plChat; // 채팅창, 채팅 입력란

	// plChat에 포함됨
	public static TextField tfChat; // 채팅 입력
	public static JTextArea taChat; // 채팅 로그
	public static JScrollPane scrChat;

	// 준비완료, 나가기 버튼 패널
	private JPanel btnPanel; // 채팅창, 채팅 입력란

	// btnPanel에 포함됨
	public static JButton btnReady; // 준비 완료 버튼
	public static JButton btnExit; // 나가기 버튼

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
	//	plId = new JPanel(); // plMain - 초기 아이디 입력 패널
	//	plSub = new JPanel(); // plMain - 초기 아이디 입력 패널
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

	// 접속 시 서버 연결 메서드.
	private void connectServer() {
		try {
			socket = new Socket("localhost", 3000);
			server.ReaderThread rt = new server.ReaderThread();
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
*/
	public static void main(String[] args) {
		MainFrame.getMainFrame();
	}
}