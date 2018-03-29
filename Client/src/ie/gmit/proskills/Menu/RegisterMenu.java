package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.Register;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		setBounds(700, 350, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Labels and buttons for interface
		JLabel lblUsername = new JLabel("Username:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JButton btnNewButton = new JButton("Register");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Declare variables for input boxes
				String username = usernameInput.getText();
				String password1 = passwordInput1.getText();
				String password2 = passwordInput1.getText();
				
				// Set all text boxes to default
				usernameInput.setText("");
				passwordInput1.setText("");
				passwordInput2.setText("");
				
				// Input validation for register details
				boolean inputValidated = false;
				
				while(inputValidated!=true)
				{
					
				}
						
				// Send our validated details to Register method
				boolean registerCheck = Register.main(username, password1);

				if(!registerCheck){
					
					MainMenu.main(null);
					CloseFrame();
					
				}else{
					//TODO Add message to user displaying failed login status
				}
				
			}
			
		});
		
		
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		
		passwordInput1 = new JTextField();
		passwordInput1.setColumns(10);
		
		passwordInput2 = new JTextField();
		passwordInput2.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblConfirmPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(passwordInput1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordInput2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(228, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassword)
					.addGap(3)
					.addComponent(passwordInput1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblConfirmPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordInput2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}
