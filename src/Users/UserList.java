package Users;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.ArrayList;
/**
 * 
 * stores the list of users
 */
public class UserList {
	ArrayList<User> UserList = new ArrayList<User>();
	public UserList()
	{
	}
        /**
         * adds a user to the list
         * @param u1 
         */
	public void addUser(User u1)
	{
		UserList.add(u1);
	}
        /** 
         * updates file and adds user to list
         * @precondition: users.txt must exist and is formatted properly
         * @param u1
         * @throws IOException 
         */
	public void addnewUser(User u1) throws IOException
	{
		int size = UserList.size();
		addUser(u1);
		FileWriter fw = new FileWriter("users.txt");
		PrintWriter pw = new PrintWriter(fw);
		System.out.println(UserList.get(size).user()+" "+UserList.get(size).pass()+" "+UserList.get(size).type());
		for(int i = 0;i<size+1;i++)
		{
			pw.println(UserList.get(i).user()+" "+UserList.get(i).pass()+" "+UserList.get(i).type());
		}
		pw.close();
		fw.close();
		
        }
        /**
         * getter for size of userlist
         * @return 
         */
	public int getSize() {
		// TODO Auto-generated method stub
		return UserList.size();
	}
        /**
         * gets a user based off index
         * @param i
         * @return 
         */
	public String getUser(int i)
	{
		return UserList.get(i).user();
		
	}
        /**
         * gets a password based off index
         * @param i
         * @return 
         */
	public String getPass(int i)
	{
		return UserList.get(i).pass();
	}
        /**
         * gets the type based off index
         * @param i
         * @return 
         */
	public String getType(int i) {
		// TODO Auto-generated method stub
		return UserList.get(i).type();
	}
        /**
         * gets a seller based off name
         * @param i
         * @return 
         */
        User getSeller(String name)
        {
            for(int i = 0;i<UserList.size();i++)
            {
                if(name == UserList.get(i).user())
                {
                    return UserList.get(i);
                }
            }
         return null;
        }
}
