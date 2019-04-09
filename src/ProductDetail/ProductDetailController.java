package ProductDetail;
import ShoppingCart.CartList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent; 
/**
 * 
 * Gets info from model, notifies view
 */
public class ProductDetailController {
    private ProductDetailModel pdm;
    private ProductDetailView pv;
    private CartList cl;
    private int quantity = 1;

    public ProductDetailController(ProductDetailModel pdm, ProductDetailView pv, CartList cl) {
        this.pdm = pdm;
        this.pv = pv;
        this.cl = cl;
        populateView();
        SliderControl();
        CartButton();
        //prevents user from adding products to cart if it is out of stock
        if(cl.getProductQuantity(pv.p) == pdm.getQuantity())
        {
            pv.btnAddToCart.setEnabled(false);
        }
        
    }
    /**
     * Adds a action listener to the add to cart button
     */
    public void CartButton()
    {
        pv.btnAddToCart.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.print("Adding "+pdm.getName());
               for(int i = 0;i<quantity;i++)
               {
                    cl.addToCart(pdm.p);
               }
               //updates amount of product user has added
                pv.updateQuantity(pdm.getQuantity());
                if (quantity == pdm.getQuantity())
                {
                    pv.btnAddToCart.setEnabled(false);
                }
              
           }
        });
    }
    /**
     * adds change listener to slider
     */
    public void SliderControl()
    {
        pv.slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent event)
            {
                quantity = pv.slider.getValue();
                pv.updateSliderLabel();
            }
        });
    }
    /**
     * populates the view with info from the model
     */
    public void populateView()
    {
        pv.setView(pdm.getName(), pdm.getID(), pdm.getPrice(), pdm.getQuantity(), pdm.getSeller(),pdm.getQuantity());
    }
}
