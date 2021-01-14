/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigues
 */
public class ArquivoMenu {
    
    String path="imagemMenuFundo.txt";
    public void armazenarBotoes(ArrayList<String> imagem){
        try(FileOutputStream fos=new FileOutputStream(path)){
                try(ObjectOutputStream gravar=new ObjectOutputStream(fos)){
                    gravar.writeObject(imagem); 
                }catch(FileNotFoundException e){
                     JOptionPane.showMessageDialog(null,"");
                }
        }catch(IOException e){
            //JOptionPane.showMessageDialog(null,"");
        }
    }//gravar um alista num arquivo
    
    public ArrayList<String>recuperarCaminho(){
      ArrayList<String>imagem=new ArrayList<>();
        try(FileInputStream fos=new FileInputStream(path)){
                try(ObjectInputStream recuperar=new ObjectInputStream(fos)){
                   imagem= (ArrayList<String>)recuperar.readObject();
                }catch(ClassNotFoundException e){
                    JOptionPane.showMessageDialog(null,"");
                }
        }catch(IOException e){
            //JOptionPane.showMessageDialog(null,"");
        }
        return imagem;
    }//l
}
