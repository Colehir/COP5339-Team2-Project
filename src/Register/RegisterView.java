package Register;
import javax.swing.*;
public class RegisterView extends JFrame{
	 JLabel l1, l2, l3,lerror; 
	 JTextField tf1;
	 JButton btn1, btn2;
	 JTextField tf2;
         JComboBox cb;
         //dispalys the register page
	 public RegisterView()
         {
          System.out.println("Register view");
	  l1 = new JLabel("Register New User");
	  l2 = new JLabel("Enter Username");
	  l3 = new JLabel("Enter Password");
          lerror = new JLabel();
	  tf1 = new JTextField();
	  tf2 = new JTextField();
	  btn1 = new JButton("Cancel");
	  btn2 = new JButton("Finish Registration");
          String[] combos = { "Customer", "Seller"};
          cb = new JComboBox(combos);
	  setLayout(null);
	  l1.setBounds(250,50,400,30);
	  l2.setBounds(100,90,200,30);
	  l3.setBounds(400,90,200,30);
          lerror.setBounds(100,180,300,20);
	  tf1.setBounds(80,120,100,30);
	  tf2.setBounds(380,120,100,30);
	  btn1.setBounds(150,150,100,30);
	  btn2.setBounds(300,150,175,30);
          cb.setBounds(200, 250, 150,50);
	  add(l3);
	  add(l1);
	  add(l2);
	  add(tf1);
	  add(l3);
	  add(tf2);
	  add(btn1);
	  add(btn2);
          add(cb);
	  setLocationRelativeTo(null); 
	  setSize(550, 400);
	  setLayout(null);
	  setVisible(true);
          this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 }
         /**
          * manually closes the view
          */
	public void closeframe() {
		// TODO Auto-generated method stub
		 setVisible(false); //you can't see me!
		 dispose();
		
	}
        /**
         * displays error message if username already exists
         * @param message 
         */
        public void errormessage(String message)
        {
            remove(lerror);
            lerror.setText(message);
            add(lerror);
            this.revalidate();
            this.repaint();
        }
}
