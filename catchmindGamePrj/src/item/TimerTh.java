package item;

import UI.*;

public class TimerTh extends Thread {
	public static boolean planStart = true;
	
	@Override
	public void run() {
		if (planStart) {
			planStart = false;
			try {
				for (int val=100; val>=0; val -= 1) {
					Ui6.timeProgress.setValue(val);
					Thread.sleep(1000);
				}
				planStart = true;
				Ui6.taChat.setText(Ui6.taChat.getText()+"\n"+"item 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
