package EditProduct;

import ProductList.ProductList;
import ProductList.Product;

public class EditProductModel {
ProductList p1;
Product p;
    public EditProductModel(Product p,ProductList p1) {
        this.p1 = p1;
        this.p = p; 
        
    }
    boolean testvalidity(String name, double cost, int stock) {
        if(name == "" || cost < 0 || stock < 0)
        {
            return false;
        }
        return true;  
    }
}
 