package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.Register;
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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819995849104340705L;
	private JPanel contentPane;
	private JTextField usernameInput;
	private JTextField passwordInput1;
	private JTextField passwordInput2;

	/**
	 * Launch the application.
	 */
	public static void main(int x, int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMenu frame = new RegisterMenu(x, y);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param y
	 * @param x
	 */
	public RegisterMenu(int x, int y) {

		// Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 560, 420);
		setTitle("StoreCompare - Register");
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
		
		//A label for the new password input
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(11, 128, 200, 14);
		panel.add(lblPassword);
		
		//A page header label
		JLabel headerLabel = new JLabel("Register");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Jokerman", Font.PLAIN, 28));
		headerLabel.setBounds(11, 11, 272, 43);
		panel.add(headerLabel);
		
		//An Image label for the logo
		JLabel logoLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/logo.png")).getImage();
		logoLabel.setIcon(new ImageIcon(img));
		logoLabel.setBounds(0, 0, 250, 200);
		contentPane.add(logoLabel);

		//A label for the username input
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(11, 57, 200, 14);
		panel.add(lblUsername);

		//A label for the confirmed password input
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblConfirmPassword.setBounds(10, 184, 186, 14);
		panel.add(lblConfirmPassword);
		
		//A text field for the new password input
		passwordInput1 = new JTextField();
		passwordInput1.setBounds(11, 153, 272, 20);
		panel.add(passwordInput1);
		passwordInput1.setColumns(10);

		//A text field for the confirmed password input
		passwordInput2 = new JTextField();
		passwordInput2.setBounds(10, 209, 273, 20);
		panel.add(passwordInput2);
		passwordInput2.setColumns(10);

		//A text field for the username input
		usernameInput = new JTextField();
		usernameInput.setBounds(11, 82, 272, 20);
		panel.add(usernameInput);
		usernameInput.setColumns(10);

		// Register button settings and listener
		JButton buttonReg = new JButton("Register");
		buttonReg.setBounds(11, 251, 272, 88);
		panel.add(buttonReg);
		
		//A button which takes you back to the landing page
		JButton backButton = new JButton("Back");
		backButton.setBounds(11, 347, 89, 23);
		panel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage.main(null);
				CloseFrame();
			}
		});
		
		buttonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Declare variables for input boxes
				String username = usernameInput.getText();
				String password1 = passwordInput1.getText();
				String password2 = passwordInput2.getText();

				// Input validation for register details
				boolean usernameValidationCheck = Validator.validateUsername(username);
				boolean passwordValidationCheck = Validator.validatePassword(password1);

				// If the user's username passes validation
				if (usernameValidationCheck == true) {
					// If the password details are valid
					if (passwordValidationCheck == true) {
						// Check the password's are the same
						if (password1.equals(password2)) {
							// Send our validated details to Register method
							boolean registerCheck = Register.main(username, password1);

							// If the validated login details match those in the database
							if (!registerCheck) {
								MainMenu.main((int) Math.round(contentPane.getLocationOnScreen().getX()),
										(int) Math.round(contentPane.getLocationOnScreen().getY()));
								CloseFrame();
							} else {
								JOptionPane.showMessageDialog(null, "Error: Could not register. Please try again.");
							}
						} else if (!password1.equals(password2)) {
							JOptionPane.showMessageDialog(null, "Passwords do not match");

							// Set all text boxes to default
							usernameInput.setText("");
							passwordInput1.setText("");
							passwordInput2.setText("");
						}

					} else if (passwordValidationCheck == false) {
						// Display a prompt to let the user know their username is invalid
						JOptionPane.showMessageDialog(null, "Please enter a valid password. \n -No spaces allowed");

						// Set all text boxes to default
						usernameInput.setText("");
						passwordInput1.setText("");
						passwordInput2.setText("");
					}
				} else if (usernameValidationCheck == false) {
					// Set all text boxes to default
					usernameInput.setText("");
					passwordInput1.setText("");
					passwordInput2.setText("");

					// Display a prompt to let the user know their username is invalid
					JOptionPane.showMessageDialog(null,
							"Please enter a valid username. \n - Between 3-15 characters \n - Numbers (0-9) \n -Symbols not accepted");
				}
			}
		});
	}

	//A function which closes the frame
	public void CloseFrame() {
		super.dispose();
	}
}
