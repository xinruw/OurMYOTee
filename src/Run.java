import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Run {
	public static void main(String[] args) throws IOException {
		new WelcomePage(); 
		Music sound = new Music("background.wav");
		InputStream stream =new ByteArrayInputStream(sound.getSamples());
		// play the sound
		sound.play(stream);
	}
}
