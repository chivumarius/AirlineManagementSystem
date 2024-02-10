package airline;

import javax.swing.*;
import java.awt.*;

public class Cancel extends JFrame { // Sixth

	private JTextField textField, textField_1, textField_2, textField_4;

	public static void main(String[] args) {
		new Cancel();
	}

	public Cancel() {
		initialize();
	}

	// Initialize the cancellation frame
	private void initialize() {
		setTitle("Cancellation");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 801, 472);
		setLayout(null);

		// Label for cancellation section
		JLabel Cancellation = new JLabel("Cancellation");
		Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
		Cancellation.setBounds(185, 24, 259, 38);
		add(Cancellation);

		// Adding cancellation image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(470, 100, 250, 250);
		add(NewLabel);

		// Labels for cancellation details
		JLabel PassengerNo = new JLabel("Passenger No");
		PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PassengerNo.setBounds(60, 100, 132, 26);
		add(PassengerNo);

		JLabel CancellationNo = new JLabel("Cancellation No");
		CancellationNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CancellationNo.setBounds(60, 150, 150, 27);
		add(CancellationNo);

		JLabel CancellationDate = new JLabel("Cancellation Date");
		CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CancellationDate.setBounds(60, 200, 180, 27);
		add(CancellationDate);

		JLabel FlightCode = new JLabel("Flight Code");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FlightCode.setBounds(60, 300, 150, 27);
		add(FlightCode);

		// Button to cancel ticket
		JButton Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Cancel.setBackground(Color.BLACK);
		Cancel.setForeground(Color.WHITE);
		Cancel.setBounds(250, 350, 150, 30);
		add(Cancel);

		// Text fields for entering cancellation details
		textField = new JTextField();
		textField.setBounds(250, 100, 150, 27);
		add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(250, 150, 150, 27);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(250, 200, 150, 27);
		add(textField_2);

		textField_4 = new JTextField();
		textField_4.setBounds(250, 300, 150, 27);
		add(textField_4);

		// ActionListener using arrow function
		Cancel.addActionListener(ae -> {

			// Retrieving cancellation details from text fields
			String passenger_no = textField.getText();
			String cancellation_no = textField_1.getText();
			String cancellation_date = textField_2.getText();
			String flight_code = textField_4.getText();

			try {
				// Establishing database connection
				DBConnection c = new DBConnection();
				// SQL query to insert cancellation details into database
				String str = "INSERT INTO cancellation values('" + passenger_no + "', '" + cancellation_no + "', '" + cancellation_date + "', '" + flight_code + "')";

				// Executing SQL query
				c.s.executeUpdate(str);
				// Displaying success message
				JOptionPane.showMessageDialog(null, "Ticket Canceled");
				setVisible(false);

			} catch (Exception e) {
				// Handling exceptions
				e.printStackTrace();
			}
		});

		setSize(860, 500);
		setVisible(true);
		setLocation(400, 200);

		// Set Frame to Open in the Center of the Screen at Runtime
		setLocationRelativeTo(null);
	}
}