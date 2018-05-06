/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author geiner
 */
public class OverseasOrderGUI extends OrderGUI{

    public OverseasOrderGUI(String labelNameOrderAmount,
            int columnsFieldOrderAmount, String labelNameAdditionalSH,
            int columnsFieldAdditionalSH) {
                
        lblOrderAmount = new JLabel(labelNameOrderAmount);
        txtOrderAmount = new JTextField(columnsFieldOrderAmount);
	txtAdditionalSH = new JTextField(columnsFieldAdditionalSH);
	lblAdditionalSH =new JLabel(labelNameAdditionalSH);
	
    }
    
}
