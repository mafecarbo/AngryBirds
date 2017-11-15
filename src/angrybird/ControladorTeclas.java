/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class ControladorTeclas implements KeyListener {
    private Vista frame;

    public ControladorTeclas(Vista vista) {
        this.frame = vista;
    }

    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       int key=ke.getKeyCode();
       if(key==KeyEvent.VK_UP){
           if(this.frame.getLogica().getAngulo()<=85){
           this.frame.getLogica().setAngulo(this.frame.getLogica().getAngulo()+5);
          

           this.frame.texto();
           }
       }
       if(key==KeyEvent.VK_DOWN){
           if(this.frame.getLogica().getAngulo()>=5){
           this.frame.getLogica().setAngulo(this.frame.getLogica().getAngulo()-5);
           this.frame.texto();
              
           }
       }
       if(key==KeyEvent.VK_RIGHT){
            
           if(this.frame.getVelocidad()>=10){
           this.frame.setVelocidad(this.frame.getVelocidad()-10);
           this.frame.texto();
            
           }
       }
       if(key==KeyEvent.VK_LEFT){
         
           if(this.frame.getVelocidad()<=400){
           this.frame.setVelocidad(this.frame.getVelocidad()+10);
           this.frame.texto();
          
           }
       }
       if(key==KeyEvent.VK_SPACE){
           System.out.println("espacio");
             this.frame.getTimer().start();
           
       }
       }
    }
    
    

