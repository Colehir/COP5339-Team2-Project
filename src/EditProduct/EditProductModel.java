/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditProduct;

import ProductList.ProductList;
import ProductList.Product;

/**
 *
 * @author jmayoral2017
 */
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
 