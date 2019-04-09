package AddProduct; 
import Inventory.InventoryView;
import ProductList.Product;
import ProductList.ProductList;
import Users.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AddProductController {
    private ProductList pl;
    private Product p;
    /**
     * adds actionlistener to addproductbutton
     * @param apv
     * @param apm
     * @param iv
     * @param pl
     * @param cu 
     */
    public AddProductController(AddProductView apv, AddProductModel apm,InventoryView iv,ProductList pl,User cu) {
        this.pl = pl;
        apv.btnFinish.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //validates product information
                if(apm.checkTypes(apv.textname.getText(),apv.textprice.getText(),apv.textstock.getText()).equals("yes"))
                {
                   String s1 = apm.validateInfo(apv.getName(),apv.getPrice(),apv.getQuantity());
                   int success = 0;
                   int i = 0;
                   while (success == 0)
                   {
                       if(pl.checkforID(i) == true)
                       {
                           i++;
                       }
                       else
                       {
                           System.out.println("New id is:"+i);
                           success = 1;
                       }
                   }
                   //adds product to list, updates file
                   p = new Product(i,apv.getName(),apv.getPrice(),apv.getQuantity(),cu.user(),apv.getInvoice());
                   pl.addProduct(p);
                    try {
                        pl.updateProductFile();
                    } catch (IOException ex) {
                        Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pl.updateProductFile();
                    } catch (IOException ex) {
                        Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("repainted");
                    try {
                        iv.updateTable(pl);
   
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }      
                }
                else
                {
                    System.out.println("type error");
                } 
            }
        });  
    }
}
