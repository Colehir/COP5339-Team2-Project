package ProductList;
import org.junit.Test; 
import static org.junit.Assert.*;
public class ProductListTest {
    Product pnew = new Product(1,"product",1,1,"Seller",1);
    public ProductListTest() {
    }

    /**
     * Test of getProductFromID method, of class ProductList.
     */
    @Test
    public void testGetProductFromID() {
        System.out.println("getProductFromID");
        int ID = pnew.getID();
        ProductList instance = new ProductList();
        instance.addProduct(pnew);
        Product expResult = pnew;
        Product result = instance.getProductFromID(ID);
        assertEquals(expResult, result);
    }
    /**
     * Test of checkforID method, of class ProductList.
     */
    @Test
    public void testCheckforID() {
        System.out.println("checkforID");
        int id = 0;
        ProductList instance = new ProductList();
        instance.addProduct(pnew);
        boolean expResult = true;
        boolean result = instance.checkforID(pnew.getID());
        assertEquals(expResult, result);
    }  
}
