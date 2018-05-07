package visitor;

import visitor.CaliforniaOrder;
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {

    public static final String newline = "\n";
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EXIT = "Exit";
    public static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER = "Non-California Order";
    public static final String OVERSEAS_ORDER = "Overseas Order";
    public static final String ORDER_TYPE = "Order Type";

    private JComboBox cmbOrderType;
    private JLabel lblOrderType;
    private JLabel lblTotal, lblTotalValue;

    private OrderVisitor objVisitor;
    private JPanel ordersPanel;

    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        cmbOrderType = new JComboBox();
        cmbOrderType.setActionCommand(OrderManager.ORDER_TYPE);
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);

        lblOrderType = new JLabel("Order Type:");

        lblTotal = new JLabel("Result:");
        lblTotalValue
                = new JLabel("Click Create or GetTotal Button");

        //Create the open button
        JButton getTotalButton
                = new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);
        JButton createOrderButton
                = new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);
        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        ButtonHandler objButtonHandler = new ButtonHandler(this);

        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        cmbOrderType.addActionListener(objButtonHandler);
        exitButton.addActionListener(new ButtonHandler());

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        ordersPanel = new JPanel();

        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(exitButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblTotal, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 20;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(ordersPanel, BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.SOUTH);
        cmbOrderType.setSelectedIndex(0);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void refreshPanel(JPanel panel) {
        ordersPanel.removeAll();
        ordersPanel.add(panel);
        ordersPanel.updateUI();
    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

} // End of class OrderManager

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    IOrderGUIBuilder builder;

    public void actionPerformed(ActionEvent e) {
        String totalResult = null;
        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.exit(1);
        }

        if (e.getActionCommand().equals(OrderManager.ORDER_TYPE)) {
            String selection = objOrderManager.getOrderType();
            objOrderManager.setTotalValue("Click Create or GetTotal Button");
            
            OrderGUIFactory  builderFactory = new OrderGUIFactory();
            builder = builderFactory.getOrdernGUIBuilder(selection);
          
            OrderDirector orderDirectorGUI = new OrderDirector(builder);
            objOrderManager.refreshPanel(orderDirectorGUI.getOrderGUI());
        }
        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
            //get input values
            String orderType = objOrderManager.getOrderType();
            String strOrderAmount
                    = builder.getOrderAmount();
            String strTax = builder.getTax();
            String strSH = builder.getSH();

            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;

            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }
            if (strTax.trim().length() == 0) {
                strTax = "0.0";
            }
            if (strSH.trim().length() == 0) {
                strSH = "0.0";
            }

            dblOrderAmount
                    = new Double(strOrderAmount).doubleValue();
            dblTax = new Double(strTax).doubleValue();
            dblSH = new Double(strSH).doubleValue();

            //Create the order
            Order order = createOrder(orderType, dblOrderAmount,
                    dblTax, dblSH);

            //Get the Visitor
            OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();

            // accept the visitor instance
            visitor.addOrder(order);

            objOrderManager.setTotalValue(
                    " Order Created Successfully");
        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            OrderVisitor visitor
                    = objOrderManager.getOrderVisitor();
            totalResult = new Double(
                    visitor.getOrderTotal()).toString();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
        }
    }

    public Order createOrder(String orderType,
            double orderAmount, double tax, double SH) {
        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
            return new CaliforniaOrder(orderAmount, tax);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.NON_CA_ORDER)) {
            return new NonCaliforniaOrder(orderAmount);
        }
        if (orderType.equalsIgnoreCase(
                OrderManager.OVERSEAS_ORDER)) {
            return new OverseasOrder(orderAmount, SH);
        }
        return null;
    }

    public ButtonHandler() {

    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }

} // End of class ButtonHandler

