package ProductList;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**  
 * displays productlist
 *
 */
public class ProductListView extends JFrame
{
	JLabel l1, l2, l3;
	private JButton btnShop, btnLogout;
        ProductList pl = new ProductList();
        private JTable table = null;
        Container c;
    public ProductListView() throws FileNotFoundException
    {
    	 l2 = new JLabel("Product List");
    	 btnShop = new JButton("Cart");
    	 btnLogout = new JButton("LogOut");
    	this.setLayout(new BorderLayout());
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "Price", "Quantity"
        };
        c = getContentPane(); 
        c.setLayout(null); 
        c.add(btnLogout);
        c.add(btnShop);
        btnLogout.setBounds(880, 20, 100, 50);
        btnShop.setBounds(780, 20, 70, 50);
        this.setLayout(null);
        this.setTitle("ProductList");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setSize(1000,500);
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    }
    /**
     * returns the table
     * @return table
     */
    public JTable getTable()
    {
        return table;
    }
    /**
     * sets the formatting for the table
     * @param data
     * @param pl 
     */
    public void setTable(Object[][] data, ProductList pl)
    {
        this.pl = pl;
        String[] columns = new String[] {
            "Id", "Name", "Price", "Quantity"
        };
         table = new JTable(data, columns);
          table.setDefaultEditor(Object.class, null);
          JScrollPane scroller = new JScrollPane(table); 
            c.add(scroller); 
            scroller.setBounds(160, 100, 700, 300);
          
    }
    /**
     * returns the cart button
     * @return JButton
     */
    public JButton getCart()
    {
        return btnShop;
    }
    /**returns the logout button
     * 
     * @return 
     */
    public JButton getLogout()
    {
        return btnLogout;
    }
    /**
     * updates the table
     */
    public void updateTable()
    {
        Object[][] data = new Object[pl.size()][4];
         for(int i = 0;i<pl.size();i++)
         {
             data[i][0] = pl.products.get(i).getID();
             data[i][1] = pl.products.get(i).getName();
             data[i][2] = pl.products.get(i).getPrice();
             data[i][3] = pl.products.get(i).getquantity();
         }
         String[] columns = new String[] {
            "Id", "Name", "Price", "Quantity"
        };
         DefaultTableModel dataModel = new DefaultTableModel(data, columns);
         //c.remove(table);
        table.setModel(dataModel);
       c.revalidate();
       c.repaint();
        System.out.println("Table is being repainted");
    }
}
