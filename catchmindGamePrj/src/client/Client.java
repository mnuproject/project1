package client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import server.GameServer;

public class Client {
	private String TAG = "Client : ";
	public static boolean isReady = false;
	
	//socket
	public static Socket socket;
	public static PrintWriter writer;
	public static BufferedReader reader;
	
	public void connectServer() {
		try {
			socket = new Socket(GameServer.ip, GameServer.PortNum);
			ReaderThread rt = new ReaderThread();
			rt.start();
		} catch (Exception e) {
			System.out.println(TAG + "Server connect fail..");
		}
	}
	
	public void sendInsertId(String idText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			if ((idText.equals(""))) { // NULL값 입력시
				writer.println("ID&" + "emptyID");
			} else { // 아이디 값 입력시.
				writer.println("ID&" + idText);
			}
		} catch (Exception e) {
			System.out.println(TAG + "Id Msg fail...");
		}
	}
	
	public void sendReady(String idText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("READY&" + idText);
		} catch (Exception e) {
			System.out.println(TAG + "Ready Msg send fail...");
		}
	}
	
	public void sendChat(String chatText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("CHAT&" + chatText);
		} catch (Exception e) {
			System.out.println(TAG + "Chat Msg fail...");
		}
	}
	
	public void sendColor(String colorText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("COLOR&" + colorText);
		} catch (Exception e) {
			System.out.println(TAG + "Color Msg fail...");
		}
	}
	
	public void sendDraw(String drawText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("DRAW&" + drawText);
		} catch (Exception e) {
			System.out.println(TAG + "Draw Msg fail...");
		}
	}
	
	public void sendItem1(String itemText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM1&" + itemText);
		} catch (Exception e) {
			System.out.println(TAG + "item1 Msg fail...");
		}
	}
	
	public void sendItem2(String itemText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM2&" + itemText);
		} catch (Exception e) {
			System.out.println(TAG + "item2 Msg fail...");
		}
	}
	
	public void sendItem3(String itemText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM3&" + itemText);
		} catch (Exception e) {
			System.out.println(TAG + "item3 Msg fail...");
		}
	}
	
	public void sendItem4(String itemText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM4&" + itemText);
		} catch (Exception e) {
			System.out.println(TAG + "item4 Msg fail...");
		}
	}
}
