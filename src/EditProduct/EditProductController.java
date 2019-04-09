package EditProduct;
import Inventory.InventoryView;
import ProductList.Product;
import ProductList.ProductList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EditProductController {
    private EditProductView epv;
    private EditProductModel epm;
    private InventoryView iv;
    private ProductList pl;
    public EditProductController(EditProductView epv, EditProductModel epm,InventoryView iv,ProductList pl)
    {
            this.epm = epm;
            this.epv = epv;
            this.iv = iv;
            this.pl = pl;
    }
    public void removeProductControl()
    {
        epv.btnRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    epm.p1.removeProduct(epm.p);
                } catch (IOException ex) {
                    Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Product has been removed");
                try {
                    iv.updateTable(pl);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            } 
        });
    }
    public void editProductControl()
    {
        epv.btnConfirmEdits.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p1 = epm.p;
                try {
                    epm.p1.removeProduct(epm.p);
                } catch (IOException ex) {
                    Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(epm.testvalidity(epv.getName(),epv.getCost(),epv.getStock()) == true)
                {
                     p1.setName(epv.getName());
                p1.setPrice(epv.getCost());
                p1.setquantity(epv.getStock());
                p1.setinvoice(epv.getInvoice());
                epm.p1.addProduct(p1);
                try {
                    epm.p1.updateProductFile();
                } catch (IOException ex) {
                    Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    iv.updateTable(pl);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(EditProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
               
            }
            
        });
    }
}

 