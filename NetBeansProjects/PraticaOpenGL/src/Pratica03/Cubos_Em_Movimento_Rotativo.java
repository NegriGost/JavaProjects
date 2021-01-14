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
import javax.swing.AbstractAction;

/**
 *
 * @author Rodrigues Mafumo
 */
public class Cubos_Em_Movimento_Rotativo extends AppRoot{
            
    private float tranX1=-9.5f;
    private float tranX2=9.5f;

    
     private float [][] cubo={
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
        Cubos_Em_Movimento_Rotativo app=new Cubos_Em_Movimento_Rotativo();
        app.start();
    }

    @Override
    public void registerAllKeysActions() {
         //     nenhum evento
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       clearCanvas();
       g.glTranslatef(tranX1, 0f, -15.0f ); 
       g.glRotatef(0,0.0f, 0.0f, 1.0f); 
       drawFigureCubef(cubo);
       
       g.glLoadIdentity();
       g.glTranslatef(tranX2, 0f, -15.0f ); 
       g.glRotatef(0,0.0f, 0.0f, -1.0f); 
       drawFigureCubef(cubo);

      // Rotate The Cubo On X, Y & Z

      //Colocando os cubos rm movimento rotativo vai e vem
      tranX2-=0.1f;
      tranX1+=0.1f;
   
       
      //Votando ao bater na parede
      if(tranX1>=9){ 
         tranX1=-9.5f;
         tranX2=9.5f;
      }


    }
}
