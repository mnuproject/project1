package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class GameServer {
	private final String TAG = "GameServer : ";
	public static Vector<ClientInfo> vcClient; // 클라이언트의 정보를 담는 벡터.
	private static GameServer gameServer;
	private ServerSocket serverSocket; // 서버 소켓.
	private Socket socket; // 클라이언트가 접속하면 새로 만드는 소켓.
	
	public static String ip = "localhost";
	public static int PortNum = 3000;
	
	// 생성자에서 클라이언트의 접속을 대기한다 (메인 스레드)
	private GameServer() {
		try {
			serverSocket = new ServerSocket(PortNum);
			vcClient = new Vector<>();
			
			while (true) {
				Ui9.playTitle.setText("접속 대기중..");
				Ui9.Input.setText(Ui9.Input.getText() + "[server] 접속 대기중...\n");
				System.out.println("client Accept wait.....");
				
				socket = serverSocket.accept(); // 서버의 접속을 대기중.
				System.out.println("Accept");
				Ui9.Input.setText(Ui9.Input.getText() + "[server] 클라이언트 접속\n");
				
				// 추가 스레드에 클라이언트 소켓을 타켓으로 설정.
				ClientInfo ci = new ClientInfo(socket);
				ci.start();
				vcClient.add(ci); // 백터에 추가.
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "server error");
		}
	}
	
	public static GameServer start() {
		if (gameServer == null) {
			gameServer = new GameServer();
		}
		return gameServer;
	}
	
	public static void main(String[] args) {
		MainFrame.getMainFrame();
	}
}
