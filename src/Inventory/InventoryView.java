package Inventory;
import ProductList.ProductList;
import Users.User;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class InventoryView extends JFrame
{
	JLabel l1, l2, l3,lrevenue,lcosts,lprofits;
	private JButton btnAddProduct, btnLogout;
        ProductList pl = new ProductList();
        private JTable table = null;
        User u1 = null;
        private Container c = null;
        JScrollPane scroller = null;
    /**
     * displays the inventory page
     * @param u1
     * @throws FileNotFoundException 
     */
    public InventoryView(User u1) throws FileNotFoundException
    {
        this.u1 = u1;
    	 l1 = new JLabel("Welcome "+u1.user());
    	 l2 = new JLabel("Product List");
         lrevenue = new JLabel();
         lcosts = new JLabel();
         lprofits = new JLabel();
    	 btnAddProduct = new JButton("Add New Product");
    	 btnLogout = new JButton("LogOut");
    	this.setLayout(new BorderLayout());
        c = getContentPane(); 
        c.setLayout(null); 
        c.add(l1);
        c.add(btnLogout);
        c.add(btnAddProduct);
        c.add(lrevenue);
        c.add(lcosts);
        c.add(lprofits);
        lrevenue.setBounds(10,300,200,30);
        lcosts.setBounds(10,350,200,30);
        lprofits.setBounds(10,400,200,30);
        l1.setBounds(450, 50, 100, 50);
        btnLogout.setBounds(880, 20, 100, 50);
        btnAddProduct.setBounds(700, 20, 150, 50);
        this.setLayout(null);
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setSize(1000,500);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    /**
     * getter for table
     * @return 
     */
    public JTable getTable()
    {
        return table;
    }
    /**
     * sets the table information
     * @param data 
     */
    public void setTable(Object[][] data)
    {
        String[] columns = new String[] {
            "Id", "Name", "Cost", "Stock"
        };
	
        table = new JTable(data, columns);
        table.setDefaultEditor(Object.class, null);
        scroller = new JScrollPane(table); 
        c.add(scroller); 
        scroller.setBounds(160, 100, 700, 300);
        c.revalidate();
        c.repaint();
    }
    /**
     * gets cart button
     * @return 
     */
    public JButton getCart()
    {
        return btnAddProduct;
    }
    /*
    gets product list
    */
    ProductList getProductList() {
        return pl;
    }
    /**
     * gets addProduct button
     * @return 
     */
    JButton getAddProductBtn()
    {
        return btnAddProduct;
    }
    /**
     * gets logout button
     * @return 
     */
    JButton getLogout() {
        return btnLogout;
}
    /**
     * updates table information
     */
    public void updateTable(ProductList pl) throws FileNotFoundException {
        c.remove(scroller);
        String[] columns = new String[] {
            "Id", "Name", "Cost", "Stock"
        };
        Object[][] data = new Object[pl.size()][5];
         int j = 0;
         for(int i = 0;i<pl.size();i++)
         {
             if(pl.products.get(i).getSeller().equalsIgnoreCase(u1.user()))
             {
                 data[j][0] = pl.products.get(i).getID();
                 data[j][1] = pl.products.get(i).getName();
                 data[j][2] = pl.products.get(i).getPrice();
                 data[j][3] = pl.products.get(i).getquantity();
                 j++;
             }
             
         }
        DefaultTableModel dataModel = new DefaultTableModel(data, columns);
        table.setModel(dataModel);
        table.setDefaultEditor(Object.class, null);
        System.out.println("table repainted");
        scroller = new JScrollPane(table); 
        c.add(scroller);
        scroller.setBounds(160, 100, 700, 300);
        c.revalidate();
        c.repaint();
    }
    /**
     * sets the product list
     * @param pl 
     */
    public void setProductList(ProductList pl)
    {
        this.pl = pl;
    }
    public void setRevenue(double revenue)
    {
        lrevenue.setText("Revenue: "+revenue);
          c.revalidate();
        c.repaint();
    }
    public void setCosts(double costs)
    {
        lcosts.setText("Costs: "+costs);
        c.revalidate();
        c.repaint();
    }
    public void setProfits(double profits)
    {
        lprofits.setText("Profits: "+profits);
        c.revalidate();
        c.repaint();
    }
}

