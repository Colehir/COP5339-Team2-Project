package Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level; 
import java.util.logging.Logger;
public class OrderController {
    private OrderView ov;
    private OrderModel om;
    public OrderController(OrderModel om, OrderView ov)
    {
        this.ov = ov;
        this.om = om;
        setTotalCost();
        confirmControl();
    }
    /**
     * gets the total cost from the model, displays it in the view
     */
    public void setTotalCost()
    {
        ov.updateView(om.getTotalCost());
    }
    /**
     * removes all products from cart, update sales file
     */
    public void confirmControl()
    {
        ov.btnConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Order confirmed");
                try {
                    om.getCart().updateQuantities();
                    om.updateProductList();
                    om.updateSales();
                    ov.closeView();
                    om.scm.cl.removeAll();
                    om.scv.updateTable(om.scm.getTabledata(),om.scm.cl.getTotalPrice());   
                } catch (IOException ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    });
    }
    
}
