package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

public class ClientInfo extends Thread {
	private final String TAG = "ClientInfo : ";
	public static LinkedList<String> clientIDS;
	private Socket socket; // 클라이언트 소켓을 받아서 사용하는 변수.
	private PrintWriter writer; // 쓰기 버퍼.
	private BufferedReader reader; // 읽기 버퍼.
	
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
				clientIDS(parsReaderMsg);
				protocolColor(parsReaderMsg);
				protocolDraw(parsReaderMsg);
				protocolEraser(parsReaderMsg);
				protocolChat(parsReaderMsg);
				protocolItem1(parsReaderMsg);
				protocolItem2(parsReaderMsg);
				protocolItem3(parsReaderMsg);
				protocolItem4(parsReaderMsg);
				
				/*protocolID(parsReaderMsg);
				protocolChat(parsReaderMsg);
				protocolSKIP(parsReaderMsg);
				protocolEXIT(parsReaderMsg);
				protocolREADY(parsReaderMsg);
				protocolSTART();
				protocolTURN();
				protocolDraw(parsReaderMsg);
				 */
			}
		} catch (Exception e) {
			System.out.println(TAG + "message fail");
		}
	} // end of run

	private void TestInfo(String text) {
		System.out.println(TAG + "message testInfo");
		for (int i = 0; i < GameServer.vcClient.size(); i++) {
			GameServer.vcClient.get(i).writer.println("client " + text+"\n");
		}
	}
	
	private void clientIDS(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ID")) {
			System.out.println(TAG + "client ID");
			clientIDS.add(parsReaderMsg[1]);
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
	
	// 게임 종료 후 결과를 출력 해주는 메서드.
	// 모든 클라이언트에게 모든 [아이디] [SCORE]값을 출력.
	/*private void protocolRESULT() {
		for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
			GameServerUI.vcClient.get(i).writer.println("END&*****RESERT*****");
			for (int j = 0; j < GameServerUI.vcClient.size(); j++) {
				GameServerUI.vcClient.get(i).writer.println(
						"END&[" + GameServerUI.vcClient.get(j).clientId + "] is SCORE => [" + GameServerUI.vcClient.get(j).score + "]");
			}
			GameServerUI.vcClient.get(i).writer.println("END&*****RESERT*****");
		}
	}

	// CHAT 프로토콜.
	// TextField 입력되는 값들은 모두 채팅으로 받음.
	// 채팅 값 중 정답을 입력하면 정답 프로토콜 메서드를 호출.
	private void protocolChat(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("CHAT") && parsReaderMsg.length > 0) {
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("CHAT&[" + clientId + "]: " + parsReaderMsg[1]);
			}
			//protocolANSWER(parsReaderMsg);
		} else if (parsReaderMsg[0].equals("CHAT")) {
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).writer.println("CHAT&[" + clientId + "] ");
			}
			for (int i = 0; i < GameServer.vcClient.size(); i++) {
				GameServer.vcClient.get(i).isRightAnswer = true;
			}
		}
	}


	// 게임 종료 프로토콜.
	// 게임이 종료되면 결과 값을 출력해주고 변수들을 초기값으로 만듬.
	private void protocolEND(String[] parsReaderMsg) {
		if (isStart == true && isEnd == true) {
			protocolRESULT();
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).writer.println("END&GAME END");
				GameServerUI.vcClient.get(i).isEnd = false;
				GameServerUI.vcClient.get(i).isStart = false;
				GameServerUI.vcClient.get(i).isClickReadybtn = false;
				GameServerUI.vcClient.get(i).isRightAnswer = false;
				GameServerUI.vcClient.get(i).checkReady = 0;
				GameServerUI.vcClient.get(i).selectTurn = 1;
				GameServerUI.vcClient.get(i).score = 0;
			}
		}
	}

	// 넘기기 프로토콜.
	// 넘기기를 버튼을 누르면 답을 맞춘 로직이 실행되지만 점수는 올라가지 않음.
	// 제시어를 다음 으로 바꾸고 턴을 다음 클라이언트에게 넘겨줌.
	private void protocolSKIP(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("SKIP")) {
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).isRightAnswer = true;
				GameServerUI.vcClient.get(i).writer.println("SERVER&Turn Skip.");
				GameServerUI.vcClient.get(i).writer.println("ANSWER&");
			}
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).selectProblem++;
			}
			if (selectProblem >= Word.problem.length) {
				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).selectProblem = 0;
				}
			}
			// 넘기기 버튼을 눌렀는데 다음턴이 없을 경우 게임 종료.
			if (selectTurn > GameServerUI.vcClient.size()) {
				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).isEnd = true;
				}
				protocolEND(parsReaderMsg);
			}
		}
	}
	
	// 준비 버튼 프로토콜.
	// 버튼을 누르면 준비 Boolean값 토글, 서버 메세지 출력.
	// 게임시작을 위한 checkReady버튼을 증가.
	private void protocolREADY(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("READY")) {
			isClickReadybtn = !(isClickReadybtn);
			if (isClickReadybtn == true) {
				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).writer.println("SERVER&[" + clientId + "] is Set Ready.");
					GameServerUI.vcClient.get(i).checkReady++;
				}
				System.out.println("checkReady: " + checkReady);
			} else {

				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).writer.println("SERVER&[" + clientId + "] please wait a moment.");
					GameServerUI.vcClient.get(i).checkReady--;
				}
				System.out.println("checkReady: " + checkReady);
			}
		}
	}

	// ID 프로토콜.
	// 입력 받은 아이디를 저장 후 입장 서버메세지 출력.
	// 그리고 순차적으로 턴 값과 스코어 값을 부여.
	// 이 후 입장한 유저 목록을 위해 IDLIST 프로토콜로
	// 모든 클라이언트 한테 아이디 값을 전송.
	private void protocolID(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ID")) {
			clientId = parsReaderMsg[1];
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).writer.println("SERVER&[" + clientId + "] is enter the room.");
				GameServerUI.vcClient.get(i).writer.println("ID&");
				GameServerUI.vcClient.get(i).userTurn = i + 1;
				GameServerUI.vcClient.get(i).score = 0;
				System.out.println("GameServerRes.vcClient.get(" + i + ").clientId: " + GameServerUI.vcClient.get(i).clientId);
				System.out.println("GameServerRes.vcClient.get(" + i + ").userTurn: " + GameServerUI.vcClient.get(i).userTurn);
				System.out.println("userTurn: " + userTurn);
			} // end of for
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				for (int j = 0; j < GameServerUI.vcClient.size(); j++) {
					GameServerUI.vcClient.get(i).writer.println("IDLIST&[" + GameServerUI.vcClient.get(j).clientId + "]");
				}
			}
		}
	}

	// 정답 프로토콜 메서드.
	// 입력된 값이 제시어와 같다면 서버메세지 출력 후 스코어 증가.
	// 정답을 맞추고 다음 턴이 없다면 게임 종료.
	private void protocolANSWER(String[] parsReaderMsg) {
		if (isStart == true && parsReaderMsg[1].equals(Word.problem[selectProblem])) {
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).writer
						.println("SERVER&[" + clientId + "] , [" + Word.problem[selectProblem] + "] is Right Answer");
				GameServerUI.vcClient.get(i).writer.println("ANSWER&");
				GameServerUI.vcClient.get(i).isRightAnswer = true;
				if (GameServerUI.vcClient.get(i).clientId.equals(clientId)) {
					GameServerUI.vcClient.get(i).score++;
					System.out.println("GameServerRes.vcClient.get( " + i + " ).score: " + GameServerUI.vcClient.get(i).score);
				}
			}
			for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
				GameServerUI.vcClient.get(i).selectProblem++;
			}
			if (selectProblem >= Word.problem.length) {
				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).selectProblem = 0;
				}
				System.out.println("selectProblem: " + selectProblem);
			}
			if (selectTurn > GameServerUI.vcClient.size()) {
				for (int i = 0; i < GameServerUI.vcClient.size(); i++) {
					GameServerUI.vcClient.get(i).isEnd = true;
				}
				protocolEND(parsReaderMsg);
			}
		}
	}


	*/
	
	
} // end of class ClientInfo
