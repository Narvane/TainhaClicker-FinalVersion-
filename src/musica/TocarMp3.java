package musica;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class TocarMp3 {

Player ply;
boolean loop;
class musica extends Thread {
		
		public void run() {
			
			try {
				do 
				{
			InputStream imput = this.getClass().getResourceAsStream("BobSong.mp3") ;
				ply = new Player (imput);
				ply.play();
				 }while(loop);
			} catch (JavaLayerException e) {
				e.printStackTrace();
				//https://www.youtube.com/watch?v=kC9_dK5hQPo
			}
		}
}

public void Play() {
	
	musica mp3 = new musica();
	loop=true;
	mp3.start();
	
}
public void Stop() {

	loop=false;
	ply.close();
	
}
	public static void main(String[] args) {
		
new TocarMp3();
	}

}
