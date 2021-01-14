/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pratica03;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;

/**
 *
 * @author Rodrigues Mafumo
 */
public class Relogio extends AppRoot{
    
    int x=650, y=350, dx=600, dy=600;
   
    int h=100;
    int m=120;
    int s=140;
    
    private float lop=50f;

    
    public static void main(String[] args) {
        Relogio app=new Relogio();
        app.start();
    }
    private float horas=17;
  

    @Override
    public void registerAllKeysActions() {
       // Sem Eventos Por enquanto       
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       clearCanvas();
       this.g.glTranslatef(0, 0, -6.6f);
       this.g.glScalef(2.0f, 2.0f, 2.0f);
       this.g.glLineWidth(4);
       
        //Desenhando a Circunferencia
        this.g.glBegin(GL2.GL_LINES);

            this.g.glVertex2f((float) 1.0,(float) 0.0);
            for (int i = 0; i < lop; i++) {
                
                 float t=(float) (i*Math.PI*2/lop);
                 this.g.glVertex2f((float) Math.cos(t),(float) Math.sin(t));
            }
          
       this.g.glEnd();
       //=======================================================================
      
       
       double T[] = new double[2];
       
        String data = "dd/MM/yyyy";  
        String hora = "hh";  
        String min = "mm";  
        String seg = "ss"; 
        String data1, hora1;
        
        java.util.Date agora = new java.util.Date();  
        SimpleDateFormat formata = new SimpleDateFormat(data);  
        data1 = formata.format(agora);  
        formata = new SimpleDateFormat(hora);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;
        
        
        
        T[0]=0;
	T[1]=-h;
        
        int escala = 120;
	for (int i=0;i<dx;i++){	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]);	//para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]);	//para y
	}

	T[0] += x;	//soma ao centro
	T[1] += y;
        
       g.glLoadIdentity();
       g.glTranslatef(0, 0, -6.6f);
       g.glBegin(GL2.GL_LINES);
//            g.glColor3b(1,0,0);
            g.glVertex2d(0.0f,0.0f);
            g.glVertex2d((float)(T[0]), (float)(T[1]));
       g.glEnd();

       
       escala = 600;
        formata = new SimpleDateFormat(min);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-m;

	for (int i=0;i<dx;i++) { //transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
            T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
            T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro 
       
       g.glLoadIdentity();
       g.glTranslatef(0, 0, -6.6f);
       g.glBegin(GL2.GL_LINES);
            g.glVertex2d(0.0f,0.0f);
            g.glVertex2d((float)(T[0]), (float)(T[1]));
       g.glEnd();
    
       
        formata = new SimpleDateFormat(seg);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-s;

	for (int i=0;i<dx;i++) {	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro
        
        g.glLoadIdentity();
        g.glTranslatef(0, 0, -6.6f);
        g.glBegin(GL2.GL_LINES);
            g.glVertex2d(0.0f,0.0f);
            g.glVertex2d((float)(T[0]), (float)(T[1]));
        g.glEnd();
        
        
       
    }
}
