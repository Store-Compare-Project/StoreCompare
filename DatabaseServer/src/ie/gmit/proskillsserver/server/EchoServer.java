package ie.gmit.proskillsserver.server;

import ie.gmit.proskillsserver.proceeses.CreateHistory;
import ie.gmit.proskillsserver.proceeses.History;
import ie.gmit.proskillsserver.proceeses.HistoryGet;
import ie.gmit.proskillsserver.proceeses.Login;
import ie.gmit.proskillsserver.proceeses.Register;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is the main server competent used to sent and receive data from/to
 * the user.<br>
 * The server receives a header which is the first word in the string to
 * identify 'login' and<br>
 * register, otherwise the server would have no idea whether it was a login or
 * register attempt<br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class EchoServer {

	/**
	 * The main server component.<br>
	 * The server starts the server on port '2004' and listens on this port for
	 * a user connection. When a user connects they are setup on a new thread
	 * and given an ID for their request to the server
	 * 
	 * @param args
	 *            Default method argument
	 * @throws Exception
	 *             Throws all errors
	 */
	public static void main(String[] args) throws Exception {

		// Set serversocket with port
		ServerSocket m_ServerSocket = new ServerSocket(2004, 10);

		// Setup date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		// Output server status
		System.out.println(
				"> (" + dateFormat.format(date) + ") Started Server on port: " + m_ServerSocket.getLocalPort());

		// Set id and listen for incoming connections
		int id = 0;
		while (true) {
			Socket clientSocket = m_ServerSocket.accept();
			ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
			cliThread.start();
		}
	}
}

// Thread settings
class ClientServiceThread extends Thread {
	Socket clientSocket;
	String message;
	int clientID = 0;
	ObjectOutputStream out;
	ObjectInputStream in;

	ClientServiceThread(Socket s, int i) {
		clientSocket = s;
		clientID = i;
	}

	// Send message method
	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	// Thread
	public void run() {

		// Setup date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		// Output server status
		System.out.println("\n> (" + dateFormat.format(date) + ") Accepted Client ID: " + clientID + " | Address - "
				+ clientSocket.getInetAddress().getHostName());

		try {
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(clientSocket.getInputStream());

			message = (String) in.readObject();

			String[] splited = message.split("\\?");
			boolean loginStatus = false;

			// If first word in string equals 'login' then user is attempting to login
			if (splited[0].equals("login")) {

				// Output server status
				System.out.println("> Client ID: " + clientID + " | Login Attempt Username - " + splited[1]);

				// Get login status from login to check if details are correct
				loginStatus = Login.main(splited[1], splited[2], clientID);

				// Send back true/false statement to client
				sendMessage("" + loginStatus);

			// If first word in string equals 'register' then user is attempting to register
			} else if (splited[0].equals("register")) {

				// Output server status
				System.out.println("> Client ID: " + clientID + " | Register Attempt Username - " + splited[1]);

				// Get login status from register to check if username is taken
				loginStatus = Register.main(splited[1], splited[2], clientID);

				// Send back true/false statement to client
				sendMessage("" + loginStatus);

			// If first word in string equals 'history' then user is attempting to add item search history
			} else if (splited[0].equals("history")) {

				// Output server status
				System.out.println("> Client ID: " + clientID + " | Adding History for - " + splited[1]);

				// Run method to add history and pass item info
				History.main(splited);

				// Send nothing and stop client form waiting for message
				sendMessage("");

			// If first word in string equals 'historyGet' then user is attempting to get all item search history
			} else if (splited[0].equals("historyGet")) {

				// Output server status
				System.out.println("> Client ID: " + clientID + " | Getting all History for User - " + splited[1]);

				// Get history search results
				String newHistory = HistoryGet.main(splited[1]);

				// Send history search results
				sendMessage(newHistory);
			}

			// Output server status
			System.out.println("> (" + dateFormat.format(date) + ") Disconnecting Client ID: " + clientID
					+ " | Address - " + clientSocket.getInetAddress().getHostName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
