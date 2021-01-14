
package relogio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author Rodrigues Mafumo e Dionisio Macamo
 */
public class PanelRelogio extends javax.swing.JPanel implements KeyListener{
       /*
     *   x, y: define ponto central
     * dx, dy: extensao de ponteiro
     *      c: cor atual
     */
    int x=650, y=350, dx=600, dy=600;
    int c;
    
     int h=100;
     int m=120;
     int s=140;

    public PanelRelogio() {
        initComponents();
       
    }

    public void desenha(int fx, int fy, int cor){
        dy = fy;
        c = cor;
    }

    protected void paintComponent(Graphics g) {
      
        super.paintComponent(g);
         Graphics2D gl = (Graphics2D) g.create();
         
//        URL img = getClass().getResource("clock.jpg");
        
        switch(c){
            case 1:gl.setColor(Color.RED);break;
            case 2:gl.setColor(Color.magenta);break;
            case 3:gl.setColor(Color.BLUE);break;
            default:gl.setColor(Color.orange);break;
        }
        
        gl.setStroke(new BasicStroke((float) 6.0));
        gl.drawOval(400,100,500,500);
        
//        g.drawImage(new ImageIcon(img).getImage(),400,100,500,500,null);
        double T[] = new double[2];
        
        gl.drawString("1", x+130, y-220);
        gl.drawString("2", x+225, y-120);
        gl.drawString("3", x+255, y+4);
        gl.drawString("4", x+225, y+130);
        gl.drawString("5", x+130, y+230);
        gl.drawString("6", x-4, y+265);
        gl.drawString("7", x-135, y+230);
        gl.drawString("8", x-230, y+130);
        gl.drawString("9", x-265, y+4);
        gl.drawString("10", x-235, y-130);
        gl.drawString("11", x-140, y-220);
        gl.drawString("12", x-10, y-255);
        
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

	int i;

	//ponto de referencia para inicio de calculos transformacao
	T[0]=0;
	T[1]=-h;

	//Equação de Transformação Linear:
	//T(x,y) = (cos(a)*x - sin(a)*y ; sin(a)*x + cos(a)*y)
	//a = angulo

        int escala = 120;
	for (i=0;i<dx;i++){	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]);	//para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]);	//para y
	}

	T[0] += x;	//soma ao centro
	T[1] += y;	//soma ao centro
        
        gl.setColor(Color.BLUE);
        gl.setStroke(new BasicStroke((float) 3.0));
        gl.drawLine(x, y, (int)(T[0]), (int)(T[1]));

        escala = 600;
        formata = new SimpleDateFormat(min);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-m;

	for (i=0;i<dx;i++) { //transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
            T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
            T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro 
        gl.setColor(Color.green);
        gl.setStroke(new BasicStroke((float) 6.0));
        gl.drawLine(x, y, (int)(T[0]), (int)(T[1]));

        formata = new SimpleDateFormat(seg);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-s;

	for (i=0;i<dx;i++) {	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro
        gl.setColor(Color.red);
        gl.setStroke(new BasicStroke((float) 9.0));
        gl.drawLine(x, y, (int)(T[0]), (int)(T[1]));

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_H: this.h+=10; break;
        }
    }//GEN-LAST:event_formKeyPressed

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:System.exit(0);break;
            case KeyEvent.VK_H:
               
                break;
            case KeyEvent.VK_M:m+=5;break;
            case KeyEvent.VK_S:s+=5;break;
            case KeyEvent.VK_1:h-=5;break;
            case KeyEvent.VK_2:m-=5;break;
            case KeyEvent.VK_3:s-=5;break;
        }
        
        JOptionPane.showMessageDialog(null, e);
                 
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
