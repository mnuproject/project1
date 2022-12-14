package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientInfo extends Thread {
	private final String TAG = "ClientInfo : ";
	
	private Socket socket; // 클라이언트 소켓을 받아서 사용하는 변수.
	private PrintWriter writer; // 쓰기 버퍼.
	private BufferedReader reader; // 읽기 버퍼.
	
	public String clientID = "user";
	public boolean isReady = false;
	public int score = 0;
	public int userTurn = 0;
	
	private boolean isStart = false;
	private boolean isTurn = false;
	public int serverTurn = 0;
	private int problemSubject = 0;
	private int problemN = 0;

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
				protocolTurn();
				protocolFinish(parsReaderMsg);
				protocolExit(parsReaderMsg);
				protocolFinTurn(parsReaderMsg);
				protocolScore(parsReaderMsg);
				
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
			Ui9.Input.setText(Ui9.Input.getText() + "[server] "+parsReaderMsg[1]+" 입장\n");
			this.clientID = parsReaderMsg[1];
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("CHAT&[" + clientID + "] is enter the room.");
				GameServer.vcClient.get(i).userTurn = i;
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
		boolean serverLog = true;
		if (parsReaderMsg[0].equals("READY")) {
			if (parsReaderMsg[2].equals("true")) {				
				for (int i = 0; i < GameServer.vcClient.size(); i++) {
					if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
						if (serverLog) {
							Ui9.Input.setText(Ui9.Input.getText() + "[server] "+parsReaderMsg[1]+" 준비\n");
							serverLog = false;
						}
						GameServer.vcClient.get(i).isReady = true;
						isStart();
					}
				}
			}
			else if (parsReaderMsg[2].equals("false")) {
				for (int i = 0; i < GameServer.vcClient.size(); i++) {
					if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
						if (serverLog) {
							Ui9.Input.setText(Ui9.Input.getText() + "[server] "+parsReaderMsg[1]+" 준비중\n");
							serverLog = false;
						}
						GameServer.vcClient.get(i).isReady = false;
					}
				}
			}
		}
	}
	
	private String isStart() {	
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			if (GameServer.vcClient.get(i).isReady == false) {
				return null;
			}
		}
		
		Ui9.Input.setText(Ui9.Input.getText() + "[server] 게임시작 됨\n");
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("START&"
				+ String.valueOf(serverTurn)
				+ "&" + String.valueOf(GameServer.vcClient.size()*2));
		}
		
		isStart = true;
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("TURN&");
		}
			
		return null;
	}

	private void protocolTurn() {
		if (isStart == true) {
			System.out.println("PROTOCOL userTurn: " + userTurn);
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				if (GameServer.vcClient.get(i).userTurn == serverTurn) {
					for (int j = 0; j < GameServer.vcClient.size(); j++) {
						GameServer.vcClient.get(j).writer.println("NOTTURN"
							+ "&" + String.valueOf(serverTurn)
							+ "&" + String.valueOf(GameServer.vcClient.size()*2));
					}
					GameServer.vcClient.get(i).writer.println("TURN"
							+ "&" + String.valueOf(serverTurn)
							+ "&" + String.valueOf(GameServer.vcClient.size()*2));
				}
			}
		}
	}
	
	private void protocolFinTurn(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("FTURN")) {
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).serverTurn = serverTurn++;
				GameServer.vcClient.get(i).writer.println("TURN&");
			}
		}
	}
	
	private void protocolFinish(String[] parsReaderMsg) {
		//Finish
		if (parsReaderMsg[0].equals("FINISH")) {
			Ui9.Input.setText(Ui9.Input.getText() + "[server] 게임종료 됨\n");
			System.out.println(TAG + "PROTOCOL Finish");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				try {
					Ui9.Input.setText(Ui9.Input.getText() + "[server] 아이디" + GameServer.vcClient.get(i).clientID + "\n");
					Ui9.Input.setText(Ui9.Input.getText() + "[server] 점수" + GameServer.vcClient.get(i).score + "\n");
				}catch (Exception e) {}
				
				for (int j = 0; j < GameServer.vcClient.size(); j++) {
					GameServer.vcClient.get(i).writer.println(
							"FINISH"
							+ "&" + String.valueOf(j) 
							+ "&" + String.valueOf(GameServer.vcClient.size()) 
							+ "&" + GameServer.vcClient.get(j).clientID
							+ "&" + String.valueOf(GameServer.vcClient.get(j).score));
				}
			}			
		}
		
		//자동종료
		if (serverTurn == GameServer.vcClient.size()*2) {
			System.out.println(TAG + "PROTOCOL Finish");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				for (int j = 0; j < GameServer.vcClient.size(); j++) {
					GameServer.vcClient.get(i).writer.println(
							"FINISH" 
							+ "&" + String.valueOf(j) 
							+ "&" + String.valueOf(GameServer.vcClient.size()) 
							+ "&" + GameServer.vcClient.get(j).clientID
							+ "&" + String.valueOf(GameServer.vcClient.get(j).score));
				}
			}		
		}
	}
	
	private void protocolExit(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("EXIT")) {
			Ui9.Input.setText(Ui9.Input.getText() + "[server] " + parsReaderMsg[1] + " 게임에서 나감\n");
			System.out.println(TAG + "PROTOCOL Exit");
			for(int i = 0; i < GameServer.vcClient.size(); i++) {
				if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
					GameServer.vcClient.remove(i);					
				}
			}			
		}
	}
	
	private void protocolScore(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("SCORE")) {
			System.out.println(TAG + "PROTOCOL Score");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				if (GameServer.vcClient.get(i).clientID.equals(parsReaderMsg[1])) {
					GameServer.vcClient.get(i).score = 100;
					for (int j = 0; j < GameServer.vcClient.size(); j++) {
						GameServer.vcClient.get(j).writer.println("SCORE&");
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
				GameServer.vcClient.get(i).writer.println("ITEM1&[" + parsReaderMsg[1] + "]: " + "초성아이템 사용");
			}
		}
	}
	
	private void protocolItem2(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM2")) {
			System.out.println(TAG + "PROTOCOL item2");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM2&[" + parsReaderMsg[1] + "]: " + "글자힌트 사용");
			}
		}
	}
	
	private void protocolItem3(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM3")) {
			System.out.println(TAG + "PROTOCOL item3");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM3&[" + parsReaderMsg[1] + "]: " + "먹물아이템 사용");
			}
		}
	}
	
	private void protocolItem4(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM4")) {
			System.out.println(TAG + "PROTOCOL item4");
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("ITEM4&[" + parsReaderMsg[1] + "]: " + "먹물방어아이템 사용");
			}
		}
	}
} // end of class ClientInfo
