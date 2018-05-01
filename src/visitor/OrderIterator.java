/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author geiner
 */
public class OrderIterator  implements Iterator{  

  Order nextOrder;
  Enumeration ec;

    public OrderIterator(Vector v) {
        ec = v.elements();        
    }       
    
    public boolean hasNext() {
       boolean matchFound = false;

       nextOrder = null;

       while (ec.hasMoreElements()) {
         Order tempObj = (Order) ec.nextElement();
         nextOrder = tempObj;
         break;
       }
       return (nextOrder != null);
    }

    public Object next() {
      if (nextOrder == null) {
        throw new NoSuchElementException();
      } else {
        return nextOrder;
      }
    }

  public void remove() {};
}
