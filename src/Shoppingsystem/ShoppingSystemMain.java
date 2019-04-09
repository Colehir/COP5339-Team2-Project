package Shoppingsystem;
import Login.LoginView;
import Login.LoginController;
import Login.LoginModel;
import Inventory.InventoryController;
import Inventory.InventoryModel;
import Inventory.InventoryView;
import ProductList.ProductListController;
import ProductList.ProductListModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import ProductList.ProductListView;
import ShoppingCart.CartList;
import Users.UserList;
import Users.User;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Register.RegisterController;
import Register.RegisterModel;
import Register.RegisterView; 
/**
 * 
 * Drives the program, determines which view the user sees depending on what kind
 * of account they signed into or created
 */
public class ShoppingSystemMain {
	static UserList l1 = new UserList();
        private CartList cartlist = new CartList();
        private int loop = 0;
        private User currentuser = null;
        public ShoppingSystemMain(UserList l1) throws FileNotFoundException, IOException
        {
            populateUserList();
            Login();
        }
        /**
         * @precondition: users.txt exists and is formatted correctly
         * @postcondition: Userlist is populated with users from users.txt
         * @throws IOException 
         */
        public void populateUserList() throws IOException
        {
            File file2 = new File(".");
            for(String fileNames : file2.list()) System.out.println(fileNames);
            System.out.println("List of Users: Username, password, User type(Customer/Seller)");
            File file = new File("src/users.txt");
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String st;
            String[] split;
            try {
			while ((st = br.readLine()) != null)
			{
                            split = st.split("\\s+");
			    User u1 = new User(split[0], split[1], split[2]);
                            System.out.println(split[0]+" "+split[1]);
			    l1.addUser(u1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  br.close();
        }
        /**
         * precondition: There is no user currently signed in
         * postcondition: A user is signed in and the appropriate page is displayed
         * @throws FileNotFoundException 
         */
        public void Login() throws FileNotFoundException
        {
            //waits for user to sign in
            while (loop == 0)
            {
                LoginModel m = new LoginModel(l1);
                LoginView v = new LoginView();
                LoginController c = new LoginController(m,v,l1);
                c.Register();
                while(c.Login() == 0)
                {
                    try {
                    Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                    Logger.getLogger(ShoppingSystemMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            switch(c.Login())
            {
                case 0:
                    
                    break;
                //if user signs in as a customer, then the productpage is displayed
                case 1:
                     currentuser = c.getCurrentUser();
                     //breaks loop
                     loop = 1;
                     ProductList();
                    break;
                //if user signs in as customer, then the seller's inventory is displayed
                case 2:
                     currentuser = c.getCurrentUser();
                     //breaks loop
                     loop = 1;
                     Inventory();
                    break;
                    //user is creating a new account
                case 3:
                    Register();
                    break;
                        
            }
            }
        }
        /**
         * precondition: user has signed in as a customer
         * @throws FileNotFoundException 
         */
        public void ProductList() throws FileNotFoundException
        {
            //displays product page
            ProductListModel pm = new ProductListModel();
            ProductListView pv = new ProductListView();
            ProductListController pc = new ProductListController(pv,pm,cartlist);
            while(pc.logoutControl() == false)
            {
                pc.logoutControl();
            }
        }
        /**
         * precondition: user has signed in as a seller
         * @throws FileNotFoundException 
         */
         public void Inventory() throws FileNotFoundException 
        {
            InventoryModel im = new InventoryModel(currentuser);
            InventoryView iv = new InventoryView(currentuser);
            InventoryController ic = new InventoryController(iv,im,currentuser);
            
            while(ic.logoutControl() == false)
            {
                ic.logoutControl();
            }
        }
         /**
          * precondition: user has pressed the register button
          * @throws FileNotFoundException 
          */
         public void Register() throws FileNotFoundException
         {
                RegisterView rv = new RegisterView();
                RegisterModel rm = new RegisterModel();
                RegisterController rc = new RegisterController(l1,rv,rm);
                while(rc.confirmRegsitration() == 0)
                {
                     try {
                    Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    Logger.getLogger(ShoppingSystemMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println(rc.confirmRegsitration());
                //if the registration was successful
                if(rc.confirmRegsitration() == 1)
                {
                    currentuser = new User(rc.getEnteredUser(),rc.getEnteredPass(),rc.getType());
                    System.out.println(rc.getType());
                    System.out.println("New user created");
                    loop = 1;
                    //if the user created a new customer account
                    if(rc.getType() == "Customer")
                    {
                        System.out.println("Type is customer");
                        ProductList();
                    }
                    //if the user created a new seller account
                    else
                    {
                        System.out.println("Type is not3 customer");
                        Inventory();
                    }  
                }
         }
	public static void main(String[] args) throws IOException
	{
            //loops program until logout or exit
            while(0 == 0)
            {
                 ShoppingSystemMain s = new ShoppingSystemMain(l1);
		 System.out.println();
            }
		 
        }
}
