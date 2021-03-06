package visitor;
import java.util.*;

class OrderVisitor implements VisitorInterface {
  private Vector orderObjList;
  private double orderTotal;  

  public OrderVisitor() {
    orderObjList = new Vector();
  }
  public void visit(NonCaliforniaOrder inp_order) {
    //this.orderObjList.add(inp_order);
    orderTotal += inp_order.getOrderAmount();
  }
  public void visit(CaliforniaOrder inp_order) {
    //this.orderObjList.add(inp_order);
    orderTotal += inp_order.getOrderAmount() + inp_order.getAdditionalTax();
  }
  public void visit(OverseasOrder inp_order) {
    //this.orderObjList.add(inp_order);
    orderTotal += inp_order.getOrderAmount() + inp_order.getAdditionalSH();
  }
  
  public void addOrder(Order inp_order){
    this.orderObjList.add(inp_order);
  }
  
  
  public double getOrderTotal(){
      orderTotal=0; 
      Iterator iterator = new OrderIterator(orderObjList); 
      while (iterator.hasNext()) {
          Order order = (Order)iterator.next();
          order.accept(this);
      }
      return this.orderTotal;
  }  
}
