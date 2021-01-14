/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Rodrigues
 */
public class ImagemFundo implements Border{

    public BufferedImage back;

    public ImagemFundo(String caminho) {
    
        try{
            URL imagemIcon=new URL(getClass().getResource(caminho).toString());
            back=ImageIO.read(imagemIcon.openStream());
        }catch(Exception e){
        e.getStackTrace();
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x+(width-back.getWidth())/2), (y+(height-back.getHeight())/2), c);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
}
