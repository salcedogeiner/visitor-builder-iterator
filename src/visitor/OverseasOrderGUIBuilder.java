/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author geiner
 */
public class OverseasOrderGUIBuilder implements IOrderGUIBuilder{
    
    private JPanel panel;
    private OverseasOrderGUI orderGUI;

    public OverseasOrderGUIBuilder() {
        initialize();
    }    
    
    @Override
    public JPanel getOrderGUI() {
        return panel;
    }
    
    public  void initialize() {
        panel = new JPanel();
        orderGUI = new OverseasOrderGUI("Order Amount:",10,
                "Additional S & H(Overseas Orders Only):",10);
        GridBagLayout gridbag = new GridBagLayout();
		panel.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    
	    panel.add(orderGUI.getLblOrderAmount());
	    panel.add(orderGUI.getTxtOrderAmount());
	    panel.add(orderGUI.getLblAdditionalSH());
	    panel.add(orderGUI.getTxtAdditionalSH());
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gridbag.setConstraints(orderGUI.getLblOrderAmount(), gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 1;            
	    gridbag.setConstraints(orderGUI.getTxtOrderAmount(), gbc);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gridbag.setConstraints(orderGUI.getLblAdditionalSH(), gbc);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gridbag.setConstraints(orderGUI.getTxtAdditionalSH(), gbc);
    }
    
    public String getOrderAmount() {
        return orderGUI.getTxtOrderAmount().getText();
    }
    public String getSH() {
        return orderGUI.getTxtAdditionalSH().getText();
    }
    public String getTax() {
        return "";
    }
    
}
