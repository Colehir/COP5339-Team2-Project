package Inventory;
import AddProduct.*;
import EditProduct.*;
import ProductList.*;
import Users.Seller;
import Users.User; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * gets info from model, notifies view
 */
public class InventoryController {
    private InventoryView iv;
    private InventoryModel im;
    private boolean closed = false;
    private ProductList pl;
    private User cu;
    public InventoryController(InventoryView iv, InventoryModel im,User cu) throws FileNotFoundException
    {
        this.iv = iv;
        this.im = im;
        this.cu = cu;
        cu = new Seller(cu.user(),cu.pass(),cu.type());
        setView();
        addNewProductButton();
        tableControl();
     
      
    }
    /**
     * adds a mouse listener to the table in the view
     */
    public void tableControl()
    {
       iv.getTable().addMouseListener(new java.awt.event.MouseAdapter(){
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            //prevents error message if user clicks on empty table
            if(iv.getTable().getValueAt(iv.getTable().getSelectedRow(),0) == null)
            {
            }
            else
            {
            int productID = Integer.parseInt(iv.getTable().getValueAt(iv.getTable().getSelectedRow(),0).toString());
                try {
                    pl = im.getProductList();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //opens up edit product window
            Product p = pl.getProductFromID(productID);
            EditProductView epv = new EditProductView(p);
            EditProductModel epm = new EditProductModel(p,pl);
            EditProductController epc = new EditProductController(epv,epm,iv,pl);
            epc.removeProductControl();
            epc.editProductControl();
            }
        }
    });
    }
    /**
     * adds an action listener to the addproduct button
     */
    public void addNewProductButton()
    {
        iv.getAddProductBtn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("Adding Product");
               AddProductView apv = new AddProductView();
               AddProductModel apm = new AddProductModel();
                try {
                    pl = im.getProductList();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
               AddProductController apc = new AddProductController(apv,apm,iv,pl,cu);
            }
        });
    }
/**
 * adds a action listener to the logout button
 * @return 
 */
    public boolean logoutControl() {
         iv.getLogout().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iv.setVisible(false);
                iv.dispose();
                closed = true;
            }  
        });
        return closed;
    }
    /**
     * returns the product list in the view
     * @return 
     */
     public ProductList getProductList()
    {
        pl = iv.getProductList();
        return pl;
    }
     /**
      * sets the view
      * @throws FileNotFoundException 
      */
     public void setView() throws FileNotFoundException
     {
         iv.setTable(im.getTabledata());
         iv.setProductList(im.getProductList());
         iv.setRevenue(im.getRevenue());
         iv.setCosts(im.getCosts());
         iv.setProfits(im.getRevenue()-im.getCosts());
     }
}
