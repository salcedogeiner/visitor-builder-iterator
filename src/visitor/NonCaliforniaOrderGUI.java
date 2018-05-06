/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author geiner
 */
public class NonCaliforniaOrderGUI extends OrderGUI{
    
    public NonCaliforniaOrderGUI(String labelNameOrderAmount,int columnsFieldtxtOrderAmount) {
        lblOrderAmount = new JLabel(labelNameOrderAmount);
        txtOrderAmount = new JTextField(columnsFieldtxtOrderAmount);
    }    

    
   
}
