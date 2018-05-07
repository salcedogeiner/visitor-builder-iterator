/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

/**
 *
 * @author Angela
 */
public class OrderGUIFactory {

    public IOrderGUIBuilder getOrdernGUIBuilder(String orderType) {
        IOrderGUIBuilder builder = null;
        switch (orderType) {
            case OrderManager.CA_ORDER:
                builder = new CaliforniaOrderGUIBuilder();
                break;
            case OrderManager.NON_CA_ORDER:
                builder = new NonCaliforniaOrderGUIBuilder();
                break;
            case OrderManager.OVERSEAS_ORDER:
                builder = new OverseasOrderGUIBuilder();
                break;
            default:
                break;
        }
        return builder;
    }

}
