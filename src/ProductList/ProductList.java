package ProductList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; 
/**
 * 
 * Stores the list of products
 */
public class ProductList {
	public ArrayList<Product> products = new ArrayList<Product>();
        /**
         * @precondition: none
         */
	public ProductList()
	{
        }
        /**
         * adds a product to the list
         * @precondition: none
         * @postcondition: productlist size will increase by 1
         * @param p 
         */
	public void addProduct(Product p)
        {
            products.add(p);
        }
        /**
         * removes a product from the list
         * @precondition: product must exist in list
         * @postcondition: list size decreases by 1
         * @param p
         * @throws IOException 
         */
        public void removeProduct(Product p) throws IOException
        {
            products.remove(p);
            updateProductFile();
        }
        /**
         * gets product in list based on its unique ID
         * @postcondition: product must exist
         * @param ID
         * @return 
         */
        public Product getProductFromID(int ID)
        {
            //searches for product based on ID
            for(int i = 0;i<products.size();i++)
            {
                if(products.get(i).getID() == ID)
                {
                    return products.get(i);
                }
            }
            return null;
        }
        //returns the size of the product list
    public int size() {
        return products.size();
    }
    /**
     * checks if the product id exists(used when adding new product, it will assign an unused ID to the product)
     * @param id
     * @return 
     */
    public boolean checkforID(int id)
    {
        for(int i = 0;i<products.size();i++)
        {
            if(id == products.get(i).getID())
            {
                System.out.println("id already taken"+id+" and taken"+products.get(i).getID());
                return true;
            }
        }
        return false;
    }
/**
 *  updates the product file by repopulating it using the array list
 * @throws IOException 
 */
    public void updateProductFile() throws IOException {
        int size = products.size();
		FileWriter fw = new FileWriter("src/products.txt");
		PrintWriter pw = new PrintWriter(fw);
		System.out.println(products.get(size-1).getID()+" "+products.get(size-1).getName()+" "+products.get(size-1).getquantity()+" "+products.get(size-1).getSeller());
		for(int i = 0;i<size;i++)
		{
			pw.println(products.get(i).getID()+" "+products.get(i).getName()+" "+products.get(i).getPrice()+" "+products.get(i).getquantity()+" "+products.get(i).getSeller()+" "+products.get(i).getinvoice());
		}
		pw.close();
		fw.close();
    }
}
