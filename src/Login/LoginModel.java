package Login;
import Users.Customer;
import Users.Seller; 
import Users.User;
import Users.UserList;
/**
 * 
 * checks login credentials and can return the logged in user
 */
public class LoginModel {
    UserList l1 = null;
    User u = null;
    public LoginModel(UserList l1)
    {
        this.l1 = l1;
    }
    /**
     * checks the login credentials
     * @param user
     * @param pass
     * @return 
     */
    public int checkCredentials(String user, String pass)
    {
        for(int i = 0;i<l1.getSize();i++)
        {
            if(user.equals(l1.getUser(i)))
            {
                if(pass.equals(l1.getPass(i)))
                {
                    if(l1.getType(i).equals("Customer"))
                    {
                        u = new Customer(l1.getUser(i),l1.getPass(i),"Customer");
                  
                        return 1;
                    }
                    else
                    {
                        u = new Seller(l1.getUser(i),l1.getPass(i),"Seller");
                        return 2;
                    }
                    
                }
            }
        }
        return 0;
    }
    /**
     * return the user that logged in
     * @return 
     */
    public User getCurrentUser()
    {
        return u;
    }
}
