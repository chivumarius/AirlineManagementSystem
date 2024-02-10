package airline;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    // Text fields for user input
    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;

    // Constructor for the AddCustomer class
    public AddCustomer() {
        // Set frame properties
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Add Customer Details");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 600);
        getContentPane().setLayout(null);

        // Label and text field for Passport Number
        JLabel PassportNo = new JLabel("Passport Number");
        PassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PassportNo.setBounds(60, 80, 150, 27);
        add(PassportNo);

        textField = new JTextField();
        textField.setBounds(240, 80, 150, 27);
        add(textField);

        // Save button
        JButton Save = new JButton("Save");
        Save.setBounds(240, 520, 150, 30);
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.WHITE);
        add(Save);

        // Label and text field for Passenger Number
        JLabel PassengerNo = new JLabel("Passenger Number");
        PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PassengerNo.setBounds(60, 120, 150, 27);
        add(PassengerNo);

        textField_1 = new JTextField();
        textField_1.setBounds(240, 120, 150, 27);
        add(textField_1);

        // Label and text field for Address
        JLabel Address = new JLabel("Address");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        textField_2 = new JTextField();
        textField_2.setBounds(240, 170, 150, 27);
        add(textField_2);

        // Label and text field for Nationality
        JLabel Nationality = new JLabel("Nationality");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(240, 220, 150, 27);
        add(textField_3);

        // Label and text field for Name
        JLabel Name = new JLabel("Name");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(240, 270, 150, 27);
        add(textField_4);

        // Label and radio buttons for Gender selection
        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 320, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("Male");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(240, 320, 70, 27);
        add(NewRadioButton);

        JRadioButton Female = new JRadioButton("Female");
        Female.setBackground(Color.WHITE);
        Female.setBounds(320, 320, 70, 27);
        add(Female);

        // Label and text field for Phone Number
        JLabel PhoneNo = new JLabel("Phone Number");
        PhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PhoneNo.setBounds(60, 370, 150, 27);
        add(PhoneNo);

        textField_5 = new JTextField();
        textField_5.setBounds(240, 370, 150, 27);
        add(textField_5);

        // Label for "Add Customer Details"
        JLabel AddPassengers = new JLabel("   Add Customer Details");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(420, 24, 442, 35);
        add(AddPassengers);

        // Label and text field for Flight Code
        JLabel FlightCode = new JLabel("Flight Code");
        FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        FlightCode.setBounds(60, 30, 150, 27);
        add(FlightCode);

        textField_6 = new JTextField();
        textField_6.setBounds(240, 30, 150, 27);
        add(textField_6);

        // Image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(450, 80, 280, 410);
        add(image);

        // Action listener for the "Save" button
        Save.addActionListener(ae -> {
            // Retrieve user input
            String passport_No = textField.getText();
            String pnr_no = textField_1.getText();
            String address = textField_2.getText();
            String nationality = textField_3.getText();
            String name = textField_4.getText();
            String fl_code = textField_6.getText();

            String gender = null;
            String ph_no = textField_5.getText();

            // Determine selected gender
            if (NewRadioButton.isSelected()) {
                gender = "male";
            } else if (Female.isSelected()) {
                gender = "female";
            }

            // Database connection and insertion of customer details
            try {
                DBConnection c = new DBConnection();
                String str = "INSERT INTO passenger values( '" + pnr_no + "', '" + address + "', '" + nationality + "','" + name + "', '" + gender + "', '" + ph_no + "','" + passport_No + "', '" + fl_code + "')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Customer Added");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Set window visibility and size
        setVisible(true);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    // Main method to run the AddCustomer frame
    public static void main(String[] args) {
        new AddCustomer();
    }
}