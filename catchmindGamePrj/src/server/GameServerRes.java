package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class GameServerRes {
	public static final String TAG = "GameServer : "; // 태그 생성.
	public static Vector<ClientInfo> vcClient; // 클라이언트의 정보를 담는 벡터.
	public static ServerSocket serverSocket; // 서버 소켓.
	public static Socket socket; // 클라이언트가 접속하면 새로 만드는 소켓.
	public static int PortNum = 3000;
}
