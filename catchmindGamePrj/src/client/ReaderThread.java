package client;

import java.awt.*;
import java.io.*;
import UI.*;

public class ReaderThread extends Thread {
	private final String TAG = "Reader : ";
	private BufferedReader reader;

	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(Client.socket.getInputStream()));
			String readerMsg = null;
			String[] parsReaderMsg;

			while ((readerMsg = reader.readLine()) != null) {
				parsReaderMsg = readerMsg.split("&");
				
				readColor(parsReaderMsg);
				readDraw(parsReaderMsg);
				readChatUI6(parsReaderMsg);				
			}
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println(TAG + "reader fail...");
		}
	}
	
	private void readColor(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("COLOR")) {
			System.out.println(TAG + "color change");
			if (parsReaderMsg[1].equals("Black")) {
				System.out.println(TAG + "black pen");
				Screen.getScreen().setColor(Color.BLACK);
			} 
			else if (parsReaderMsg[1].equals("Red")) {
				System.out.println(TAG + "red pen");
				Screen.getScreen().setColor(Color.RED);
			} 
			else if (parsReaderMsg[1].equals("Orange")) {
				System.out.println(TAG + "orange pen");
				Screen.getScreen().setColor(Color.ORANGE);
			} 
			else if (parsReaderMsg[1].equals("Yellow")) {
				System.out.println(TAG + "yellow pen");
				Screen.getScreen().setColor(Color.YELLOW);
			} 
			else if (parsReaderMsg[1].equals("Green")) {
				System.out.println(TAG + "green pen");
				Screen.getScreen().setColor(Color.GREEN);
			} 
			else if (parsReaderMsg[1].equals("Cyan")) {
				System.out.println(TAG + "cyan pen");
				Screen.getScreen().setColor(Color.CYAN);
			} 
			else if (parsReaderMsg[1].equals("Blue")) {
				System.out.println(TAG + "blue pen");
				Screen.getScreen().setColor(Color.BLUE);
			} 
			else if (parsReaderMsg[1].equals("Purple")) {
				System.out.println(TAG + "purple pen");
				Screen.getScreen().setColor(Color.MAGENTA);
			} 
			else if (parsReaderMsg[1].equals("Eraser")) {
				System.out.println(TAG + "Eraser");
				Screen.getScreen().setEraser();
			} 
			else if (parsReaderMsg[1].equals("Delete")) {
				System.out.println(TAG + "all Delete");
				Screen.getScreen().setClear();
				Screen.getScreen().repaint();
			}
		}
	}

	private void readDraw(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("DRAW")) {
			String xy[] = parsReaderMsg[1].split(",");
			System.out.println(String.format("%s DRAW (%s, %s)", TAG, xy[0], xy[1]));		
			Point xyP = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
			Screen.mousePointList.add(xyP);
		}
	}
	
	private void readChatUI6(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("CHAT")) {
			System.out.println(TAG + "chat");
			Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);
		}
	}
}
