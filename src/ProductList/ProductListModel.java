package ProductList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * Stores the information that is used by the controller and view
 */
public class ProductListModel {
    ProductList pl = new ProductList();
    /**
     * Gets the information to be used in the productlist table view from a file
     * @precondition: products.txt exists and is properly formatted
     * @return Object[][]
     * @throws FileNotFoundException 
     */
    public Object[][] getTableData() throws FileNotFoundException
    {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
                }
         //information for table
         Object[][] data = new Object[pl.size()][4];
         for(int i = 0;i<pl.size();i++)
         {
                data[i][0] = pl.products.get(i).getID();
                data[i][1] = pl.products.get(i).getName();
                data[i][2] = pl.products.get(i).getPrice();
                data[i][3] = pl.products.get(i).getquantity();
         }
         return data;
    }
    /**
     * returns the list of products
     * @return ProductList
     */
   ProductList getProductList() {
        return pl;
    }
}
