package Inventory;
import ProductList.Product;
import ProductList.ProductList;
import Users.User; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * contains info from productlist and seller
 */
public class InventoryModel{
    ProductList pl = new ProductList();
    User currentuser;
    public InventoryModel(User currentuser) throws FileNotFoundException
    {
        this.currentuser = currentuser;
        File file = new File("src/products.txt");
		 BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st;
		  String[] split;
		  try {
			while ((st = br.readLine()) != null)
			{
                            split = st.split("\\s+");
			    Product p1 = new Product(Integer.parseInt(split[0]),split[1],Double.parseDouble(split[2]),Integer.parseInt(split[3]),split[4],Double.parseDouble(split[5]));
                            pl.addProduct(p1);
			}
		} catch (IOException e) {
			e.printStackTrace();
                }
    }
    /**
     * gets the productlist
     * @return
     * @throws FileNotFoundException 
     */
    ProductList getProductList() throws FileNotFoundException 
    {
        
                  return pl;
    }
    /**
     * gets the products that belong to the seller
     * @return 
     */
    public Object[][] getTabledata()
    {
        Object[][] data = new Object[pl.size()][5];
        int j = 0;
         for(int i = 0;i<pl.size();i++)
         {
             
             if(pl.products.get(i).getSeller().equalsIgnoreCase(currentuser.user()))
             {
                 data[j][0] = pl.products.get(i).getID();
                 data[j][1] = pl.products.get(i).getName();
                 data[j][2] = pl.products.get(i).getPrice();
                 data[j][3] = pl.products.get(i).getquantity();
                 j++;
             }
         }
         return data;
    }
    public double getRevenue() throws FileNotFoundException
    {
        double revenue = 0;
         File file = new File("src/sales.txt");
         BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st;
		  String[] split;
		  try {
			while ((st = br.readLine()) != null)
			{
                            split = st.split("\\s+");
			    if(split[0].equals(currentuser.user()))
                            {
                                revenue = revenue+Double.parseDouble(split[1]);
                            }
                            
			}
                        br.close();
		} catch (IOException e) {
			e.printStackTrace();
                }
                  System.out.println(revenue);
                  return revenue;
    }
    public double getCosts() throws FileNotFoundException
    {
        double costs = 0;
         File file = new File("src/sales.txt");
         BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st;
		  String[] split;
		  try {
			while ((st = br.readLine()) != null)
			{
                            split = st.split("\\s+");
                            System.out.println(split[0]);
			    if(split[0].equals(currentuser.user()))
                            {
                                costs = costs+Double.parseDouble(split[2]);
                            }
                            
			}
                        br.close();
		} catch (IOException e) {
			e.printStackTrace();
                }
                  System.out.println(costs);
                  return costs;
    }
}

