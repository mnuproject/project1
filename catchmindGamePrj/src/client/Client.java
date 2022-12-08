package client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import UI.Ui6;
import server.ClientInfo;
import server.GameServer;

public class Client {
	private String TAG = "Client : ";
	public static String clientID = "user";
	public static boolean isReady = false;
	public static int score = 0;
	
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
	
	public void sendId(String idText) {		
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			
			if (idText != null) {
				clientID = idText;
				System.out.println(clientID);
			}
			writer.println("ID&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "Id Msg fail...");
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
	
	public void sendReady() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("READY&" +clientID);
		} catch (Exception e) {
			System.out.println(TAG + "Ready Msg send fail...");
		}
	}
	
	public void sendPrepare() {
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("PREPARE&" + clientID);
		} catch (Exception e) {
			System.out.println(TAG + "Ready Msg send fail...");
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
}
