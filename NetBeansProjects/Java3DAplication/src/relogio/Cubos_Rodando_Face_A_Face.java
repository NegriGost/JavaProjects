package relogio;

import com.jogamp.opengl.GLAutoDrawable;

/**
 *
 * @author Rodrigues Mafumo e Dionisio Macamo
 */
public class Cubos_Rodando_Face_A_Face extends AppRoot{
            
     private float rquad = 0.0f,rtri=0.0f; 

    
     private float [][] cubo={
      //Em Frente
      {-1, -1, 1},
      {1, -1, 1},
      {1, 1, 1},
      {-1, 1, 1 },
    
      //Em Cima
      {-1, 1, 1},
      {1, 1, 1 },
      { 1, 1, -1 },
      {-1, 1, -1 },

      //Esquerda
      {-1, -1, 1 },
      {-1, 1, 1 },  
      { -1, 1, -1 },
      {-1, -1, -1},

      //Direita
      {1, 1, -1},
      {1, 1, 1},
      {1, -1, 1},
      {1, -1, -1},

      //Em Baixo
      {-1, -1, 1},
      {-1, -1, -1},
      {1, -1, -1},
      {1, -1, 1},
      

      //Atrás
      {-1, 1, -1},
      {1, 1, -1},
      {1, -1, -1},
      {-1, -1, -1}, 
//

    };

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
