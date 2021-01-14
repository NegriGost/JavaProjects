package Pratica05;

/**
 *
 * @author Rodrigues Mafumo e Dionisio Macamo
 */
import java.awt.DisplayMode;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;


import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Color;

public class Cubo_Colorido_Em_Rotacao implements GLEventListener {

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
    private GLUT glut;
   private float rquad = 0.0f,rtri=0.0f;

   public void display( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      glut = new GLUT();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
      
//======================================================================================
//      desenhando Cubo em eixos 
      gl.glLoadIdentity();
      gl.glTranslatef( 0.0f, 0.0f, -10.0f ); 

      // Rotação em X, Y & Z
      gl.glRotatef(rquad,60.0f,60.0f,10.0f); 
      //      -668.5608f , -708.5608f angulo de rotação

      gl.glBegin(GL2.GL_QUADS); // Começa a rotaçao
      gl.glColor3f(1f,0f,0f); //cor vermelha
      gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
      
      
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad

      gl.glEnd(); // Done Drawing The Quad
		
//      rquad -= 1.0f;// incremento da rotação
//     
//======================================================================================
//      desenhando eixos 
        
      gl.glLoadIdentity();
      gl.glTranslatef( 0.0f, 0.0f, -10.0f ); 
      gl.glRotatef(-708.5608f ,30.0f, -30.0f,10.0f); 
      
      
      gl.glLineWidth(3);//Aumentando o tamanho das rectas

      //Desenhando Eixos
      //Eixo X
      gl.glBegin (GL2.GL_LINES);
        gl.glVertex3f(0.0f,0.0f, 0.0f);
        gl.glVertex3f(3.5f,0, 0.0f);  
      gl.glEnd();
      
       //definindo o local onde X ira ficar
      gl.glRasterPos3f(4.2f,0,0);
      glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "X"); 
    
   
      //Eixo Y 
      gl.glBegin (GL2.GL_LINES);
        gl.glVertex3f(0.0f,0.0f, 0.0f);
        gl.glVertex3f(0,2.7f, 0.0f);
      gl.glEnd();
      
      //definindo o local onde Y ira ficar
      gl.glRasterPos3f(0,3.3f,0);
      glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Y");
      
      //Eixo Z 
      gl.glBegin (GL2.GL_LINES);
        gl.glVertex3f(0.0f, 0.0f,0.0f);
        gl.glVertex3f(0.0f,0.0f, 6.3f);
      gl.glEnd();
      
      //definindo o local onde Z ira ficar
      gl.glRasterPos3f(0,0,6.7f);
      glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Z");
      
      gl.glFlush();
      
      //========================================================================================================
      
      //desenhar cubos pequenos no estremo de cada eixo
      
      //eixo X==================================================================
      
      gl.glLoadIdentity();
      gl.glTranslatef(3.93f, 0.15f,-10.0f ); 
      gl.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      gl.glRotatef(160,30.0f, -30.0f,10.0f); 
      //      -668.5608f , -708.5608f angulo de rotação
      gl.glBegin(GL2.GL_QUADS); // Começa a rotaçao
      gl.glColor3f(1f,0f,0f); //cor vermelha
      gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
      
      
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad

      gl.glEnd(); // Done Drawing The Quad
      
      //eixo Y==================================================================
      
      gl.glLoadIdentity();
      gl.glTranslatef(-0.15f,3.0f,-10.0f ); 
      gl.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      gl.glRotatef(180,30.0f, -30.0f,-10.0f); 
      //      -668.5608f , -708.5608f angulo de rotação
      gl.glBegin(GL2.GL_QUADS); // Começa a rotaçao
      gl.glColor3f(1f,0f,0f); //cor vermelha
      gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
      
      
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad

      gl.glEnd();
      
      //eixo Z==================================================================
      
      gl.glLoadIdentity();
      gl.glTranslatef(-2.23f, -2.25f,-10.0f ); 
      gl.glScalef(0.2f,0.2f,0.4f ); 

      // Rotação em X, Y & Z
      gl.glRotatef(90,30.0f, -30.0f,10.0f); 
      //      -668.5608f , -708.5608f angulo de rotação
      gl.glBegin(GL2.GL_QUADS); // Começa a rotaçao
      gl.glColor3f(1f,0f,0f); //cor vermelha
      gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
      
      
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad

      gl.glEnd(); // Done Drawing The Quad
      
      rquad +=1.5f;
     
   }
   

   public void dispose( GLAutoDrawable drawable ) {
      // TODO Auto-generated method stub
   }
   

   public void init( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
   }
      

   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
      // TODO Auto-generated method stub
      final GL2 gl = drawable.getGL().getGL2();
      if(  height== 0 )
         height = 1;
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
      
   public static void main( String[] args ) {
      //Criação do painel e do Frame 
      //1.passo: Criar GLProfile e GLCapabilities
      GLProfile glp=GLProfile.get(GLProfile.GL2);
      GLCapabilities glcb=new GLCapabilities(glp);
      
      //2.passo: Adicionar o GLCapabilites ao GLCanvas
      GLJPanel glc=new GLJPanel(glcb);
//      glc.setBackground(new Color(1,1,1,123));
      glc.setSize(400,400);
      
      
      //3.passo: adicionar esta classe ao GLEventListener do canvas
      Cubo_Colorido_Em_Rotacao cube=new Cubo_Colorido_Em_Rotacao();
      glc.addGLEventListener(cube);
      
      //4.Desenhar uma frame
      JFrame f=new JFrame("Cubo Colorido Em Rotação Com Cores Diferentes");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setExtendedState(JFrame.MAXIMIZED_BOTH);
      f.setBackground(Color.red);
      f.getContentPane().add(glc);
      f.setSize(500,500);
      f.setVisible(true);
     
       final FPSAnimator animator = new FPSAnimator(glc,200,true);
      animator.start();
   }
	
}