package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import UI.MainFrame;
import UI.Ui6;
import client.Client;

public class ClientInfo extends Thread {
	private final String TAG = "ClientInfo : ";
<<<<<<< HEAD
=======
	public static String[] clientIDS = {"", "", "", ""};
	public static int[] scoreList = {0, 0, 0, 0};
	public static boolean[] readyList = {false, false, false, false};
	
>>>>>>> branch 'main' of https://github.com/mnuproject/project1
	private Socket socket; // 클라이언트 소켓을 받아서 사용하는 변수.
	private PrintWriter writer; // 쓰기 버퍼.
	private BufferedReader reader; // 읽기 버퍼.

	public String clientID = "user";
	public boolean isReady = false;
	public int score = 0;
	public int turn = 0;
	
	// 생성자에서 클라이언트 소켓을 내부 클래스 소켓에 담는다.
	public ClientInfo(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			String readerMsg = null;
			String[] parsReaderMsg;
			
			while ((readerMsg = reader.readLine()) != null) {
				parsReaderMsg = readerMsg.split("&");
				
				// Client Thread에서 동작하는 프로토콜.				
				protocolID(parsReaderMsg);
				protocolReady(parsReaderMsg);
				protocol_IDTotalList(parsReaderMsg);
				
				protocolColor(parsReaderMsg);
				protocolDraw(parsReaderMsg);
				protocolEraser(parsReaderMsg);
				protocolChat(parsReaderMsg);
				protocolItem1(parsReaderMsg);
				protocolItem2(parsReaderMsg);
				protocolItem3(parsReaderMsg);
				protocolItem4(parsReaderMsg);
			}
		} catch (Exception e) {
			System.out.println(TAG + "message fail");
		}
	} // end of run
	
	private void protocolID(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ID")) {
			this.clientID = parsReaderMsg[1];
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("CHAT&[" + clientID + "] is enter the room.");
				GameServer.vcClient.get(i).score = 0;
			}
		}
	}
	
	private void protocol_IDTotalList(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("IDTotalLIST")) {
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				for (int j = 0; j < GameServer.vcClient.size(); j++) {
					GameServer.vcClient.get(i).writer.println(
							"IDTotalLIST" 
							+ "&" + String.valueOf(j) 
							+ "&" + GameServer.vcClient.get(j).clientID
							+ "&" + String.valueOf(GameServer.vcClient.get(j).score)
							+ "&" + String.valueOf(GameServer.vcClient.get(j).isReady));
				}
			}
		}
	}
	
	private void protocolReady(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("READY")) {
			if (parsReaderMsg[2].equals("true")) {				
				for (int i = 0; i < GameServer.vcClient.size(); i++) {
					if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
						GameServer.vcClient.get(i).isReady = true;
					}
				}
			}
			else if (parsReaderMsg[2].equals("false")) {
				for (int i = 0; i < GameServer.vcClient.size(); i++) {
					if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
						GameServer.vcClient.get(i).isReady = false;
					}
				}
			}
		}
	}
	
	private void protocolColor(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("COLOR")) {
			System.out.println(TAG + "PROTOCOL change color");
			for(int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("COLOR&"+parsReaderMsg[1]);
			}
		}
	}
	
	private void protocolDraw(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("DRAW")) {
			System.out.println(TAG + "PROTOCOL Draw");
			for(int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("DRAW&"+parsReaderMsg[1]);
			}
		}
	}	
	
	private void protocolEraser(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("Eraser")) {
			System.out.println(TAG + "PROTOCOL Eraser");
			for(int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("Eraser&"+parsReaderMsg[1]);
			}
		}
	}

	private void protocolChat(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("CHAT") && parsReaderMsg.length > 0) {
			System.out.println(TAG + "PROTOCOL Chat");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("CHAT&[" + parsReaderMsg[1] + "]: " + parsReaderMsg[2]);
			}
		}
	}
	
	private void protocolItem1(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM1")) {
			System.out.println(TAG + "PROTOCOL item1");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM1&" + parsReaderMsg[1]);
			}
		}
	}
	
	private void protocolItem2(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM2")) {
			System.out.println(TAG + "PROTOCOL item2");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM2&" + parsReaderMsg[1]);
			}
		}
	}
	
	private void protocolItem3(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM3")) {
			System.out.println(TAG + "PROTOCOL item3");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM3&" + parsReaderMsg[1]);
			}
		}
	}
	
	private void protocolItem4(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM4")) {
			System.out.println(TAG + "PROTOCOL item4");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM4&" + parsReaderMsg[1]);
			}
		}
	}
	
	private void protocolSendIDS() {
		System.out.println(TAG + "PROTOCOL sendIDs");
		String IDstr = "";
		for (int i=0; i<4; i++) {
			IDstr += clientIDS[i]+"&";
		}
		
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("IDS&" + IDstr);
		}
	}
	
	private void protocolSendScoreList() {
		System.out.println(TAG + "PROTOCOL sendScoreList");
		String scoreStr = "";
		for (int i=0; i<4; i++) {
			scoreStr += String.valueOf(scoreList[i])+"&";
		}
		
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("SCORELIST&" + scoreStr);
		}
	}
	
	private void protocolSendReadyList() {
		System.out.println(TAG + "PROTOCOL sendReadyList");
		String scoreStr = "";
		for (int i=0; i<4; i++) {
			scoreStr += String.valueOf(scoreList[i])+"&";
		}
		
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("SCORELIST&" + scoreStr);
		}
	}
} // end of class ClientInfo
