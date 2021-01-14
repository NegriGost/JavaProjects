/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pratica02;

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

    private float [][] figureQuads={
        {-1,-1,1},
        {1,-1,1},
        {1,1,1},
        {-1,1,1}
    };
    
     private float [][] figureCircle={
        {1,0,0},
        {1,1,0},
        {1,1,1},

    };
    
    private float [][] figureTriangls={
        {0,1,0},
        {-1,-1,0},
        {1,-1,0},
    };
    
    public static void main(String[] args) {
        App app=new App();
        app.start();
    }

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
       this.g.glTranslatef(0, 0, -6.6f);
       this.g.glRotatef(xRotate, 1, 0, 0);
       this.g.glRotatef(yRotate, 0, 1, 0);
       this.g.glRotatef(zRotate, 0, 0, 1);
       
//        drawFigureQuads3f(figureQuads);
//        drawFigureTriangls3f(figureTriangls);
//        drawFigureCircle3f(figureCircle);
        
        this.g.glBegin(GL2.GL_LINE_LOOP);
        
            this.g.glVertex2f(1, 1);
            this.g.glVertex2f(1, -1);
//            this.g.glVertex2f(-1, -1);
//            this.g.glVertex2f(-1, 1);
            
        this.g.glEnd();
        this.g.glFlush();
    }
}
