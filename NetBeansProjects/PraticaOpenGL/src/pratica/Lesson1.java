/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Rodrigues Mafumo
 */
public class Lesson1 implements GLEventListener{

    private static GraphicsEnvironment graphicsEveroment;
    private static boolean isFullScreen=false;
    private static DisplayMode dm,dm_old;
    private static Dimension xGraphic;
    private static Point point=new Point(0,0);
    
    @Override
    public void init(GLAutoDrawable drawable) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable drawable) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        
        //definindo o open Gl Versao 2
        final GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        
        //The Canvas para tudo que formos a desenhar
        GLCanvas glcanvas=new GLCanvas(capabilities);
        Lesson1 l=new Lesson1();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(400,400);
        
        //Animação
        final FPSAnimator animator=new FPSAnimator(glcanvas,300,true);
        final JFrame frame=new JFrame("Lesson1 of OpenGl");
        frame.getContentPane().add(glcanvas);
        
        //fechar janela
        frame.addWindowListener(new WindowAdapter() {
            public  void WindowClosing(WindowEvent e){
                if(animator.isStarted()){
                    animator.stop();
                    System.exit(0);
                }
            }
        });
//        
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
    
}
