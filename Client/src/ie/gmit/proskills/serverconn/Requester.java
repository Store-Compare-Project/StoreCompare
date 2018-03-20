package ie.gmit.proskills.serverconn;



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
		stdin = new Scanner(System.in);
		try{
			//1. creating a socket to connect to the server
			System.out.println("Please Enter your IP Address");
			ipaddress = stdin.next();
			requestSocket = new Socket(ipaddress, 2004);
			System.out.println("Connected to "+ipaddress+" in port 2004");
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			System.out.println("Hello");
			//3: Communicating with the server
			
			do{
				try
				{
					sendMessage(messageSend);
					
					if(message.compareToIgnoreCase("1")==0)
					{
						message = (String)in.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);
						
						message = (String)in.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);
						
						message = (String)in.readObject();
						System.out.println(message);
						
					}
					
						
						
				}
				catch(ClassNotFoundException classNot)
				{
					System.err.println("data received in unknown format");
				}
			}while(!(message == ""));
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
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
			System.out.println("client>" + msg);
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