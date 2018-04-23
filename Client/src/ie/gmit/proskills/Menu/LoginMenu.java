package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.Login;
import ie.gmit.proskills.Processes.Validator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819995849104340705L;
	private JPanel contentPane;
	private JTextField usernameInput;
	private JTextField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(int x, int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu frame = new LoginMenu(x, y);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginMenu(int x, int y) {
		
		// Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 560, 420);
		setTitle("StoreCompare - Login");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel settings
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(251, 0, 293, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel coverPanel = new JPanel();
		coverPanel.setBackground(Color.DARK_GRAY);
		coverPanel.setBounds(0, 199, 250, 182);
		contentPane.add(coverPanel);
		
		// Text labels
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(11, 57, 200, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(11, 113, 200, 14);
		panel.add(lblPassword);
		
		JLabel lblHeader = new JLabel("Login");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Jokerman", Font.PLAIN, 28));
		lblHeader.setBounds(11, 11, 272, 43);
		panel.add(lblHeader);
		
		// Image labels
		JLabel logoLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/logo.png")).getImage();
		logoLabel.setIcon(new ImageIcon(img));
		logoLabel.setBounds(0, 0, 250, 200);
		
		contentPane.add(logoLabel);
		
		// Text fields for user input
		usernameInput = new JTextField();
		usernameInput.setBounds(11, 82, 272, 20);
		panel.add(usernameInput);
		usernameInput.setColumns(10);
		
		passwordInput = new JTextField();
		passwordInput.setBounds(10, 137, 273, 20);
		panel.add(passwordInput);
		passwordInput.setColumns(10);
		
		// Login button setup and action listener
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(11, 215, 272, 88);
		panel.add(loginButton);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(11, 347, 89, 23);
		panel.add(backButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = usernameInput.getText();
				String password = passwordInput.getText();

				// Input validation for register details
				boolean usernameValidationCheck = Validator.validateUsername(username);
				boolean passwordValidationCheck = Validator.validatePassword(password);

				boolean loginCheck = Login.main(username, password);

				// If the username details are valid
				if (usernameValidationCheck == true) {
					// If the password details are valid
					if (passwordValidationCheck == true) {
						// If the user logs in successfully, send them to the
						// main landing page of the program
						if (loginCheck) {
							MainMenu.main((int) Math.round(contentPane.getLocationOnScreen().getX()),
									(int) Math.round(contentPane.getLocationOnScreen().getY()));
							CloseFrame();
						} else {
							JOptionPane.showMessageDialog(null, "Username/Password are incorrect.");
							usernameInput.setText("");
							passwordInput.setText("");
						}
					} else if (passwordValidationCheck == false) {
						// Display a prompt to let the user know their username
						// is invalid
						JOptionPane.showMessageDialog(null, "Please enter a valid password. \n -No spaces allowed");

						// Set all text boxes to default
						usernameInput.setText("");
						passwordInput.setText("");
					}

					// If the validated login details DON'T match those in the
					// database
					else if (usernameValidationCheck == false) {
						// Set all text boxes to default
						usernameInput.setText("");
						passwordInput.setText("");

						// Debug
						// System.out.printf("Username %s is invalid",
						// username);

						// Display a prompt to let the user know their username
						// is invalid
						JOptionPane.showMessageDialog(null,
								"Please enter a valid username. \n - Between 3-15 characters \n - Numbers (0-9) \n -Symbols not accepted");
					}

				}
			}
		});
		
	}

	public void CloseFrame() {
		super.dispose();
	}
}