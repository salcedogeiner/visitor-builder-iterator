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
public class CaliforniaOrderGUI extends OrderGUI{

    public CaliforniaOrderGUI(String labelNameOrderAmount,
            int columnsFieldOrderAmount, String labelNameAdditionalTax,
            int columnsFieldAdditionalTax) {
        txtOrderAmount = new JTextField(columnsFieldOrderAmount);
	txtAdditionalTax = new JTextField(columnsFieldAdditionalTax);
	lblAdditionalTax =new JLabel(labelNameAdditionalTax);
	lblOrderAmount = new JLabel(labelNameOrderAmount);	
    }    
}
