package visitor;

public class OverseasOrder implements Order {
  private double orderAmount;
  private double additionalSH;
  private double totalOrder;

  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
    totalOrder = orderAmount + additionalSH;            
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public double getTotalOrder() {
      return totalOrder;
  }
}
