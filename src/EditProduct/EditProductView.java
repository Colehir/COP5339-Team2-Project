package EditProduct;
import ProductList.Product;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class EditProductView extends JFrame{
JLabel l1, l2, l3,l4,l5;
Product p;
JTextField tname,tprice,tstock,tinvoice;
JButton btnConfirmEdits, btnRemove;
    public EditProductView(Product p)
    {
       this.p = p;
       l1 = new JLabel("Product ID:"+p.getID());
       l2 = new JLabel("Name:");
       l3 = new JLabel("Price:");
       l4 = new JLabel("Stock: ");
       l5 = new JLabel("Invoice: ");
       tname = new JTextField(p.getName());
       tprice = new JTextField(""+p.getPrice());
       tstock = new JTextField(""+p.getquantity());
       tinvoice = new JTextField(""+p.getinvoice());
        btnConfirmEdits = new JButton("Confirm Edits");
        btnRemove = new JButton("Remove Product");
        Container c = getContentPane(); 
        c.setLayout(null); 
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(tname);
        c.add(tprice);
        c.add(tstock);
        c.add(tinvoice);
        c.add(btnConfirmEdits);
        c.add(btnRemove);
        l1.setBounds(10, 10, 250, 20);
        l2.setBounds(10, 30, 250, 20);
        tname.setBounds(10,60,250,20);
        l3.setBounds(10,80, 250, 20);
        tprice.setBounds(10,110,250,20);
        l4.setBounds(10, 130, 250, 20);
        tstock.setBounds(10,160,250,20);
        l5.setBounds(10, 180, 250, 20);
        tinvoice.setBounds(10,200,250,20);
        btnConfirmEdits.setBounds(220, 300, 150, 50);
        btnRemove.setBounds(70,300,150,50);
        this.setLayout(null);
        this.setTitle("Table Example");
        this.setSize(400,400);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);    
    } 
    /**
     * gets entered name
     * @return 
     */
    public String getName()
    {
        return tname.getText();
    }
    /**
     * gets entered cost
     * @return 
     */
    public double getCost()
    {
        return Double.parseDouble(tprice.getText());
    }
    /**
     * gets entered stock
     * @return 
     */
    public int getStock()
    {
        return Integer.parseInt(tstock.getText());
    }
    /**
     * gets entered invoice
     * @return 
     */
    public double getInvoice()
    {
        return Double.parseDouble(tinvoice.getText());
    }
}
