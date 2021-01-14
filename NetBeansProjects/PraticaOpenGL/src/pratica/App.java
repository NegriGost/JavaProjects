/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Rodrigues Mafumo
 */
public class App extends AppRoot{
    
    private float xRotate;
    private float yRotate;
    private float zRotate;
    private float lop=50;

    
    public static void main(String[] args) {
        App app=new App();
        app.start();
    }
    private float horas=17;
    private float rquad=0.0f,rtri=0.0f;

    @Override
    public void registerAllKeysActions() {
        registerKeyAction(KeyEvent.VK_UP, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xRotate+=3;
            }
        });
        
       
        registerKeyAction(KeyEvent.VK_DOWN, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xRotate-=3;
            }
        });
        
        registerKeyAction(KeyEvent.VK_LEFT, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yRotate+=3;
            }
        });
        
         registerKeyAction(KeyEvent.VK_RIGHT, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yRotate-=3;
            }
        });
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       clearCanvas();
       this.g.glTranslatef(xRotate, 0, -6.6f);
//       this.g.glRotatef(xRotate, 1, 0, 0);
//       this.g.glRotatef(yRotate, 0, 1, 0);
//       this.g.glRotatef(zRotate, 0, 0, 1);
       
        this.g.glLineWidth(3);
       
        this.g.glBegin(GL2.GL_LINE_LOOP);

            this.g.glVertex2f((float) 1.0,(float) 0.0);
            
            for (int i = 0; i < lop; i++) {
                
                 float t=(float) (i*Math.PI*2/lop);
                 this.g.glVertex2f((float) Math.cos(t),(float) Math.sin(t));
            }
            
          //            
       this.g.glEnd();
       this.g.glFlush();
       
       
       this.g.glLineWidth(3);
       this.g.glTranslatef(xRotate, 0, 6.6f);
        this.g.glBegin(GL2.GL_LINE_LOOP);

            this.g.glVertex2f((float) 1.0,(float) 0.0);
            
            for (int i = 0; i < lop; i++) {
                
                 float t=(float) (i*Math.PI*2/lop);
                 this.g.glVertex2f((float) Math.cos(t),(float) Math.sin(t));
            }
            
          //            
       this.g.glEnd();
       this.g.glFlush();
       
       
       this.xRotate-=0.15f;   
       this.xRotate+=0.15f;  
       
    }
}
