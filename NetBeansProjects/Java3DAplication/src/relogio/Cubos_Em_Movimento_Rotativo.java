package relogio;

import com.jogamp.opengl.GLAutoDrawable;

/**
 *
 * @author Rodrigues Mafumo e Dionisio Macamo
 */
public class Cubos_Em_Movimento_Rotativo extends AppRoot{
            
    private float tranX1=-9.5f;
    private float tranX2=9.5f;

    
     private float [][] cubo={
      //Frente
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
      

      //backside
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
       g.glTranslatef(tranX1, 0f, -15.0f ); 
       g.glRotatef(0,0.0f, 0.0f, 1.0f);
       drawFigureCubef(cubo);
       
       g.glLoadIdentity();
       g.glTranslatef(tranX2, 0f, -15.0f ); 
       g.glRotatef(0f,0.0f, 0.0f, -15.0f); 
       drawFigureCubef(cubo);

      // Rotate The Cubo On X, Y & Z

      //Colocando os cubos rm movimento rotativo vai e vem
      tranX2-=0.10f;
      tranX1+=0.10f;
       
      //Votando ao bater na parede
      if(tranX1>=9){ 
         tranX1=-9.5f;
         tranX2=9.5f;
      }


    }
}
