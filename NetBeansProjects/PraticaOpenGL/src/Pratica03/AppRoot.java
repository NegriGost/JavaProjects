/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pratica03;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Rodrigues Mafumo
 */
public abstract class AppRoot implements GLEventListener{
    
    protected  GL2 g;
    
    private static GLU glu;
    GLUT glut;
    
    private GLProfile profile;
    private GLCapabilities capabilities;
    
    private FPSAnimator animator;
    private GLJPanel glcanvas;
    
    private JFrame frame;
    
    private JPanel panel;
    
    private static InputMap inputMap;
    private static ActionMap actionMap;
    
    
    
    public abstract  void registerAllKeysActions();
    public abstract void display(GLAutoDrawable drawable);
    
    
    public void drawFiguref(int mode,float[][] figure){
        
        if((figure==null)||(figure[0].length!=3)) return;
        
        Random r=new Random(1);
        this.g.glBegin(mode);
            for (int i = 0; i < figure.length; i++) {
                this.g.glColor3f(r.nextInt(), r.nextInt(), r.nextInt());
                this.g.glVertex3f(figure[i][0], figure[i][1], figure[i][2]);
            }
        this.g.glEnd();
        this.g.glFlush();
    
    }
    
     public void drawFigureQuads3f(float[][] figure){
         drawFiguref(GL2.GL_QUADS, figure);
     }
    
    public void drawFigureTriangls3f(float[][] figure){
        drawFiguref(GL2.GL_TRIANGLES, figure);      
    }
    
     public void drawFigureCubef(float[][] figure){
        drawFiguref(GL2.GL_QUADS, figure);      
    }
    
    public void drawFigureCircle3f(float[][] figure){
        drawFiguref(GL2.GL_LINE_BIT, figure);      
    }
    
    public void drawFigureLine3f(float[][] figure){
        drawFiguref(GL2.GL_LINES, figure);      
    }
    
    
    //inicializa objectos para criar a janel
    private void initGLObjects(){
        this.glu=new GLU();
        glut = new GLUT();
        this.profile=GLProfile.get(GLProfile.GL2);
        this.capabilities= new GLCapabilities(this.profile);
    }
    
    //inicializa a janela
    private void createWindow(){
        this.glcanvas=new GLJPanel(this.capabilities);
        this.glcanvas.addGLEventListener(this);
        this.glcanvas.setSize(800,600);
        
        this.frame=new JFrame("Aplicação Core");
        this.frame.getContentPane().add(this.glcanvas);
        this.frame.setSize(this.frame.getContentPane().getPreferredSize());
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
////        this.panel=new JPanel();
////        this.panel.setPreferredSize(new Dimension(0,0));
////        this.panel.add(glcanvas);
////        this.frame.add(this.panel);
        
        this.actionMap=this.glcanvas.getActionMap();
        this.inputMap=this.glcanvas.getInputMap();
        
        this.frame.addWindowListener(new WindowAdapter(){
            
            public void windowIsClosing(){
                
                if(animator.isStarted()){
                    animator.stop();
                    System.exit(0); 
                }
                    
            }
        
        });
    }
    
    public void registerKeyAction(Integer key, AbstractAction a){
        this.inputMap.put(KeyStroke.getKeyStroke(key,0),key.toString());
        this.actionMap.put(key.toString(), a);
    }
    
    
    //Começa a animação
    public void start(){this.animator.start();}
    
    //Refresca a Janela
    public void clearCanvas(){
        this.g.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        this.g.glLoadIdentity();
    }
    
    public void init(GLAutoDrawable d){
       this.g = d.getGL().getGL2();
       this.g.glShadeModel(GL2.GL_SMOOTH); 
       this.g.glClearColor(0,0,0,0);
       this.g.glClearDepth(1);
       this.g.glEnable(GL2.GL_DEPTH_TEST); 
       this.g.glDepthFunc(GL2.GL_LEQUAL);
       this.g.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT,GL2.GL_NICEST); 
    }
    
    public void reshape(GLAutoDrawable d,int x,int y,int width,int height) throws NullPointerException{
        this.g.glViewport(x, y, width, height);
        this.g.glMatrixMode(GL2.GL_PROJECTION); 
        this.g.glLoadIdentity();
        glu.gluPerspective(45f,(float) width/(float) height, 1, 20);
        this.g.glMatrixMode(GL2.GL_MODELVIEW);
        this.g.glLoadIdentity();
        
    }
    
    public void dispose(GLAutoDrawable d){}
    
    public AppRoot(){
        this.initGLObjects();
        this.createWindow();
        registerAllKeysActions();
        this.animator=new FPSAnimator(this.glcanvas,200,true);
        this.frame.setVisible(true);
    }
    
}
