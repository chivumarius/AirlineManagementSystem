package airline;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FlightInfo extends JFrame {

	private final JTable table; // Table to display flight information
	private final JTextField textField; // Text field for user input

	// Main method to run the FlightInfo frame
	public static void main(String[] args) {
		new FlightInfo().setVisible(true);
	}

	// Constructor for the FlightInfo class
	public FlightInfo() {
		// Set frame properties
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860, 523);
		setLayout(null);
		setVisible(true);

		// Label for flight code input
		JLabel FlightCode = new JLabel("Flight Code");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FlightCode.setBounds(50, 100, 200, 30);
		add(FlightCode);

		// Label for flight information title
		JLabel FlightDetails = new JLabel("Flight Information");
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(50, 20, 570, 35);
		add(FlightDetails);

		// Button to show flight information
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShow.setBounds(220, 150, 120, 30);
		add(btnShow);

		// ActionListener for the "Show" button
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String code = textField.getText();
				try {
					DBConnection c = new DBConnection();
					String str = "select f_code,f_name,src,dst,capacity,class_code,class_name from flight ,sector where f_code = '" + code + "'";
					ResultSet rs = c.s.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		// Table to display flight information
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(23, 250, 800, 300);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(23, 250, 800, 300);
		pane.setBackground(Color.WHITE);
		add(pane);

		// Text field for flight code input
		textField = new JTextField();
		textField.setBounds(220, 100, 200, 30);
		add(textField);

		// Labels for column headers in the flight information table
		JLabel FCode = new JLabel("Flight Code");
		FCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FCode.setBounds(23, 220, 126, 14);
		add(FCode);

		JLabel FlightName = new JLabel("Flight Name");
		FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FlightName.setBounds(145, 220, 120, 14);
		add(FlightName);

		JLabel Source = new JLabel("Source");
		Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Source.setBounds(275, 220, 104, 14);
		add(Source);

		JLabel Destination = new JLabel("Destination");
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Destination.setBounds(367, 220, 120, 14);
		add(Destination);

		JLabel Capacity = new JLabel("Capacity");
		Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Capacity.setBounds(497, 220, 111, 14);
		add(Capacity);

		JLabel ClassCode = new JLabel("Class Code");
		ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ClassCode.setBounds(587, 220, 120, 14);
		add(ClassCode);

		JLabel ClassName = new JLabel("Class Name");
		ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ClassName.setBounds(700, 220, 111, 14);
		add(ClassName);

		// Set frame properties
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900, 650);

		// Set Frame to Open in the Center of the Screen at Runtime
		setLocationRelativeTo(null);
	}
}