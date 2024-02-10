package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDetails extends JFrame { // Fifth

	JTextField textField;
	JTable table;
	JLabel Sector;
	JLabel FlightCode, Capacity, ClassCode, ClassName, label;

	public static void main(String[] args) {
		new PaymentDetails();
	}

	public PaymentDetails() {
		initialize();
	}

	// Initialize the payment details frame
	private void initialize() {
		setTitle("Payment Details");
		getContentPane().setBackground(Color.WHITE);
		setSize(860, 486);
		setLayout(null);

		// Label for passenger name reference
		JLabel FCode = new JLabel("Passenger Number");
		FCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FCode.setBounds(100, 160, 150, 26);
		add(FCode);

		// Text field for entering passenger name reference
		textField = new JTextField();
		textField.setBounds(280, 160, 150, 26);
		add(textField);

		// Table to display payment details
		table = new JTable();
		table.setBounds(45, 329, 766, 87);
		add(table);

		// Button to show payment details
		JButton Show = new JButton("Show");
		Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Show.setBackground(Color.BLACK);
		Show.setForeground(Color.WHITE);
		Show.setBounds(280, 210, 150, 26);
		add(Show);

		// Label for payment details section
		Sector = new JLabel("Payment Details");
		Sector.setForeground(Color.BLUE);
		Sector.setFont(new Font("Tahoma", Font.PLAIN, 31));
		Sector.setBounds(51, 17, 300, 39);
		add(Sector);

		// Labels for payment details attributes
		FlightCode = new JLabel("Passenger");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FlightCode.setBounds(84, 292, 108, 26);
		add(FlightCode);

		Capacity = new JLabel("Paid Amount");
		Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Capacity.setBounds(183, 298, 92, 14);
		add(Capacity);

		ClassCode = new JLabel("Pay Date");
		ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ClassCode.setBounds(322, 294, 101, 24);
		add(ClassCode);

		ClassName = new JLabel("Cheque Number");
		ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ClassName.setBounds(455, 298, 114, 14);
		add(ClassName);

		// Label for payment details image
		label = new JLabel("");
		label.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payment.png")));
		label.setBounds(505, 15, 239, 272);
		add(label);

		JLabel CardNo = new JLabel("Card Number");
		CardNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CardNo.setBounds(602, 299, 101, 19);
		add(CardNo);

		JLabel PhoneNo = new JLabel("Phone Number");
		PhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PhoneNo.setBounds(712, 294, 86, 24);
		add(PhoneNo);

		setVisible(true);

		// ActionListener using arrow function
		Show.addActionListener(ae -> {
			try {
				String code = textField.getText();

				DBConnection c = new DBConnection();
				String str = "select pnr_no,paid_amt, pay_date, cheque_no,card_no,ph_no from payment where pnr_no = '" + code + "'";

				ResultSet rs = c.s.executeQuery(str);

				table.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		setSize(960, 590);
		setLocation(400, 200);
		setVisible(true);

		// Set Frame to Open in the Center of the Screen at Runtime
		setLocationRelativeTo(null);

	}
}