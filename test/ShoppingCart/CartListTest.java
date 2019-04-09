package ShoppingCart;
import ProductList.Product;
import org.junit.Test;
import static org.junit.Assert.*; 
public class CartListTest {
    public CartListTest() {
    }
    /**
     * Test of getProductQuantity method, of class CartList.
     */
    @Test
    public void testGetProductQuantity() {
        System.out.println("getProductQuantity");
        Product p1 = null;
        CartList instance = new CartList();
        int expResult = 0;
        int result = instance.getProductQuantity(p1);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class CartList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        CartList instance = new CartList();
        instance.addToCart(new Product(1,"",1,1,"",1));
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class CartList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        CartList instance = new CartList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalPrice method, of class CartList.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        CartList instance = new CartList();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addToCart method, of class CartList.
     */
    @Test
    public void testAddToCart() {
        System.out.println("addToCart");
        Product p1 = null;
        CartList instance = new CartList();
        instance.addToCart(p1);
        assertTrue(instance.p.size() == 1);
    }

    /**
     * Test of removeFromCart method, of class CartList.
     */
    @Test
    public void testRemoveFromCart() {
        System.out.println("removeFromCart");
        Product pone = null;
        CartList instance = new CartList();
        instance.addToCart(pone);
        System.out.println(instance.size());
        instance.removeFromCart(pone);
        assertTrue(instance.isEmpty() == true);
        
    }
}
