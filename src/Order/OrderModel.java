package Order;
import ProductList.Product;
import ShoppingCart.CartList;
import ShoppingCart.ShoppingCartModel;
import ShoppingCart.ShoppingCartView;
import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class OrderModel {
    private CartList cl;
    ShoppingCartModel scm;
    ShoppingCartView scv;
    public OrderModel(CartList cl,ShoppingCartModel scm,ShoppingCartView scv){
        this.cl = cl;
        this.scm = scm;
        this.scv = scv;
    }
    /**
     * calculates total cost
     * @return totalprice returns the totalcost of the cart
     */
    public String getTotalCost()
    {
        return Double.toString(cl.getTotalPrice());
    }
    /**
     * getter for cart
     * @return cl returns the cart
     */
    public CartList getCart()
    {
        return cl;
    }
    /**
     * updates productlist view
     */
    public void updateProductList()
    {
        scm.updateProductListView();
    }
/**
 * updates sales file for sellers to track revenue,costs,profits
 * @throws FileNotFoundException
 * @throws IOException 
 */
    void updateSales() throws FileNotFoundException, IOException
    {
        File file =new File("src/sales.txt");
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0;i<cl.size();i++)
        {
           Product p =  cl.getProduct(i);
           int quantity = cl.getProductQuantity(p);
           double price = p.getPrice()*quantity;
           double invoice = p.getinvoice()*quantity;
           bw.write(p.getSeller()+" "+price+" "+invoice+"\n");
           System.out.println("written");
        }
        bw.close();
    }
}
