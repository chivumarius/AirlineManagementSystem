package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame { // Fourth

	JTable table;
	JLabel ReservationDetails, PnrNo, TicketId, FCode, JnyDate, JnyTime, Source, Destination;
	JButton Show;

	public static void main(String[] args) {
		new JourneyDetails();
	}

	public JourneyDetails() {

		// Setting frame title
		setTitle("Journey Details");

		// Setting background color
		getContentPane().setBackground(Color.WHITE);

		// Setting default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setting layout to null
		setLayout(null);

		// Making the frame visible
		setVisible(true);

		// Creating Source label
		Source = new JLabel("Source");
		Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Source.setBounds(60, 100, 150, 27);
		add(Source);

		// Creating Destination label
		Destination = new JLabel("Destination");
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Destination.setBounds(350, 100, 150, 27);
		add(Destination);

		// Creating Show button
		Show = new JButton("Show");
		Show.setBounds(680, 100, 100, 30);
		add(Show);

		// Setting default close operation
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		// Creating ReservationDetails label
		ReservationDetails = new JLabel("Journey Details");
		ReservationDetails.setForeground(Color.BLUE);
		ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		ReservationDetails.setBounds(280, 27, 359, 31);
		add(ReservationDetails);

		// Creating Passenger Number label
		PnrNo = new JLabel("Passenger Number");
		PnrNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PnrNo.setBounds(79, 270, 83, 20);
		add(PnrNo);

		// Ticket Id Label
		TicketId = new JLabel("Ticket Id");
		TicketId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TicketId.setBounds(172, 270, 71, 20);
		add(TicketId);

		// Creating Flight Code label
		FCode = new JLabel("Flight Code");
		FCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FCode.setBounds(297, 270, 103, 20);
		add(FCode);

		// Creating Journey Date label
		JnyDate = new JLabel("Journey Date");
		JnyDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JnyDate.setBounds(390, 270, 94, 20);
		add(JnyDate);

		// Creating Journey Time label
		JnyTime = new JLabel("Journey Time");
		JnyTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JnyTime.setBounds(494, 270, 83, 20);
		add(JnyTime);

		// Creating Source label for table
		Source = new JLabel("Source");
		Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Source.setBounds(613, 270, 94, 20);
		add(Source);

		// Creating Destination label for table
		Destination = new JLabel("Destination");
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Destination.setBounds(717, 270, 94, 20);
		add(Destination);

		// Array of items for the source ComboBox
		String[] items1 = {"City A", "City B", "City C", "City D", "City E", "City F", "City G",
				"City H", "City I", "City J", "City K", "City L", "City M", "City N",
				"City O", "City P", "City Q", "City R", "City S", "City T"};

		// Creating ComboBox for source
		JComboBox<String> comboBox = new JComboBox<>(items1);
		comboBox.setBounds(150, 100, 150, 27);
		add(comboBox);

		// Array of items for the destination ComboBox
		String[] items2 = {"City A", "City B", "City C", "City D", "City E", "City F", "City G",
				"City H", "City I", "City J", "City K", "City L", "City M", "City N",
				"City O", "City P", "City Q", "City R", "City S", "City T"};

		// Creating ComboBox for destination
		JComboBox<String> comboBox_1 = new JComboBox<>(items2);
		comboBox_1.setBounds(500, 100, 150, 27);
		add(comboBox_1);

		// Adding action listener to Show button
		Show.addActionListener(ae -> {
			try {
				String src = (String) comboBox.getSelectedItem();
				String dst = (String) comboBox_1.getSelectedItem();

				DBConnection c = new DBConnection();

				String str = "select * from reservation where src = '" + src + "' and dst = '" + dst + "'";
				ResultSet rs = c.s.executeQuery(str);

				// Setting the table model with the result set
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// Creating table
		table = new JTable();
		table.setBounds(38, 310, 770, 130);
		add(table);

		// Creating scroll pane for the table
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(23, 250, 800, 300);
		pane.setBackground(Color.WHITE);
		add(pane);

		// Setting frame size
		setSize(860, 600);

		// Setting frame location
		setLocation(400, 200);

		// Making the frame visible
		setVisible(true);

		// Set Frame to Open in the Center of the Screen at Runtime
		setLocationRelativeTo(null);
	}
}