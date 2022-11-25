// 최종본
package server;

import java.net.ServerSocket;
import java.util.Vector;

public class GameServer {
	// 생성자에서 클라이언트의 접속을 대기한다 (메인 스레드)
	public GameServer() {
		try {
			GameServerRes.serverSocket = new ServerSocket(GameServerRes.PortNum);
			GameServerRes.vcClient = new Vector<>();
			while (true) {
				System.out.println("클라이언트 요청 대기중.....");
				GameServerRes.socket = GameServerRes.serverSocket.accept(); // 서버의 접속을 대기중.
				System.out.println("요청이 성공함");
				// 추가 스레드에 클라이언트 소켓을 타켓으로 설정.
				ClientInfo ci = new ClientInfo(GameServerRes.socket);
				ci.start();
				GameServerRes.vcClient.add(ci); // 백터에 추가.
			}

		} catch (Exception e) {
			System.out.println(GameServerRes.TAG + "연결안됨");
		}
	} // END OF CONSTRUCTOR

	public static void main(String[] args) {
		new GameServer();
	}

}
