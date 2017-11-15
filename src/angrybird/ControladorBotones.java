/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenovo
 */
public class ControladorBotones implements ActionListener{

    private Vista frame;
    
    public ControladorBotones(Vista vista) {
        this.frame= vista;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       String key = ae.getActionCommand();
       if(key.equals(this.frame.getBoton1().getActionCommand())){
           System.exit(0);
       }
       if(key.equals(this.frame.getBoton2().getActionCommand())){
           this.frame.setNumero_pajaro(0);
            this.frame.setVisible(false);
             Vista vista= new Vista();
             vista.setVisible(true);
             this.frame=vista;
       }
    }
    
}
