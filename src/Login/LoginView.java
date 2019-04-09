package Login;
import javax.swing.JButton;
import javax.swing.JLabel; 
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LoginView extends JFrame{
 JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1, btn2;
 JTextField tf2;
 public LoginView() {
  l1 = new JLabel("Sign in");
  l2 = new JLabel("Username");
  l3 = new JLabel("Password");
  tf1 = new JTextField();
  tf2 = new JTextField();
  btn1 = new JButton("Login");
  btn2 = new JButton("Register new user");
  l1.setBounds(250,50,400,30);
  l2.setBounds(100,90,200,30);
  l3.setBounds(400,90,200,30);
  tf1.setBounds(80,120,100,30);
  tf2.setBounds(380,120,100,30);
  btn1.setBounds(150,150,100,30);
  btn2.setBounds(300,150,175,30);
  add(l1);
  add(l2);
  add(tf1);
  add(l3);
  add(tf2);
  add(btn1);
  add(btn2);
  setLocationRelativeTo(null); 
  setSize(550, 400);
  setLayout(null);
  setVisible(true);
  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 }
 public void closeframe()
 {
	 setVisible(false);
	 dispose();
 }
 /**
  * getter for login button
  * @return 
  */
 public JButton getLoginButton()
 {
     return btn1;
 }
 /**
  * getter for register button
  * @return 
  */
 public JButton getRegisterButton()
 {
     return btn2;
 }
 /**
  * getter for username
  * @return 
  */
 public String getUser()
 {
     return tf1.getText();
 }
 /**
  * getter for password
  * @return 
  */
 public String getPass()
 {
     return tf2.getText();
 }
}
