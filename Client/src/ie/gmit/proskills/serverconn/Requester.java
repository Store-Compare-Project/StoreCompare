package ie.gmit.proskills.serverconn;

import ie.gmit.proskills.object.LoginObject;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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
			
			requestSocket = new Socket("35.189.113.175", 2004);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			
			sendMessage(message);
			message = (String)in.readObject();
			
			String[] splited = message.split("\\s+");
			
			if(splited[0].equals("user")){
				LoginObject.setLogin(Boolean.parseBoolean(message));
			}else if (splited[0].equals("history")){
				System.out.println(message);
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