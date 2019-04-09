package AddProduct;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class AddProductView extends JFrame
{
     JLabel l1, l2, l3,l4, errorlabel;
     JButton btnFinish;
     JTextField textname,textprice,textstock,textinvoice;
     public  AddProductView()
    {
        l1 = new JLabel("Name: ");
        l2 = new JLabel("Price: ");
        l3 = new JLabel("Quantity: ");
        l4 = new JLabel("Invoice: ");
        textname = new JTextField();
        textprice = new JTextField();
        textstock = new JTextField();
        textinvoice = new JTextField();
    	btnFinish = new JButton("Create Product");
        Container c = getContentPane();
        c.setLayout(null);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(textname);
        c.add(textprice);
        c.add(textstock);
        c.add(textinvoice);
        c.add(btnFinish);
        l1.setBounds(10, 10, 250, 10);
        textname.setBounds(10,25,100,30);
        l2.setBounds(10, 60, 250, 10);
        textprice.setBounds(10,80,100,30);
        l3.setBounds(10, 110, 250, 20);
        textstock.setBounds(10,130,100,30);
        l4.setBounds(10,170,250,10);
        textinvoice.setBounds(10,190,100,30);
        btnFinish.setBounds(220, 300, 150, 50);
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
         return textname.getText();
     }
     /**
      * gets entered price
      * @return 
      */
     public double getPrice()
     {
         return Double.parseDouble(textprice.getText());
     }
     /**
      * gets entered quantity
      * @return 
      */
     public int getQuantity()
     {
         return Integer.parseInt(textstock.getText());
     }
/**
 * gets entered invoice
 * @return 
 */
    double getInvoice() {
        return Double.parseDouble(textinvoice.getText());
    }
} 