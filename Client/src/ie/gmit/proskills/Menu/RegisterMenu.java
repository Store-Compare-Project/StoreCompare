package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.Register;
import ie.gmit.proskills.Processes.Validator;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMenu frame = new RegisterMenu();
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
	public RegisterMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(251, 0, 293, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordInput1 = new JTextField();
		passwordInput1.setBounds(42, 53, 258, 20);
		panel.add(passwordInput1);
		passwordInput1.setColumns(10);
		
		
		
		usernameInput = new JTextField();
		usernameInput.setBounds(11, 82, 272, 20);
		panel.add(usernameInput);
		usernameInput.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(42, 132, 186, 14);
		panel.add(lblPassword);
		
		// Labels and buttons for interface
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(42, 17, 52, 14);
		panel.add(lblUsername);
		
		passwordInput2 = new JTextField();
		passwordInput2.setBounds(42, 228, 186, 20);
		panel.add(passwordInput2);
		passwordInput2.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(42, 188, 186, 14);
		panel.add(lblConfirmPassword);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(61, 287, 141, 23);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Declare variables for input boxes
				String username = usernameInput.getText();
				String password1 = passwordInput1.getText();
				String password2 = passwordInput1.getText();
				
				// Input validation for register details
				boolean validationCheck = Validator.validateUsername(username);
				
				// If the user's username passes validation
				if(validationCheck == true)
				{
					
					// Send our validated details to Register method
					boolean registerCheck = Register.main(username, password1);
					
					if(!registerCheck){
						
						MainMenu.main(null);
						CloseFrame();
						
					}else{
						//TODO Add message to user displaying failed login status
					}
				}
				
				else if(validationCheck == false)
				{
					// Set all text boxes to default
					usernameInput.setText("");
					passwordInput1.setText("");
					passwordInput2.setText("");
					
					// Debug
					System.out.printf("Username %s is invalid", username);
					
					// Display a prompt to let the user know their username is invalid
					JOptionPane.showMessageDialog(null, "Please enter a valid username. \n - Between 3-15 characters \n - Numbers (0-9) \n Symbols - (_ . @)");
				}
						
				
				
			}
			
		});
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}
