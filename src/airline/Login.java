package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JLabel l1,l2; // Declaration of JLabels for username and password
    JTextField t1; // Declaration of JTextField for username input
    JPasswordField t2; // Declaration of JPasswordField for password input
    JButton b1,b2; // Declaration of JButtons for login and cancel actions

    Login(){
        super("Login"); // Set the title of the JFrame to "Login"

        setLayout(null); // Set layout to null for absolute positioning of components


        // Create and configure JLabel for username
        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30); // Set bounds (position and size) for the label
        add(l1); // Add the label to the JFrame

        // Create and configure JLabel for password
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30); // Set bounds for the label
        add(l2); // Add the label to the JFrame

        // Create and configure JTextField for username input
        t1=new JTextField();
        t1.setBounds(150,20,150,30); // Set bounds for the text field
        add(t1); // Add the text field to the JFrame

        // Create and configure JPasswordField for password input
        t2=new JPasswordField();
        t2.setBounds(150,70,150,30); // Set bounds for the password field
        add(t2); // Add the password field to the JFrame

        // Create and configure JLabel to display an image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150); // Set bounds for the label displaying the image
        add(l3); // Add the label to the JFrame

        // Create and configure JButton for login action
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30); // Set bounds for the button
        b1.setFont(new Font("serif",Font.BOLD,15)); // Set font for the button text
        b1.addActionListener(this); // Add action listener to handle button clicks
        b1.setBackground(Color.BLACK); // Set background color of the button
        b1.setForeground(Color.WHITE); // Set foreground (text) color of the button
        add(b1); // Add the button to the JFrame

        // Create and configure JButton for cancel action
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30); // Set bounds for the button
        b2.setFont(new Font("serif",Font.BOLD,15)); // Set font for the button text
        b2.setBackground(Color.BLACK); // Set background color of the button
        b2.setForeground(Color.WHITE); // Set foreground (text) color of the button
        add(b2); // Add the button to the JFrame

        b2.addActionListener(this); // Add action listener to handle button clicks

        getContentPane().setBackground(Color.WHITE); // Set background color of the content pane


        // Set window visibility and size
        setSize(600, 300);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set window visibility after all components are added
        setVisible(true);
    }

    // ActionListener implementation for handling button clicks
    public void actionPerformed(ActionEvent ae){
        // Check if the login button is clicked
        if(ae.getSource()==b1){
            try{
                DBConnection c1 = new DBConnection(); // Create a new database connection
                String u = t1.getText(); // Get the entered username

                char[] passwordChars = t2.getPassword(); // Get the entered password as a char array
                String v = new String(passwordChars); // Convert the password char array to a String

                // SQL query to check if the username and password match
                String q = "select * from login where username='"+u+"' and password='"+v+"'";

                // Execute the query and retrieve the result set
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new MainFrame().setVisible(true); // Open the main frame if login is successful
                    setVisible(false); // Hide the login frame
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login"); // Show error message for invalid login
                    setVisible(false); // Hide the login frame
                }
            }catch(Exception e){
                e.printStackTrace(); // Print the stack trace if an exception occurs
            }
        } else if(ae.getSource()==b2){ // Check if the cancel button is clicked
            System.exit(0); // Exit the application if cancel button is clicked
        }
    }

    // Main method to create an instance of the Login class
    public static void main(String[] arg){
        new Login(); // Create a new instance of the Login class
    }
}