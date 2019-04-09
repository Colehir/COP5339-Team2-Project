package Login;
import Users.User;
import Users.UserList; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * gets information from the model, notifies the view
 */
public class LoginController {
    private LoginModel m;
    private LoginView v;
    private int success = 0;
    private UserList l1 = null;
    public LoginController(LoginModel m, LoginView v, UserList l1)
    {
        this.m = m;
        this.v = v;
        this.l1 = l1;
    }
    /**
     * adds action listener to login button
     * @return 
     */
    public int Login()
    {
       v.getLoginButton().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               //uses model to check login credentials
               if(m.checkCredentials(v.getUser(), v.getPass()) == 0)
               {
                   success = 0;
               }
               if (m.checkCredentials(v.getUser(), v.getPass()) == 1)
               {
                   success = 1;
                   v.closeframe();
               }
               if (m.checkCredentials(v.getUser(), v.getPass()) == 2)
               {
                   success = 2;
                   v.closeframe();
               }
           }
       });
       return success;
    }
    /**
     * adds action listener to register button
     * @return 
     */
   public int Register()
   {
       v.getRegisterButton().addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               v.closeframe();
               success = 3;
               System.out.println(success);
           }
       });
      return success;
   }
   /**
    * gets the currentuser
    * @return 
    */
   public User getCurrentUser()
   {
       return m.getCurrentUser();
   }
}
