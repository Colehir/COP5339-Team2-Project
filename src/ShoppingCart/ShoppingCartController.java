package ShoppingCart;
import ProductList.ProductList;
import ProductList.Product;
import Order.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
/**
 *gets cart info from model, notifies view of changes
 * 
 */
public class ShoppingCartController {
private ShoppingCartView scv;
private ShoppingCartModel scm;
private ProductList pl;
    public ShoppingCartController(ShoppingCartView scv, ShoppingCartModel scm,ProductList pl) {
        this.scm = scm;
        this.scv = scv;
        this.pl = pl;
        setView();
        removeControl();
        orderControl();
    }
    /**
     * adds an mouse listener to the table to remove products
     */
    public void removeControl()
    {
        scv.getTable().addMouseListener(new java.awt.event.MouseAdapter(){
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int productID = Integer.parseInt(scv.getTable().getValueAt(scv.getTable().getSelectedRow(),0).toString());
            System.out.println(productID);
            Product p = pl.getProductFromID(productID);
            scm.getCartList().removeFromCart(p);
            scv.updateTable(scm.getTabledata(),scm.cl.getTotalPrice());   
           
        }
        }
        );
    }
    /**
     * adds a action listener to the order button
     */
    public void orderControl()
    {
        scv.getOrderButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(scm.getCartList().isEmpty() == true)
                {
                    System.out.println("Your shopping cart is empty");
                    scv.errormessage("Cart is empty");
                }
                else
                {
                 OrderModel om = new OrderModel(scm.getCartList(),scm,scv);
                 OrderView ov = new OrderView();
                 OrderController oc = new OrderController(om,ov);
                }
                 
            }
            
        });
    }
    /**
     * sets the view using info from the model
     */
    public void setView()
    {
        scv.setView(scm.getTabledata(),scm.cl.getTotalPrice());
    }
}
            
             