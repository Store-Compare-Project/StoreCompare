package ie.gmit.proskills.serverconn;

import ie.gmit.proskills.object.History;
import ie.gmit.proskills.object.LoginObject;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * This class is the Requester, which is used to sent and receive data from/to
 * the user.<br>
 * It is the class which connects to the server.
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */

public class Requester{
	
	/**
	 * The main server component.<br>
	 * Sends requests to the server on port 2004 and handles the messageSend.
	 * 
	 * 
	 * 
	 * @param messageSend
	 *            the login object that is sent to the server
	 * @param msg
	 *            the message that is wrote to the server
	 */
	
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message="";
 	String ipaddress;
 	Scanner stdin;
	Requester(){}
	
	void run(String messageSend)
	{
		message = messageSend;
		
		try{
			
			requestSocket = new Socket("35.189.113.175", 2004);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			
			sendMessage(message);
			message = (String)in.readObject();
			
			String[] splited = messageSend.split("\\s+");
			
			if(splited[0].equals("login") || splited[0].equals("register")){
				LoginObject.setLogin(Boolean.parseBoolean(message));
			}else if (splited[0].equals("historyGet")){
				History.setHistory(message);
			}
			
			
			
			
			
			
		}
		catch(UnknownHostException unknownHost){
			unknownHost.printStackTrace();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	public static void main(String messageSend)
	{
		Requester client = new Requester();
		client.run(messageSend);
	}
}