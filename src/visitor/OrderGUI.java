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
public abstract class OrderGUI {
  protected JTextField txtOrderAmount, txtAdditionalTax,
  txtAdditionalSH;
  protected JLabel lblOrderAmount, lblAdditionalTax, lblAdditionalSH;

    public JTextField getTxtOrderAmount() {
        return txtOrderAmount;
    }

    public void setTxtOrderAmount(JTextField txtOrderAmount) {
        this.txtOrderAmount = txtOrderAmount;
    }

    public JTextField getTxtAdditionalTax() {
        return txtAdditionalTax;
    }

    public void setTxtAdditionalTax(JTextField txtAdditionalTax) {
        this.txtAdditionalTax = txtAdditionalTax;
    }

    public JTextField getTxtAdditionalSH() {
        return txtAdditionalSH;
    }

    public void setTxtAdditionalSH(JTextField txtAdditionalSH) {
        this.txtAdditionalSH = txtAdditionalSH;
    }

    public JLabel getLblOrderAmount() {
        return lblOrderAmount;
    }

    public void setLblOrderAmount(JLabel lblOrderAmount) {
        this.lblOrderAmount = lblOrderAmount;
    }

    public JLabel getLblAdditionalTax() {
        return lblAdditionalTax;
    }

    public void setLblAdditionalTax(JLabel lblAdditionalTax) {
        this.lblAdditionalTax = lblAdditionalTax;
    }

    public JLabel getLblAdditionalSH() {
        return lblAdditionalSH;
    }

    public void setLblAdditionalSH(JLabel lblAdditionalSH) {
        this.lblAdditionalSH = lblAdditionalSH;
    }
    
  
}
