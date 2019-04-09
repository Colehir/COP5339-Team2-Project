package Register;
import Users.UserList;
/** 
 *
 * checks to see if the username already exists in the user list
 */
public class RegisterModel {
    public boolean checkUserList(String user, UserList l1) {
        int size = l1.getSize();
        for(int i =0;i<size;i++)
	{
		if(user.equals(l1.getUser(i)))
		{
			System.out.println("Username aready taken");
                        return false;
		}
	}
        return true;
    }
}
