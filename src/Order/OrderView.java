package Order;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;  
public class OrderView extends JFrame{
    JLabel ltotal, lcc;
    Container c;
    JTextField textcreditcard;
    JButton btnConfirm;
    public OrderView()
    {
        btnConfirm = new JButton("Confirm");
        c = getContentPane();
        ltotal = new JLabel("");
        lcc = new JLabel("Please enter credit card info");
        textcreditcard = new JTextField();
        c.add(ltotal);
        c.add(textcreditcard);
        c.add(lcc);
        c.add(btnConfirm);
        btnConfirm.setBounds(250, 250, 100, 100);
        ltotal.setBounds(10,100,100,50);
        lcc.setBounds(10,150,300,30);
        textcreditcard.setBounds(10,200,300,30);
        this.setLayout(null);
        this.setTitle("Order");
        this.setSize(400,400);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);    
    }
    /**
     * updates total;
     * @param s the total that will be displayed by the label
     */
    public void updateView(String s)
    {
        ltotal.setText(s);
    }
    /**
     * manually closes the view
     */
    public void closeView()
    {
        this.setVisible(false);
        this.dispose();
    }
    
}
