/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria;

import javax.swing.JFrame;
import vista.frmPrincipal;

/**
 *
 * @author alumno
 */
public class Heladeria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        frmPrincipal formulario = new frmPrincipal();
        formulario.setExtendedState(JFrame.MAXIMIZED_BOTH);
        formulario.setVisible(true);
    }
    
}
