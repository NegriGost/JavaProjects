/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pratica03;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Rodrigues Mafumo
 */
public class Cubo_Em_Rotacao extends AppRoot{
    
    private float xRotate;
    private float yRotate;
    private float zRotate;
    private float rquad = 0.0f;

//    private float [][] figureLines={
//        {0,0,0},
//        {3.5f,0,0},
//    };
//    
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
    
    private float [][] figureCube={
      //front
      {-1, -1, 1},
      {1, -1, 1},
      {1, 1, 1},
      {-1, 1, 1 },
    
      //top
      {-1, 1, 1},
      {1, 1, 1 },
      { 1, 1, -1 },
      {-1, 1, -1 },

      //left
      {-1, -1, 1 },
      {-1, 1, 1 },  
      { -1, 1, -1 },
      {-1, -1, -1},

      //right
      {1, 1, -1},
      {1, 1, 1},
      {1, -1, 1},
      {1, -1, -1},

      //bottom
      {-1, -1, 1},
      {-1, -1, -1},
      {1, -1, -1},
      {1, -1, 1},
      

      //backside
      {-1, 1, -1},
      {1, 1, -1},
      {1, -1, -1},
     {-1, -1, -1}, 
//

    };
     
     private float [][] cubosPequenos={
      //front
      {-1, -1, 1},
      {1, -1, 1},
      {1, 1, 1},
      {-1, 1, 1 },
    
      //top
      {-1, 1, 1},
      {1, 1, 1 },
      { 1, 1, -1 },
      {-1, 1, -1 },

      //left
      {-1, -1, 1 },
      {-1, 1, 1 },  
      { -1, 1, -1 },
      {-1, -1, -1},

      //right
      {1, 1, -1},
      {1, 1, 1},
      {1, -1, 1},
      {1, -1, -1},

      //bottom
      {-1, -1, 1},
      {-1, -1, -1},
      {1, -1, -1},
      {1, -1, 1},
      

      //backside
      {-1, 1, -1},
      {1, 1, -1},
      {1, -1, -1},
     {-1, -1, -1}, 
//

    };
    public static void main(String[] args) {
        Cubo_Em_Rotacao app=new Cubo_Em_Rotacao();
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
         
         registerKeyAction(KeyEvent.VK_1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figureCube[0][0]=0;
                figureCube[0][1]=0;
                figureCube[0][2]=0;
               
                figureCube[1][0]=0;
                figureCube[1][1]=0;
                figureCube[1][2]=0;
             
                figureCube[2][0]=0;
                figureCube[2][1]=0;
                figureCube[2][2]=0;
              
                figureCube[3][0]=0;
                figureCube[3][1]=0;
                figureCube[3][2]=0;
               
            }
        });
         
        registerKeyAction(KeyEvent.VK_2, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   
                figureCube[4][0]=0;
                figureCube[4][1]=0;
                figureCube[4][2]=0;
                
                figureCube[5][0]=0;
                figureCube[5][1]=0;
                figureCube[5][2]=0;
                
                figureCube[6][0]=0;
                figureCube[6][1]=0;
                figureCube[6][2]=0;
                
                figureCube[7][0]=0;
                figureCube[7][1]=0;
                figureCube[7][2]=0;
            }
        });
        
        registerKeyAction(KeyEvent.VK_3, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                figureCube[8][0]=0;
                figureCube[8][1]=0;
                figureCube[8][2]=0;
                
                figureCube[9][0]=0;
                figureCube[9][1]=0;
                figureCube[9][2]=0;
                
                figureCube[10][0]=0;
                figureCube[10][1]=0;
                figureCube[10][2]=0;
                
                figureCube[10][0]=0;
                figureCube[10][1]=0;
                figureCube[10][2]=0;
                
            }
        });
        
        registerKeyAction(KeyEvent.VK_4, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                figureCube[11][0]=0;
                figureCube[11][1]=0;
                figureCube[11][2]=0;
                
                figureCube[12][0]=0;
                figureCube[12][1]=0;
                figureCube[12][2]=0;
                
                figureCube[13][0]=0;
                figureCube[13][1]=0;
                figureCube[13][2]=0;
                
                figureCube[14][0]=0;
                figureCube[14][1]=0;
                figureCube[14][2]=0;
                
            }
        });
        
        registerKeyAction(KeyEvent.VK_5, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                figureCube[15][0]=0;
                figureCube[15][1]=0;
                figureCube[15][2]=0;
                
                figureCube[16][0]=0;
                figureCube[16][1]=0;
                figureCube[16][2]=0;
                
                figureCube[17][0]=0;
                figureCube[17][1]=0;
                figureCube[17][2]=0;
                
                figureCube[18][0]=0;
                figureCube[18][1]=0;
                figureCube[18][2]=0;
                
            }
        });
        
        registerKeyAction(KeyEvent.VK_6, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                figureCube[19][0]=0;
                figureCube[19][1]=0;
                figureCube[19][2]=0;
                
                figureCube[20][0]=0;
                figureCube[20][1]=0;
                figureCube[20][2]=0;
                
                figureCube[21][0]=0;
                figureCube[21][1]=0;
                figureCube[21][2]=0;
                
                figureCube[22][0]=0;
                figureCube[22][1]=0;
                figureCube[22][2]=0;
                
            }
        });
        
        registerKeyAction(KeyEvent.VK_R, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                figureCube[0][0]=-1;
                figureCube[0][1]=-1;
                figureCube[0][2]=1;
               
                figureCube[1][0]=1;
                figureCube[1][1]=-1;
                figureCube[1][2]=1;
             
                figureCube[2][0]=1;
                figureCube[2][1]=1;
                figureCube[2][2]=1;
              
                figureCube[3][0]=-1;
                figureCube[3][1]=1;
                figureCube[3][2]=1;
                
                //==============================================================

                figureCube[4][0]=-1;
                figureCube[4][1]=1;
                figureCube[4][2]=1;
                
                figureCube[5][0]=1;
                figureCube[5][1]=1;
                figureCube[5][2]=1;
                
                figureCube[6][0]=1;
                figureCube[6][1]=1;
                figureCube[6][2]=-1;
                
                figureCube[7][0]=-1;
                figureCube[7][1]=1;
                figureCube[7][2]=-1;

                //==============================================================

                figureCube[8][0]=-1;
                figureCube[8][1]=-1;
                figureCube[8][2]=1;
                
                figureCube[9][0]=-1;
                figureCube[9][1]=1;
                figureCube[9][2]=1;
                
                figureCube[10][0]=-1;
                figureCube[10][1]=1;
                figureCube[10][2]=-1;
                
                figureCube[11][0]=-1;
                figureCube[11][1]=-1;
                figureCube[11][2]=-1;
 
                //==============================================================
                figureCube[12][0]=1;
                figureCube[12][1]=1;
                figureCube[12][2]=-1;
                
                figureCube[13][0]=1;
                figureCube[13][1]=1;
                figureCube[13][2]=1;
                
                figureCube[14][0]=1;
                figureCube[14][1]=-1;
                figureCube[14][2]=1;
                
                figureCube[15][0]=1;
                figureCube[15][1]=-1;
                figureCube[15][2]=-1;
     
                //==============================================================

                figureCube[16][0]=-1;
                figureCube[16][1]=-1;
                figureCube[16][2]=1;
                
                figureCube[17][0]=-1;
                figureCube[17][1]=-1;
                figureCube[17][2]=-1;
                
                figureCube[18][0]=1;
                figureCube[18][1]=-1;
                figureCube[18][2]=-1;
                
                figureCube[19][0]=1;
                figureCube[19][1]=-1;
                figureCube[19][2]=1;

                //==============================================================

                figureCube[20][0]=-1;
                figureCube[20][1]=1;
                figureCube[20][2]=-1;
                
                figureCube[21][0]=1;
                figureCube[21][1]=1;
                figureCube[21][2]=-1;
                
                figureCube[22][0]=1;
                figureCube[22][1]=-1;
                figureCube[22][2]=-1;
                
                figureCube[23][0]=-1;
                figureCube[23][1]=-1;
                figureCube[23][2]=-1;
   
            }
        });
        
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       clearCanvas();
//       this.g.glTranslatef(0, 0, -6.6f);
//       this.g.glRotatef(xRotate, 1, 0, 0);
//       this.g.glRotatef(yRotate, 0, 1, 0);
//       this.g.glRotatef(zRotate, 0, 0, 1);
       
        //Cubo em Rotação
        this.g.glTranslatef( 0.0f, 0.0f, -10.0f ); 
        this.g.glRotatef(xRotate,60.0f,60.0f,10.0f); 

        drawFigureCubef(figureCube);
        
        
        xRotate-=1;
     //========================================================================
      g.glLoadIdentity();
      g.glTranslatef( 0.0f, 0.0f, -10.0f ); 
      g.glRotatef(-708.5608f ,30.0f, -30.0f,10.0f); 
      
      
      g.glLineWidth(3.5f);//Aumentando o tamanho das rectas

      //Desenhando Eixos
      //Eixo X
      g.glBegin (GL2.GL_LINES);
        g.glColor3f(1f,0f,0f);
        g.glVertex3f(0.0f,0.0f, 0.0f);
        g.glVertex3f(3.5f,0, 0.0f);  
      g.glEnd();
      
       //definindo o local onde X ira ficar
      g.glRasterPos3f(4.2f,0,0);
      this.glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "X"); 
    
   
      //Eixo Y 
      g.glBegin (GL2.GL_LINES);
      
        g.glVertex3f(0.0f,0.0f, 0.0f);
        g.glVertex3f(0,2.7f, 0.0f);
      g.glEnd();
      
      //definindo o local onde Y ira ficar
      g.glRasterPos3f(0,3.3f,0);
      this.glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Y");
      
      //Eixo Z 
      g.glBegin (GL2.GL_LINES);
        g.glVertex3f(0.0f, 0.0f,0.0f);
        g.glVertex3f(0.0f,0.0f, 6.1f);
      g.glEnd();
      
      //definindo o local onde Z ira ficar
      g.glRasterPos3f(0,0,6.7f);
      this.glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Z");
      
      //=======================Cubo Pequeno no Eixo X===========================
      g.glLoadIdentity();
      g.glTranslatef(3.93f, 0.15f,-10.0f ); 
      g.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      g.glRotatef(160,30.0f, -30.0f,10.0f); 
      //      -668.5608f , -708.5608f angulo de rotação
    
      drawFigureCubef(cubosPequenos);
      
      //=======================Cubo Pequeno no Eixo Y===========================
      g.glLoadIdentity();
      g.glTranslatef(-0.15f,3.0f,-10.0f ); 
      g.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      g.glRotatef(180,30.0f, -30.0f,-10.0f); 
      drawFigureCubef(cubosPequenos);
      //=======================Cubo Pequeno no Eixo Z===========================
      g.glLoadIdentity();
      g.glTranslatef(-2.2f, -2.25f,-10.0f ); 
      g.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      g.glRotatef(90,30.0f, -30.0f,10.0f);
      drawFigureCubef(cubosPequenos);
      
      
    }
}
