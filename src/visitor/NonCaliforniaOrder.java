package visitor;

public class NonCaliforniaOrder implements Order {
  private double orderAmount;
  private double totalOrder;

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
    totalOrder = orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }  
  public double getTotalOrder() {
      return totalOrder;
  }
}
