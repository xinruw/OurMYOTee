import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.JFileChooser;  
import javax.imageio.ImageIO;
public class Saver {

	public Saver(BufferedImage a){
		JFileChooser jfc = new JFileChooser(); 
		jfc.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
		jfc.showSaveDialog(null); 
		File dir = jfc.getSelectedFile(); // Ñ¡ÔñÎÄ¼þ
		String path = dir.getAbsolutePath() + "\\myFacu.png";
		File f = new File(path);
		try {
			ImageIO.write(a, "png", f);
		} catch (IOException e) {}
		
		new TTQGame(path);
	}
}
