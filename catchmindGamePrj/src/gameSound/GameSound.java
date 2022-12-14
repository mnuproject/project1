package gameSound;

import javax.sound.sampled.*;

public class GameSound {
	private Clip bgClip = null;
	private Clip clip = null;
	
	public GameSound(String bgPath) {
		if (bgPath != null) {
			playBg(bgPath);			
		}
	}
	
	private void playBg(String bgPath) {
		try {
			bgClip = AudioSystem.getClip();
			bgClip.open(AudioSystem.getAudioInputStream(getClass().getResource(String.format("/" + bgPath))));
			bgClip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopBg() {
		try {
			bgClip.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playEffect(String path) {
        try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(String.format("/" + path))));
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			clip.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
