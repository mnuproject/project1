package client;

import java.awt.*;
import java.io.*;

import javax.swing.JOptionPane;

import UI.*;
import item.TimerTh;
import server.GameServer;

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
				
				read_IdTotalList(parsReaderMsg);
				readReadyList(parsReaderMsg);
				
				readChatUI4(parsReaderMsg);
				readColor(parsReaderMsg);
				readDraw(parsReaderMsg);
				readEraser(parsReaderMsg);
				readChatUI6(parsReaderMsg);
				
				readItem1(parsReaderMsg);
				readItem2(parsReaderMsg);
				readItem3(parsReaderMsg);
				readItem4(parsReaderMsg);
			}
		} catch (IOException e) {
			System.out.println(TAG + "reader fail...");
		}
	}
	
	private void read_IdTotalList(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("IDTotalLIST")) {
			try {
				if (parsReaderMsg[1].equals("0")) {
					Ui6.IdProfile1.setBackground(new Color(93, 242, 250));
					Ui6.idProfileID1.setText("아이디: " + parsReaderMsg[2]);
					Ui6.idProfileScore1.setText("점수: " + parsReaderMsg[3]);
				}
				else if (parsReaderMsg[1].equals("1")) {
					Ui6.IdProfile2.setBackground(new Color(110, 250, 50));
					Ui6.idProfileID2.setText("아이디: " + parsReaderMsg[2]);
					Ui6.idProfileScore2.setText("점수: " + parsReaderMsg[3]);
				}
				else if (parsReaderMsg[1].equals("2")) {
					Ui6.IdProfile3.setBackground(new Color(250, 160, 40));
					Ui6.idProfileID3.setText("아이디: " + parsReaderMsg[2]);
					Ui6.idProfileScore3.setText("점수: " + parsReaderMsg[3]);
				}
				else if (parsReaderMsg[1].equals("3")) {
					Ui6.IdProfile4.setBackground(new Color(250, 250, 40));
					Ui6.idProfileID4.setText("아이디: " + parsReaderMsg[2]);
					Ui6.idProfileScore4.setText("점수: " + parsReaderMsg[3]);
				}
			} catch (Exception e) {}
		}
	}

	private void readReadyList(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("IDTotalLIST")) {
			try {
				if (parsReaderMsg[1].equals("0")) {
					if (parsReaderMsg[4].equals("true")) {
						Ui6.idProfileReady1.setVisible(true);		
					}
					else if (parsReaderMsg[4].equals("false")) {
						Ui6.idProfileReady1.setVisible(false);		
					}
				}
				else if (parsReaderMsg[1].equals("1")) {
					if (parsReaderMsg[4].equals("true")) {
						Ui6.idProfileReady2.setVisible(true);		
					}
					else if (parsReaderMsg[4].equals("false")) {
						Ui6.idProfileReady2.setVisible(false);		
					}
				}
				else if (parsReaderMsg[1].equals("2")) {
					if (parsReaderMsg[4].equals("true")) {
						Ui6.idProfileReady3.setVisible(true);		
					}
					else if (parsReaderMsg[4].equals("false")) {
						Ui6.idProfileReady3.setVisible(false);		
					}
				}
				else if (parsReaderMsg[1].equals("3")) {
					if (parsReaderMsg[4].equals("true")) {
						Ui6.idProfileReady4.setVisible(true);		
					}
					else if (parsReaderMsg[4].equals("false")) {
						Ui6.idProfileReady4.setVisible(false);		
					}
				}
			} catch (Exception e) {}
		}
	}
	
	private void readColor(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("COLOR")) {
			System.out.println(TAG + "color change");
			if (parsReaderMsg[1].equals("Black")) {
				System.out.println(TAG + "black pen");
				Screen.getScreen().addColor(Color.BLACK);
			} 
			else if (parsReaderMsg[1].equals("Red")) {
				System.out.println(TAG + "red pen");
				Screen.getScreen().addColor(Color.RED);
			} 
			else if (parsReaderMsg[1].equals("Orange")) {
				System.out.println(TAG + "orange pen");
				Screen.getScreen().addColor(Color.ORANGE);
			} 
			else if (parsReaderMsg[1].equals("Yellow")) {
				System.out.println(TAG + "yellow pen");
				Screen.getScreen().addColor(Color.YELLOW);
			} 
			else if (parsReaderMsg[1].equals("Green")) {
				System.out.println(TAG + "green pen");
				Screen.getScreen().addColor(Color.GREEN);
			} 
			else if (parsReaderMsg[1].equals("Cyan")) {
				System.out.println(TAG + "cyan pen");
				Screen.getScreen().addColor(Color.CYAN);
			} 
			else if (parsReaderMsg[1].equals("Blue")) {
				System.out.println(TAG + "blue pen");
				Screen.getScreen().addColor(Color.BLUE);
			} 
			else if (parsReaderMsg[1].equals("Purple")) {
				System.out.println(TAG + "purple pen");
				Screen.getScreen().addColor(Color.MAGENTA);
			} 
			else if (parsReaderMsg[1].equals("Eraser")) {
				System.out.println(TAG + "Eraser");
				Screen.getScreen().setEraser();
			} 
			else if (parsReaderMsg[1].equals("Delete")) {
				System.out.println(TAG + "all Delete");
				Screen.getScreen().setClear();
			}
		}
	}

	private void readDraw(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("DRAW")) {
			String xy[] = parsReaderMsg[1].split(",");
			System.out.println(String.format("%s DRAW (%s, %s)", TAG, xy[0], xy[1]));
			Point xyP = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
			Screen.getScreen().addPoint(xyP);
		}
	}

	private void readEraser(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("Eraser")) {
			String xy[] = parsReaderMsg[1].split(",");
			System.out.println(String.format("%s Eraser (%s, %s)", TAG, xy[0], xy[1]));
			Point xyP = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
			Screen.getScreen().eraser(xyP);
		}
	}
	
	private void readChatUI4(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("CHAT")) {
			System.out.println(TAG + parsReaderMsg[1]);
			Ui4.ta1.setText(Ui4.ta1.getText()+"\n"+parsReaderMsg[1]);
		}
	}
	
	private void readChatUI6(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("CHAT")) {
			System.out.println(TAG + "chat");
			try {
				Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);				
			} catch (Exception e) {}
		}
	}
	
	private void readItem1(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM1")) {
			System.out.println(TAG + "item1");
			new TimerTh().start();
			Ui6.playTitle.setText("제시어 : 동물");
			Ui6.playTitle.setFont(new Font("맑은고딕", Font.BOLD, 16));
			Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);
		}
	}
	
	private void readItem2(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM2")) {
			System.out.println(TAG + "item2");
			new TimerTh().start();
			Ui6.playTitle.setText("제시어 : 쿠키");
			Ui6.playTitle.setFont(new Font("맑은고딕", Font.BOLD, 16));
			Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);
		}
	}
	
	private void readItem3(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM3")) {
			System.out.println(TAG + "item3");
			new TimerTh().start();
			Ui6.playTitle.setText("제시어 : 귤");
			Ui6.playTitle.setFont(new Font("맑은고딕", Font.BOLD, 16));
			Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);
		}
	}
	
	private void readItem4(String[] parsReaderMsg) {
		if (parsReaderMsg[0].equals("ITEM4")) {
			System.out.println(TAG + "item4");
			new TimerTh().start();
			Ui6.playTitle.setText("제시어 : 오버워치");
			Ui6.playTitle.setFont(new Font("맑은고딕", Font.BOLD, 16));
			Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+parsReaderMsg[1]);
		}
	}
}
