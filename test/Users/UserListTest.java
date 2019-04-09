package Users;
import org.junit.After; 
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class UserListTest {
    
    public UserListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserList.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u1 = new User("name","pass","Customer");
        UserList instance = new UserList();
        instance.addUser(u1);
        assert(instance.getUser(0) == "name");
    }
    /**
     * Test of getSize method, of class UserList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        UserList instance = new UserList();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class UserList.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int i = 0;
        UserList instance = new UserList();
        User u = new User("name","pass","type");
        instance.addUser(u);
        String expResult = "name";
        String result = instance.getUser(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPass method, of class UserList.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        int i = 0;
        UserList instance = new UserList();
        User user = new User("name","pass","Customer");
        instance.addUser(user);
        String expResult = "pass";
        String result = instance.getPass(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class UserList.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        int i = 0;
        UserList instance = new UserList();
        User user = new User("name","pass","Customer");
        instance.addUser(user);
        String expResult = "Customer";
        String result = instance.getType(i);
        assertEquals(expResult, result);
    }
}
