package client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import server.GameServer;

public class Client {
	private String TAG = "Client : ";
	public static String ip = "localhost";
	public static int PortNum = 3000;
	
	public static String clientID = "user";
	public static boolean isReady = false;
	
	//socket
	public static Socket socket;
	public static PrintWriter writer;
	public static BufferedReader reader;
	
	public void connectServer() {
		try {
			socket = new Socket(ip, PortNum);
			ReaderThread rt = new ReaderThread();
			rt.start();				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "서버접속 실패");
			System.out.println(TAG + "Server connect fail..");
		}
	}
	
	public void sendId(String idText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			if (idText != null) {
				Client.clientID = idText;
				System.out.println(clientID);
			}
			writer.println("ID&" + clientID);
			
		} catch (Exception e) {
			System.out.println(TAG + "Id Msg fail...");
		}
	}
	
	public void send_IdTotalList() {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("IDTotalLIST&");
		} catch (Exception e) {
			System.out.println(TAG + "Id Msg fail...");
		}
	}
	
	public void sendReady() {
		try {
			isReady = !isReady;
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("READY&" + clientID + "&" + String.valueOf(isReady));
		} catch (Exception e) {
			System.out.println(TAG + "Ready Msg send fail...");
		}
	}
	
	public void sendFinTurn() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("FTURN&");
		} catch (Exception e) {
			System.out.println(TAG + "Finish Turn Msg send fail...");
		}
	}
	
	public void sendFinish() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("FINISH&");
		} catch (Exception e) {
			System.out.println(TAG + "Finish Msg send fail...");
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
	
	public void sendDraw(String xyText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("DRAW&" + xyText);
		} catch (Exception e) {
			System.out.println(TAG + "Draw Msg fail...");
		}
	}	
	
	public void sendEraser(String xyText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("Eraser&" + xyText);
		} catch (Exception e) {
			System.out.println(TAG + "Eraser Msg fail...");
		}
	}
	
	public void sendChat(String chatText) {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("CHAT&" + clientID +"&" + chatText);
		} catch (Exception e) {
			System.out.println(TAG + "Chat Msg fail...");
		}
	}
	
	public void sendItem1() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM1&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "item1 Msg fail...");
		}
	}
	
	public void sendItem2() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM2&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "item2 Msg fail...");
		}
	}
	
	public void sendItem3() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM3&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "item3 Msg fail...");
		}
	}
	
	public void sendItem4() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("ITEM4&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "item4 Msg fail...");
		}
	}
	
	public void sendExit() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("EXIT&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "Exit Msg fail...");
		}
	}
}
