package ProductList;
import ProductDetail.ProductDetailModel;
import ProductDetail.ProductDetailController;
import ProductDetail.ProductDetailView; 
import ShoppingCart.CartList;
import ShoppingCart.ShoppingCartController;
import ShoppingCart.ShoppingCartModel;
import ShoppingCart.ShoppingCartView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
/**
 * gets information from the model, notifies the view of changes
 * 
 */
public class ProductListController {
    private ProductListView v;
    private ProductListModel m;
    private ProductList pl = null;
    private CartList cl;
    private boolean closed = false;
    public ProductListController(ProductListView v, ProductListModel m, CartList cl) throws FileNotFoundException
    {
        this.v = v;
        this.m = m;
        this.cl = cl;
        populateTable();
        tableControl();
        cartControl();
    }
    /**
     * Uses the productlist in model to populate the table in the view
     * @precondition: productlist in model is initialized
     * @postcondition: table in view is populated
     * @throws FileNotFoundException 
     */
    public void populateTable() throws FileNotFoundException
    {
       v.setTable(m.getTableData(),m.getProductList());
    }
    /**
     * adds a mouse listener to the table in the view
     * @precondition: table exists in view
     * @postcondition:table is populated
     */
    public void tableControl()
    {
        v.getTable().addMouseListener(new java.awt.event.MouseAdapter(){
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            //gets product ID from the row that was clicked
            int productID = Integer.parseInt(v.getTable().getValueAt(v.getTable().getSelectedRow(),0).toString());
            //if the product is out of stock, nothing happens
            if(Integer.parseInt(v.getTable().getValueAt(v.getTable().getSelectedRow(),3).toString()) != 0)
            {
                pl = m.getProductList();
                cl.addList(pl);
                //displays the ProductDetails window
                ProductDetailModel pdm = new ProductDetailModel(pl.getProductFromID(productID));
                ProductDetailView pv = new ProductDetailView();
                ProductDetailController pdc = new ProductDetailController(pdm,pv,cl);
            }
           
            
        }
    });
    }
    /**
     * adds an action listener to the cart button
     * 
     */
    public void cartControl()
    {
        v.getCart().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //displays Shoppingcart
                ShoppingCartView scv = new ShoppingCartView();
                ShoppingCartModel scm = new ShoppingCartModel(v,cl);
                ShoppingCartController scc = new ShoppingCartController(scv,scm,pl);
               System.out.println("Cart open");
            }
            
        });
    }
    /**
     * adds an action listener to the logout button
     * @return 
     */
    public boolean logoutControl() {
        v.getLogout().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                v.setVisible(false);
                v.dispose();
                closed = true;
            }  
        });
        return closed;
}
    /**
     * updates the table in the view
     */
    public void updateTable() {
        v.updateTable();
    }
}
