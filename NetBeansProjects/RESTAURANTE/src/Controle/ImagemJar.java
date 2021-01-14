
package Controle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigues
 */
public class ImagemJar {

    public ImagemJar() {
    }
    
        public InputStream getArquivo(String end) {
          InputStream is = getClass().getResourceAsStream(end);
          return is;
	}
        public ImageIcon getImageIcon(String end) {
		InputStream inputStream = getArquivo(end);
		byte[] dados;
		try {
			dados = new byte[inputStream.available()];
			inputStream.read(dados);
			return new ImageIcon(dados);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return null;
	}
        
        public static Dimension redimensionarFrameTotal (){
            return ( new Dimension ( (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (), (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ())); 
        }
}
