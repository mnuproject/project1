package server;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import client.GameStart;
import res.Word;

// 서버로 부터 메세지를 받아 TextArea에 뿌려주는 Thread.
public class ReaderThread extends Thread {
	/*private BufferedReader reader;

	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(GameServerRes.socket.getInputStream()));
			String readerMsg = null;
			String[] parsReaderMsg;
			while ((readerMsg = reader.readLine()) != null) {
				parsReaderMsg = readerMsg.split("&");
				if (parsReaderMsg[0].equals("DRAW")) {
					String[] drawM = parsReaderMsg[1].split(",");
					res.res.x = Integer.parseInt(drawM[0]);
					res.res.y = Integer.parseInt(drawM[1]);
					res.res.brush.setX(res.res.x);
					res.res.brush.setY(res.res.y);
					res.res.brush.repaint();
					res.res.brush.printAll(res.res.imgBuff.getGraphics());
					System.out.println("브러쉬 값 : " + drawM);
					System.out.println("브러쉬 값 : " + res.res.x);
					System.out.println("브러쉬 값 : " + res.res.y);
				} else if (parsReaderMsg[0].equals("COLOR")) {
					System.out.println("색 변경 요청 들어옴");
					if (parsReaderMsg[1].equals("Black")) {
						System.out.println("검은색 요청");
						res.res.brush.setColor(Color.BLACK);
					} else if (parsReaderMsg[1].equals("Red")) {
						System.out.println("빨간색 요청");
						res.res.brush.setColor(Color.RED);
					} else if (parsReaderMsg[1].equals("Orange")) {
						System.out.println("주황색 요청");
						res.res.brush.setColor(Color.ORANGE);
					} else if (parsReaderMsg[1].equals("Yellow")) {
						System.out.println("노랑색 요청");
						res.res.brush.setColor(Color.YELLOW);
					} else if (parsReaderMsg[1].equals("Green")) {
						System.out.println("초록색 요청");
						res.res.brush.setColor(Color.GREEN);
					} else if (parsReaderMsg[1].equals("Blue")) {
						System.out.println("파랑색 요청");
						res.res.brush.setColor(Color.CYAN);
					} else if (parsReaderMsg[1].equals("Indigo")) {
						System.out.println("인디고 위졋고 휘졋고 오졋고 요청");
						res.res.brush.setColor(Color.BLUE);
					} else if (parsReaderMsg[1].equals("Purple")) {
						System.out.println("퍼플같은 핑크 요청");
						res.res.brush.setColor(Color.PINK);
					} else if (parsReaderMsg[1].equals("White")) {
						System.out.println("지우개 요청");
						res.res.brush.setColor(Color.WHITE);
					} else if (parsReaderMsg[1].equals("Delete")) {
						System.out.println("화면 리셋 요청");
						res.res.brush.setClearC(false);
						res.res.brush.repaint();
						res.res.brush.printAll(res.res.imgBuff.getGraphics());
					}
				} else if (parsReaderMsg[0].equals("SERVER")) {
					GameStart.taChat.append("[SERVER]: " + parsReaderMsg[1] + "\n");
				} else if (parsReaderMsg[0].equals("CHAT") && parsReaderMsg.length > 1) {
					GameStart.taChat.append(parsReaderMsg[1] + "\n");
				} else if (parsReaderMsg[0].equals("START")) {
					GameStart.btnReady.setVisible(false);

				} else if (parsReaderMsg[0].equals("ID")) {
					GameStart.taUserList.setText("");
				} else if (parsReaderMsg[0].equals("IDLIST")) {
					GameStart.taUserList.append(parsReaderMsg[1] + "\n");
				} else if (parsReaderMsg[0].equals("TURN")) {
					GameStart.laQuiz.setText(Word.problem[res.res.selectProblem]);
					GameStart.laQuiz.setVisible(true);
					GameStart.btnSkip.setVisible(true);
					res.res.drawPPAP = true;
					GameStart.tfChat.setEnabled(false);
					GameStart.plBottom.setVisible(true);
					System.out.println("내 턴 임");
				} else if (parsReaderMsg[0].equals("NOTTURN")) {
					GameStart.laQuiz.setVisible(false);
					GameStart.btnSkip.setVisible(false);
					System.out.println("내 턴 아님");
					res.res.brush.setDrawPen(false);
					res.res.drawPPAP = false;
					GameStart.tfChat.setEnabled(true);
					GameStart.plBottom.setVisible(false);
					System.out.println(res.res.drawPPAP);
				} else if (parsReaderMsg[0].equals("ANSWER")) {
					res.res.selectProblem++;
					if (res.res.selectProblem >= Word.problem.length) {
						res.res.selectProblem = 0;
					}
				} else if (parsReaderMsg[0].equals("END")) {
					GameStart.taChat.append("[SERVER]: " + parsReaderMsg[1] + "\n");
					GameStart.btnReady.setVisible(true);
					GameStart.tfChat.setEnabled(true);
					GameStart.plBottom.setVisible(true);
					GameStart.btnSkip.setVisible(false);
					GameStart.btnReady.setVisible(true);
					GameStart.laQuiz.setVisible(false);
					res.res.drawPPAP = true;
				} else {
					GameStart.taChat.append("\n");
				}
				// 스크롤을 밑으로 고정.
				GameStart.scrChat.getVerticalScrollBar().setValue(GameStart.scrChat.getVerticalScrollBar().getMaximum());
			}
		} catch (IOException e) {
			System.out.println(GameStart.TAG + "통신 실패");
		}
	}*/
}
