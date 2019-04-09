package ProductDetail;
import ProductList.Product;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
public class ProductDetailView extends JFrame{ 
JLabel l1, l2, l3,l4,l5,sliderlabel;
Product p;
JButton btnAddToCart;
JSlider slider;
private int min = 1;
private int max;
Container c = getContentPane();
    public ProductDetailView()
    {
       this.p = p;
        sliderlabel = new JLabel("Use the slider to choose the quantity");
    	 btnAddToCart = new JButton("Add to Cart");
        c.setLayout(null); 
        this.setLayout(null);
        this.setTitle("Product Details");
        this.setSize(400,400);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);    
    }
    /**
     * updates the slider values
     */
    public void updateSliderLabel()
    {
        sliderlabel.setText(Integer.toString(slider.getValue()));
        sliderlabel.revalidate();
        sliderlabel.repaint();
    }
    /**
     * updates the quantity
     * @param quantity 
     */
    void updateQuantity(int quantity) {
        max = quantity;
        slider.setMaximum(max);
        slider.repaint();
    }
    /**
     * sets up the view with info from the model
     * @param name
     * @param ID
     * @param price
     * @param quantity
     * @param seller
     * @param Maximumvalue 
     */
    public void setView(String name,int ID,double price,int quantity,String seller,int Maximumvalue)
    {
        l1 = new JLabel("Name: "+name);
        l2 = new JLabel("ID: "+ID);
        l3 = new JLabel("Price: "+price);
        l4 = new JLabel("Stock: "+quantity);
        l5 = new JLabel("Seller: "+seller);
        max = Maximumvalue;
        slider = new JSlider(min,max);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(slider);
        c.add(btnAddToCart);
        c.add(sliderlabel);
        sliderlabel.setBounds(10,230,250,30);
        l1.setBounds(10, 10, 250, 10);
        l2.setBounds(10, 30, 250, 10);
        l3.setBounds(10, 50, 250, 20);
        l4.setBounds(10, 70, 250, 20);
        l5.setBounds(10, 90, 250, 20);
        slider.setBounds(10,250,100,30);
        btnAddToCart.setBounds(220, 300, 150, 50);
    }
}
