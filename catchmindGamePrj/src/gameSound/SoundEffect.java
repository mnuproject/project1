package gameSound;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
	public SoundEffect() {
		
	}
	
	public void playEffect_turn() {
        Clip clip = null;
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("resources/soundeffect_turn.wav")));
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
