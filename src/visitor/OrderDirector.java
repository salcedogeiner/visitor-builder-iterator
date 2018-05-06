/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javax.swing.JPanel;

/**
 *
 * @author geiner
 */
public class OrderDirector {
    
    private IOrderGUIBuilder myBuilder;

    public OrderDirector(IOrderGUIBuilder myBuilder) {
        this.myBuilder = myBuilder;
    }
    
    public JPanel getOrderGUI(){
        return this.myBuilder.getOrderGUI();
    }
    
}
