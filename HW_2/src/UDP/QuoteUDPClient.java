package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteUDPClient {
	public static void main(String[] args)
	 {
		 DatagramSocket socket = null;
		 try {
			 socket = new DatagramSocket();
			 String message;
			 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			 System.out.print("Type get or exit: ");
			 while((message = stdIn.readLine()) != null) {
				 if(message.equalsIgnoreCase("EXIT")) {
					 byte[] sendData = message.getBytes();
					 InetAddress addr = InetAddress.getByName("localhost");
					 DatagramPacket sPacket = new DatagramPacket(sendData, sendData.length, addr, 8080);
					 socket.send(sPacket);
					 System.out.println("Shutting down the program...");
					 break;
				 }
				 byte[] sendData = message.getBytes();
				 InetAddress addr = InetAddress.getByName("localhost");
				 DatagramPacket sPacket = new DatagramPacket(sendData, sendData.length, addr, 8080);
				 socket.send(sPacket);
				 byte[] receiveData = new byte[1024];
				 DatagramPacket rPacket = new DatagramPacket(receiveData, receiveData.length);
				 socket.receive(rPacket);
				 String response = new String(rPacket.getData(), 0, rPacket.getLength());
				 System.out.println("Received from server: " + response);
				 System.out.print("Type get or exit: ");
			 }
		 }
		 catch (Exception e){ e.printStackTrace(); }
		 finally
		{
			if (socket != null && !socket.isClosed())
			socket.close();
		}
	}
}
