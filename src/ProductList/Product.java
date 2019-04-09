package ProductList;
/**
 *  
 * Stores information about the product
 */
public class Product {
	private String name;
	private double price;
	private int ID;
	private String Seller;
        private int quantity;
        private double invoice;
        /**
         * Constructor
         * @param ID
         * @param name
         * @param price
         * @param quantity
         * @param Seller 
         */
public Product(int ID, String name, double price,int quantity, String Seller,double invoice)
	{
            this.name = name;
            this.ID = ID;
            this.price = price;
            this.Seller = Seller;
            this.quantity = quantity;
            this.invoice = invoice;
	}
/**
 * setter for name
 * @precondition name is a string
 * @param name 
 */
public void setName(String name)
{
    this.name = name;
}
/**
 * getter for name
 * @return name
 */
public String getName()
{
    return name;
}
/**
 * setter for price
 * @precondition: price must be double
 * @param price 
 */
public void setPrice(double price)
{
    this.price = price;
}
/**
 * getter for price
 * @return price
 */
public double getPrice()
{
    return price;
}
/**
 * setter for ID
 * @precondition: ID must be int
 * @param ID 
 */
public void setID(int ID)
{
    this.ID = ID;
}
/**
 * getter for ID
 * @return ID
 */
public int getID()
{
    return ID;
}
/**
 * setter for quantity
 * @param quantity 
 */
public void setquantity(int quantity)
{
    this.quantity = quantity;
}
/**
 * getter for quantity
 * @return quantity
 */
public int getquantity()
{
    return quantity;
}
/**
 * getter for invoice
 * @return 
 */
public double getinvoice()
{
    return invoice;
}
/**
 * setter for invoice
 * @param invoice 
 */
public void setinvoice(double invoice)
{
    this.invoice = invoice;
}
/**
 * returns the product
 * @return 
 */
public Product getProduct()
{
    return this;
}
/**
 * getter for Seller
 * @return 
 */
public String getSeller() {
       return Seller;
    }
}
