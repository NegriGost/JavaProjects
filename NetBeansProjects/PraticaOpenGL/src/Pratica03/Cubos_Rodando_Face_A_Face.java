/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pratica03;

import com.jogamp.opengl.GLAutoDrawable;

/**
 *
 * @author Rodrigues Mafumo
 */
public class Cubos_Rodando_Face_A_Face extends AppRoot{
            
     private float rquad = 0.0f,rtri=0.0f; 

    
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
        Cubos_Rodando_Face_A_Face app=new Cubos_Rodando_Face_A_Face();
        app.start();
    }

    @Override
    public void registerAllKeysActions() {
         //     nenhum evento
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       clearCanvas();
       
       g.glTranslatef(-2.5f, 0f, -10.0f ); 
       g.glRotatef(rtri,0.0f, 0.0f, 1.0f); 
       drawFigureCubef(cubo);
       
       g.glLoadIdentity();
       
       g.glTranslatef( 2.5f, 0f, -10.0f ); 
       g.glRotatef(rquad,0.0f, 0.0f, -1.0f); 
       drawFigureCubef(cubo);

      //Colocando os cubos a rodarem face a face
      rtri -= 1.5f;	
      rquad -=1.5f;
    }
}
