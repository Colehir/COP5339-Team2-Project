package ProductDetail;
import ProductList.Product;
/**
 * Contains info from the Product 
 * 
 */
public class ProductDetailModel {
    Product p;
    public ProductDetailModel(Product p) {
        this.p = p;
    }
    /**
     * getter for name
     * @return 
     */
    public String getName()
    {
        return p.getName();
    }
    /**
     * getter for ID
     * @return 
     */
    public int getID()
    {
        return p.getID();
    }
    /**
     * getter for price
     * @return 
     */
    public double getPrice()
    {
        return p.getPrice();
    }
    /**
     * getter for quantity
     * @return 
     */
    public int getQuantity()
    {
        return p.getquantity();
    }
    /** getter for seller
     * 
     * @return 
     */
    public String getSeller()
    {
        return p.getSeller();
    }
}
