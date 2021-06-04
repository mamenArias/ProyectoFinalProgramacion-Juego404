package hilos;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Clase que instancia un objeto tipo HiloBatalla que hereda de Thread.
 * @author Mamen Arias
 *
 */
public class HiloBatalla extends Thread {

	private Clip audioClip; // variable de tipo Clip que contiene la información del audio
	private AudioInputStream audioStream; // variable de tipo AudioStream que contiene el stream del audio
	
	/**
	 * Función que lanza el hilo
	 */
	public void run() {

		File audioFile = new File("audio/battle.wav");
		{
			try {
				audioStream = AudioSystem.getAudioInputStream(audioFile);
				AudioFormat format = audioStream.getFormat();

				DataLine.Info info = new DataLine.Info(Clip.class, format);
				this.audioClip = (Clip) AudioSystem.getLine(info);

				this.audioClip.open(audioStream);
				this.audioClip.start();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}
	
	/**
	 * Función que para el hilo
	 */
	public void parar() {
		this.audioClip.close();
		try {
			this.audioStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}