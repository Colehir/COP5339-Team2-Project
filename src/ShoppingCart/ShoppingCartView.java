package ShoppingCart;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * displays the shopping cart
 */
public class ShoppingCartView extends JFrame{
    JLabel l1, l2, l3,lerror,lremove;
    JButton btnOrder;
    JTable table;
    Container c;
    JScrollPane scroller;
    CartList cl;
     public ShoppingCartView()
    {
        this.cl = cl;
        l1 = new JLabel("Shopping Cart");
    	lremove = new JLabel("Click on a product to remove it from the list");
        btnOrder = new JButton("Order");
        c = getContentPane(); 
        c.setLayout(null); 
        c.add(l1);
        c.add(btnOrder);
        c.add(lremove);
        lremove.setBounds(100,280,300,50);
        l1.setBounds(165, 50, 100, 50);
        btnOrder.setBounds(340, 500, 70, 50);
        this.setLayout(null);
        this.setTitle("Shopping Cart");
        //this.pack();
        this.setSize(435,600);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
     /**
      * sets the view, initializes the table information
      * @param data
      * @param totalcost 
      */
     public void setView(Object[][] data,double totalcost)
     {
         l2 = new JLabel("Total: $"+totalcost);
         lerror = new JLabel("");
         String[] columns = new String[] {
            "Id", "Name", "Cost", "Quantity"
        };
        table = new JTable(data, columns);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.setDefaultEditor(Object.class, null);
        scroller = new JScrollPane(table); 
        scroller.setBounds(10, 100,400, 200);
        c.add(scroller); 
        c.add(l2);
        c.add(lerror);
        l2.setBounds(100, 500, 100, 50);
        lerror.setBounds(100,400,100,50);
        c.revalidate();
        c.repaint();
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
      * getter for order button
      * @return 
      */
     public JButton getOrderButton()
     {
         return btnOrder;
     }
     /**
      * updates the table in the view
      * @param data
      * @param totalcost 
      */
     public void updateTable(Object[][] data,double totalcost)
     {
         c.remove(scroller);
         c.remove(l2);
        String[] columns = new String[] {
            "Id", "Name", "Cost", "Quantity"
        };
 
        l2 = new JLabel("Total: $"+totalcost);
        l2.setBounds(100, 500, 100, 50);
        DefaultTableModel dataModel = new DefaultTableModel(data, columns);
        table.setModel(dataModel);
        table.setDefaultEditor(Object.class, null);
        System.out.println("table repainted");
        scroller = new JScrollPane(table); 
        c.add(scroller);
        c.add(l2);
        scroller.setBounds(10, 100, 400, 200);
        l2.repaint();
        c.revalidate();
        c.repaint();
     }
     /**
      * sets the string for the error message
      * @param message 
      */
     public void errormessage(String message)
     {
        c.remove(lerror);
        lerror = new JLabel(message);
        lerror.setBounds(100,400,100,50);
        c.add(lerror);
        c.revalidate();
        c.repaint();
     }
}
