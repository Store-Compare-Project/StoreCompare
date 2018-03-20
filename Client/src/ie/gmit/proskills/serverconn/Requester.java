package ie.gmit.proskills.serverconn;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import ie.gmit.proskills.object.LoginObject;

public class Requester{
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
			
			requestSocket = new Socket("127.0.0.1", 2004);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			
			sendMessage(message);
			message = (String)in.readObject();
			
			LoginObject.setLogin(Boolean.parseBoolean(message));
			
		}
		catch(UnknownHostException unknownHost){
			unknownHost.printStackTrace();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//4: Closing connection
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