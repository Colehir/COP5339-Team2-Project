package Register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Users.UserList; 
import Users.User;
/**
 * gets info from model and notifies the view
 *
 */
	public class RegisterController {
	private String user;
	private String pass;
	String type = null;
	RegisterView view = null;
	private int success = 0;
	private int taken = 0;
        /**
         * adds action listeners to buttons
         * @param l1
         * @param v
         * @param m 
         */
	public RegisterController(final UserList l1, final RegisterView v,RegisterModel m) 
        {
		v.btn2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view = v;
				user = v.tf1.getText();
				pass = v.tf2.getText();
                                type = v.cb.getSelectedItem().toString();
				int size = l1.getSize();
                                //uses model to check if the username is already taken
                                if(m.checkUserList(user,l1) == false)
                                {
                                    taken = 1;
                                    v.errormessage("Username is already taken");
                                }
				if(taken == 0)
                                {       
					User newuser = new User(user, pass,v.cb.getSelectedItem().toString());
                                        success =1;
					try {
						l1.addnewUser(newuser);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();	
					}
					v.closeframe();
				}
                                taken = 0;
			}
		});
		v.btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				v.closeframe();
				System.out.println("click");
                                success = -1;
			}	
		});	
                // TODO Auto-generated constructor stub
	}
        /**
         * gets the entered username
         * @return 
         */
	public String getEnteredUser()
	{
		return user;
	}
        /**
         * gets the entered password
         * @return 
         */
	public String getEnteredPass()
	{
		return pass;
	}
        /**
         * manually closes the view
         */
	public void closeview()
	{
                view.closeframe();
	}
        /**
         * gets the entered type
         * @return 
         */
	public String getType()
	{
		return type;
	}
        public int confirmRegsitration()
        {
                return success;
        }
}