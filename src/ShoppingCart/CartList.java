package ShoppingCart;
import ProductList.Product;
import ProductList.ProductList;
import java.io.IOException;
import java.util.ArrayList;
/** 
 * 
 * contains infomation about the cartlist
 */
public class CartList {
    ProductList pl;
    //stores the list of products
    ArrayList<Product> p = new ArrayList<Product>();
    //stores the quantity of products in the cart
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    public CartList()
    {
    }
    /**
     * gets the quantity of products in the cart
     * @param p1
     * @return 
     */
    public int getProductQuantity(Product p1)
    {
        if(p.contains(p1))
        {
            int index = p.indexOf(p1);
            System.out.println(p.indexOf(p1));
            return quantity.get(index); 
        }
        else
        {
            return 0;
        }
    }
    /**
     * check if cart is empty
     * @return 
     */
    public boolean isEmpty()
    {
        return p.isEmpty();
    }
    /**
     * returns the seize of the cart
     * @return 
     */
    public int size()
    {
        return p.size();
    }
    /**
     * gets the total price of the items in the cart
     * @return 
     */
    public double getTotalPrice()
    {
        double total = 0;
        for(int i = 0;i<p.size();i++)
        {
            total = total+p.get(i).getPrice()*quantity.get(i);
        }
        return total;
    }
    /**
     * add a new product to the cart
     * @param p1 
     */
    public void addToCart(Product p1)
    {
        //checks if product already exists in the cart
        if(p.contains(p1))
        {
            int index = p.indexOf(p1);
            if(quantity.get(index) >= p1.getquantity())
            {
                System.out.println("no more quantity");
            }
            else
            {
                int repeat = 0;
        if(p.size() == 0)
        {
            p.add(p1);
            quantity.add(1);
        }
        else
        {
            for(int i = 0;i<p.size();i++)
        {
            if(p.get(i).getID() == p1.getID())
            {
                quantity.set(i,quantity.get(i)+1);
                repeat = 1;
            }
        }
        if(repeat == 0)
        {
            p.add(p1);
            quantity.add(1);
        }
        }
            }
        }
        else
        {
            int repeat = 0;
        if(p.size() == 0)
        {
            p.add(p1);
            quantity.add(1);
        }
        else
        {
            for(int i = 0;i<p.size();i++)
        {
            if(p.get(i).getID() == p1.getID())
            {
                quantity.set(i,quantity.get(i)+1);
                repeat = 1;
            }
        }
        if(repeat == 0)
        {
            p.add(p1);
            quantity.add(1);
        }
        }
        
        }
        
    }
    /**
     * remove an item from the cart
     * @precondition: item must exist in the cart
     * @param pone 
     */
    public void removeFromCart(Product pone)
    {
        int index = p.indexOf(pone);
        {
            if(quantity.get(index) > 1)
            {
                quantity.set(index, quantity.get(index)-1);
            }
            else if(quantity.get(index) == 1)
            {
                quantity.remove(index);
                p.remove(pone);
            }
        }
    }
    /**
     * updates the stock of products in the product file
     * @throws IOException 
     */
    public void updateQuantities() throws IOException {
        for(int i = 0;i<p.size();i++)
        {
           
            int amount = quantity.get(i);
            Product pone = p.get(i);
            pl.removeProduct(pone);
            pone.setquantity(pone.getquantity()-amount);
            pl.addProduct(pone);
            pl.updateProductFile();
        }
    }
    public void addList(ProductList pl) {
        this.pl = pl;
    }
    public Product getProduct(int i)
    {
        return p.get(i);
    }
    public void removeAll()
    {
        p.removeAll(p);
        quantity.removeAll(quantity);
    }
}
