package visitor;


import visitor.CaliforniaOrder;

public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
}
