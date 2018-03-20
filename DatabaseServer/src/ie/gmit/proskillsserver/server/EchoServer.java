package ie.gmit.proskillsserver.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
  public static void main(String[] args) throws Exception {
    ServerSocket m_ServerSocket = new ServerSocket(2004,10);
    int id = 0;
    while (true) {
      Socket clientSocket = m_ServerSocket.accept();
      ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
      cliThread.start();
    }
  }
}

class ClientServiceThread extends Thread {
  Socket clientSocket;
  String message;
  int clientID = -1;
  boolean running = true;
  ObjectOutputStream out;
  ObjectInputStream in;

  ClientServiceThread(Socket s, int i) {
    clientSocket = s;
    clientID = i;
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
  public void run() {
    System.out.println("Accepted Client : ID - " + clientID + " : Address - "
        + clientSocket.getInetAddress().getHostName());
    try 
    {
    	out = new ObjectOutputStream(clientSocket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(clientSocket.getInputStream());
		System.out.println("Accepted Client : ID - " + clientID + " : Address - "
		        + clientSocket.getInetAddress().getHostName());
		
		try
		{
			message = (String)in.readObject();
			
			String[] splited = message.split("\\s+");
			
			sendMessage("" + splited);
			
			/*
			if(message.compareToIgnoreCase("1")==0)
			{
				System.out.println("User wishes to complete the string test");
				sendMessage("Please enter a string");
				String string1 = (String)in.readObject();
				sendMessage("Please enter a string");
				String string2 = (String)in.readObject();
				
				if(string1.equals(string2))
					sendMessage("Both strings are the same");
				else if(string1.compareToIgnoreCase(string2)>0)
					sendMessage("String 1 is bigger");
				else
					sendMessage("String 2 is bigger");
			}
			
			else if(message.compareToIgnoreCase("2")==0)
			{
				System.out.println("User wishes to complete the calculator test");
				
				sendMessage("Press 1 for Multiply\nPress 2 for square root\n");
				message=(String)in.readObject();
				
				if(message.equalsIgnoreCase("1"))
				{
					sendMessage("Please enter number 1");
					message = (String)in.readObject();
					int a = Integer.parseInt(message);
					
					sendMessage("Please enter number 2");
					message = (String)in.readObject();
					int b = Integer.parseInt(message);
					
					sendMessage(""+(a*b));
				}
				
				else if(message.equalsIgnoreCase("2"))
				{
					sendMessage("Please enter the number");
					message = (String)in.readObject();
					int a = Integer.parseInt(message);
					
					sendMessage(""+Math.sqrt(a));
					
				}
				
			}
			*/
			
		}
		catch(ClassNotFoundException classnot){
			System.err.println("Data received in unknown format");
		}
			
      
		System.out.println("Ending Client : ID - " + clientID + " : Address - " + clientSocket.getInetAddress().getHostName());
		
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
