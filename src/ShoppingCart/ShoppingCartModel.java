package ShoppingCart;
import ProductList.ProductListView;

public class ShoppingCartModel {
    ProductListView v;
    public CartList cl = null;
    public ShoppingCartModel(ProductListView v,CartList cl)
    { 
        this.v = v;
        this.cl = cl;
    }
    /**
     * updates the table from the productlist view
     */
    public void updateProductListView()
    {
        v.updateTable();
    }
    /**
     * returns the cart list
     * @return 
     */
    public CartList getCartList()
    {
        return cl;
    }
    /**
     * gets the data for the table in the view
     * @return 
     */
    public Object[][] getTabledata()
    {
         Object[][] data = new Object[cl.size()][4];
        //actual data for the table in a 2d array
        ////////
        for(int i = 0;i<cl.size();i++)
         {
             data[i][0] = cl.p.get(i).getID();
             System.out.println(cl.p.get(i).getName());
             data[i][1] = cl.p.get(i).getName();
             data[i][2] = cl.p.get(i).getPrice();
             data[i][3] = cl.quantity.get(i);
         }
        return data;
    }
    
}
