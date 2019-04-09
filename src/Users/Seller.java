package Users;
 
/** 
 *
 * extends the User Class
 */
public class Seller extends User{
    
    public Seller(String username, String password, String type) {
        super(username, password, type);
    }
    /**
     * getter for revenue
     * @return 
     */
    public double getRevenue()
    {
        return revenue;
    }
    /**
     * setter for revenue
     * @param d 
     */
    public void setRevenue(Double d)
    {
        this.revenue = revenue;
    }
    private double revenue;
}
