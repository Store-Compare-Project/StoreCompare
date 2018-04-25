package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.StoreSearch;
import ie.gmit.proskills.object.StoreInfo;
import ie.gmit.proskills.Processes.HistoryAdd;
import ie.gmit.proskills.Processes.HistoryGet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JCheckBox;

/**
 * This class is responsible for loading the Main Menu to the user. <br>
 * The class allows the user to Search a product.
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */

// A MainMenu class which utilises a JFrame to allow the user to search for
// products.
public class MainMenu extends JFrame {

	private static final long serialVersionUID = -7318028064219521737L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfStore_Seach;
	private JTable table_1;

	/**
	 * This class displays a Menu to the user. From here they can enter a
	 * product name into the input field and this will display the search
	 * results. The user can also choose to logout.
	 * 
	 * @param x
	 *            The x coordinates of the JFrame
	 * @param y
	 *            The y coordinates of the JFrame
	 * @param username
	 *            The username who logged in/resisted
	 */
	public static void main(int x, int y, String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(x, y, username);
					frame.setVisible(true);

					// Change the icon image for the frame
					Image img = new ImageIcon(this.getClass().getResource("/img/logo.png")).getImage();
					frame.setIconImage(img);

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
	 *            The x coordinates of the JFrame
	 * @param x
	 *            The y coordinates of the JFrame
	 * @param username
	 *            The username who logged in/resisted
	 */
	public MainMenu(int x, int y, String username) {

		DecimalFormat df = new DecimalFormat("#.00");

		// Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 660, 530);
		setTitle("StoreCompare - Main Menu");
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Table settings
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		String header[] = new String[] { "Item Name", "Price", "Postage", "Total", "Store" };
		dtm.setColumnIdentifiers(header);
		table = new JTable();
		table.setModel(dtm);

		// Table settings
		DefaultTableModel dtmHistory = new DefaultTableModel(0, 0);
		String headerHistory[] = new String[] { "Item Name", "Ebay AVG", "DoneDeal AVG", "Newegg AVG", "Date" };
		dtmHistory.setColumnIdentifiers(headerHistory);
		table_1 = new JTable();
		table_1.setModel(dtmHistory);

		// Scroll pane for item search results
		JScrollPane mainScroll = new JScrollPane();
		mainScroll.setBounds(10, 126, 624, 325);
		contentPane.add(mainScroll);
		mainScroll.setViewportView(table);

		// Scroll pane for prevoius search history
		JScrollPane historyScroll = new JScrollPane();
		historyScroll.setBounds(242, 28, 392, 87);
		contentPane.add(historyScroll);
		historyScroll.setViewportView(table_1);

		// Text label settings
		JLabel lblStore_Search = new JLabel("Store Search:");
		lblStore_Search.setForeground(Color.LIGHT_GRAY);
		lblStore_Search.setBounds(10, 56, 125, 14);
		contentPane.add(lblStore_Search);

		// Label for DoneDeal item average
		JLabel lblDoneDealAVG = new JLabel("DoneDeal AVG:");
		lblDoneDealAVG.setForeground(Color.LIGHT_GRAY);
		lblDoneDealAVG.setBounds(162, 466, 89, 14);
		contentPane.add(lblDoneDealAVG);

		// Label for Ebay item average
		JLabel lblEbayAVG = new JLabel("Ebay AVG:");
		lblEbayAVG.setForeground(Color.LIGHT_GRAY);
		lblEbayAVG.setBounds(10, 466, 70, 14);
		contentPane.add(lblEbayAVG);

		// Label for displaying current username
		JLabel lblUser = new JLabel("User: " + username);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setBounds(10, 12, 226, 14);
		contentPane.add(lblUser);
		
		// Label for previous history table
		JLabel lblPreviousSearchHistory = new JLabel("Previous Search History:");
		lblPreviousSearchHistory.setForeground(Color.LIGHT_GRAY);
		lblPreviousSearchHistory.setBounds(243, 12, 177, 14);
		contentPane.add(lblPreviousSearchHistory);

		// Textfield settings for user input
		tfStore_Seach = new JTextField();
		tfStore_Seach.setBounds(10, 71, 125, 20);
		contentPane.add(tfStore_Seach);
		tfStore_Seach.setColumns(10);

		// Displays the average price for DoneDeal store
		TextArea taDoneDealAVG = new TextArea("€0.00", 3, 100, TextArea.SCROLLBARS_NONE);
		taDoneDealAVG.setBounds(257, 465, 70, 20);
		contentPane.add(taDoneDealAVG);

		// Displays the average price for Ebay store
		TextArea taEbayAVG = new TextArea("€0.00", 3, 100, TextArea.SCROLLBARS_NONE);
		taEbayAVG.setBounds(86, 465, 70, 20);
		contentPane.add(taEbayAVG);
		
		// Displays the average price for Newegg store
		TextArea taNeweggAVG = new TextArea("€0.00", 3, 100, TextArea.SCROLLBARS_NONE);
		taNeweggAVG.setBounds(426, 465, 70, 20);
		contentPane.add(taNeweggAVG);

		// Search button setup and action listener
		JButton btnStore_Search = new JButton("Search");
		btnStore_Search.setBounds(10, 92, 125, 23);
		contentPane.add(btnStore_Search);

		// A button which take you back to the landing page.
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(545, 462, 89, 23);
		contentPane.add(logoutButton);

		// Radio box for querying the DoneDeal store
		JCheckBox chckbxNewegg = new JCheckBox("Newegg");
		chckbxNewegg.setBounds(141, 50, 97, 23);
		chckbxNewegg.setBackground(Color.DARK_GRAY);
		chckbxNewegg.setForeground(Color.LIGHT_GRAY);
		contentPane.add(chckbxNewegg);
		
		// Radio box for querying the ebay store
		JCheckBox chckbxEbay = new JCheckBox("Ebay");
		chckbxEbay.setBounds(141, 70, 97, 23);
		chckbxEbay.setBackground(Color.DARK_GRAY);
		chckbxEbay.setForeground(Color.LIGHT_GRAY);
		contentPane.add(chckbxEbay);

		// Radio box for querying the DoneDeal store
		JCheckBox chckbxDonedeal = new JCheckBox("DoneDeal");
		chckbxDonedeal.setBounds(141, 92, 97, 23);
		chckbxDonedeal.setBackground(Color.DARK_GRAY);
		chckbxDonedeal.setForeground(Color.LIGHT_GRAY);
		contentPane.add(chckbxDonedeal);
		
		JLabel lblNeweggAVG = new JLabel("Newegg AVG:");
		lblNeweggAVG.setForeground(Color.LIGHT_GRAY);
		lblNeweggAVG.setBounds(331, 466, 89, 14);
		contentPane.add(lblNeweggAVG);
		
		

				
		// Button listener for the back button
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage.main((int) Math.round(contentPane.getLocationOnScreen().getX()),
						(int) Math.round(contentPane.getLocationOnScreen().getY()));
				CloseFrame();
			}
		});

		// Button listener for the search feature
		btnStore_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfStore_Seach.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please do not leave search blank!");
				} else if (!chckbxEbay.isSelected() && !chckbxDonedeal.isSelected() && !chckbxNewegg.isSelected()) {
					System.out.println(chckbxEbay.isSelected());
					JOptionPane.showMessageDialog(null, "Please tick at least one of the boxes!");
				} else {
					// Reset table for new query
					dtm.setRowCount(0);

					String itemSearch = tfStore_Seach.getText();

					try {
						StoreSearch.main(itemSearch, dtm, chckbxEbay, chckbxDonedeal, chckbxNewegg);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					taEbayAVG.setText("€" + StoreInfo.getEbayAVG());

					taDoneDealAVG.setText("€" + StoreInfo.getDoneDealAVG());
					
					taNeweggAVG.setText("€" + StoreInfo.getNeweggAVG());

					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();

					HistoryAdd.main(username, itemSearch, StoreInfo.getEbayAVG(), StoreInfo.getDoneDealAVG(), StoreInfo.getNeweggAVG(),
							dateFormat.format(date));

					dtmHistory.addRow(new Object[] { itemSearch,
							"€" + df.format(Double.parseDouble(StoreInfo.getEbayAVG())),
							"€" + df.format(Double.parseDouble(StoreInfo.getDoneDealAVG())),
							"€" + df.format(Double.parseDouble(StoreInfo.getNeweggAVG())),
							dateFormat.format(date) });
					StoreInfo.setEbayAVG("0.00");
					StoreInfo.setDoneDealAVG("0.00");
				}
			}
		});

		String history = HistoryGet.main(username);

		String[] splited = history.split("\\?");

		try {
			for (int i = 0; i < splited.length; i += 5) {
				dtmHistory.addRow(new Object[] { 
				splited[i], 
				"€" + df.format(Double.parseDouble(splited[i + 1])),
				"€" + df.format(Double.parseDouble(splited[i + 2])), 
				"€" + df.format(Double.parseDouble(splited[i + 3])), 
				splited[i + 4] });
			}
		} catch (ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException) {
		}

	}

	// A function which closes the frame
	public void CloseFrame() {
		super.dispose();
	}
}