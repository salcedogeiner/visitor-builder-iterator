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
public interface IOrderGUIBuilder {
    
    public JPanel getOrderGUI();
    public String getOrderAmount();
    public String getTax();
    public String getSH();
    
}
