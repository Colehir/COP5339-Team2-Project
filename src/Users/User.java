package Users; 
/** 
 * 
 * contains information about the user
 */
public class User {
	private String username;
	private String password;
	private String type;
	public User(String username, String password, String type)
	{
		this.username = username;
		this.password = password;
		this.type = type;
        }
        /**
         * getter for username
         * @return 
         */
	public String user()
	{
		return username;
	}
        /**
         * getter for password
         * @return 
         */
	public String pass()
	{
		return password;
	}
        /**
         * getter for type
         * @return 
         */
	public String type()
	{
		return type;
	}

}
