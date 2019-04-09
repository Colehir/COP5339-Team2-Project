package AddProduct; 
import org.junit.Test; 
import static org.junit.Assert.*;
public class AddProductModelTest {
    public AddProductModelTest() {
    }
    /**
     * Test of validateInfo method, of class AddProductModel.
     */
    @Test
    public void testValidateInfo() {
        System.out.println("validateInfo");
        AddProductModel apm = new AddProductModel();
        String name = "name";
        double price = 1.0;
        int stock = 5;
        assertTrue(apm.validateInfo(name, price, stock).equals("All Good"));
    }

    /**
     * Test of checkTypes method, of class AddProductModel.
     */
    @Test
    public void testCheckTypes() {
        System.out.println("checkTypes");
        AddProductModel apm = new AddProductModel();
        String name = "name";
        String price = "1.0";
        String stock = "5";
        System.out.println(apm.checkTypes(name,price, stock));
        assertEquals(apm.checkTypes(name,price, stock),"yes");
    }
}
      