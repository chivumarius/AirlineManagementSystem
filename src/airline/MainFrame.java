package airline;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        // Create and display the main frame
        new MainFrame().setVisible(true);
    }

    public MainFrame() {
        // Set the title of the frame
        super("Airline Reservation Management System");
        // Initialize the frame
        initialize();
    }

    private void initialize() {
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Set the foreground color
        setForeground(Color.CYAN);
        // Set layout to null for absolute positioning of components
        setLayout(null);

        // Set the background image
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, screenWidth, screenHeight);
        add(backgroundLabel);

        // Display the welcome message
        JLabel welcomeLabel = new JLabel("The Romanian Airline Welcomes You");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        // Center the welcome message horizontally and position it at the top of the screen
        welcomeLabel.setBounds((screenWidth - welcomeLabel.getPreferredSize().width) / 2, 60, welcomeLabel.getPreferredSize().width, welcomeLabel.getPreferredSize().height);
        backgroundLabel.add(welcomeLabel);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Add menu items for airline system
        JMenu airlineSystemMenu = new JMenu("Airline System");
        airlineSystemMenu.setForeground(Color.BLACK); // Set text color to black
        menuBar.add(airlineSystemMenu);

        // Add menu items for different functionalities
        JMenuItem flightDetailsItem = new JMenuItem("Flight Info");
        airlineSystemMenu.add(flightDetailsItem);

        JMenuItem reservationDetailsItem = new JMenuItem("Add Customer Details");
        airlineSystemMenu.add(reservationDetailsItem);

        JMenuItem passengerDetailsItem = new JMenuItem("Journey Details");
        airlineSystemMenu.add(passengerDetailsItem);

        JMenuItem sectorDetailsItem = new JMenuItem("Payment Details");
        airlineSystemMenu.add(sectorDetailsItem);

        JMenuItem cancellationItem = new JMenuItem("Cancellation");
        airlineSystemMenu.add(cancellationItem);

        // Add menu item for logout
        JMenu exitMenu = new JMenu("Logout");
        exitMenu.setForeground(Color.BLACK); // Set Text Color to black
        menuBar.add(exitMenu);

        JMenuItem logoutItem = new JMenuItem("Logout");
        exitMenu.add(logoutItem);

        // Add action listeners for menu items

        // Open FlightInfo window when FlightDetails menu item is clicked
        flightDetailsItem.addActionListener(ae -> new FlightInfo());

        // Open AddCustomer window when ReservationDetails menu item is clicked
        reservationDetailsItem.addActionListener(ae -> {
            try {
                new AddCustomer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Open JourneyDetails window when PassengerDetails menu item is clicked
        passengerDetailsItem.addActionListener(ae -> {
            try {
                new JourneyDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Open PaymentDetails window when SectorDetails menu item is clicked
        sectorDetailsItem.addActionListener(ae -> {
            try {
                new PaymentDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Open Cancel window when Cancellation menu item is clicked
        cancellationItem.addActionListener(ae -> new Cancel());

        // Logout and display the login window when Logout menu item is clicked
        logoutItem.addActionListener(ae -> {
            setVisible(false);
            new Login().setVisible(true);
        });

        // Set the size of the JFrame to match the screen size
        setSize(screenWidth, screenHeight);
        // Make the JFrame visible
        setVisible(true);
    }
}