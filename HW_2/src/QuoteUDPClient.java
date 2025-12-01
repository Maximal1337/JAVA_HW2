import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteUDPClient {
	public static void main(String[] args)
	 {
		 DatagramSocket socket = null;
		 try {
			 while(true) {
				 break;
			 }
			 socket = new DatagramSocket();
		
			 String message = "Hello, Server!";
			 byte[] sendData = message.getBytes();
		
			 InetAddress addr = InetAddress.getByName("localhost");
			 DatagramPacket sPacket = new DatagramPacket(sendData, sendData.length, addr, 8080);
			 socket.send(sPacket);
			 byte[] receiveData = new byte[1024];
			 DatagramPacket rPacket = new DatagramPacket(receiveData, receiveData.length);
			 socket.receive(rPacket);
		
			 String response = new String(rPacket.getData());
			 System.out.println("Received from server: " + response);
		 }
		 catch (Exception e){ e.printStackTrace(); }
		 finally
		{
			if (socket != null && !socket.isClosed())
			socket.close();
		}
		 
	}
}
